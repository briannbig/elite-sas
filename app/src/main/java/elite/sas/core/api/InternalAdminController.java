package elite.sas.core.api;

import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.entities.Account;
import elite.sas.core.entities.AppUser;
import elite.sas.core.entities.Tenant;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return tenantService.createTenant(createTenantParams).get();
    }


}
