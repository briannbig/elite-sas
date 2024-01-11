package elite.sas.core.api;

import elite.sas.core.api.dto.TenantDTO;
import elite.sas.core.api.dto.UserDTO;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.service.TenantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TenantDTO> tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(value -> ResponseEntity.ok(TenantDTO.from(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/schools")
    public ResponseEntity<List<TenantDTO>> schools() {
        var schools = tenantService.getAllSchools().stream().map(TenantDTO::from).toList();
        return schools.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(schools);
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<TenantDTO> getSchoolById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(v -> ResponseEntity.ok(TenantDTO.from(v))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/companies")
    public ResponseEntity<List<TenantDTO>> companies() {
        var companies = tenantService.getAllCompanies().stream().map(TenantDTO::from).toList();
        return companies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<TenantDTO> getCompanyById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(v -> ResponseEntity.ok(TenantDTO.from(v))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/supervisors")
    public ResponseEntity<List<UserDTO>> tenantSupervisors(@PathVariable("id") String id) {
        var supervisors = tenantService.getTenantSupervisors(id).stream().map(UserDTO::from).toList();
        return supervisors.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(supervisors);
    }

    @PostMapping("/")
    public ResponseEntity<TenantDTO> registerTenant(@RequestBody CreateTenantParams createTenantParams) {
        return tenantService.createTenant(createTenantParams).map(v -> ResponseEntity.ok(TenantDTO.from(v))).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
