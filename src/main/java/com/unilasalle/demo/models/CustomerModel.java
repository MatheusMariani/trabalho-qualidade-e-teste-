package com.unilasalle.demo.models;

import javax.persistence.Column;

import com.unilasalle.demo.entities.Customer;

public class CustomerModel {

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "CPF")
	private String cpf;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;

	public CustomerModel(Customer customer) {
		setName(customer.getName());
		setCpf(customer.getCpf());
		setPhone(customer.getPhone());
		setEmail(customer.getEmail());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
