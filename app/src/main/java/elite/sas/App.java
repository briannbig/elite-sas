package elite.sas;

import elite.sas.service.TenantService;
import elite.sas.util.TemporalUtil;
import elite.sas.api.params.CreateTenantParams;
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
    public CommandLineRunner saveSampleUser(TenantService tenantService) {
        return args -> {
//            check if internal tenant exists and create one if false

            var optionalTenant = tenantService.getInternalTenant();
            if (optionalTenant.isPresent()){
                return;
            }

            log.info("Creating default tenant");
            TemporalUtil.tenantRegistrationWorkflow().handle(
                    new CreateTenantParams("Elite Student Attachment System", "Nairobi kenya", "0768656107", "support@elitesas.com", TenantType.INTERNAL)
            );

        };
    }

}
