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
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TenantDTO> thisTenant(@AuthenticationPrincipal Account account) {
        return appUserService.getUserByUserName(account.getUsername()).map(AppUser::getTenant).map(TenantDTO::from)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantDTO> tenantById(@PathVariable("id") String id) {
        return tenantService.findTenantById(id).map(TenantDTO::from)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/companies")
    public ResponseEntity<List<TenantDTO>> companies() {
        var companies = tenantService.getAllCompanies().stream().map(TenantDTO::from).toList();
        return companies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }

    @GetMapping("/supervisors")
    public ResponseEntity<List<UserDTO>> tenantSupervisors(@AuthenticationPrincipal Account account) {
        var optionalAppUser = appUserService.getUserByUserName(account.getUsername());
        var optionalTenant = optionalAppUser.map(AppUser::getTenant);

        if (optionalTenant.isEmpty()) {
            return ResponseEntity.of(ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED)).build();
        }
        var supervisors = tenantService.getTenantSupervisors(optionalTenant.get().getId().toString()).stream().map(UserDTO::from).toList();

        return supervisors.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(supervisors);
    }

}
