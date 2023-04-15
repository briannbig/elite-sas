package elite.sas.api.server;

import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.UnretriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.UserServiceProto;
import elite.sas.api.grpc.userServiceGrpc;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.entities.AppUser;
import elite.sas.core.service.AppUserService;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.workflows.definition.UserAccountRegistrationWorkflow;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class UserService extends userServiceGrpc.userServiceImplBase {

    private UserAccountRegistrationWorkflow userAccountRegistrationWorkflow = TemporalUtil.userAccountRegistrationWorkflow();

    private final AppUserService appUserService;

    @Override
    public void registerUser(UserServiceProto.RegisterUserRequest request, StreamObserver<UserServiceProto.AppUser> responseObserver) {

        CreateUserParams createUserParams = null;
        try {
            createUserParams = CreateUserParams.builder()
                    .userName(request.getUserName())
                    .userType(ApiUtil.userTypeFromAPi(request.getUserType()))
                    .build();
        } catch (UnretriableException e) {
            responseObserver.onError(e);
        }
        AppUser appUser = userAccountRegistrationWorkflow.handle(createUserParams);

        try {
            responseObserver.onNext(ApiUtil.appUserToApi(appUser));
        } catch (UnretriableException e) {
            responseObserver.onCompleted();
        }
        responseObserver.onCompleted();

    }

    @Override
    public void getAllUsers(CommonsProto.Empty request, StreamObserver<UserServiceProto.AppUser> responseObserver) {
        log.debug("-------------- Listing all users");
        appUserService.findAllUsers().forEach(u -> {
            log.debug("user ----> {}", u);
            try {
                responseObserver.onNext(ApiUtil.appUserToApi(u));
            } catch (UnretriableException e) {
                responseObserver.onError(e);
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
                            responseObserver.onNext(ApiUtil.appUserToApi(u));
                        } catch (UnretriableException e) {
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
                responseObserver.onNext(ApiUtil.appUserToApi(optionalAppUser.get()));
            } catch (UnretriableException e) {
                responseObserver.onError(e);
            }
        }

        if (Objects.nonNull(request.getUserName())) {
            Optional<AppUser> optionalAppUser = appUserService.getUserByUserName(request.getUserName());
            if (optionalAppUser.isEmpty()) {
                responseObserver.onCompleted();
            }
            try {
                responseObserver.onNext(ApiUtil.appUserToApi(optionalAppUser.get()));
            } catch (UnretriableException e) {
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
        super.getAccount(request, responseObserver);
    }
}
