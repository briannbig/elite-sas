package elite.sas.workflows;

import elite.sas.util.TemporalUtil;
import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.api.params.CreateTenantParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.Tenant;
import elite.sas.entities.UserType;
import elite.sas.workflows.definition.TenantRegistrationWorkflow;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TenantRegistrationWorkflowImpl implements TenantRegistrationWorkflow {

    private final RegistrationActivity registrationActivity = TemporalUtil.registrationActivitiesStub();
    @Override
    public Tenant handle(CreateTenantParams params) {

        // 1 create tenant;
        var optionalTenant = registrationActivity.registerTenant(params);
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

        TemporalUtil.userAccountRegistrationWorkflow().handle(createUserParams);

        return tenant;
    }
}
