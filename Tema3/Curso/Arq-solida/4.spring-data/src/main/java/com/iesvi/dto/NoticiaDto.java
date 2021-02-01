package com.iesvi.dto;

import java.util.Date;

public class NoticiaDto {

    private int id;
    private String titulo;
    private String autor;
    private Date fecha;

    public NoticiaDto(int id, String titulo, String autor,Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha= fecha;
    }

    public NoticiaDto() {}

    public int getId() {return id; }

    public String getTitulo() {return titulo;}

    public String getAutor() {return autor;}

    public Date getFecha() {return fecha;}
}
