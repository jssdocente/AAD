package com.iesvi.test.shared.domain.builder;

import com.iesvi.bo.Noticia;
import com.sun.tools.corba.se.idl.constExpr.Not;
import io.beanmother.core.ObjectMother;

import java.util.Date;

public class NoticiaBuilder {

    private int id;
    private String titulo;
    private String autor;
    private Date fecha;

    public NoticiaBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public NoticiaBuilder withTitle(String title) {
        this.titulo = title;
        return this;
    }

    public NoticiaBuilder withAutor(String author) {
        this.autor = author;
        return this;
    }

    public NoticiaBuilder withDate(Date date) {
        this.fecha = date;
        return this;
    }

    public Noticia build() {
        ObjectMother om = ObjectMother.getInstance();
        Noticia nmother= om.bear("noticia",Noticia.class);

        return new Noticia(
                id!=0 ? id : nmother.getId(),
                titulo!=null ? titulo : nmother.getTitulo(),
                autor!=null ? autor : nmother.getTitulo(),
                fecha!=null ? fecha : nmother.getFecha()
        );
    }
}