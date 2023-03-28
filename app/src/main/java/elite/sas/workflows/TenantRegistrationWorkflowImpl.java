package elite.sas.workflows;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.config.temporal.TemporalConfig;
import elite.sas.entities.Tenant;
import elite.sas.entities.UserType;
import elite.sas.workflows.definition.TenantRegistrationWorkflow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TenantRegistrationWorkflowImpl implements TenantRegistrationWorkflow {

    @Autowired
    private final TemporalConfig config;


    @Override
    public Tenant handle(CreateTenantParams params) {

        // 1 create tenant;
        var optionalTenant = config.registrationActivity().registerTenant(params);
        if (optionalTenant.isEmpty()) {
            return null;
        }
        var tenant = optionalTenant.get();

        // 2 create admin account for tenant;
        var createUserParams = CreateUserParams.builder()
                .email(tenant.getEmail())
                .userName(tenant.getEmail())
                .userType(UserType.ADMIN)
                .password(tenant.getEmail())
                .passwordConfirm(tenant.getEmail())
                .firstName("Admin")
                .lastName(tenant.getName())
                .build();

        config.userAccountRegistrationWorkflow().handle(createUserParams);

        return tenant;
    }
}
