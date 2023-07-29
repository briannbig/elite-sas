package elite.sas.core.api;

import elite.sas.core.api.dto.*;
import elite.sas.core.entities.*;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.AttachmentService;
import elite.sas.core.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/tenant")
@RequiredArgsConstructor
@Slf4j
public class CompanyAdminController {

    @Autowired
    private final TenantService tenantService;
    @Autowired
    private final AppUserService appUserService;

    @Autowired
    private final AttachmentService attachmentService;


    @GetMapping("/")
    public TenantDTO thisTenant(@AuthenticationPrincipal Account account) {
        return appUserService.getUserByUserName(account.getUsername()).map(AppUser::getTenant).map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).get();

    }

    @GetMapping("/schools")
    public List<TenantDTO> schools() {
        return tenantService.getAllSchools().stream().map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).collect(Collectors.toList());
    }

    @GetMapping("/supervisors")
    public List<UserDTO> tenantSupervisors(@AuthenticationPrincipal Account account) {

        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        var optionalTenant = optionalAppUser.map(AppUser::getTenant);
        if (optionalTenant.isEmpty()) {
            return null;
        }

        return tenantService.getTenantSupervisors(optionalTenant.get().getId().toString()).stream().map(u -> {
            return DTOConverter.getUserDTO(u);
        }).collect(Collectors.toList());
    }


    @GetMapping("/interns")
    public List<StudentDTO> getInterns(@AuthenticationPrincipal Account account, @RequestParam(required = false) boolean active

    ) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);


        if (active) {
            return optionalTenant.map(tenant -> attachmentService.getActiveStudentsAtCompany(String.valueOf(tenant.getId())).stream().map(s -> {
                var c = s.getCourse();
                return new StudentDTO(s.getId().toString(), DTOConverter.getUserDTO(s.getAppUser()), s.getAdmissionNumber(), new CourseDTO(c.getId().toString(), c.getName(), c.getCourseLevel().name()));
            }).collect(Collectors.toList())).orElse(null);
        } else {
            return optionalTenant.map(tenant -> attachmentService.getAllStudentsAtCompany(String.valueOf(tenant.getId())).stream().map(s -> {
                var c = s.getCourse();
                return new StudentDTO(s.getId().toString(), DTOConverter.getUserDTO(s.getAppUser()), s.getAdmissionNumber(), new CourseDTO(c.getId().toString(), c.getName(), c.getCourseLevel().name()));
            }).collect(Collectors.toList())).orElse(null);
        }
    }

    @GetMapping("/attachments")
    public List<AttachmentDTO> getAttachments(@AuthenticationPrincipal Account account, @RequestParam(required = false) boolean active

    ) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);


        if (active) {
            return optionalTenant.map(tenant -> attachmentService.getActiveAttachmentsAtCompany(String.valueOf(tenant.getId())).stream().map(a -> {
                var s = a.getStudent();
                var attachmentWeeks = a.getAttachmentWeeks().stream().map(aw -> {
                    return new AttachmentWeekDTO(aw.getId().toString(), aw.getAttachment().getId().toString(), aw.getWeekNumber(), aw.getLogs().stream().map(l -> new LogDTO(l.getId().toString(), l.getAttachmentWeek().getId().toString(), l.getWorkDone(), l.getIndustrySupervisorComment(), l.getSchoolSupervisorComment())).collect(Collectors.toList()), aw.getWeekSummary(), aw.getStudentComment(), aw.getIndustrySupervisorComment(), aw.getSchoolSupervisorComment(), aw.isActive());
                }).collect(Collectors.toList());
                var courseDTO = new CourseDTO(s.getCourse().getId().toString(), s.getCourse().getName(), s.getCourse().getCourseLevel().name());
                return new AttachmentDTO(a.getId().toString(), new StudentDTO(s.getId().toString(), DTOConverter.getUserDTO(s.getAppUser()), s.getAdmissionNumber(), courseDTO), a.getTenant().getId().toString(), a.getAttachmentPeriod(), a.getStartDate(), a.getEndDate(), DTOConverter.getUserDTO(a.getIndustrySupervisor()), DTOConverter.getUserDTO(a.getSchoolSupervisor()), attachmentWeeks);
            }).collect(Collectors.toList())).orElse(null);

        } else {
            return optionalTenant.map(tenant -> attachmentService.getAllAttachmentsAtCompany(String.valueOf(tenant.getId())).stream().map(a -> {
                var s = a.getStudent();
                var attachmentWeeks = a.getAttachmentWeeks().stream().map(aw -> {
                    return new AttachmentWeekDTO(aw.getId().toString(), aw.getAttachment().getId().toString(), aw.getWeekNumber(), aw.getLogs().stream().map(l -> new LogDTO(l.getId().toString(), l.getAttachmentWeek().getId().toString(), l.getWorkDone(), l.getIndustrySupervisorComment(), l.getSchoolSupervisorComment())).collect(Collectors.toList()), aw.getWeekSummary(), aw.getStudentComment(), aw.getIndustrySupervisorComment(), aw.getSchoolSupervisorComment(), aw.isActive());
                }).collect(Collectors.toList());
                var courseDTO = new CourseDTO(s.getCourse().getId().toString(), s.getCourse().getName(), s.getCourse().getCourseLevel().name());
                return new AttachmentDTO(a.getId().toString(), new StudentDTO(s.getId().toString(), DTOConverter.getUserDTO(s.getAppUser()), s.getAdmissionNumber(), courseDTO), a.getTenant().getId().toString(), a.getAttachmentPeriod(), a.getStartDate(), a.getEndDate(), DTOConverter.getUserDTO(a.getIndustrySupervisor()), DTOConverter.getUserDTO(a.getSchoolSupervisor()), attachmentWeeks);
            }).collect(Collectors.toList())).orElse(null);
        }
    }


}
