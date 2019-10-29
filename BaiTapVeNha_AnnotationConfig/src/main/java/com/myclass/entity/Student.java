package com.myclass.entity;

import java.util.Scanner;

public class Student {
	private int id;
	private String email;
	private String fullName;
	private String address;
	private String phone;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String email, String fullName, String address, String phone) {

		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("email: ");
		this.email = sc.nextLine();

		System.out.println("fullname: ");
		this.fullName = sc.nextLine();

		System.out.println("address: ");
		this.address = sc.nextLine();

		System.out.println("phone: ");
		this.phone = sc.nextLine();

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", fullName=" + fullName + ", address=" + address + ", phone="
				+ phone + "]";
	}

}
