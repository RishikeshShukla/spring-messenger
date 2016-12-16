package org.spring.app.messenger.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.spring.app.messenger.model.Message;
import org.spring.app.messenger.model.Profile;

/*
 * 
 * DAO layer will replace with real DB interaction
 * 
 */

public class DataBaseClass {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getAllMessages() {
		return messages;
	}

	public static Map<Long, Profile> gatAllProfiles() {
		return profiles;
	}
}
