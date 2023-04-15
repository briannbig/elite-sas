package elite.sas.api.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GRPCServer {

    private static final int port = 9001;
    private static GRPCServer INSTANCE = null;

    private final UserService userService;
    private final ApplicationService applicationService;


    public void startServer() {
        log.info("starting grpc server...");
        Server server = ServerBuilder.forPort(port)
                .addService(userService)
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
