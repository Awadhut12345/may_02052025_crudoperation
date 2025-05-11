package com.soft.entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_tab")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id_col")
	private int id;
	@Column(name="emp_name_col")
	private String name;
	@Column(name="emp_email_col")
	private String email;
	@Column(name="emp_address_col")
	private String address;
	@Column(name="emp_phone_col")
	private long phone;
	@Column(name="emp_salary_col")
	private float salary;
	@Column(name="emp_password_col")
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER) //@EmlementCollection is use to store entity in separate table
	@CollectionTable( //@CollectionTable used to define table name and foreign key
	name="emp_role_tab", //table name
	joinColumns = @JoinColumn(name="emp_id_col") //foreign key column in emp_role_tab link back to Employee table id
	)
	@Column(name="emp_role_col")
	private Set<String> role;
	@Column(name="emp_active_col")
	private boolean active;
	@Column(name="emp_otp_col")
	private String otp;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", salary=" + salary + ", password=" + password + ", role=" + role + ", active=" + active
				+ ", otp=" + otp + "]";
	}
	
	
	
	
	
	
}
