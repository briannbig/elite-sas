package elite.sas.core.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import elite.sas.core.api.params.CreateStudentParams;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.api.params.LoginParams;
import elite.sas.core.api.params.TokenRefreshParams;
import elite.sas.core.api.response.JWTResponse;
import elite.sas.core.api.response.TokenRefreshResponse;
import elite.sas.core.entities.*;
import elite.sas.core.repository.UserRepository;
import elite.sas.core.util.JWTUtil;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.repository.AccountRepository;
import elite.sas.core.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Brian Barasa
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final AuthenticationManager authManager;
    @Autowired
    private final JWTUtil jwtUtil;


    @Transactional
    public Optional<Account> registerNewUserAccount(CreateUserParams request) {

        AppUser appUser = TemporalUtil.userAccountRegistrationWorkflow().handle(request);

        return accountRepository.findByAppUserUserName(appUser.getUserName());
    }

    @Transactional
    public Optional<Student> registerNewStudent(CreateStudentParams request) {

        return TemporalUtil.studentCreationWorkflow().handle(request);

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
                .id(userDetails.getId())
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
        log.info("old refresh-token requestBody():-->{}", tokenRefreshRequest);

        String refresh_token = tokenRefreshRequest.getRefreshToken();

        //logic to create new refresh/access token
        String newRefreshToken = "";
        String newAccessToken = "";

        if (refresh_token != null && jwtUtil.validateJwtToken(refresh_token)) {


            String username = jwtUtil.getUserNameFromJwtToken(refresh_token);
            log.info("username from refresh token:-->{}", username);

            DecodedJWT jwt = JWT.decode(refresh_token);
            if (jwt.getExpiresAt().before(new Date())) {

                log.info("-->refresh token is expired");
                newRefreshToken = jwtUtil.newRefreshToken(username);
            } else {
                log.info("-->refresh token not expired");
                newRefreshToken = refresh_token;
            }
            // newRefreshToken = jwtUtils.newRefreshToken(username);
            newAccessToken = jwtUtil.newAccessToken(username);

            log.info("newRefreshToken:-->{} ,newAccessToken:-->{}", newRefreshToken, newAccessToken);

        }

        TokenRefreshResponse tokenRefreshResponse = TokenRefreshResponse.builder()
                .refreshToken(newRefreshToken)
                .accessToken(newAccessToken)
                .tokenType("Bearer")
                .build();


        log.info("new refresh-token/access-token responseBody():-->{}", tokenRefreshResponse);
        return tokenRefreshResponse;
    }

    public Optional<AppUser> findUserById(String uuid) {
        return Optional.of(userRepository.findById(UUID.fromString(uuid)).orElseThrow());
    }

    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    public List<AppUser> getAllUsersForTenant(String tenantId) {
        return userRepository.findByTenantId(UUID.fromString(tenantId));
    }

    public Role saveRole(Role role) {

        var optionalInternalAdminRole = roleRepository.findByRoleName(RoleName.INTERNAL_ADMIN);
        var optionalTenantAdminRole = roleRepository.findByRoleName(RoleName.TENANT_ADMIN);
        var optionalSupervisorRole = roleRepository.findByRoleName(RoleName.SUPERVISOR);
        var optionalStudentRole = roleRepository.findByRoleName(RoleName.STUDENT);

        if (optionalInternalAdminRole.isPresent() && role.getRoleName() == RoleName.INTERNAL_ADMIN) {
            log.error("Role: {} already present", role.getRoleName());
            return null;
        } else if (optionalTenantAdminRole.isPresent() && Objects.equals(role.getRoleName(), RoleName.TENANT_ADMIN)) {
            log.error("Role: {} already present", role.getRoleName());
            return null;
        } else if (optionalSupervisorRole.isPresent() && Objects.equals(role.getRoleName(), RoleName.SUPERVISOR)) {
            log.error("Role: {} already present", role.getRoleName());
            return null;
        } else if (optionalStudentRole.isPresent() && Objects.equals(role.getRoleName(), RoleName.STUDENT)) {
            log.error("Role: {} already present", role.getRoleName());
            return null;
        } else {
            return roleRepository.save(role);
        }
    }

    public Optional<AppUser> getUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}