package com.iesvi.hibernate.ejemplos.ProyHbnJpa.generacionId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntityIdentity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String text;
	
	public MyEntityIdentity() {
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}
	
	
	
	


}