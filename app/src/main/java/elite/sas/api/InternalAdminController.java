package elite.sas.api;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.entities.Account;
import elite.sas.entities.AppUser;
import elite.sas.entities.Tenant;
import elite.sas.service.AppUserService;
import elite.sas.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/internal")
@RequiredArgsConstructor
public class InternalAdminController {

    @Autowired
    private final TenantService tenantService;
    @Autowired
    private final AppUserService appUserService;


    @GetMapping("/")
    public Tenant thisTenant(@AuthenticationPrincipal Account account){
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        return optionalAppUser.map(AppUser::getTenant).orElse(null);

    }


    @GetMapping("/tenants")
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }


    @GetMapping("/{id}")
    public Tenant tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).orElse(null);
    }

    @GetMapping("/schools")
    public List<Tenant> schools() {
        return tenantService.getAllSchools();
    }

    @GetMapping("/schools/{id}")
    public Tenant getSchoolById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).orElse(null);
    }

    @GetMapping("/companies")
    public List<Tenant> companies() {
        return tenantService.getAllCompanies();
    }
    @GetMapping("/companies/{id}")
    public Tenant getCompanyById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).orElse(null);
    }

    @GetMapping("/{id}/supervisors")
    public List<AppUser> tenantSupervisors(@PathVariable("id") String id) {
        return tenantService.getTenantSupervisors(id);
    }

    @PostMapping("/")
    public Tenant registerTenant(@RequestBody CreateTenantParams createTenantParams) {
        return tenantService.createTenant(createTenantParams);
    }


}
