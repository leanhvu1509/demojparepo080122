package com.lavu.demojparepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavu.demojparepo.entity.Province;
import com.lavu.demojparepo.repository.ProvinceRepository;

@Service
public class ProvinceServiceImpl implements BaseService<Province>{

	@Autowired
	private ProvinceRepository provinceRepository;

	@Override
	public List<Province> getAll() {
		// TODO Auto-generated method stub
		return provinceRepository.findAll();
	}

	@Override
	public void save(Province object) {
		// TODO Auto-generated method stub
		provinceRepository.save(object);
	}

	@Override
	public Province getByID(int id) {
		// TODO Auto-generated method stub
		return provinceRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		provinceRepository.deleteById(id);
	}

	@Override
	public Boolean existsByName(String name) {
		// TODO Auto-generated method stub
		if (provinceRepository.existsByName(name)) {
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