package com.iesvi.bo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String texto;
	private String autor;
	
	//uno a uno
	// modificar nuestro modelo para permitir lazy fetching
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="noticiaId")
	private Noticia noticia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Comentario(String texto, String autor, Noticia noticia) {
		super();
		this.texto = texto;
		this.autor = autor;
		this.noticia = noticia;
	}

	public Comentario() {
		super();
	}

	public Comentario(int id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Comentario)) return false;

		Comentario that = (Comentario) o;

		if (getId() != that.getId()) return false;
		if (!getTexto().equals(that.getTexto())) return false;
		return getAutor() != null ? getAutor().equals(that.getAutor()) : that.getAutor() == null;
	}

	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + getTexto().hashCode();
		result = 31 * result + (getAutor() != null ? getAutor().hashCode() : 0);
		return result;
	}
}
