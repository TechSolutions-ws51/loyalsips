package com.acme.loyalsips.platform.loyalsips.application.internal.outboundservices.acl;

import com.acme.loyalsips.platform.loyalsips.domain.model.valueobjects.ProfileId;
import com.acme.loyalsips.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileByEmail(String email) {
        var profileId = profilesContextFacade.getProfileIdByEmail(email);
        if (profileId == 0L) {
            return Optional.empty();
        }
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(String firstName, String lastName, String email, String street, String number, String city, String country) {
        var profileId = profilesContextFacade.createProfile(firstName, lastName, email, street, number, city, country);
        if (profileId == 0L) {
            return Optional.empty();
        }
        return Optional.of(new ProfileId(profileId));
    }

}