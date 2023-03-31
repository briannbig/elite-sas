package elite.sas.api;

import elite.sas.entities.Account;
import elite.sas.entities.AppUser;
import elite.sas.entities.Tenant;
import elite.sas.service.AppUserService;
import elite.sas.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/school")
@RequiredArgsConstructor
@Slf4j
public class SchoolAdminController {

    @Autowired
    private final TenantService tenantService;
    @Autowired
    private final AppUserService appUserService;



    @GetMapping("/")
    public Tenant thisTenant(@AuthenticationPrincipal Account account){
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        return optionalAppUser.map(AppUser::getTenant).orElse(null);

    }

    @GetMapping("/{id}")
    public Tenant tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).orElse(null);
    }

    @GetMapping("/companies")
    public List<Tenant> companies() {
        return tenantService.getAllCompanies();
    }

    @GetMapping("/supervisors")
    public List<AppUser> tenantSupervisors(@AuthenticationPrincipal Account account) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        var optionalTenant = optionalAppUser.map(AppUser::getTenant);

        return optionalTenant.map(tenant -> tenantService.getTenantSupervisors(tenant.getId().toString())).orElse(null);
    }




}
