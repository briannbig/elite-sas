package elite.sas.core.api;

import elite.sas.core.api.dto.TenantDTO;
import elite.sas.core.api.dto.UserDTO;
import elite.sas.core.entities.Account;
import elite.sas.core.entities.AppUser;
import elite.sas.core.service.AppUserService;
import elite.sas.core.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public TenantDTO thisTenant(@AuthenticationPrincipal Account account) {
        return appUserService.getUserByUserName(account.getUsername()).map(AppUser::getTenant).map(t -> {
            return TenantDTO.fromModel(t);
        }).get();
    }

    @GetMapping("/{id}")
    public TenantDTO tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(t -> {
            return TenantDTO.fromModel(t);
        }).orElse(null);
    }

    @GetMapping("/companies")
    public List<TenantDTO> companies() {
        return tenantService.getAllCompanies().stream().map(t -> {
            return TenantDTO.fromModel(t);
        }).collect(Collectors.toList());
    }

    @GetMapping("/supervisors")
    public List<UserDTO> tenantSupervisors(@AuthenticationPrincipal Account account) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());

        var optionalTenant = optionalAppUser.map(AppUser::getTenant);

        if (optionalTenant.isEmpty()) {
            return null;
        }
        return tenantService.getTenantSupervisors(optionalTenant.get().getId().toString()).stream().map(u -> {
            return UserDTO.fromModel(u);
        }).collect(Collectors.toList());
    }


}
