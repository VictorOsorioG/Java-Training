package com.globant.training.java.S;

public class UserPersistenceService {

	private Store store = new Store();
	
	public void saveUser(User user) {
		store.store(user);
	}
}
