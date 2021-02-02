package com.iesvi.bo.filter;

import com.iesvi.bo.Comentario;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticiaFilter {

	private String titulo;

	private String autor;
	private Date fecha;

	public boolean isFilterByAutor() {
		return autor!=null && !autor.isEmpty();
	}

	public boolean isFilterByTitulo() {
		return  titulo!=null && !titulo.isEmpty();
	}

	public boolean isFilterByFecha() {
		return fecha==null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFecha() {
		return fecha;
	}

}
