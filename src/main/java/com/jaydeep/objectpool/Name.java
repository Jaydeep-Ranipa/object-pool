package com.jaydeep.objectpool;

import java.util.HashMap;
import java.util.Map;

public final class Name {
	private static Map<Integer, Name> namePool = new HashMap<Integer, Name>();

	private String givenName;
	private String familyName;
	
	// private Constructor
	private Name(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}
	
	// Getters
	public String getGivenName() {
		return givenName;
	}
	public String getFamilyName() {
		return familyName;
	}

	// HashCode and Equals
	private static int hashCode(String givenName, String familyName) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
		return result;
	}
	@Override
	public int hashCode() {
		return hashCode(this.givenName, this.familyName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		return true;
	}
	
	/*
	 * Pool Logic Implementation
	 */
	public static Name newName(String givenName, String familyName) {
		int hashCode = hashCode(givenName, familyName);
		if (namePool.containsKey(hashCode)) {
			return namePool.get(hashCode);
		}
		Name name = new Name(givenName, familyName);
		namePool.put(hashCode, name);
		return name;
	}

}
