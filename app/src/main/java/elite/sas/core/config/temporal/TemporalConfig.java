package elite.sas.core.config.temporal;

import elite.sas.core.activities.LogBookActivityImpl;
import elite.sas.core.activities.NotificationsActivityImpl;
import elite.sas.core.activities.RegistrationActivityImpl;
import elite.sas.core.repository.*;
import elite.sas.core.workflows.ProcessDailyLogBookWorkflowImpl;
import elite.sas.core.workflows.RegisterStudentWorkflowImpl;
import elite.sas.core.workflows.TenantRegistrationWorkflowImpl;
import elite.sas.core.workflows.UserAccountRegistrationWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TemporalConfig {
    @Autowired
    private final TenantRepository tenantRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final LogRepository logRepository;
    @Autowired
    private final AttachmentWeekRepository attachmentWeekRepository;

    @Autowired
    private final AttachmentRepository attachmentRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Bean
    WorkflowClient workflowClient() {
        WorkflowServiceStubs workflowServiceStubs = WorkflowServiceStubs.newLocalServiceStubs();
        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public WorkerFactory defaultWorkerFactory() {
        WorkerFactory workerFactory = WorkerFactory.newInstance(workflowClient());
        Worker worker = workerFactory.newWorker("SAS_TASK_QUEUE");

        var registrationActivity = new RegistrationActivityImpl(
                accountRepository,
                roleRepository,
                userRepository,
                tenantRepository,
                studentRepository,
                courseRepository,
                passwordEncoder
        );
        var notificationsActivity = new NotificationsActivityImpl();

        var logBookActivity = new LogBookActivityImpl(attachmentWeekRepository, attachmentRepository, logRepository);

        worker.registerWorkflowImplementationTypes(
                UserAccountRegistrationWorkflowImpl.class,
                TenantRegistrationWorkflowImpl.class,
                RegisterStudentWorkflowImpl.class,
                ProcessDailyLogBookWorkflowImpl.class
        );
        worker.registerActivitiesImplementations(registrationActivity, notificationsActivity, logBookActivity);

        return workerFactory;
    }


}
