package com.iesvi.hibernate.strategies.Joined;

import com.iesvi.hibernate.strategies.Tablexclass.Publication;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Book")
public class Book extends Publication {

    @Column
    private int pages;
    
}