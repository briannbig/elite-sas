package elite.sas.core.api;

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
    public Tenant thisTenant(@AuthenticationPrincipal Account account) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        return optionalAppUser.map(AppUser::getTenant).orElse(null);

    }

    @GetMapping("/schools")
    public List<Tenant> schools() {
        return tenantService.getAllSchools();
    }

    @GetMapping("/supervisors")
    public List<AppUser> tenantSupervisors(@AuthenticationPrincipal Account account) {

        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        var optionalTenant = optionalAppUser.map(AppUser::getTenant);

        return optionalTenant.map(tenant -> tenantService.getTenantSupervisors(tenant.getId().toString())).orElse(null);
    }

    @GetMapping("/interns")
    public List<Student> getInterns(
            @AuthenticationPrincipal Account account,
            @RequestParam(required = false) boolean active

    ) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);


        if (active) {
            return optionalTenant.map(tenant -> attachmentService.getActiveStudentsAtCompany(String.valueOf(tenant.getId()))).orElse(null);
        } else {
            return optionalTenant.map(tenant -> attachmentService.getAllStudentsAtCompany(String.valueOf(tenant.getId()))).orElse(null);
        }
    }

    @GetMapping("/attachments")
    public List<Attachment> getAttachments(
            @AuthenticationPrincipal Account account,
            @RequestParam(required = false) boolean active

    ) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);


        if (active) {
            return optionalTenant.map(tenant -> attachmentService.getActiveAttachmentsAtCompany(String.valueOf(tenant.getId()))).orElse(null);
        } else {
            return optionalTenant.map(tenant -> attachmentService.getAllAttachmentsAtCompany(String.valueOf(tenant.getId()))).orElse(null);
        }
    }


}
