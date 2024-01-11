package elite.sas.core.api;

import elite.sas.core.api.dto.AttachmentDTO;
import elite.sas.core.api.dto.StudentDTO;
import elite.sas.core.api.dto.TenantDTO;
import elite.sas.core.api.dto.UserDTO;
import elite.sas.core.entities.Account;
import elite.sas.core.entities.AppUser;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.AttachmentService;
import elite.sas.core.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TenantDTO> thisTenant(@AuthenticationPrincipal Account account) {
        return appUserService.getUserByUserName(account.getUsername()).map(AppUser::getTenant).map(TenantDTO::from).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/schools")
    public ResponseEntity<List<TenantDTO>> schools() {
        var schools = tenantService.getAllSchools().stream().map(TenantDTO::from).toList();
        return schools.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(schools);
    }

    @GetMapping("/supervisors")
    public ResponseEntity<List<UserDTO>> tenantSupervisors(@AuthenticationPrincipal Account account) {

        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        var optionalTenant = optionalAppUser.map(AppUser::getTenant);
        if (optionalTenant.isEmpty()) {
            return ResponseEntity.of(ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED)).build();
        }

        var users = tenantService.getTenantSupervisors(optionalTenant.get().getId().toString()).stream().map(UserDTO::from).toList();

        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }


    @GetMapping("/interns")
    public ResponseEntity<List<StudentDTO>> getInterns(@AuthenticationPrincipal Account account, @RequestParam(required = false) boolean active

    ) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);

        List<StudentDTO> students;
        if (active) {
            students = optionalTenant.map(tenant -> attachmentService.getActiveStudentsAtCompany(String.valueOf(tenant.getId())).stream().map(StudentDTO::fromModel).collect(Collectors.toList())).orElse(null);
        } else {
            students = optionalTenant.map(tenant -> attachmentService.getAllStudentsAtCompany(String.valueOf(tenant.getId())).stream().map(StudentDTO::fromModel).collect(Collectors.toList())).orElse(null);
        }

        assert students != null;

        return students.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(students);

    }

    @GetMapping("/attachments")
    public ResponseEntity<List<AttachmentDTO>> getAttachments(@AuthenticationPrincipal Account account, @RequestParam(required = false) boolean active) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);

        List<AttachmentDTO> internships;

        if (active) {
            internships = optionalTenant.map(tenant -> attachmentService.getActiveAttachmentsAtCompany(String.valueOf(tenant.getId())).stream().map(AttachmentDTO::fromModel).toList()).orElse(null);

        } else {
            internships = optionalTenant.map(tenant -> attachmentService.getAllAttachmentsAtCompany(String.valueOf(tenant.getId())).stream().map(AttachmentDTO::fromModel).toList()).orElse(null);
        }
        assert internships != null;
        return internships.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(internships);
    }


}
