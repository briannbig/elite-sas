package elite.sas.api.login;


import elite.sas.api.params.CreateUserParams;
import elite.sas.api.params.LoginParams;
import elite.sas.api.params.TokenRefreshParams;
import elite.sas.api.response.JWTResponse;
import elite.sas.api.response.TokenRefreshResponse;
import elite.sas.entities.AppUser;
import elite.sas.service.AppUserService;
import elite.sas.util.TemporalUtil;
import elite.sas.workflows.definition.UserAccountRegistrationWorkflow;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Brian Barasa
 */
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Login")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    @Autowired
    private AppUserService userService;

    private final UserAccountRegistrationWorkflow userAccountRegistrationWorkflow = TemporalUtil.userAccountRegistrationWorkflow();


    @PostMapping("/sign-in")
    public ResponseEntity<JWTResponse> login(@RequestBody LoginParams request) {
        log.debug("login request: --> {}", request);
        JWTResponse jwtResponse = userService.login(request);

        return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
    }

    @PostMapping("/sign-up")

    public ResponseEntity<AppUser> Register(@RequestBody CreateUserParams request) {

        //return userService.signUp(request);
        var appUser = userAccountRegistrationWorkflow.handle(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(appUser);

    }

    @PostMapping("/refresh-token")

    public ResponseEntity<TokenRefreshResponse> RefreshToken(@RequestBody TokenRefreshParams request) {

        log.info(" RefreshToken to generate new access token:-->{}",request);
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.generateRefreshToken(request));

        //return userService.genarateRefreshToken(tokenRefreshRequest);


    }

}
