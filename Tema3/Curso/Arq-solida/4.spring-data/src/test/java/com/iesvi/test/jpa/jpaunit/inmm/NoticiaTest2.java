package com.iesvi.test.jpa.jpaunit.inmm;

import com.iesvi.bo.Noticia;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class NoticiaTest2 extends JPAUnitTest {

	@Test
	public void entityManagerFactoryOK() {
		
		assertNotNull(emf);
	}
	
	@Test
	public void entityManagerOK() {
		
		assertNotNull(em);
	}
	
	@Test
	public void seleccionarNoticiaInicial() {
		
		Noticia noticia= em.find(Noticia.class, "java 9 ha salido");
		assertEquals("cecilio",noticia.getAutor());
		
	}
	
	@Test
	public void borrarNoticiaInicial() {
		
		Noticia noticia= em.find(Noticia.class, "java 9 ha salido");
		em.getTransaction().begin();
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia sinNoticia= em.find(Noticia.class, "java 9 ha salido");
		assertNull(sinNoticia);
		
	}
	@Test
	public void insertarNuevaNoticia() {
		
		em.getTransaction().begin();
		Noticia noticiaNueva= new Noticia(2,"java 8 y streams","Cecilio",new Date());
		em.persist(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticiaInsertada= em.find(Noticia.class,"java 8 y streams");
		
		
	}
	
	
		
}
