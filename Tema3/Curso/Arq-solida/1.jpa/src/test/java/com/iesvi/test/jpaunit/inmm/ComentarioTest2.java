package com.iesvi.test.jpaunit.inmm;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComentarioTest2 extends JPAUnitTest {

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
