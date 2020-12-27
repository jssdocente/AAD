package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.Bi;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;

@Entity
public class Person  {
	
	
    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String registrationNumber;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Address> addresses = new HashSet<>();

    public Person() {
    }

    public Person(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add( address );
        address.getOwners().add( this );
    }

    public void removeAddress(Address address) {
        addresses.remove( address );
        address.getOwners().remove( this );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals( registrationNumber, person.registrationNumber );
    }

    @Override
    public int hashCode() {
        return Objects.hash( registrationNumber );
    }
}
