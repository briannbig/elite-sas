package elite.sas.api;

import elite.sas.api.exceptions.UnretriableException;
import elite.sas.api.grpc.*;
import elite.sas.core.entities.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class ApiUtil {

    public static AppUser appUserFromApi(UserServiceProto.AppUser appUser) throws UnretriableException {
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
                        .roleName(tenantFromApi(r.getRoleName()))
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
                .tenant(tenantFromApi(appUser.getTenant()))
                .userType(userTypeFromAPi(appUser.getUserType()))
                .roles(roleSet);

        return userBuilder.build();
    }

    public static Tenant tenantFromApi(TenantServiceProto.Tenant tenant) throws UnretriableException {
        if (Objects.isNull(tenant.getId()) || Objects.isNull(tenant.getEmail()) ||
                Objects.isNull(tenant.getName()) || Objects.isNull(tenant.getTenantType())
        ) {
            throw new UnretriableException();
        }

        Tenant.TenantBuilder tenantBuilder = Tenant.builder()
                .Id(UUID.fromString(tenant.getId()))
                .email(tenant.getEmail())
                .name(tenant.getName())
                .tenantType(TenantType.valueOf(tenant.getTenantType().name()));

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

    public static RoleName tenantFromApi(CommonsProto.RoleName roleName) throws UnretriableException {
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

    public static Course courseFromApi(CourseServiceProto.Course apiCourse) throws UnretriableException {
        if (Objects.isNull(apiCourse.getId()) || Objects.isNull(apiCourse.getName()) ||
                Objects.isNull(apiCourse.getCourseLevel())
        ) {
            throw new UnretriableException();
        }
        return Course.builder()
                .Id(UUID.fromString(apiCourse.getId()))
                .name(apiCourse.getName())
                .courseLevel(CourseLevel.valueOf(apiCourse.getCourseLevel().name()))
                .build();
    }

    public static Listing listingFromApi(ApplicationServiceProto.Listing apiListing) throws UnretriableException {
        if (Objects.isNull(apiListing.getId()) || !apiListing.hasTenant() ||
                !apiListing.hasCourse()
        ) {
            throw new UnretriableException();
        }
        var listingBuilder = Listing.builder()
                .Id(UUID.fromString(apiListing.getId()))
                .tenant(tenantFromApi(apiListing.getTenant()))
                .course(courseFromApi(apiListing.getCourse()));

        if (Objects.nonNull(apiListing.getDescription())) {
            listingBuilder.description(apiListing.getDescription());
        }

        if (Objects.nonNull(apiListing.getAttachmentPeriod())) {
            listingBuilder.attachmentPeriod(AttachmentPeriod.valueOf(apiListing.getAttachmentPeriod().name()));
        }

        if (Objects.nonNull(apiListing.getDeadline())) {

        }

        return listingBuilder.build();

    }


    public static Application applicationFromApi(ApplicationServiceProto.Application apiApplication) throws UnretriableException {
        if (Objects.isNull(apiApplication.getId()) || Objects.isNull(apiApplication.getApplicant()) ||
                Objects.isNull(apiApplication.getListing())
        ) {
            throw new UnretriableException();
        }

        var builder = Application.builder()
                .Id(UUID.fromString(apiApplication.getId()))
                .applicant(appUserFromApi(apiApplication.getApplicant()))
                .listing(listingFromApi(apiApplication.getListing()));

        if (Objects.nonNull(apiApplication.getApplication())) {
            builder.application(apiApplication.getApplication());
        }

        if (Objects.nonNull(apiApplication.getCvUrl())) {
            builder.cvUrl(apiApplication.getCvUrl());
        }

        if (Objects.nonNull(apiApplication.getApplicationStatus())) {
            builder.applicationStatus(ApplicationStatus.valueOf(apiApplication.getApplicationStatus().name()));
        }

        return builder.build();
    }


    /*
     To Api
    */

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
                .setUserType(CommonsProto.UserType.valueOf(appUser.getUserType().name()))
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


    public static CommonsProto.RoleName roleNameToApi(RoleName roleName) throws UnretriableException {
        switch (roleName.name()) {
            case "STUDENT":
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

    public static CourseServiceProto.Course courseToApi(Course course) throws UnretriableException {
        if (Objects.isNull(course.getId()) || Objects.isNull(course.getName()) ||
                Objects.isNull(course.getCourseLevel())
        ) {
            throw new UnretriableException();
        }
        return CourseServiceProto.Course.newBuilder()
                .setId(String.valueOf(course.getId()))
                .setName(course.getName())
                .setCourseLevel(CommonsProto.CourseLevel.valueOf(course.getCourseLevel().name()))
                .build();
    }

    public static ApplicationServiceProto.Listing listingToApi(Listing listing) throws UnretriableException {
        if (Objects.isNull(listing.getId()) || Objects.isNull(listing.getCourse()) ||
                Objects.isNull(listing.getTenant())
        ) {
            throw new UnretriableException();
        }
        var listingBuilder = ApplicationServiceProto.Listing.newBuilder()
                .setId(String.valueOf(listing.getId()))
                .setTenant(tenantToApi(listing.getTenant()))
                .setCourse(courseToApi(listing.getCourse()));

        return listingBuilder.build();
    }

    public static ApplicationServiceProto.Application applicationToApi(Application application) throws UnretriableException {
        if (Objects.isNull(application.getId()) || Objects.isNull(application.getApplicant()) ||
                Objects.isNull(application.getListing())
        ) {
            throw new UnretriableException();
        }

        var builder = ApplicationServiceProto.Application.newBuilder()
                .setId(String.valueOf(application.getId()))
                .setApplicant(appUserToApi(application.getApplicant()))
                .setListing(listingToApi(application.getListing()));

        if (Objects.nonNull(application.getApplication())) {
            builder.setApplication(application.getApplication());
        }

        if (Objects.nonNull(application.getCvUrl())) {
            builder.setCvUrl(application.getCvUrl());
        }

        if (Objects.nonNull(application.getApplicationStatus())) {
            builder.setApplicationStatus(CommonsProto.ApplicationStatus.valueOf(application.getApplicationStatus().name()));
        }

        return builder.build();
    }

}
