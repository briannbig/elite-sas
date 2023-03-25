package elite.sas.config.security;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    /**This method "commence()"will be triggered anytime unauthenticated User requests
     * a secured HTTP resource and an AuthenticationException is thrown.*/
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error("Unauthorized error:--> {}", authException.getMessage());
        //HttpServletResponse.SC_UNAUTHORIZED is the 401 Status code.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized" + authException.getMessage());
        response.setHeader("error",authException.getMessage());
    }

}
