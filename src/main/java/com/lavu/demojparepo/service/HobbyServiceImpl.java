package com.lavu.demojparepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavu.demojparepo.entity.Hobby;
import com.lavu.demojparepo.repository.HobbyRepositoy;

@Service
public class HobbyServiceImpl implements BaseService<Hobby>{

	@Autowired
	private HobbyRepositoy hobbyRepository;
	
	@Override
	public List<Hobby> getAll() {
		// TODO Auto-generated method stub
		return hobbyRepository.findAll();
	}

	@Override
	public void save(Hobby object) {
		// TODO Auto-generated method stub
		hobbyRepository.save(object);
	}

	@Override
	public Hobby getByID(int id) {
		// TODO Auto-generated method stub
		return hobbyRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		hobbyRepository.deleteById(id);
	}

	@Override
	public Boolean existsByName(String name) {
		// TODO Auto-generated method stub
		if(hobbyRepository.existsByName(name)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
