package elite.sas.api;

import com.google.protobuf.Timestamp;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.grpc.*;
import elite.sas.core.entities.*;
import jakarta.annotation.Nullable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static elite.sas.api.StrUtil.*;

public final class ApiUtil {

    public static AppUser appUserFromApi(UserServiceProto.AppUser apiAppUser) throws ModelConversionException {
        if (
                areStrEmpty(apiAppUser.getId(), apiAppUser.getEmail(), apiAppUser.getFirstName(), apiAppUser.getLastName(), apiAppUser.getUserName(), apiAppUser.getUserType().name()) ||
                        apiAppUser.getRolesList().isEmpty() || !apiAppUser.hasTenant()
        ) {
            throw new ModelConversionException();
        }

        Set<Role> roleSet = apiAppUser.getRolesList().stream().map(r -> {
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
        userBuilder.Id(UUID.fromString(apiAppUser.getId()))
                .email(apiAppUser.getEmail())
                .firstName(apiAppUser.getFirstName())
                .lastName(apiAppUser.getLastName())
                .userName(apiAppUser.getUserName())
                .tenant(tenantFromApi(apiAppUser.getTenant()))
                .userType(userTypeFromAPi(apiAppUser.getUserType()))
                .roles(roleSet);

        if (apiAppUser.hasMetadata()) {
            var metadata = apiAppUser.getMetadata();
            userBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            userBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            userBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return userBuilder.build();
    }

    public static Account accountFromApi(UserServiceProto.Account apiAccount) throws ModelConversionException {
        if (areStrEmpty(apiAccount.getId(), apiAccount.getPassword(), apiAccount.getAppUser().getId())) {
            throw new ModelConversionException("Bad account data");
        }
        Account.AccountBuilder accountBuilder = Account.builder()
                .Id(UUID.fromString(apiAccount.getId()))
                .appUser(appUserFromApi(apiAccount.getAppUser()))
                .password(apiAccount.getPassword());

        if (apiAccount.hasMetadata()) {
            var metadata = apiAccount.getMetadata();
            accountBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            accountBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            accountBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return accountBuilder.build();

    }

    public static Tenant tenantFromApi(TenantServiceProto.Tenant apiTenant) throws ModelConversionException {
        if (areStrEmpty(apiTenant.getId(), apiTenant.getEmail(),
                        apiTenant.getName())
        ) {
            throw new ModelConversionException();
        }

        Tenant.TenantBuilder tenantBuilder = Tenant.builder()
                .Id(UUID.fromString(apiTenant.getId()))
                .email(apiTenant.getEmail())
                .name(apiTenant.getName())
                .tenantType(TenantType.valueOf(apiTenant.getTenantType().name()));

        if (areStrEmpty(apiTenant.getLocation())) {
            tenantBuilder.location(apiTenant.getLocation());
        }

        if (apiTenant.hasMetadata()) {
            var metadata = apiTenant.getMetadata();
            tenantBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            tenantBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            tenantBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return tenantBuilder.build();
    }

    public static Student studentFromApi(CourseServiceProto.Student apiStudent) throws ModelConversionException {
        if (areStrEmpty(apiStudent.getId(), apiStudent.getAdmissionNumber()) || !apiStudent.hasAppUser() || apiStudent.hasCourse()
        ) {
            throw new ModelConversionException("Missing required field(s)");
        }

        var studentBuilder = Student.builder()
                .Id(UUID.fromString(apiStudent.getId()))
                .admissionNumber(apiStudent.getAdmissionNumber())
                .appUser(appUserFromApi(apiStudent.getAppUser()))
                .course(courseFromApi(apiStudent.getCourse()));

        if (apiStudent.hasMetadata()) {
            var metadata = apiStudent.getMetadata();
            studentBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            studentBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            studentBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return studentBuilder.build();
    }

    public static UserType userTypeFromAPi(CommonsProto.UserType apiUserType) {
        return UserType.valueOf(apiUserType.name());
    }

    public static RoleName roleNameFromApi(CommonsProto.RoleName apiRoleName) throws ModelConversionException {
        return switch (apiRoleName.name()) {
            case "student" -> RoleName.STUDENT;
            case "supervisor" -> RoleName.SUPERVISOR;
            case "TENANT_ADMIN" -> RoleName.TENANT_ADMIN;
            case "INTERNAL_ADMIN" -> RoleName.INTERNAL_ADMIN;
            default -> throw new ModelConversionException();
        };
    }

    public static TenantType tenantTypeFromApi(CommonsProto.TenantType apiTenantType) {
        return TenantType.valueOf(apiTenantType.name());
    }

    public static CourseLevel courseLevelFromApi(CommonsProto.CourseLevel apiCourseLevel) {
        return CourseLevel.valueOf(apiCourseLevel.name());
    }

    public static Course courseFromApi(CourseServiceProto.Course apiCourse) throws ModelConversionException {
        if (areStrEmpty(apiCourse.getId(), apiCourse.getName())) {
            throw new ModelConversionException();
        }
        Course.CourseBuilder courseBuilder = Course.builder()
                .Id(UUID.fromString(apiCourse.getId()))
                .name(apiCourse.getName())
                .courseLevel(CourseLevel.valueOf(apiCourse.getCourseLevel().name()));

        if (apiCourse.hasMetadata()) {
            var metadata = apiCourse.getMetadata();
            courseBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            courseBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            courseBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return courseBuilder.build();
    }

    public static Listing listingFromApi(ApplicationServiceProto.Listing apiListing) throws ModelConversionException {
        if (areStrEmpty(apiListing.getId()) || !apiListing.hasTenant() ||
                !apiListing.hasCourse()
        ) {
            throw new ModelConversionException();
        }
        var listingBuilder = Listing.builder()
                .Id(UUID.fromString(apiListing.getId()))
                .tenant(tenantFromApi(apiListing.getTenant()))
                .course(courseFromApi(apiListing.getCourse()));

        if (!areStrEmpty(apiListing.getDescription())) {
            listingBuilder.description(apiListing.getDescription());
        }

        listingBuilder.attachmentPeriod(AttachmentPeriod.valueOf(apiListing.getAttachmentPeriod().name()));

        listingBuilder.deadline(timeStampFromApi(apiListing.getDeadline()));

        if (apiListing.hasMetadata()) {
            var metadata = apiListing.getMetadata();
            listingBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            listingBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            listingBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return listingBuilder.build();

    }

    public static Attachment attachmentFromApi(InternshipServiceProto.Attachment apiAttachment) throws ModelConversionException {
        if (areStrEmpty(apiAttachment.getId()) || !apiAttachment.hasStudent() || !apiAttachment.hasCompany()
        ) {
            throw new ModelConversionException();
        }

        Attachment.AttachmentBuilder attachmentBuilder = Attachment.builder()
                .Id(UUID.fromString(apiAttachment.getId()))
                .student(studentFromApi(apiAttachment.getStudent()))
                .tenant(tenantFromApi(apiAttachment.getCompany()))
                .attachmentPeriod(attachmentPeriodFromApi(apiAttachment.getAttachmentPeriod()));

        attachmentBuilder.startDate(timeStampFromApi(apiAttachment.getStartDate()));

        attachmentBuilder.endDate(timeStampFromApi(apiAttachment.getEndDate()));

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

        if (apiAttachment.hasMetadata()) {
            var metadata = apiAttachment.getMetadata();
            attachmentBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            attachmentBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            attachmentBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }

        return attachmentBuilder.build();
    }

    public static AttachmentWeek attachmentWeekFromApi(InternshipServiceProto.AttachmentWeek apiAttachmentWeek) throws ModelConversionException {
        if (areStrEmpty(apiAttachmentWeek.getId())) {
            throw new ModelConversionException();
        }
        AttachmentWeek.AttachmentWeekBuilder builder = AttachmentWeek.builder()
                .Id(UUID.fromString(apiAttachmentWeek.getId()))
                .weekNumber(apiAttachmentWeek.getWeekNumber());

        apiAttachmentWeek.getWeekSummary();
        builder.weekSummary(apiAttachmentWeek.getWeekSummary());

        apiAttachmentWeek.getStudentComment();
        builder.studentComment(apiAttachmentWeek.getStudentComment());

        apiAttachmentWeek.getIndustrySupervisorComment();
        builder.industrySupervisorComment(apiAttachmentWeek.getIndustrySupervisorComment());

        apiAttachmentWeek.getSchoolSupervisorComment();
        builder.schoolSupervisorComment(apiAttachmentWeek.getSchoolSupervisorComment());

        builder.isActive(apiAttachmentWeek.getIsActive());

        List<Log> apiLogsList = apiAttachmentWeek.getLogsList().stream().map(log -> {
            try {
                return logFromApi(log);
            } catch (ModelConversionException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        builder.logs(apiLogsList);

        if (apiAttachmentWeek.hasMetadata()) {
            var metadata = apiAttachmentWeek.getMetadata();
            builder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            builder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            builder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
        }


        return builder.build();

    }

    public static Log logFromApi(InternshipServiceProto.Log apiLog) throws ModelConversionException {
        if (areStrEmpty(apiLog.getId())) {
            throw new ModelConversionException();
        } else {
            apiLog.getAttachmentWeekId();
        }

        AttachmentWeek attachmentWeek = AttachmentWeek.builder().Id(UUID.fromString(apiLog.getAttachmentWeekId())).build();

        Log.LogBuilder logBuilder = Log.builder().Id(UUID.fromString(apiLog.getId()))
                .attachmentWeek(attachmentWeek);

        if (!areStrEmpty(apiLog.getWorkDone())) {
            logBuilder.workDone(apiLog.getWorkDone());
        }

        if (!areStrEmpty(apiLog.getIndustrySupervisorComment())) {
            logBuilder.industrySupervisorComment(apiLog.getIndustrySupervisorComment());
        }

        if (!areStrEmpty(apiLog.getSchoolSupervisorComment())) {
            logBuilder.schoolSupervisorComment(apiLog.getSchoolSupervisorComment());
        }

        if (apiLog.hasMetadata()) {
            var metadata = apiLog.getMetadata();
            logBuilder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            logBuilder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            logBuilder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
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
        if (areStrEmpty(apiApplication.getId(), apiApplication.getApplicant().getId(), apiApplication.getListing().getId())
        ) {
            throw new ModelConversionException();
        }

        var builder = Application.builder()
                .Id(UUID.fromString(apiApplication.getId()))
                .applicant(appUserFromApi(apiApplication.getApplicant()))
                .listing(listingFromApi(apiApplication.getListing()));

        if (!areStrEmpty(apiApplication.getApplication())) {
            builder.application(apiApplication.getApplication());
        }

        if (!areStrEmpty(apiApplication.getCvUrl())) {
            builder.cvUrl(apiApplication.getCvUrl());
        }

        builder.applicationStatus(ApplicationStatus.valueOf(apiApplication.getApplicationStatus().name()));

        if (apiApplication.hasMetadata()) {
            var metadata = apiApplication.getMetadata();
            builder.createdAt(timeStampFromApi(metadata.getCreatedAt()));
            builder.updatedAt(timeStampFromApi(metadata.getUpdatedAt()));
            builder.deletedAt(timeStampFromApi(metadata.getDeletedAt()));
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

        userBuilder.setMetadata(metadataToApi(appUser.getCreatedAt(), appUser.getUpdatedAt(), appUser.getDeletedAt()));

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
                .setMetadata(metadataToApi(account.getCreatedAt(), account.getUpdatedAt(), account.getDeletedAt()))
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

        if (Objects.nonNull(tenant.getLocation())) {
            tenantBuilder.setLocation(tenant.getLocation());
        }

        tenantBuilder.setMetadata(metadataToApi(tenant.getCreatedAt(), tenant.getUpdatedAt(), tenant.getDeletedAt()));

        return tenantBuilder.build();
    }

    public static CourseServiceProto.Student studentToApi(Student student) throws ModelConversionException {
        if (Objects.isNull(student.getId()) || Objects.isNull(student.getAppUser()) ||
                Objects.isNull(student.getAdmissionNumber()) || Objects.isNull(student.getCourse())
        ) {
            throw new ModelConversionException("Missing required field(s)");
        }

        return CourseServiceProto.Student.newBuilder()
                .setId(String.valueOf(student.getId()))
                .setAdmissionNumber(student.getAdmissionNumber())
                .setAppUser(appUserToApi(student.getAppUser()))
                .setCourse(courseToApi(student.getCourse()))
                .setMetadata(metadataToApi(student.getCreatedAt(), student.getUpdatedAt(), student.getDeletedAt()))
                .build();
    }

    public static CommonsProto.RoleName roleNameToApi(RoleName roleName) throws ModelConversionException {
        return switch (roleName.name()) {
            case "STUDENT" -> CommonsProto.RoleName.student;
            case "SUPERVISOR" -> CommonsProto.RoleName.supervisor;
            case "TENANT_ADMIN" -> CommonsProto.RoleName.TENANT_ADMIN;
            case "INTERNAL_ADMIN" -> CommonsProto.RoleName.INTERNAL_ADMIN;
            default -> throw new ModelConversionException();
        };
    }

    public static CommonsProto.TenantType tenantTypeToApi(TenantType tenantType) throws ModelConversionException {
        return switch (tenantType.name()) {
            case "SCHOOL" -> CommonsProto.TenantType.SCHOOL;
            case "COMPANY" -> CommonsProto.TenantType.COMPANY;
            case "INTERNAL" -> CommonsProto.TenantType.INTERNAL;
            default -> throw new ModelConversionException();
        };
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
                .setMetadata(metadataToApi(course.getCreatedAt(), course.getUpdatedAt(), course.getDeletedAt()))
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
        listingBuilder.setMetadata(metadataToApi(listing.getCreatedAt(), listing.getUpdatedAt(), listing.getDeletedAt()));

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
        attachmentBuilder.setMetadata(metadataToApi(attachment.getCreatedAt(), attachment.getUpdatedAt(), attachment.getDeletedAt()));

        return attachmentBuilder.build();
    }

    public static InternshipServiceProto.AttachmentWeek attachmentWeekToApi(AttachmentWeek attachmentWeek) throws ModelConversionException {
        if (Objects.isNull(attachmentWeek.getId())) {
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

        builder.setMetadata(metadataToApi(attachmentWeek.getCreatedAt(), attachmentWeek.getUpdatedAt(), attachmentWeek.getDeletedAt()));


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

        builder.setMetadata(metadataToApi(log.getCreatedAt(), log.getUpdatedAt(), log.getDeletedAt()));

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

        builder.setMetadata(metadataToApi(application.getCreatedAt(), application.getUpdatedAt(), application.getDeletedAt()));

        return builder.build();
    }

    private static CommonsProto.Metadata metadataToApi(@Nullable LocalDateTime createdAt, @Nullable LocalDateTime updatedAt, @Nullable LocalDateTime deletedAt) {
        assert createdAt != null;
        CommonsProto.Metadata.Builder builder = CommonsProto.Metadata.newBuilder()
                .setCreatedAt(timeStampToApi(createdAt));

        if (Objects.nonNull(updatedAt)) {
            builder.setUpdatedAt(timeStampToApi(updatedAt));
        }

        if (Objects.nonNull(deletedAt)) {
            builder.setDeletedAt(timeStampToApi(deletedAt));
        }

        return builder.build();
    }

}
