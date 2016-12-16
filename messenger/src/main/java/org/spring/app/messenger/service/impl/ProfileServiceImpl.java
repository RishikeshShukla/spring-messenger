package org.spring.app.messenger.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.spring.app.messenger.dao.impl.DataBaseClass;
import org.spring.app.messenger.model.Profile;
import org.spring.app.messenger.service.ProfileService;
import org.springframework.stereotype.Service;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

private Map<Long, Profile> profiles = DataBaseClass.gatAllProfiles();
	

	public ProfileServiceImpl() {
		
		profiles.put(1L, new Profile(1L, "Rishikesh", "Shukla", "User"));
		profiles.put(2L, new Profile(1L, "Jitender", "Chahar", "User"));
		profiles.put(3L, new Profile(1L, "Praveen", "Kumar", "Admin"));

		/*System.out.println("PPPPPPPPPPP"+profiles.size());
		profiles.get(1).addMessage(messages.get(1));
		profiles.get(2).addMessage(messages.get(2));
		profiles.get(3).addMessage(messages.get(3));*/
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(Long id) {
		return profiles.get(id);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profiles.get(profile.getId()) == null) {
			return null;
		}
		profiles.put(profile.getId(), profile);
		return profile;
	}

	public Profile removeProfile(Long profileId) {
		return profiles.remove(profileId);
	}
}
