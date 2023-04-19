package elite.sas.api.server;

import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.exceptions.UnRetriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.UserServiceProto;
import elite.sas.api.grpc.userServiceGrpc;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.entities.Account;
import elite.sas.core.entities.AppUser;
import elite.sas.core.service.AppUserDetailsService;
import elite.sas.core.service.AppUserService;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.workflows.definition.UserAccountRegistrationWorkflow;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;
import java.util.Optional;

import static elite.sas.api.ApiUtil.*;

@RequiredArgsConstructor
@Slf4j
public class UserService extends userServiceGrpc.userServiceImplBase {

    private UserAccountRegistrationWorkflow userAccountRegistrationWorkflow = TemporalUtil.userAccountRegistrationWorkflow();

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserServiceProto.RegisterUserRequest request, StreamObserver<UserServiceProto.AppUser> responseObserver) {

        CreateUserParams createUserParams = null;
        try {
            createUserParams = CreateUserParams.builder()
                    .userName(request.getUserName())
                    .userType(userTypeFromAPi(request.getUserType()))
                    .build();
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(e);
            return;
        }
        AppUser appUser = userAccountRegistrationWorkflow.handle(createUserParams);

        try {
            responseObserver.onNext(appUserToApi(appUser));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(e);
            return;
        }
        responseObserver.onCompleted();

    }

    @Override
    public void getAllUsers(CommonsProto.Empty request, StreamObserver<UserServiceProto.AppUser> responseObserver) {
        log.debug("-------------- Listing all users");
        log.info("-------------- Listing all users");
        appUserService.findAllUsers().forEach(u -> {
            log.debug("user ----> {}", u);
            try {
                responseObserver.onNext(appUserToApi(u));
            } catch (ModelConversionException e) {
                responseObserver.onError(e);
                return;
            }
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getUsers(UserServiceProto.SearchUserParams request, StreamObserver<UserServiceProto.AppUser> responseObserver) {
        // list users by tenant
        if (Objects.nonNull(request.getTenantId())) {
            appUserService.getAllUsersForTenant(request.getTenantId()).forEach(u -> {
                        try {
                            responseObserver.onNext(appUserToApi(u));
                        } catch (ModelConversionException e) {
                            responseObserver.onError(e);
                        }
                    }
            );
        }
        responseObserver.onCompleted();

    }

    @Override
    public void getUser(UserServiceProto.SearchUserParams request, StreamObserver<UserServiceProto.AppUser> responseObserver) {

        if (Objects.nonNull(request.getId())) {
            Optional<AppUser> optionalAppUser = appUserService.findUserById(request.getId());
            if (optionalAppUser.isEmpty()) {
                responseObserver.onCompleted();
            }
            try {
                responseObserver.onNext(appUserToApi(optionalAppUser.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(e);
            }
        }

        if (Objects.nonNull(request.getUserName())) {
            Optional<AppUser> optionalAppUser = appUserService.getUserByUserName(request.getUserName());
            if (optionalAppUser.isEmpty()) {
                responseObserver.onCompleted();
            }
            try {
                responseObserver.onNext(appUserToApi(optionalAppUser.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(e);
            }
        }

        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UserServiceProto.UpdateUserRequest request, StreamObserver<UserServiceProto.AppUser> responseObserver) {
        super.updateUser(request, responseObserver);
    }

    @Override
    public void updatePassword(UserServiceProto.UpdateAccountParams request, StreamObserver<UserServiceProto.Account> responseObserver) {
        super.updatePassword(request, responseObserver);
    }

    @Override
    public void getAccount(UserServiceProto.GetAccountRequest request, StreamObserver<UserServiceProto.Account> responseObserver) {
        if (Objects.nonNull(request.getAccountId())) {

            Optional<Account> optionalAccount = appUserService.getAccountById(request.getAccountId());

            if (optionalAccount.isEmpty()) {
                log.debug("Account with id: '{}' not found", request.getAccountId());
                responseObserver.onError(new UnRetriableException("Account with given id not found!"));
                return;
            }

            try {
                responseObserver.onNext(accountToApi(optionalAccount.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(e);
                return;
            }

            responseObserver.onCompleted();

        }

        if (Objects.nonNull(request.getUsername())) {
            Optional<Account> optionalAccount = appUserService.getAccountByUserName(request.getUsername());

            if (optionalAccount.isEmpty()) {
                log.debug("Account with username: '{}' not found", request.getUsername());
                responseObserver.onError(new UnRetriableException("Account with given username not found!"));
                return;
            }

            try {
                responseObserver.onNext(accountToApi(optionalAccount.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(e);
                return;
            }

            responseObserver.onCompleted();

        }

        responseObserver.onError(new UnRetriableException("Required params(account id or user name) not provided"));
    }

    @Override
    public void login(UserServiceProto.LogInRequest request, StreamObserver<UserServiceProto.Account> responseObserver) {
        if (Objects.isNull(request.getUsername()) || Objects.isNull(request.getPassword())) {
            responseObserver.onError(new UnRetriableException("Required credentials not provided!"));
        }
        Optional<Account> optionalAccount = appUserService.getAccountByUserName(request.getUsername());

        if (optionalAccount.isEmpty()) {
            log.debug("account with username '{}' not found", request.getUsername());
            log.info("account with username '{}' not found", request.getUsername());
            responseObserver.onError(new UnRetriableException("account with given username not found"));
            return;
        }
        var pass = passwordEncoder.matches(request.getPassword(), optionalAccount.get().getPassword());
        if (!pass) {
            log.debug("Incorrect password for {}", optionalAccount.get().getUsername());
            log.info("Incorrect password for {}", optionalAccount.get().getUsername());
            responseObserver.onError(new UnRetriableException("Incorrect password!"));
            return;
        }

        try {
            responseObserver.onNext(accountToApi(optionalAccount.get()));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            log.info("Conversion error: {}", e);
            responseObserver.onError(e);
        }

        responseObserver.onCompleted();

    }
}
