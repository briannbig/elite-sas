package elite.sas;

import elite.sas.core.entities.Role;
import elite.sas.core.entities.RoleName;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.TenantService;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.cron.LogsCronRunner;
import elite.sas.core.entities.TenantType;
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
    public CommandLineRunner initAppRolesAndInternalAdmin(AppUserService appUserService, TenantService tenantService) {
        return args -> {

//            save roles
//          internal admin
            appUserService.saveRole(
                    Role.builder()
                            .roleName(RoleName.INTERNAL_ADMIN)
                            .build()
            );

//          tenant admin
            appUserService.saveRole(
                    Role.builder()
                            .roleName(RoleName.TENANT_ADMIN)
                            .build()
            );
//          supervisor
            appUserService.saveRole(
                    Role.builder()
                            .roleName(RoleName.SUPERVISOR)
                            .build()
            );
//          student
            appUserService.saveRole(
                    Role.builder()
                            .roleName(RoleName.STUDENT)
                            .build()
            );


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
