package elite.sas.core.config.grpc;

import elite.sas.api.server.GRPCServer;
import elite.sas.api.server.UserService;
import elite.sas.core.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GRPCConfig {


    @Bean
    UserService userService(AppUserService appUserService) {
        return new UserService(appUserService);
    }

    @Bean
    GRPCServer grpcServer(UserService userService) {
        return new GRPCServer(userService);
    }


}