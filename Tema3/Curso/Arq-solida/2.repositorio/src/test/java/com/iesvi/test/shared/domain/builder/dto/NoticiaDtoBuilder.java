package com.iesvi.test.shared.domain.builder.dto;

import com.iesvi.bo.Noticia;
import com.iesvi.dto.NoticiaDto;
import io.beanmother.core.ObjectMother;

import java.util.Date;

public class NoticiaDtoBuilder {

    private int id;
    private String titulo;
    private String autor;
    private Date fecha;

    public NoticiaDtoBuilder withTitle(String title) {
        this.titulo = title;
        return this;
    }

    public NoticiaDtoBuilder withAutor(String author) {
        this.autor = author;
        return this;
    }

    public NoticiaDtoBuilder withDate(Date date) {
        this.fecha = date;
        return this;
    }

    public NoticiaDto build() {
        ObjectMother om = ObjectMother.getInstance();
        NoticiaDto nmother= om.bear("noticiadto",NoticiaDto.class);

        return new NoticiaDto(
                id!=0 ? id : nmother.getId(),
                titulo!=null ? titulo : nmother.getTitulo(),
                autor!=null ? autor : nmother.getTitulo(),
                fecha!=null ? fecha : nmother.getFecha()
        );
    }
}