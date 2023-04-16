package elite.sas.core.config.grpc;

import elite.sas.api.server.*;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.AttachmentService;
import elite.sas.core.service.CourseService;
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

    @Bean(name = "GRPCApplicationService")
    ApplicationService applicationService(elite.sas.core.service.ApplicationService applicationService) {
        return new ApplicationService(applicationService);
    }

    @Bean(name = "GRPCTenantService")
    TenantService tenantService(elite.sas.core.service.TenantService tenantService) {
        return new TenantService(tenantService);
    }

    @Bean
    InternshipService internshipService(AttachmentService attachmentService) {
        return new InternshipService(attachmentService);
    }


    @Bean(name = "GRPCStudentService")
    StudentService studentService(elite.sas.core.service.StudentService studentService, CourseService courseService) {
        return new StudentService(studentService, courseService);
    }

    @Bean
    GRPCServer grpcServer(UserService userService, ApplicationService applicationService,
                          TenantService tenantService, StudentService studentService,
                          InternshipService internshipService
    ) {
        return new GRPCServer(userService, applicationService, tenantService, studentService, internshipService);
    }


}
