package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.Uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	
    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String number;

    public Address() {
    }

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

}
