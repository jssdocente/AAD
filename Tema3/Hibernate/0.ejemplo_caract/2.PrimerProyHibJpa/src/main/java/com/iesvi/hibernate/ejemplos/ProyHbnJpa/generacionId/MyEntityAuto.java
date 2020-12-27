package com.iesvi.hibernate.ejemplos.ProyHbnJpa.generacionId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntityAuto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String text;
	
	public MyEntityAuto() {
		
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