package elite.sas.api.server;

import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.exceptions.UnRetriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.TenantServiceProto;
import elite.sas.api.grpc.tenantServiceGrpc;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.entities.Tenant;
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

        if (Objects.isNull(request.getName()) || Objects.isNull(request.getEmail()) ||
                Objects.isNull(request.getTenantType()) || Objects.isNull(request.getTelephone()) ||
                Objects.isNull(request.getLocation())
        ) {
            responseObserver.onError(new ModelConversionException());
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
                responseObserver.onError(e);
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
                        log.debug("Conversion error");
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getTenantById(TenantServiceProto.SearchParams request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {

        if (Objects.isNull(request.getId())) {
            responseObserver.onError(new ModelConversionException());
            log.debug("tenant id not specified in search params :{}", request);
            return;
        }

        Optional<Tenant> optionalTenant = tenantService.findTenantById(request.getId());

        if (optionalTenant.isPresent()) {
            try {
                responseObserver.onNext(tenantToApi(optionalTenant.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(e);
                log.debug("Conversion error: {}", e);
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
                            log.debug("Conversion error");
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
                        }
                    }
            );
        }

        responseObserver.onCompleted();
    }

    @Override
    public void updateTenant(TenantServiceProto.UpdateTenantRequest request, StreamObserver<TenantServiceProto.Tenant> responseObserver) {
        if (Objects.isNull(request.getId())) {
            responseObserver.onError(new ModelConversionException("tenant id not specified in update request"));
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
                responseObserver.onError(e);
                return;
            }
        } else {
            responseObserver.onError(new UnRetriableException("could not update tenant"));
            log.debug("could not update tenant with id: {}", request.getId());
            return;
        }

        responseObserver.onCompleted();

    }
}
