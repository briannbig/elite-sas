package elite.sas.api.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GRPCServer {

    @Value("${elite-sas.grpc.server.port}")
    private String port = "9001";


    private final UserService userService;
    private final ApplicationService applicationService;
    private final TenantService tenantService;
    private final StudentService studentService;
    private final InternshipService internshipService;


    public void startServer() {
        log.info("starting grpc server...");
        Server server = ServerBuilder.forPort(Integer.parseInt(port))
                .addService(userService)
                .addService(applicationService)
                .addService(tenantService)
                .addService(studentService)
                .addService(internshipService)
                .build();

        log.info("starting grppc server on port {}", port);
        try {
            server.start();
            log.info("grpc server started");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
