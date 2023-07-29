package elite.sas.core.api;

import elite.sas.core.api.dto.DTOConverter;
import elite.sas.core.api.dto.TenantDTO;
import elite.sas.core.api.dto.UserDTO;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.service.TenantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Tenures controller")
@RequestMapping("/api/v1/tenant")
@RequiredArgsConstructor
public class TenantController {

    @Autowired
    private final TenantService tenantService;

    @GetMapping("/{id}")
    public TenantDTO tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).orElse(null);
    }

    @GetMapping("/schools")
    public List<TenantDTO> schools() {
        return tenantService.getAllSchools().stream().map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).collect(Collectors.toList());
    }

    @GetMapping("/schools/{id}")
    public TenantDTO getSchoolById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).orElse(null);
    }

    @GetMapping("/companies")
    public List<TenantDTO> companies() {
        return tenantService.getAllCompanies().stream().map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).collect(Collectors.toList());
    }

    @GetMapping("/companies/{id}")
    public TenantDTO getCompanyById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).orElse(null);
    }

    @GetMapping("/{id}/supervisors")
    public List<UserDTO> tenantSupervisors(@PathVariable("id") String id) {
        return tenantService.getTenantSupervisors(id).stream().map(u -> {
            return DTOConverter.getUserDTO(u);
        }).collect(Collectors.toList());
    }

    @PostMapping("/")
    public TenantDTO registerTenant(@RequestBody CreateTenantParams createTenantParams) {
        return tenantService.createTenant(createTenantParams).map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).get();
    }


}
