package elite.sas.api;

import com.google.protobuf.Timestamp;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.grpc.*;
import elite.sas.core.entities.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ApiUtil {

    public static AppUser appUserFromApi(UserServiceProto.AppUser appUser) throws ModelConversionException {
        if (Objects.isNull(appUser.getId()) || Objects.isNull(appUser.getEmail()) ||
                Objects.isNull(appUser.getFirstName()) || Objects.isNull(appUser.getLastName()) ||
                Objects.isNull(appUser.getUserName()) || !appUser.hasTenant() ||
                Objects.isNull(appUser.getUserType()) || appUser.getRolesList().isEmpty()
        ) {
            throw new ModelConversionException();
        }

        Set<Role> roleSet = appUser.getRolesList().stream().map(r -> {
            try {
                return Role.builder()
                        .Id(UUID.fromString(r.getId()))
                        .roleName(roleNameFromApi(r.getRoleName()))
                        .build();
            } catch (ModelConversionException e) {
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

    public static Account accountFromApi(UserServiceProto.Account apiAccount) throws ModelConversionException {
        if (Objects.isNull(apiAccount.getId()) || Objects.isNull(apiAccount.getAppUser()) || Objects.isNull(apiAccount.getPassword())) {
            throw new ModelConversionException("Bad account data");
        }
        return Account.builder()
                .Id(UUID.fromString(apiAccount.getId()))
                .appUser(appUserFromApi(apiAccount.getAppUser()))
                .password(apiAccount.getPassword())
                .build();
    }

    public static Tenant tenantFromApi(TenantServiceProto.Tenant tenant) throws ModelConversionException {
        if (Objects.isNull(tenant.getId()) || Objects.isNull(tenant.getEmail()) ||
                Objects.isNull(tenant.getName()) || Objects.isNull(tenant.getTenantType())
        ) {
            throw new ModelConversionException();
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

    public static Student studentFromApi(CourseServiceProto.Student apiStudent) throws ModelConversionException {
        if (Objects.isNull(apiStudent.getId()) || !apiStudent.hasAppUser()
                || Objects.isNull(apiStudent.getAdmissionNumber()) ||
                apiStudent.hasCourse()
        ) {
            throw new ModelConversionException("Missing required field(s)");
        }

        var student = Student.builder()
                .Id(UUID.fromString(apiStudent.getId()))
                .admissionNumber(apiStudent.getAdmissionNumber())
                .appUser(appUserFromApi(apiStudent.getAppUser()))
                .course(courseFromApi(apiStudent.getCourse()))
                .build();

        return student;
    }

    public static UserType userTypeFromAPi(CommonsProto.UserType userType) throws ModelConversionException {
        switch (userType.name()) {
            case "STUDENT":
                return UserType.STUDENT;
            case "SUPERVISOR":
                return UserType.SUPERVISOR;
            case "ADMIN":
                return UserType.ADMIN;
            default:
                throw new ModelConversionException();
        }
    }

    public static RoleName roleNameFromApi(CommonsProto.RoleName roleName) throws ModelConversionException {
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
                throw new ModelConversionException();
        }
    }

    public static TenantType tenantTypeFromApi(CommonsProto.TenantType tenantType) {
        return TenantType.valueOf(tenantType.name());
    }

    public static CourseLevel courseLevelFromApi(CommonsProto.CourseLevel apiCourseLevel) {
        return CourseLevel.valueOf(apiCourseLevel.name());
    }

    public static Course courseFromApi(CourseServiceProto.Course apiCourse) throws ModelConversionException {
        if (Objects.isNull(apiCourse.getId()) || Objects.isNull(apiCourse.getName()) ||
                Objects.isNull(apiCourse.getCourseLevel())
        ) {
            throw new ModelConversionException();
        }
        return Course.builder()
                .Id(UUID.fromString(apiCourse.getId()))
                .name(apiCourse.getName())
                .courseLevel(CourseLevel.valueOf(apiCourse.getCourseLevel().name()))
                .build();
    }

    public static Listing listingFromApi(ApplicationServiceProto.Listing apiListing) throws ModelConversionException {
        if (Objects.isNull(apiListing.getId()) || !apiListing.hasTenant() ||
                !apiListing.hasCourse()
        ) {
            throw new ModelConversionException();
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

    public static Attachment attachmentFromApi(InternshipServiceProto.Attachment apiAttachment) throws ModelConversionException {
        if (Objects.isNull(apiAttachment.getId()) || !apiAttachment.hasStudent() ||
                !apiAttachment.hasCompany() || Objects.isNull(apiAttachment.getAttachmentPeriod())
        ) {
            throw new ModelConversionException();
        }

        Attachment.AttachmentBuilder attachmentBuilder = Attachment.builder()
                .Id(UUID.fromString(apiAttachment.getId()))
                .student(studentFromApi(apiAttachment.getStudent()))
                .tenant(tenantFromApi(apiAttachment.getCompany()))
                .attachmentPeriod(attachmentPeriodFromApi(apiAttachment.getAttachmentPeriod()));

        if (Objects.nonNull(apiAttachment.getStartDate())) {
            attachmentBuilder.startDate(timeStampFromApi(apiAttachment.getStartDate()));
        }

        if (Objects.nonNull(apiAttachment.getEndDate())) {
            attachmentBuilder.endDate(timeStampFromApi(apiAttachment.getEndDate()));
        }

        List<AttachmentWeek> attachmentWeeksFromApi = apiAttachment.getAttachmentWeeksList().stream().map(
                attachmentWeek -> {
                    try {
                        return attachmentWeekFromApi(attachmentWeek);
                    } catch (ModelConversionException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).toList();

        attachmentBuilder.attachmentWeeks(attachmentWeeksFromApi);

        return attachmentBuilder.build();
    }

    public static AttachmentWeek attachmentWeekFromApi(InternshipServiceProto.AttachmentWeek apiAttachmentWeek) throws ModelConversionException {
        if (Objects.isNull(apiAttachmentWeek.getId()) || Objects.isNull(apiAttachmentWeek.getWeekNumber())) {
            throw new ModelConversionException();
        }
        AttachmentWeek.AttachmentWeekBuilder builder = AttachmentWeek.builder()
                .Id(UUID.fromString(apiAttachmentWeek.getId()))
                .weekNumber(apiAttachmentWeek.getWeekNumber());

        if (Objects.nonNull(apiAttachmentWeek.getWeekSummary())) {
            builder.weekSummary(apiAttachmentWeek.getWeekSummary());
        }

        if (Objects.nonNull(apiAttachmentWeek.getStudentComment())) {
            builder.studentComment(apiAttachmentWeek.getStudentComment());
        }

        if (Objects.nonNull(apiAttachmentWeek.getIndustrySupervisorComment())) {
            builder.industrySupervisorComment(apiAttachmentWeek.getIndustrySupervisorComment());
        }

        if (Objects.nonNull(apiAttachmentWeek.getSchoolSupervisorComment())) {
            builder.schoolSupervisorComment(apiAttachmentWeek.getSchoolSupervisorComment());
        }

        builder.isActive(apiAttachmentWeek.getIsActive());

        List<Log> apiLogsList = apiAttachmentWeek.getLogsList().stream().map(log -> {
            try {
                return logFromApi(log);
            } catch (ModelConversionException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        builder.logs(apiLogsList);


        return builder.build();

    }

    public static Log logFromApi(InternshipServiceProto.Log apiLog) throws ModelConversionException {
        if (Objects.isNull(apiLog.getId()) || Objects.isNull(apiLog.getAttachmentWeekId())) {
            throw new ModelConversionException();
        }

        AttachmentWeek attachmentWeek = AttachmentWeek.builder().Id(UUID.fromString(apiLog.getAttachmentWeekId())).build();

        Log.LogBuilder logBuilder = Log.builder().Id(UUID.fromString(apiLog.getId()))
                .attachmentWeek(attachmentWeek);

        if (Objects.nonNull(apiLog.getWorkDone())) {
            logBuilder.workDone(apiLog.getWorkDone());
        }

        if (Objects.nonNull(apiLog.getIndustrySupervisorComment())) {
            logBuilder.industrySupervisorComment(apiLog.getIndustrySupervisorComment());
        }

        if (Objects.nonNull(apiLog.getSchoolSupervisorComment())) {
            logBuilder.schoolSupervisorComment(apiLog.getSchoolSupervisorComment());
        }

        return logBuilder.build();

    }

    public static AttachmentPeriod attachmentPeriodFromApi(CommonsProto.AttachmentPeriod apiAttachmentPeriod) {
        return AttachmentPeriod.valueOf(apiAttachmentPeriod.name());
    }

    public static LocalDateTime timeStampFromApi(Timestamp apiTimestamp) {
        Instant instant = Instant.ofEpochSecond(apiTimestamp.getSeconds(), apiTimestamp.getNanos())
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }


    public static Application applicationFromApi(ApplicationServiceProto.Application apiApplication) throws ModelConversionException {
        if (Objects.isNull(apiApplication.getId()) || Objects.isNull(apiApplication.getApplicant()) ||
                Objects.isNull(apiApplication.getListing())
        ) {
            throw new ModelConversionException();
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

    public static UserServiceProto.AppUser appUserToApi(AppUser appUser) throws ModelConversionException {
        if (Objects.isNull(appUser.getId()) || Objects.isNull(appUser.getEmail()) ||
                Objects.isNull(appUser.getFirstName()) || Objects.isNull(appUser.getLastName()) ||
                Objects.isNull(appUser.getUserName()) || Objects.isNull(appUser.getTenant()) ||
                Objects.isNull(appUser.getUserType()) || appUser.getRoles().isEmpty()
        ) {
            throw new ModelConversionException();
        }

        Set<UserServiceProto.Role> roleSet = appUser.getRoles().stream().map(r -> {
            try {
                return UserServiceProto.Role.newBuilder()
                        .setId(String.valueOf(r.getId()))
                        .setRoleName(roleNameToApi(r.getRoleName()))
                        .build();
            } catch (ModelConversionException e) {
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

    public static UserServiceProto.Account accountToApi(Account account) throws ModelConversionException {
        if (Objects.isNull(account.getId()) || Objects.isNull(account.getAppUser()) || Objects.isNull(account.getPassword())) {
            throw new ModelConversionException("Bad account data");
        }
        return UserServiceProto.Account.newBuilder()
                .setId(String.valueOf(account.getId()))
                .setAppUser(appUserToApi(account.getAppUser()))
                .setPassword(account.getPassword())
                .build();
    }

    public static TenantServiceProto.Tenant tenantToApi(Tenant tenant) throws ModelConversionException {
        if (Objects.isNull(tenant.getId()) || Objects.isNull(tenant.getEmail()) ||
                Objects.isNull(tenant.getName()) || Objects.isNull(tenant.getTenantType())
        ) {
            throw new ModelConversionException("Bad tenant data");
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

    public static CourseServiceProto.Student studentToApi(Student student) throws ModelConversionException {
        if (Objects.isNull(student.getId()) || Objects.isNull(student.getAppUser()) ||
                Objects.isNull(student.getAdmissionNumber()) || Objects.isNull(student.getCourse())
        ) {
            throw new ModelConversionException("Missing required field(s)");
        }

        var apiStudent = CourseServiceProto.Student.newBuilder()
                .setId(String.valueOf(student.getId()))
                .setAdmissionNumber(student.getAdmissionNumber())
                .setAppUser(appUserToApi(student.getAppUser()))
                .setCourse(courseToApi(student.getCourse()))
                .build();

        return apiStudent;
    }

    public static CommonsProto.RoleName roleNameToApi(RoleName roleName) throws ModelConversionException {
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
                throw new ModelConversionException();
        }
    }

    public static CommonsProto.TenantType tenantTypeToApi(TenantType tenantType) throws ModelConversionException {
        switch (tenantType.name()) {
            case "SCHOOL":
                return CommonsProto.TenantType.SCHOOL;
            case "COMPANY":
                return CommonsProto.TenantType.COMPANY;
            case "INTERNAL":
                return CommonsProto.TenantType.INTERNAL;
            default:
                throw new ModelConversionException();
        }
    }

    public static CommonsProto.CourseLevel courseLevelToApi(CommonsProto.CourseLevel courseLevel) {
        return CommonsProto.CourseLevel.valueOf(courseLevel.name());
    }

    public static CourseServiceProto.Course courseToApi(Course course) throws ModelConversionException {
        if (Objects.isNull(course.getId()) || Objects.isNull(course.getName()) ||
                Objects.isNull(course.getCourseLevel())
        ) {
            throw new ModelConversionException();
        }
        return CourseServiceProto.Course.newBuilder()
                .setId(String.valueOf(course.getId()))
                .setName(course.getName())
                .setCourseLevel(CommonsProto.CourseLevel.valueOf(course.getCourseLevel().name()))
                .build();
    }

    public static ApplicationServiceProto.Listing listingToApi(Listing listing) throws ModelConversionException {
        if (Objects.isNull(listing.getId()) || Objects.isNull(listing.getCourse()) ||
                Objects.isNull(listing.getTenant())
        ) {
            throw new ModelConversionException();
        }
        var listingBuilder = ApplicationServiceProto.Listing.newBuilder()
                .setId(String.valueOf(listing.getId()))
                .setTenant(tenantToApi(listing.getTenant()))
                .setCourse(courseToApi(listing.getCourse()));

        return listingBuilder.build();
    }

    public static InternshipServiceProto.Attachment attachmentToApi(Attachment attachment) throws ModelConversionException {
        if (Objects.isNull(attachment.getId()) || Objects.isNull(attachment.getStudent()) ||
                Objects.isNull(attachment.getTenant()) || Objects.isNull(attachment.getAttachmentPeriod())
        ) {
            throw new ModelConversionException();
        }

        InternshipServiceProto.Attachment.Builder attachmentBuilder = InternshipServiceProto.Attachment.newBuilder()
                .setId(String.valueOf(attachment.getId()))
                .setStudent(studentToApi(attachment.getStudent()))
                .setCompany(tenantToApi(attachment.getTenant()))
                .setAttachmentPeriod(attachmentPeriodToApi(attachment.getAttachmentPeriod()));

        if (Objects.nonNull(attachment.getStartDate())) {
            attachmentBuilder.setStartDate(timeStampToApi(attachment.getStartDate()));
        }

        if (Objects.nonNull(attachment.getEndDate())) {
            attachmentBuilder.setEndDate(timeStampToApi(attachment.getEndDate()));
        }

        List<InternshipServiceProto.AttachmentWeek> attachmentWeekList = attachment.getAttachmentWeeks().stream().map(
                attachmentWeek -> {
                    try {
                        return attachmentWeekToApi(attachmentWeek);
                    } catch (ModelConversionException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).toList();

        attachmentBuilder.addAllAttachmentWeeks(attachmentWeekList);

        return attachmentBuilder.build();
    }

    public static InternshipServiceProto.AttachmentWeek attachmentWeekToApi(AttachmentWeek attachmentWeek) throws ModelConversionException {
        if (Objects.isNull(attachmentWeek.getId()) || Objects.isNull(attachmentWeek.getWeekNumber())) {
            throw new ModelConversionException();
        }
        InternshipServiceProto.AttachmentWeek.Builder builder = InternshipServiceProto.AttachmentWeek.newBuilder()
                .setId(String.valueOf(attachmentWeek.getId()))
                .setWeekNumber(attachmentWeek.getWeekNumber());

        if (Objects.nonNull(attachmentWeek.getWeekSummary())) {
            builder.setWeekSummary(attachmentWeek.getWeekSummary());
        }

        if (Objects.nonNull(attachmentWeek.getStudentComment())) {
            builder.setStudentComment(attachmentWeek.getStudentComment());
        }

        if (Objects.nonNull(attachmentWeek.getIndustrySupervisorComment())) {
            builder.setIndustrySupervisorComment(attachmentWeek.getIndustrySupervisorComment());
        }

        if (Objects.nonNull(attachmentWeek.getSchoolSupervisorComment())) {
            builder.setSchoolSupervisorComment(attachmentWeek.getSchoolSupervisorComment());
        }

        builder.setIsActive(attachmentWeek.isActive());

        List<InternshipServiceProto.Log> logsList = attachmentWeek.getLogs().stream().map(log -> {
            try {
                return logToApi(log);
            } catch (ModelConversionException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        builder.addAllLogs(logsList);


        return builder.build();


    }

    public static InternshipServiceProto.Log logToApi(Log log) throws ModelConversionException {
        if (Objects.isNull(log.getId()) || Objects.isNull(log.getAttachmentWeek())) {
            throw new ModelConversionException();
        }

        InternshipServiceProto.Log.Builder builder = InternshipServiceProto.Log.newBuilder()
                .setId(String.valueOf(log.getId()))
                .setAttachmentWeekId(String.valueOf(log.getAttachmentWeek().getId()));

        if (Objects.nonNull(log.getWorkDone())) {
            builder.setWorkDone(log.getWorkDone());
        }

        if (Objects.nonNull(log.getIndustrySupervisorComment())) {
            builder.setIndustrySupervisorComment(log.getIndustrySupervisorComment());
        }

        if (Objects.nonNull(log.getSchoolSupervisorComment())) {
            builder.setSchoolSupervisorComment(log.getSchoolSupervisorComment());
        }

        return builder.build();

    }

    public static CommonsProto.AttachmentPeriod attachmentPeriodToApi(AttachmentPeriod attachmentPeriod) {
        return CommonsProto.AttachmentPeriod.valueOf(attachmentPeriod.name());
    }

    public static Timestamp timeStampToApi(LocalDateTime localDateTime) {
        Instant instant = Instant.ofEpochSecond(localDateTime.getSecond(), localDateTime.getNano())
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    public static ApplicationServiceProto.Application applicationToApi(Application application) throws ModelConversionException {
        if (Objects.isNull(application.getId()) || Objects.isNull(application.getApplicant()) ||
                Objects.isNull(application.getListing())
        ) {
            throw new ModelConversionException();
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
