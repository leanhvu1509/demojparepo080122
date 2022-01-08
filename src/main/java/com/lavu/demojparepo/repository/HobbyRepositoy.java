package com.lavu.demojparepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavu.demojparepo.entity.Hobby;

@Repository("hobbyRepository")
public interface HobbyRepositoy extends JpaRepository<Hobby, Integer> {

	Boolean existsByName(String name);
}
