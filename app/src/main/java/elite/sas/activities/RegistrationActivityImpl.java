package elite.sas.activities;

import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.api.params.CreateStudentParams;
import elite.sas.api.params.CreateTenantParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.*;
import elite.sas.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@RequiredArgsConstructor
@Slf4j
public class RegistrationActivityImpl implements RegistrationActivity {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Optional<Tenant> registerTenant(CreateTenantParams createTenantParams) {
        return registerNewTenant(createTenantParams);
    }

    @Override
    public Optional<AppUser> createUserAccount(CreateUserParams request) {
        if (Objects.isNull(request.getTenantId()) || Objects.isNull(request.getFirstName()) ||
                Objects.isNull(request.getLastName()) || Objects.isNull(request.getUserName()) ||
                Objects.isNull(request.getEmail()) || Objects.isNull(request.getPassword()) ||
                Objects.isNull(request.getPasswordConfirm()) || request.getRoles().isEmpty()
        ) {
            log.error("Missing required field(s) in the request");
            return Optional.empty();
        }

        if (!Objects.equals(request.getPassword(), request.getPasswordConfirm())) {
            log.error("Passwords do not match!");
            return Optional.empty();
        }

        Optional<Account> optionalAccount = accountRepository.findByAppUserUserName(request.getUserName());

        if (optionalAccount.isPresent()) {
            log.error("Username {} already taken!", request.getUserName());
            return Optional.empty();
        }

        Optional<Account> optionalAccountWithEmail = accountRepository.findByAppUserEmail(request.getEmail());

        if (optionalAccountWithEmail.isPresent()) {
            log.debug("Email already taken!");
            return Optional.empty();
        }

        Optional<Tenant> optionalTenant = tenantRepository.findById(request.getTenantId());

        if (optionalTenant.isEmpty()) {
            log.error("Tenant with id {} not exists!", request.getTenantId());
            return Optional.empty();
        }

        UserType userType = UserType.STUDENT;
        if (Objects.nonNull(request.getUserType())) {
            userType = request.getUserType();
        }

        var user = AppUser.builder()
                .tenant(optionalTenant.get())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .userType(userType)
                .build();

        Set<Role> roles = new HashSet<>();


        request.getRoles().forEach(r -> {
            Optional<Role> optionalRole = roleRepository.findByRoleName(RoleName.INTERNAL_ADMIN);
            optionalRole.ifPresent(roles::add);
        });

        if (!roles.isEmpty()) {
            user.setRoles(roles);
        }


        var createdUser = userRepository.save(user);

        var account = new Account.CustomBuilder()
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setuser(createdUser)
                .build();

        var acc = accountRepository.save(account);

        log.info("User account created successfully! {}", acc);


        return Optional.of(acc).map(Account::getAppUser);
    }


    @Override
    public Optional<Student> registerStudent(CreateStudentParams request) {

        if (Objects.isNull(request.getUserId()) ||
                Objects.isNull(request.getAdmissionNumber()) ||
                Objects.isNull(request.getCourseId())
        ) {
            log.error("Missing required field(s) in the request");
            return Optional.empty();
        }

        Optional<AppUser> optionalAppUser = userRepository.findById(request.getUserId());

        if (optionalAppUser.isEmpty()) {
            return Optional.empty();
        }


        Optional<Course> optionalCourse = courseRepository.findById(request.getCourseId());

        if (optionalCourse.isEmpty()) {
            return Optional.empty();
        }

        Student student = Student.builder()
                .appUser(optionalAppUser.get())
                .admissionNumber(request.getAdmissionNumber())
                .course(optionalCourse.get())
                .build();

        return Optional.of(studentRepository.save(student));


    }

    @Override
    public AppUser registerSupervisor(CreateUserParams createUserParams) {
        return null;
    }

    @Override
    public AppUser registerAdmin(CreateUserParams createUserParams) {
        return null;
    }


    private Optional<Tenant> registerNewTenant(CreateTenantParams params) {

        if (Objects.isNull(params.getName()) ||
                Objects.isNull(params.getEmail()) ||
                Objects.isNull(params.getTelephone()) ||
                Objects.isNull(params.getLocation())
        ) {
            log.error("Missing required field(s) in the request");
            return Optional.empty();
        }

        Optional<Tenant> optionalTenantWithName = tenantRepository.findByName(params.getName());
        if (optionalTenantWithName.isPresent()) {
            log.debug("tenant with name '{}' already exists!", params.getName());
        }

        Optional<Tenant> optionalTenantWithEmail = tenantRepository.findByEmail(params.getEmail());
        if (optionalTenantWithEmail.isPresent()) {
            log.debug("tenant with email '{}' already exists!", params.getEmail());
        }

        Optional<Tenant> optionalTenantWithTelephone = tenantRepository.findByTelephone(params.getTelephone());
        if (optionalTenantWithTelephone.isPresent()) {
            log.debug("tenant with telephone '{}' already exists!", params.getTelephone());
        }

        TenantType tenantType = null;
        if (Objects.nonNull(params.getTenantType())) {
            tenantType = params.getTenantType();
        }

        var tenantBuilder = Tenant.builder()
                .name(params.getName())
                .email(params.getEmail())
                .telephone(params.getTelephone())
                .location(params.getLocation())
                .location(params.getLocation())
                .tenantType(tenantType);

        var tenant = tenantRepository.save(tenantBuilder.build());

        log.info("Tenant created successfully! {}", tenant);

        return Optional.of(tenant);

    }
}
