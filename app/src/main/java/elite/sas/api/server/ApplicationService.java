package elite.sas.api.server;


import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.exceptions.UnRetriableException;
import elite.sas.api.grpc.ApplicationServiceProto;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.applicationServiceGrpc;
import elite.sas.core.entities.Application;
import elite.sas.core.entities.Listing;
import io.grpc.Status;
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
            optionalListing = applicationService.addListing(Listing.builder()
                    .course(courseFromApi(request.getCourse()))
                    .attachmentPeriod(attachmentPeriodFromApi(request.getAttachmentPeriod()))
                    .tenant(tenantFromApi(request.getTenant()))
                    .deadline(timeStampFromApi(request.getDeadline()))
                    .description(request.getDescription())
                    .build());
            if (optionalListing.isPresent()) {
                responseObserver.onNext(listingToApi(optionalListing.get()));
            }
            responseObserver.onCompleted();
        } catch (ModelConversionException e) {
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
        }


    }

    @Override
    public void getAllListings(CommonsProto.Empty request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        applicationService.getAllListings().forEach(
                l -> {
                    try {
                        responseObserver.onNext(listingToApi(l));
                    } catch (ModelConversionException e) {
                        log.debug("Conversion error: {}", e);
                        responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getListings(ApplicationServiceProto.SearchListingParams request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        if (Objects.nonNull(request.getCourseId()) && !request.getCourseId().isEmpty()) {
            applicationService.getAllListingsByCourse(request.getCourseId()).forEach(
                    l -> {
                        try {
                            responseObserver.onNext(listingToApi(l));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }
        if (Objects.nonNull(request.getTenantId()) && !request.getTenantId().isEmpty()) {
            applicationService.getAllCompanyListings(request.getTenantId()).forEach(
                    l -> {
                        try {
                            responseObserver.onNext(listingToApi(l));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }

        responseObserver.onCompleted();

    }

    @Override
    public void getListing(ApplicationServiceProto.SearchListingParams request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {
        if (Objects.nonNull(request.getId()) && !request.getId().isEmpty()) {
            Optional<Listing> optionalListing = applicationService.getListingById(request.getId());
            if (optionalListing.isPresent()) {
                try {
                    responseObserver.onNext(listingToApi(optionalListing.get()));
                } catch (ModelConversionException e) {
                    log.debug("Conversion error: {}", e);
                    responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            }
        }

        responseObserver.onCompleted();
    }

    @Override
    public void updateListing(ApplicationServiceProto.UpdateListingRequest request, StreamObserver<ApplicationServiceProto.Listing> responseObserver) {

        if (Objects.isNull(request.getId()) || request.getId().isEmpty()) {
            var e = new UnRetriableException("No Id specified in params");
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());

        }

        ApplicationServiceProto.Listing.Builder apiListingBuilder = ApplicationServiceProto.Listing.newBuilder();

        apiListingBuilder.setId(request.getId());

        if (request.hasCourse()) {
            apiListingBuilder.setCourse(request.getCourse());
        }

        if (request.hasDeadline()) {
            apiListingBuilder.setDeadline(apiListingBuilder.getDeadline());
        }

        try {
            Optional<Listing> listingOptional = applicationService.updateListing(listingFromApi(apiListingBuilder.build()));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
        }
    }

    @Override
    public void addApplication(ApplicationServiceProto.Application request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        Optional<Application> optionalApplication;
        try {
            optionalApplication = applicationService.addApplication(applicationFromApi(request));
        } catch (ModelConversionException e) {
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            return;
        }
        if (optionalApplication.isPresent()) {
            try {
                responseObserver.onNext(applicationToApi(optionalApplication.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
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
                    } catch (ModelConversionException e) {
                        log.debug("Conversion error: {}", e);
                        responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                    }
                }
        );

        responseObserver.onCompleted();
    }

    @Override
    public void getApplications(ApplicationServiceProto.SearchApplicationParams request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {

        if (Objects.nonNull(request.getApplicantId()) && !request.getApplicantId().isEmpty()) {
            applicationService.getAllApplicationsByApplicant(request.getApplicantId()).forEach(
                    application -> {
                        try {
                            responseObserver.onNext(applicationToApi(application));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }

        if (Objects.nonNull(request.getListingId()) && !request.getListingId().isEmpty()) {
            applicationService.getAllApplicationsForListing(request.getListingId()).forEach(
                    application -> {
                        try {
                            responseObserver.onNext(applicationToApi(application));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }

        if (Objects.nonNull(request.getTenantId()) && request.getTenantId().isEmpty()) {
            applicationService.getAllApplicationsForCompany(request.getTenantId()).forEach(
                    application -> {
                        try {
                            responseObserver.onNext(applicationToApi(application));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                        }
                    }
            );
        }


        responseObserver.onCompleted();
    }

    @Override
    public void getApplication(ApplicationServiceProto.SearchApplicationParams request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        if (Objects.isNull(request.getId()) && !request.getId().isEmpty()) {
            log.debug("no application id specified in SearchApplicationParams");
            var e = new UnRetriableException("no application id specified in params");
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
            return;
        }

        Optional<Application> optionalApplication = applicationService.getApplicationById(request.getId());
        if (optionalApplication.isPresent()) {
            try {
                responseObserver.onNext(applicationToApi(optionalApplication.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }
        }

        responseObserver.onCompleted();

    }

    @Override
    public void updateApplication(ApplicationServiceProto.UpdateApplicationRequest request, StreamObserver<ApplicationServiceProto.Application> responseObserver) {
        if (Objects.isNull(request.getId()) && request.getId().isEmpty()) {
            var exception = new UnRetriableException("no id specified for application to be updated");
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(exception).asRuntimeException());

        }

        Application application = Application.builder().build();

        Optional<Application> optionalApplication = applicationService.updateApplication(application);

        if (optionalApplication.isEmpty()) {
            var exception = new UnRetriableException("Could not update application " + application);
            responseObserver.onError(Status.INTERNAL.withCause(exception).asRuntimeException());
        }

        try {
            responseObserver.onNext(applicationToApi(optionalApplication.get()));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());


        }

        responseObserver.onCompleted();

    }
}
