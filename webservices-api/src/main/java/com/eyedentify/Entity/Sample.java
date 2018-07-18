package com.eyedentify.Entity;

import java.io.Serializable;
import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;




@Table("Sample")
public class Sample implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	@PrimaryKey
	private UUID id;

	private String name;
	private int age;
	private boolean active;

	public Sample() {
	}

	public Sample(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", active=" + active + "]";
	}

	

	public Sample(String name, int age, boolean active) {
		super();
		this.name = name;
		this.age = age;
		this.active = active;
	}

}
