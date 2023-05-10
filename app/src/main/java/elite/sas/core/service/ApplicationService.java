package elite.sas.core.service;


import elite.sas.core.entities.Application;
import elite.sas.core.entities.Listing;
import elite.sas.core.repository.ApplicationRepository;
import elite.sas.core.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ListingRepository listingRepository;


    public Optional<Listing> getListingById(String id) {
        return listingRepository.findById(UUID.fromString(id));
    }

    public Optional<Listing> addListing(Listing listing) {

        return Optional.of(listingRepository.save(listing));
    }

    public Optional<Listing> updateListing(Listing listing) {
        Optional<Listing> listingOptional = listingRepository.findById(listing.getId());
        if (listingOptional.isEmpty()) {
            return Optional.empty();
        }
        var listing1 = listingOptional.get();
        listing1.setDeadline(listing.getDeadline());
        listing1.setTenant(listing.getTenant());
        listing1.setCourse(listing.getCourse());
        listing1.setDescription(listing.getDescription());

        return Optional.of(listingRepository.save(listing1));
    }

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public List<Listing> getAllCompanyListings(String tenantId) {
        try {
            return listingRepository.findByTenantId(UUID.fromString(tenantId));
        } catch (Exception e) {
            log.debug("{}", e);
            return List.of();
        }
    }

    public List<Listing> getAllListingsByCourse(String courseId) {
        try {
            return listingRepository.findByCourseId(UUID.fromString(courseId));
        } catch (Exception e) {
            log.debug("{}", e);
            return List.of();
        }
    }


    public Optional<Application> getApplicationById(String applicationId) {
        try {
            return applicationRepository.findById(UUID.fromString(applicationId));
        } catch (Exception e) {
            log.debug("{}", e);
            return Optional.empty();
        }

    }

    public Optional<Application> addApplication(Application application) {
        return Optional.of(applicationRepository.save(application));
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> getAllApplicationsForCompany(String tenantId) {
        try {
            return applicationRepository.findByApplicantTenantId(UUID.fromString(tenantId));
        } catch (Exception e) {
            log.error("{}", e);
            return List.of();
        }
    }

    public List<Application> getAllApplicationsByApplicant(String userId) {
        try {
            return applicationRepository.findByApplicantId(UUID.fromString(userId));
        } catch (Exception e) {
            log.debug("{}", e);
            return List.of();
        }
    }

    public List<Application> getAllApplicationsForListing(String listingId) {
        try {
            return applicationRepository.findByListingId(UUID.fromString(listingId));
        } catch (Exception e) {
            log.debug("{}", e);
            return List.of();
        }
    }


    public Optional<Application> updateApplication(Application application) {
        Optional<Application> optionalApplication = applicationRepository.findById(application.getId());

        if (optionalApplication.isEmpty()) {
            return Optional.empty();
        }

        if (!Objects.equals(optionalApplication.get().getApplicationStatus(), application.getApplicationStatus())) {
            optionalApplication.get().setApplicationStatus(application.getApplicationStatus());
        }

        if (!Objects.equals(optionalApplication.get().getApplication(), application.getApplication())) {
            optionalApplication.get().setApplication(application.getApplication());
        }

        if (!Objects.equals(optionalApplication.get().getCvUrl(), application.getCvUrl())) {
            optionalApplication.get().setCvUrl(application.getCvUrl());
        }

        return Optional.of(applicationRepository.save(optionalApplication.get()));

    }


}
