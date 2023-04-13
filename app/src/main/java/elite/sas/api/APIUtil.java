package elite.sas.api;

import elite.sas.api.exceptions.UnretriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.TenantServiceProto;
import elite.sas.api.grpc.UserServiceProto;
import elite.sas.core.entities.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class APIUtil {

    public static AppUser fromApi(UserServiceProto.AppUser appUser) throws UnretriableException {
        if (Objects.isNull(appUser.getId()) || Objects.isNull(appUser.getEmail()) ||
                Objects.isNull(appUser.getFirstName()) || Objects.isNull(appUser.getLastName()) ||
                Objects.isNull(appUser.getUserName()) || !appUser.hasTenant() ||
                Objects.isNull(appUser.getUserType()) || appUser.getRolesList().isEmpty()
        ) {
            throw new UnretriableException();
        }

        Set<Role> roleSet = appUser.getRolesList().stream().map(r -> {
            try {
                return Role.builder()
                        .Id(UUID.fromString(r.getId()))
                        .roleName(fromApi(r.getRoleName()))
                        .build();
            } catch (UnretriableException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());

        AppUser.AppUserBuilder userBuilder = AppUser.builder();
        userBuilder.Id(UUID.fromString(appUser.getId()))
                .email(appUser.getEmail())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .userName(appUser.getUserName())
                .tenant(fromApi(appUser.getTenant()))
                .userType(userTypeFromAPi(appUser.getUserType()))
                .roles(roleSet);

        return userBuilder.build();
    }

    public static Tenant fromApi(TenantServiceProto.Tenant tenant) throws UnretriableException {
        if (Objects.isNull(tenant.getId()) || Objects.isNull(tenant.getEmail()) ||
                Objects.isNull(tenant.getName()) || Objects.isNull(tenant.getTenantType())
        ) {
            throw new UnretriableException();
        }

        Tenant.TenantBuilder tenantBuilder = Tenant.builder()
                .Id(UUID.fromString(tenant.getId()))
                .email(tenant.getEmail())
                .name(tenant.getName())
                .tenantType(tenantTypeFromApi(tenant.getTenantType()));

        if (Objects.isNull(tenant.getLocation())) {
            tenantBuilder.location(tenant.getLocation());
        }

        return tenantBuilder.build();
    }

    public static UserType userTypeFromAPi(CommonsProto.UserType userType) throws UnretriableException {
        switch (userType.name()) {
            case "STUDENT":
                return UserType.STUDENT;
            case "SUPERVISOR":
                return UserType.SUPERVISOR;
            case "ADMIN":
                return UserType.ADMIN;
            default:
                throw new UnretriableException();
        }
    }

    public static RoleName fromApi(CommonsProto.RoleName roleName) throws UnretriableException {
        switch (roleName.name()) {
            case "student":
                return RoleName.STUDENT;
            case "supervisor":
                return RoleName.SUPERVISOR;
            case "TENANT_ADMIN":
                return RoleName.TENANT_ADMIN;
            case "INTERNAL_ADMIN":
                return RoleName.INTERNAL_ADMIN;
            default:
                throw new UnretriableException();
        }
    }

    public static TenantType tenantTypeFromApi(CommonsProto.TenantType tenantType) throws UnretriableException {
        switch (tenantType.name()) {
            case "SCHOOL":
                return TenantType.SCHOOL;
            case "COMPANY":
                return TenantType.COMPANY;
            case "INTERNAL":
                return TenantType.INTERNAL;
            default:
                throw new UnretriableException();
        }
    }


    public static UserServiceProto.AppUser appUserToApi(AppUser appUser) throws UnretriableException {
        if (Objects.isNull(appUser.getId()) || Objects.isNull(appUser.getEmail()) ||
                Objects.isNull(appUser.getFirstName()) || Objects.isNull(appUser.getLastName()) ||
                Objects.isNull(appUser.getUserName()) || Objects.isNull(appUser.getTenant()) ||
                Objects.isNull(appUser.getUserType()) || appUser.getRoles().isEmpty()
        ) {
            throw new UnretriableException();
        }

        Set<UserServiceProto.Role> roleSet = appUser.getRoles().stream().map(r -> {
            try {
                return UserServiceProto.Role.newBuilder()
                        .setId(String.valueOf(r.getId()))
                        .setRoleName(roleNameToApi(r.getRoleName()))
                        .build();
            } catch (UnretriableException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());

        UserServiceProto.AppUser.Builder userBuilder = UserServiceProto.AppUser.newBuilder();

        userBuilder.setId(String.valueOf(appUser.getId()))
                .setEmail(appUser.getEmail())
                .setFirstName(appUser.getFirstName())
                .setLastName(appUser.getLastName())
                .setUserName(appUser.getUserName())
                .setTenant(tenantToApi(appUser.getTenant()))
                .setUserType(userTypeToAPi(appUser.getUserType()))
                .addAllRoles(roleSet);

        return userBuilder.build();
    }

    public static TenantServiceProto.Tenant tenantToApi(Tenant tenant) throws UnretriableException {
        if (Objects.isNull(tenant.getId()) || Objects.isNull(tenant.getEmail()) ||
                Objects.isNull(tenant.getName()) || Objects.isNull(tenant.getTenantType())
        ) {
            throw new UnretriableException("Bad tenant data");
        }

        TenantServiceProto.Tenant.Builder tenantBuilder = TenantServiceProto.Tenant.newBuilder()
                .setId(String.valueOf(tenant.getId()))
                .setEmail(tenant.getEmail())
                .setName(tenant.getName())
                .setTenantType(tenantTypeToApi(tenant.getTenantType()));

        if (Objects.isNull(tenant.getLocation())) {
            tenantBuilder.setLocation(tenant.getLocation());
        }

        return tenantBuilder.build();
    }

    public static CommonsProto.UserType userTypeToAPi(UserType userType) throws UnretriableException {
        switch (userType.name()) {
            case "STUDENT":
                return CommonsProto.UserType.STUDENT;
            case "SUPERVISOR":
                return CommonsProto.UserType.SUPERVISOR;
            case "ADMIN":
                return CommonsProto.UserType.ADMIN;
            default:
                throw new UnretriableException();
        }
    }


    public static CommonsProto.RoleName roleNameToApi(RoleName roleName) throws UnretriableException {
        switch (roleName.name()) {
            case "STUDENT" :
                return CommonsProto.RoleName.student;
            case "SUOERVISOR":
                return CommonsProto.RoleName.supervisor;
            case "TENANT_ADMIN":
                return CommonsProto.RoleName.TENANT_ADMIN;
            case "INTERNAL_ADMIN":
                return CommonsProto.RoleName.INTERNAL_ADMIN;
            default:
                throw new UnretriableException();
        }
    }

    public static CommonsProto.TenantType tenantTypeToApi(TenantType tenantType) throws UnretriableException {
        switch (tenantType.name()) {
            case "SCHOOL":
                return CommonsProto.TenantType.SCHOOL;
            case "COMPANY":
                return CommonsProto.TenantType.COMPANY;
            case "INTERNAL":
                return CommonsProto.TenantType.INTERNAL;
            default:
                throw new UnretriableException();
        }
    }
}
