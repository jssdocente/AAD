package com.iesvi.hibernate.ejemplos.asociones.OneToManyBid;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NaturalId //anotación para indicar que esta columna es una clave candidata y muy util para filtrar/igualdad de forma natura de la clase. De ahi NaturalId
	@Column(unique=true)
	private String number;	
	
	@ManyToOne
	private Person person;
	
	public Phone() { }
	
	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	//Este equals es muy sencillo comparado con Java 1.5, haciendo uso de los beneficios de Java 1.7+
	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equals( number, phone.number );
	}
	
	
	
	
	
}
