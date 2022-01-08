package com.lavu.demojparepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavu.demojparepo.entity.Province;

@Repository("provinceRepository")
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	Boolean existsByName(String name);
}
