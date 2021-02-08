package com.iesvi.hibernate.strategies.Mappedsuper;

import com.iesvi.hibernate.strategies.Tablexclass.Publication;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Book")
public class Book extends Publication {

    @Column
    private int pages;
    
}