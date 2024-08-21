package com.globant.training.java.I.service;

import com.globant.training.java.I.entity.Entity;

import java.util.List;

//common interface to be implemented by all persistence services. 
public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);

}
