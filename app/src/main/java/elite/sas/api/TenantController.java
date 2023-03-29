package elite.sas.api;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.entities.AppUser;
import elite.sas.entities.Tenant;
import elite.sas.service.TenantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Tenures controller")
@RequestMapping("/api/v1/tenant")
@RequiredArgsConstructor
public class TenantController {

    @Autowired
    private final TenantService tenantService;

    @GetMapping("/{id}")
    public Tenant tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).orElse(null);
    }

    @GetMapping("/schools")
    public List<Tenant> schools() {
        return tenantService.getAllSchools();
    }

    @GetMapping("/companies")
    public List<Tenant> companies() {
        return tenantService.getAllCompanies();
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
