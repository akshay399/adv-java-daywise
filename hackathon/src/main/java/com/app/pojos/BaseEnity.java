package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEnity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseEnity(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BaseEnity [id=" + id + "]";
	}

	public BaseEnity() {
		
	}
	
}
