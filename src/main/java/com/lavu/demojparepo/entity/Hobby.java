package com.lavu.demojparepo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "hobby")
public class Hobby {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "is required")
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "hobbies")
	private List<Customer> customers = new ArrayList<>();

	
	public Hobby(int id, String name, List<Customer> customers) {
		super();
		this.id = id;
		this.name = name;
		this.customers = customers;
	}
	
	public Hobby(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Hobby() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	
}
