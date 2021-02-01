package com.iesvi.test.jpa.basicos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.iesvi.bo.Noticia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoticiaTest {

	static EntityManagerFactory emf;
	protected EntityManager em;

	@Before
	public void iniciar() {
		//Persistence.generateSchema("curso", null);  //NO ES NECESARIO ==> LA LINEA DE ABAJO YA HACE ESTO TAMBIEN
		emf = Persistence.createEntityManagerFactory("curso");
		em = emf.createEntityManager();
	}

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
		
		Noticia noticia= em.find(Noticia.class, 1);
		assertEquals("cecilio",noticia.getAutor());
		
	}
	
	@Test
	public void borrarNoticiaInicial() {
		
		Noticia noticia= em.find(Noticia.class, 1);
		em.getTransaction().begin();
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia sinNoticia= em.find(Noticia.class, 1);
		assertNull(sinNoticia);
		
	}
	@Test
	public void insertarNuevaNoticia() {
		
		em.getTransaction().begin();
		Noticia noticiaNueva= new Noticia(2, "java 8 y streams","Cecilio",new Date());
		em.persist(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticiaInsertada= em.find(Noticia.class,2);
		
		
	}
	
	
		
}
