package elite.sas.core.workflows;

import elite.sas.core.activities.definition.NotificationsActivity;
import elite.sas.core.entities.*;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.workflows.definition.TenantRegistrationWorkflow;
import elite.sas.core.activities.definition.RegistrationActivity;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.workflows.definition.WorkflowStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TenantRegistrationWorkflowImpl implements TenantRegistrationWorkflow {

    private final RegistrationActivity registrationActivity = TemporalUtil.registrationActivitiesStub();
    private final NotificationsActivity notificationsActivity = TemporalUtil.notificationsActivityStub();

    private WorkflowStatus status = WorkflowStatus.STARTED;

    @Override
    public WorkflowStatus getStatus() {
        return status;
    }

    @Override
    public Tenant handle(CreateTenantParams params) {

        status = WorkflowStatus.EXECUTING;

        // 1 create tenant;
        var optionalTenant = registrationActivity.registerTenant(params);
        if (optionalTenant.isEmpty()) {
            status = WorkflowStatus.FAILED;
            return null;
        }
        var tenant = optionalTenant.get();

        // 2 create admin account for tenant;
        List<Role> roles = new ArrayList<>();

        if (tenant.getTenantType() == TenantType.INTERNAL) {
            roles.add(
                    Role.builder()
                            .roleName(RoleName.INTERNAL_ADMIN)
                            .build()
            );
        }

        roles.add(
                Role.builder()
                        .roleName(RoleName.TENANT_ADMIN)
                        .build()
            );

        var createUserParams = CreateUserParams.builder()
                .tenantId(tenant.getId())
                .email(tenant.getEmail())
                .userName(tenant.getEmail())
                .userType(UserType.ADMIN)
                .password(tenant.getEmail())
                .passwordConfirm(tenant.getEmail())
                .firstName("Admin")
                .lastName(tenant.getName())
                .roles(roles)
                .build();

        var user = registrationActivity.createUserAccount(createUserParams);
        if (user.isEmpty()) {
            status = WorkflowStatus.FAILED;
            return tenant;
        }

        // send notification

        Map<String, String> data = new HashMap<>();
        data.put("title", "User creation Successful!");
        notificationsActivity.sendNotification(user.get(), data);

        status = WorkflowStatus.SUCCESSFUL;


        return tenant;
    }
}
