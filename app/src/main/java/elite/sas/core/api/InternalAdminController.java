package elite.sas.core.api;

import elite.sas.core.api.dto.TenantDTO;
import elite.sas.core.api.dto.UserDTO;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.entities.Account;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TenantDTO> thisTenant(@AuthenticationPrincipal Account account) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        return optionalAppUser.map(appUser -> ResponseEntity.ok(TenantDTO.from(appUser.getTenant()))).orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/tenants")
    public ResponseEntity<List<TenantDTO>> getAllTenants() {
        var tenants = tenantService.getAllTenants().stream().map(TenantDTO::from).toList();
        return tenants.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tenants);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TenantDTO> tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(TenantDTO::from)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/schools")
    public ResponseEntity<List<TenantDTO>> schools() {
        var schools = tenantService.getAllSchools().stream().map(TenantDTO::from).toList();
        return schools.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(schools);
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<TenantDTO> getSchoolById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(TenantDTO::from).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/companies")
    public ResponseEntity<List<TenantDTO>> companies() {
        var companies = tenantService.getAllCompanies().stream().map(TenantDTO::from).toList();
        return companies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<TenantDTO> getCompanyById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(TenantDTO::from)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/supervisors")
    public ResponseEntity<List<UserDTO>> tenantSupervisors(@PathVariable("id") String id) {
        var supervisors = tenantService.getTenantSupervisors(id).stream().map(UserDTO::from).toList();
        return supervisors.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(supervisors);

    }

    @PostMapping("/")
    public ResponseEntity<TenantDTO> registerTenant(@RequestBody CreateTenantParams createTenantParams) {
        return tenantService.createTenant(createTenantParams).map(TenantDTO::from).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }


}
