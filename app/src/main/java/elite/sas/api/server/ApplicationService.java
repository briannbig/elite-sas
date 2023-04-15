package elite.sas.api.server;


import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.UnretriableException;
import elite.sas.api.grpc.ApplicationServiceProto;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.applicationServiceGrpc;
import elite.sas.core.entities.Application;
import elite.sas.core.entities.Listing;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

import static elite.sas.api.ApiUtil.*;

@RequiredArgsConstructor
@Slf4j
public class ApplicationService extends applicationServiceGrpc.applicationServiceImplBase {


    private final elite.sas.core.service.ApplicationService applicationService;


    @Override
    public void addListing(ApplicationServiceProto.Listing request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        Optional<Listing> optionalListing;
        try {
             optionalListing = applicationService.addListing(listingFromApi(request));
             if (optionalListing.isPresent()) {
                 responseObserver.onNext(listingToApi(optionalListing.get()));
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
                        responseObserver.onNext(listingToApi(l));
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
                            responseObserver.onNext(listingToApi(l));
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
                            responseObserver.onNext(listingToApi(l));
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
                    responseObserver.onNext(listingToApi(optionalListing.get()));
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
            Optional<Listing> listingOptional = applicationService.updateListing(listingFromApi(apiListingBuilder.build()));
        } catch (UnretriableException e) {
            log.debug("Conversion error: {}", e);
        }
    }

    @Override
    public void addApplication(ApplicationServiceProto.Application request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        Optional<Application> optionalApplication;
        try {
             optionalApplication = applicationService.addApplication(applicationFromApi(request));
        } catch (UnretriableException e) {
            responseObserver.onError(e);
            return;
        }
        if (optionalApplication.isPresent()) {
            try {
                responseObserver.onNext(applicationToApi(optionalApplication.get()));
            } catch (UnretriableException e) {
                responseObserver.onError(e);
                return;
            }
        }

        responseObserver.onCompleted();

    }

    @Override
    public void getAllApplications(CommonsProto.Empty request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        applicationService.getAllApplications().forEach(
                application -> {
                    try {
                        responseObserver.onNext(applicationToApi(application));
                    } catch (UnretriableException e) {
                        log.debug("Conversion error: {}", e);
                    }
                }
        );

        responseObserver.onCompleted();
    }

    @Override
    public void getApplications(ApplicationServiceProto.SearchApplicationParams request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {

        if (Objects.nonNull(request.getApplicantId())) {
            applicationService.getAllApplicationsByApplicant(request.getApplicantId()).forEach(
                    application -> {
                        try {
                            responseObserver.onNext(applicationToApi(application));
                        } catch (UnretriableException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }

        if (Objects.nonNull(request.getListingId())) {
            applicationService.getAllApplicationsForListing(request.getListingId()).forEach(
                    application -> {
                        try {
                            responseObserver.onNext(applicationToApi(application));
                        } catch (UnretriableException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }

        if (Objects.nonNull(request.getTenantId())) {
            applicationService.getAllApplicationsForCompany(request.getTenantId()).forEach(
                    application -> {
                        try {
                            responseObserver.onNext(applicationToApi(application));
                        } catch (UnretriableException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }


        responseObserver.onCompleted();
    }

    @Override
    public void getApplication(ApplicationServiceProto.SearchApplicationParams request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        if (Objects.isNull(request.getId())) {
            responseObserver.onError(new UnretriableException());
            log.debug("no application id specified in SearchApplicationParams");
            return;
        }

        Optional<Application> optionalApplication = applicationService.getApplicationById(request.getId());
        if (optionalApplication.isPresent()) {
            try {
                responseObserver.onNext(applicationToApi(optionalApplication.get()));
            } catch (UnretriableException e) {
                log.debug("Conversion error: {}", e);
            }
        }

        responseObserver.onCompleted();

    }

    @Override
    public void updateApplication(ApplicationServiceProto.UpdateApplicationRequest request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        if (Objects.isNull(request.getId())) {
            responseObserver.onError(new UnretriableException("no id specified for application to be updated"));
        }

        Application application = Application.builder().build();

        Optional<Application> optionalApplication = applicationService.updateApplication(application);

        if (optionalApplication.isEmpty()) {
            responseObserver.onError(new UnretriableException("Could not update application " + application ));
        }

        try {
            responseObserver.onNext(applicationToApi(optionalApplication.get()));
        } catch (UnretriableException e) {
            log.debug("Conversion error: {}", e);
        }

        responseObserver.onCompleted();

    }
}
