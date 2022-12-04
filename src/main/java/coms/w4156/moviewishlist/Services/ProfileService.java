package coms.w4156.moviewishlist.services;

import coms.w4156.moviewishlist.models.Profile;
import coms.w4156.moviewishlist.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService
    extends ServiceForRepository<Long, Profile, ProfileRepository> {

    /**
     * Constructor to set up dependency injection for the ProfileRepository.
     *
     * @param repository - The repository to inject
     */
    @Autowired
    public ProfileService(final ProfileRepository repository) {
        this.setRepository(repository);
    }
}
