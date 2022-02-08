package io.project.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	@Column(name="phone_no")
	private String phoneNo;
	public Student(long id, String name, String email, String phone_no) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phone_no;
	}
	public Student() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getPhone_no() {
		return phoneNo;
	}
	public void setPhone_no(String phone_no) {
		this.phoneNo = phone_no;
	}
	

}
