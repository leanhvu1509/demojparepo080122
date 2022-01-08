package com.lavu.demojparepo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "is required")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty(message = "is required")
	@Column(name = "last_name")
	private String lastName;
	
	@Email
	@Column(name = "email")
	private String email;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "PROVINCE_ID")
	private Province province;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "customers_hobbies",joinColumns = @JoinColumn(name="CUSTOMER_ID"),inverseJoinColumns = @JoinColumn(name="HOBBY_ID"))
	private List<Hobby> hobbies = new ArrayList<>(); 
	public Customer() {
		super();
	}
	
	
	public Customer(int id, String firstName, String lastName, String email, Province province) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.province = province;
	}
	

	public Customer(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Province getProvince() {
		return province;
	}


	public void setProvince(Province province) {
		this.province = province;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Customer(int id, String firstName, String lastName, String email, Province province, List<Hobby> hobbies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.province = province;
		this.hobbies = hobbies;
	}


	public List<Hobby> getHobbies() {
		return hobbies;
	}


	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	
}
