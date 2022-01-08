package com.lavu.demojparepo.service;

import java.util.List;

public interface BaseService<T> {

	List<T> getAll();
	
	void save(T object);
	
	T getByID(int id);
	
	void deleteById(int id);
	
	Boolean existsByName(String name);
	
	Boolean existsByEmail(String email);
	
	
}
