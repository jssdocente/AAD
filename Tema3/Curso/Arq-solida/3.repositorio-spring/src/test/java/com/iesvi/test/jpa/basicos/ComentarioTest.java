package com.iesvi.test.jpa.basicos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComentarioTest {

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
	public void seleccionarComentarioInicial() {
		
		Comentario comentario= em.find(Comentario.class,1);
		assertEquals("pedro",comentario.getAutor());
		
	}
	
	@Test
	public void seleccionarComentarioInicialConsulta() {
		
		int total= em.createQuery("select c from Comentario c").getResultList().size();
		assertEquals(1,total);
		
	}
	
	@Test
	public void seleccionarComentarioDeNoticia() {
		
		
		Noticia noticia= em.find(Noticia.class, "java 9 ha salido");
		Comentario comentario=noticia.getComentarios().get(0);
		assertEquals("pedro",comentario.getAutor());
		
	}
	
	
}
