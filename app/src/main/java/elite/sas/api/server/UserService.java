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
import elite.sas.core.service.AppUserService;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.workflows.definition.UserAccountRegistrationWorkflow;
import io.grpc.Status;
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

        CreateUserParams createUserParams = CreateUserParams.builder()
                .userName(request.getUserName())
                .userType(userTypeFromAPi(request.getUserType()))
                .build();

        AppUser appUser = userAccountRegistrationWorkflow.handle(createUserParams);

        try {
            responseObserver.onNext(appUserToApi(appUser));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
        }
        responseObserver.onCompleted();

    }

    @Override
    public void getAllUsers(CommonsProto.Empty request, StreamObserver<UserServiceProto.AppUser> responseObserver) {

        appUserService.findAllUsers().forEach(u -> {
            try {
                responseObserver.onNext(appUserToApi(u));
            } catch (ModelConversionException e) {
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getUsers(UserServiceProto.SearchUserParams request, StreamObserver<UserServiceProto.AppUser> responseObserver) {
        // list users by tenant
        if (Objects.nonNull(request.getTenantId()) && !request.getTenantId().isEmpty()) {
            appUserService.getAllUsersForTenant(request.getTenantId()).forEach(u -> {
                        try {
                            responseObserver.onNext(appUserToApi(u));
                        } catch (ModelConversionException e) {
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }
        responseObserver.onCompleted();

    }

    @Override
    public void getUser(UserServiceProto.SearchUserParams request, StreamObserver<UserServiceProto.AppUser> responseObserver) {

        if (Objects.nonNull(request.getId()) && !request.getId().isEmpty()) {
            Optional<AppUser> optionalAppUser = appUserService.findUserById(request.getId());
            if (optionalAppUser.isEmpty()) {
                var e = new UnRetriableException("user with given Id not found");
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
            }
            try {
                responseObserver.onNext(appUserToApi(optionalAppUser.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }

            responseObserver.onCompleted();
        }

        if (Objects.nonNull(request.getUserName()) && !request.getUserName().isEmpty()) {
            Optional<AppUser> optionalAppUser = appUserService.getUserByUserName(request.getUserName());
            if (optionalAppUser.isEmpty()) {
                var e = new UnRetriableException(("user with given userName not found"));
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
            }
            try {
                responseObserver.onNext(appUserToApi(optionalAppUser.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }
            responseObserver.onCompleted();
        }
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
        if (Objects.nonNull(request.getAccountId()) && !request.getAccountId().isEmpty()) {

            Optional<Account> optionalAccount = appUserService.getAccountById(request.getAccountId());

            if (optionalAccount.isEmpty()) {
                log.debug("Account with id: '{}' not found", request.getAccountId());
                var e = new UnRetriableException("Account with given id not found!");
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
            }

            try {
                responseObserver.onNext(accountToApi(optionalAccount.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }

            responseObserver.onCompleted();

        }

        if (Objects.nonNull(request.getUsername())) {
            Optional<Account> optionalAccount = appUserService.getAccountByUserName(request.getUsername());

            if (optionalAccount.isEmpty()) {
                log.debug("Account with username: '{}' not found", request.getUsername());
                var e = new UnRetriableException("Account with given username not found!");
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
            }

            try {
                responseObserver.onNext(accountToApi(optionalAccount.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                return;
            }

            responseObserver.onCompleted();

        }

        var e = new UnRetriableException("Required params(account id or user name) not provided");
        responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
    }

    @Override
    public void login(UserServiceProto.LogInRequest request, StreamObserver<UserServiceProto.Account> responseObserver) {
        if (request.getUsername().isEmpty() || request.getPassword().isEmpty()) {
            var e = new UnRetriableException("Required credentials not provided!");
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
        }
        Optional<Account> optionalAccount = appUserService.getAccountByUserName(request.getUsername());

        if (optionalAccount.isEmpty()) {
            log.debug("account with username '{}' not found", request.getUsername());
            log.info("account with username '{}' not found", request.getUsername());
            var e = new UnRetriableException("account with given username not found");
            responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
        }
        var pass = passwordEncoder.matches(request.getPassword(), optionalAccount.get().getPassword());
        if (!pass) {
            log.debug("Incorrect password for {}", optionalAccount.get().getUsername());
            log.info("Incorrect password for {}", optionalAccount.get().getUsername());
            var e = new UnRetriableException("Incorrect password!");
            responseObserver.onError(Status.NOT_FOUND.INTERNAL.withCause(e).asRuntimeException());
        }

        try {
            responseObserver.onNext(accountToApi(optionalAccount.get()));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            log.info("Conversion error: {}", e);
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
        }

        responseObserver.onCompleted();

    }
}
