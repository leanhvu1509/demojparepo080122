package com.lavu.demojparepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavu.demojparepo.entity.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	Boolean existsByEmail(String email);
}
