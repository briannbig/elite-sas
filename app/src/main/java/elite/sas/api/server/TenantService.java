package elite.sas.api.server;

import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.exceptions.UnRetriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.TenantServiceProto;
import elite.sas.api.grpc.tenantServiceGrpc;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.entities.Tenant;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sqm.sql.ConversionException;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static elite.sas.api.ApiUtil.*;

@Slf4j
@RequiredArgsConstructor
public class TenantService extends tenantServiceGrpc.tenantServiceImplBase {

    private final elite.sas.core.service.TenantService tenantService;


    @Override
    public void registerTenant(TenantServiceProto.RegisterTenantRequest request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {

        if (request.getName().isEmpty() || request.getEmail().isEmpty() ||
                Objects.isNull(request.getTenantType()) || request.getTelephone().isEmpty() ||
                request.getLocation().isEmpty()
        ) {
            var e = new ModelConversionException();
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
            return;
        }

        var createTenantParams = CreateTenantParams.builder()
                .name(request.getName())
                .email(request.getEmail())
                .telephone(request.getTelephone())
                .location(request.getLocation())
                .tenantType(tenantTypeFromApi(request.getTenantType()));

        Optional<Tenant> optionalTenant = tenantService.createTenant(createTenantParams.build());

        if (optionalTenant.isPresent()) {
            try {
                responseObserver.onNext(tenantToApi(optionalTenant.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                return;
            }
        }

        responseObserver.onCompleted();

    }

    @Override
    public void getAllTenants(CommonsProto.Empty request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {
        tenantService.getAllTenants().stream().forEach(
                tenant -> {
                    try {
                        responseObserver.onNext(tenantToApi(tenant));
                    } catch (ModelConversionException e) {
                        responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getTenantById(TenantServiceProto.SearchParams request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {

        if (Objects.isNull(request.getId()) || request.getId().isEmpty()) {
            var e = new ModelConversionException();
            log.debug("tenant id not specified in search params :{}", request);
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
            return;
        }

        Optional<Tenant> optionalTenant = tenantService.findTenantById(request.getId());

        if (optionalTenant.isPresent()) {
            try {
                responseObserver.onNext(tenantToApi(optionalTenant.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                return;
            }
        }

        responseObserver.onCompleted();
    }

    @Override
    public void getTenants(TenantServiceProto.SearchParams request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {
        if (Objects.nonNull(request.getTenantType())) {
            tenantService.getAllTenantsByType(tenantTypeFromApi(request.getTenantType())).forEach(
                    tenant -> {
                        try {
                            responseObserver.onNext(tenantToApi(tenant));
                        } catch (ModelConversionException e) {
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }

        if (Objects.nonNull(request.getLocation())) {
            tenantService.getAllTenantsByLocation(request.getLocation()).forEach(
                    tenant -> {
                        try {
                            responseObserver.onNext(tenantToApi(tenant));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error");
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }

        responseObserver.onCompleted();
    }

    @Override
    public void updateTenant(TenantServiceProto.UpdateTenantRequest request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {
        if (Objects.isNull(request.getId()) || !request.getId().isEmpty()) {
            var e = new ModelConversionException("tenant id not specified in update request");
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
            return;
        }

        var tenantBuilder = Tenant.builder()
                .Id(UUID.fromString(request.getId()));

        if (Objects.nonNull(request.getName())) {
            tenantBuilder.name(request.getName());
        }

        if (Objects.nonNull(request.getLocation())) {
            tenantBuilder.location(request.getLocation());
        }

        if (Objects.nonNull(request.getTelephone())) {
            tenantBuilder.location(request.getTelephone());
        }

        Optional<Tenant> optionalTenant = tenantService.updateTenant(tenantBuilder.build());
        if (optionalTenant.isPresent()) {
            try {
                responseObserver.onNext(tenantToApi(optionalTenant.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }
        } else {

            log.debug("could not update tenant with id: {}", request.getId());
            var e = new UnRetriableException("could not update tenant");
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
        }

        responseObserver.onCompleted();

    }
}
