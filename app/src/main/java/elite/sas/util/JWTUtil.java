package elite.sas.util;

import elite.sas.entities.Account;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Brian Barasa
 */

@Component
@Slf4j
public class JWTUtil {

    @Value("${jwt-properties.app.jwtSecret}")
    private String jwtSecret;

//    @Value("${jwt-properties.app.jwtExpirationMs")
    private final int jwtExpirationMs = 86400000;

//    @Value("${jwt-properties.app.refreshExpirationMs}")
    private final int refreshExpirationMs = 864000000;


    public String generateJWT(Authentication authentication) {
        Account userDetails = (Account) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String generateRefreshJwtToken(Authentication authentication) {
        Account userDetails = (Account) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    public String newRefreshToken(String username) {



        return Jwts.builder()
                .setSubject((username))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + refreshExpirationMs)) //expires after 10 days
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String newAccessToken(String username) {



        return Jwts.builder()
                .setSubject((username))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) //expires after 1 day
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }



    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature:--> {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token:--> {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired:--> {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported:--> {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty:--> {}", e.getMessage());
        }

        return false;
    }


}
