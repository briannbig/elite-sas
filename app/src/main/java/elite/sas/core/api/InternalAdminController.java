package elite.sas.core.api;

import elite.sas.core.api.dto.TenantDTO;
import elite.sas.core.api.dto.UserDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/internal")
@RequiredArgsConstructor
public class InternalAdminController {

    @Autowired
    private final TenantService tenantService;
    @Autowired
    private final AppUserService appUserService;


    @GetMapping("/")
    public TenantDTO thisTenant(@AuthenticationPrincipal Account account) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        if (optionalAppUser.isEmpty()) {
            return null;
        }
        var tenant = optionalAppUser.get().getTenant();

        return new TenantDTO(tenant.getId(), tenant.getName(), tenant.getLocation(), tenant.getTelephone(), tenant.getEmail(), tenant.getTenantType());

    }


    @GetMapping("/tenants")
    public List<TenantDTO> getAllTenants() {
        return tenantService.getAllTenants().stream().map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public TenantDTO tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(tenant -> {
            return new TenantDTO(tenant.getId(), tenant.getName(), tenant.getLocation(), tenant.getTelephone(), tenant.getEmail(), tenant.getTenantType());
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
        return tenantService.getTenantSupervisors(id).stream().map(u-> {
            return new UserDTO(u.getId(), u.getTenant().getId(),u.getUserName(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getUserType(), u.getRoles());
        }).collect(Collectors.toList());
    }

    @PostMapping("/")
    public TenantDTO registerTenant(@RequestBody CreateTenantParams createTenantParams) {
        return tenantService.createTenant(createTenantParams).map(t -> {
            return new TenantDTO(t.getId(), t.getName(), t.getLocation(), t.getTelephone(), t.getEmail(), t.getTenantType());
        }).orElse(null);
    }


}
