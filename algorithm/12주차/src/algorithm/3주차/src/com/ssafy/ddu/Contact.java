package com.ssafy.ddu;

import java.io.Serializable;

public class Contact implements Serializable{
	private String number;
	private String name;
	private String company;
	
	public Contact() {
		
	}
	public Contact(String number, String name, String company) {
		this.number = number;
		this.name = name;
		this.company = company;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Contact [number=" + number + ", name=" + name + ", company=" + company + "]";
	}
	
	
}
