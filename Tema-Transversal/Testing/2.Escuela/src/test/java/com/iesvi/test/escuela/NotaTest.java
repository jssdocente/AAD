package com.iesvi.test.escuela;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iesvi.escuela.Nota;
import com.iesvi.escuela.Nota.Tipo;

class NotaTest {

	Nota nota1=null;
	Nota nota2=null;
	Nota nota3= null;
	Nota nota4= null;
	Nota nota5= null;
	Nota nota6= null;
	Nota nota7= null;
	
	@BeforeEach
	public void setUp() {
		
		// compartir un testfixture entre varias pruebas unitarias
		// esto suele ser bastante util
		nota1= new Nota(8,"lengua");
		nota2= new Nota (8,"lengua");
		nota3= new Nota (9,"matematicas");
		nota4= new Nota (7,"matematicas");
		nota5= new Nota (10,"lengua");
		nota6= new Nota (6,"lengua");
		nota7= new Nota (5.2,"lengua");
		
		
	}
	@Test
	void testMismaAsignaturaNota() {

		boolean esMisma = nota1.esMismaAsignatura(nota2);
		boolean esDistinta = nota1.esMismaAsignatura(nota3);

		assertTrue(esMisma);
		assertFalse(esDistinta);
	}

	@Test
	void testIgualdadNotas() {

		boolean iguales = nota1.equals(nota2);
		assertTrue(iguales);
	}

	@Test
	void testNoIgualdadNotas() {
		boolean noIguales = nota1.equals(nota3);
		// assert
		assertFalse(noIguales);
	}

	@Test
	void testNotaEsMayorQueOtra() {

		boolean esMayor= nota5.esMayor(nota1);		
		assertTrue(esMayor);
	}
	
	@Test
	void testNotaNoesComparableConOtra() {
		
		assertThrows(RuntimeException.class, ()->nota1.esMayor(nota3));


	}
	
	@Test
	void testNotaTipoBien() {
		
		Tipo miTipoNota=nota6.geTipo();
		
		assertEquals(Tipo.BIEN, miTipoNota);


	}
	@Test
	void testNotaTipoNotable() {
		
		Tipo miTipoNota=nota4.geTipo();
		// un valor limite
		assertEquals(Tipo.NOTABLE, miTipoNota);
	}
	@Test
	void testNotaTipoSuficiente() {
		
		Tipo miTipoNota=nota7.geTipo();
		// un valor limite
		assertEquals(Tipo.BIEN, miTipoNota);


	}

}
