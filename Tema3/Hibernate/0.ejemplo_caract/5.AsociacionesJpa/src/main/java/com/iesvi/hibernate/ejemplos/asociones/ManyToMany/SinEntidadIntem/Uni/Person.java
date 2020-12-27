package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.Uni;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Address> addresses = new HashSet<>();

    public Person() {
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

}
