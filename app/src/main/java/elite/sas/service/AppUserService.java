package elite.sas.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import elite.sas.api.params.LoginParams;
import elite.sas.api.params.TokenRefreshParams;
import elite.sas.api.response.JWTResponse;
import elite.sas.api.response.TokenRefreshResponse;
import elite.sas.entities.Account;
import elite.sas.entities.Tenant;
import elite.sas.entities.AppUser;
import elite.sas.api.params.CreateUserParams;
import elite.sas.repository.AccountRepository;
import elite.sas.repository.TenantRepository;
import elite.sas.repository.UserRepository;
import elite.sas.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Brian Barasa
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService  {


    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final TenantRepository tenantRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authManager;
    @Autowired
    private final JWTUtil jwtUtil;



    public Optional<Account> registerNewUserAccount(CreateUserParams request) {

        if (Objects.isNull(request.getTenantId()) || Objects.isNull(request.getFirstName()) ||
                Objects.isNull(request.getLastName()) || Objects.isNull(request.getUserName()) ||
                Objects.isNull(request.getEmail()) || Objects.isNull(request.getPassword()) ||
                Objects.isNull(request.getPasswordConfirm())
        ) {
            log.error("Missing required field(s) in the request");
            return Optional.empty();
        }

        if (!Objects.equals(request.getPassword(), request.getPasswordConfirm())) {
            log.error("Passwords do not match!");
            return Optional.empty();
        }

        Optional<Account> optionalAccount = accountRepository.findByAppUserUserName(request.getUserName());

        if (optionalAccount.isPresent()) {
            log.error("Username {} already taken!", request.getUserName());
            return Optional.empty();
        }

        Optional<Account> optionalAccountWithEmail = accountRepository.findByAppUserEmail(request.getEmail());

        if (optionalAccountWithEmail.isPresent()) {
            log.debug("Email already taken!");
            return Optional.empty();
        }

        Optional<Tenant> optionalTenant = tenantRepository.findById(request.getTenantId());

        if (optionalTenant.isEmpty()){
            log.error("Tenant with id {} not exists!", request.getTenantId());
            return Optional.empty();
        }


        var userBuilder = AppUser.builder();
        userBuilder
                .tenant(optionalTenant.get())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .email(request.getEmail());

        var createdUser = userRepository.save(userBuilder.build());

        var account = new Account.CustomBuilder()
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setuser(createdUser)
                .build();

        var acc = accountRepository.save(account);

        log.info("User account created successfully! {}", acc);

        return Optional.of(acc);



    }
    public JWTResponse login(LoginParams request) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        log.info("authentication info: {}", authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtil.generateJWT(authentication);
        String refreshToken = jwtUtil.generateRefreshJwtToken(authentication);

        Account userDetails = (Account) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .toList();

        var jwtResponse = JWTResponse.builder()
                .username(userDetails.getUsername())
                .email(userDetails.getAppUser().getEmail())
                .roles(roles)
                .access_token(accessToken)
                .refresh_token(refreshToken)
                .type("Bearer")
                .build();

        log.info("jwtResponse: --> {}", jwtResponse);

        return jwtResponse;
    }

    public TokenRefreshResponse generateRefreshToken(TokenRefreshParams tokenRefreshRequest) {
        log.info("old refresh-token requestBody():-->{}",tokenRefreshRequest);

        String refresh_token = tokenRefreshRequest.getRefreshToken();

        //logic to create new refresh/access token
        String newRefreshToken="";
        String newAccessToken="";

        if (refresh_token != null && jwtUtil.validateJwtToken(refresh_token)) {



            String username = jwtUtil.getUserNameFromJwtToken(refresh_token);
            log.info("username from refresh token:-->{}",username);

            DecodedJWT jwt = JWT.decode(refresh_token);
            if( jwt.getExpiresAt().before(new Date())) {

                log.info("-->refresh token is expired");
                newRefreshToken = jwtUtil.newRefreshToken(username);
            }else{
                log.info("-->refresh token not expired");
                newRefreshToken = refresh_token;
            }
            // newRefreshToken = jwtUtils.newRefreshToken(username);
            newAccessToken  = jwtUtil.newAccessToken(username);

            log.info("newRefreshToken:-->{} ,newAccessToken:-->{}",newRefreshToken,newAccessToken);

        }

        TokenRefreshResponse tokenRefreshResponse = TokenRefreshResponse.builder()
                .refreshToken(newRefreshToken)
                .accessToken(newAccessToken)
                .tokenType("Bearer")
                .build();


        log.info("new refresh-token/access-token responseBody():-->{}",tokenRefreshResponse);
        return tokenRefreshResponse;
    }

    public Optional<AppUser> findUserById(UUID uuid) {
        return Optional.of(userRepository.findById(uuid).orElseThrow());
    }

    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

}