package com.iesvi.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Noticia implements Serializable {

	@Id
	private int id;

	private String titulo;

	private String autor;
	private Date fecha;

	@OneToMany(mappedBy="noticia",cascade=CascadeType.ALL)
	private List<Comentario> comentarios= new ArrayList<Comentario>();


	public Noticia(int id, String titulo, String autor, Date fecha) {
		super();

		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
	}
	
	public Noticia(String titulo) {
		super();
		this.titulo = titulo;
	}

	
	public Noticia() {
		super();
	}
	
	public void addComentario(Comentario c) {
		
		comentarios.add(c);
	}

	public int getId() {return id;}
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
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	public static Noticia from(Noticia noticia) {
		return new Noticia(noticia.id, noticia.titulo, noticia.autor, noticia.fecha);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Noticia)) return false;

		Noticia noticia = (Noticia) o;

		if (getId() != noticia.getId()) return false;
		if (getTitulo() != null ? !getTitulo().equals(noticia.getTitulo()) : noticia.getTitulo() != null) return false;
		if (getAutor() != null ? !getAutor().equals(noticia.getAutor()) : noticia.getAutor() != null) return false;
		return getFecha() != null ? getFecha().equals(noticia.getFecha()) : noticia.getFecha() == null;
	}

	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getTitulo() != null ? getTitulo().hashCode() : 0);
		result = 31 * result + (getAutor() != null ? getAutor().hashCode() : 0);
		result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
		return result;
	}
}
