package elite.sas.core.service;


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

    public Optional<Listing> updateListing(Listing listing){
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
        return listingRepository.findByTenantId(UUID.fromString(tenantId));
    }

    public List<Listing> getAllListingsByCourse(String courseId) {
        return listingRepository.findByCourseId(UUID.fromString(courseId));
    }


}
