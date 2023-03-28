package elite.sas;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.config.temporal.TemporalConfig;
import elite.sas.cron.LogsCronRunner;
import elite.sas.entities.TenantType;
import io.temporal.worker.WorkerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    @Bean
    CommandLineRunner startLogsCronRunner(WorkerFactory workerFactory) {
        return args -> {
            workerFactory.start();
            LogsCronRunner.getInstance().run();
        };
    }

    @Bean
    public CommandLineRunner saveSampleUser(WorkerFactory workerFactory, TemporalConfig config) {
        return args -> {
            workerFactory.start();
            log.info("Creating default tenant");
            config.tenantRegistrationWorkflow().handle(
                    new CreateTenantParams("Brian holdings ltd", "Nairobi kenya", "098736363", "brian@holdings.com", TenantType.COMPANY)
            );

        };
    }

}
