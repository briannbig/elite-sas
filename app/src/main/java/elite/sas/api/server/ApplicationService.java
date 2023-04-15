package elite.sas.api.server;


import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.UnretriableException;
import elite.sas.api.grpc.ApplicationServiceProto;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.applicationServiceGrpc;
import elite.sas.core.entities.Listing;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class ApplicationService extends applicationServiceGrpc.applicationServiceImplBase {


    private final elite.sas.core.service.ApplicationService applicationService;


    @Override
    public void addListing(ApplicationServiceProto.Listing request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        Optional<Listing> optionalListing;
        try {
             optionalListing = applicationService.addListing(ApiUtil.listingFromApi(request));
             if (optionalListing.isPresent()) {
                 responseObserver.onNext(ApiUtil.listingToApi(optionalListing.get()));
             }
             responseObserver.onCompleted();
        } catch (UnretriableException e) {
            responseObserver.onError(e);
        }


    }

    @Override
    public void getAllListings(CommonsProto.Empty request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        applicationService.getAllListings().forEach(
                l -> {
                    try {
                        responseObserver.onNext(ApiUtil.listingToApi(l));
                    } catch (UnretriableException e) {
                        log.debug("Conversion error: {}", e);
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getListings(ApplicationServiceProto.SearchListingParams request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        if (Objects.nonNull(request.getCourseId())) {
            applicationService.getAllListingsByCourse(request.getCourseId()).forEach(
                    l -> {
                        try {
                            responseObserver.onNext(ApiUtil.listingToApi(l));
                        } catch (UnretriableException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }
        if (Objects.nonNull(request.getTenantId())) {
            applicationService.getAllCompanyListings(request.getTenantId()).forEach(
                    l -> {
                        try {
                            responseObserver.onNext(ApiUtil.listingToApi(l));
                        } catch (UnretriableException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }

        responseObserver.onCompleted();

    }

    @Override
    public void getListing(ApplicationServiceProto.SearchListingParams request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        if (Objects.nonNull(request.getId())) {
            Optional<Listing> optionalListing = applicationService.getListingById(request.getId());
            if (optionalListing.isPresent()){
                try {
                    responseObserver.onNext(ApiUtil.listingToApi(optionalListing.get()));
                } catch (UnretriableException e) {
                    log.debug("Conversion error: {}", e);
                }
            }
        }

        responseObserver.onCompleted();
    }

    @Override
    public void updateListing(ApplicationServiceProto.UpdateListingRequest request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        ApplicationServiceProto.Listing.Builder apiListingBuilder = ApplicationServiceProto.Listing.newBuilder();

        if (Objects.nonNull(request.getId())) {
            apiListingBuilder.setId(request.getId());
        }

        try {
            Optional<Listing> listingOptional = applicationService.updateListing(ApiUtil.listingFromApi(apiListingBuilder.build()));
        } catch (UnretriableException e) {
            log.debug("Conversion error: {}", e);
        }
    }

    @Override
    public void addApplication(ApplicationServiceProto.Application request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        super.addApplication(request, responseObserver);
    }

    @Override
    public void getAllApplications(CommonsProto.Empty request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        super.getAllApplications(request, responseObserver);
    }

    @Override
    public void getApplications(ApplicationServiceProto.SearchApplicationParams request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        super.getApplications(request, responseObserver);
    }

    @Override
    public void getApplication(ApplicationServiceProto.SearchApplicationParams request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        super.getApplication(request, responseObserver);
    }

    @Override
    public void updateApplication(ApplicationServiceProto.UpdateApplicationRequest request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        super.updateApplication(request, responseObserver);
    }
}
