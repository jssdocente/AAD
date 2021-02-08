package com.iesvi.hibernate.strategies.Singletable;

import com.iesvi.hibernate.strategies.Tablexclass.Publication;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "BlogPost")
@DiscriminatorValue("Blog")
public class BlogPost extends Publication {

    @Column
    private String url;
    
}