package com.iesvi.test.escuela;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iesvi.escuela.Alumno;
import com.iesvi.escuela.Nota;

class AlumnoTest4 {
	
	List<Nota> notas;

	@BeforeEach
	public void setUp() {
		
		Nota nota1 = new Nota(5, "matematicas");
		Nota nota2 = new Nota(7, "lengua");
		Nota nota3 = new Nota(10, "fisica");
		
		// dos suspensos
		Nota nota4 = new Nota(4, "lengua");
		Nota nota5 = new Nota(3, "ingles");
		Nota nota6 = new Nota(1, "fisica");
	
		
		notas = new ArrayList<Nota>();
		notas.add(nota1);
		notas.add(nota2);
		notas.add(nota3);
		notas.add(nota4);
		notas.add(nota5);
		notas.add(nota6);	
	}

	@Test
	void testAnadirNotaAlumno() {
		//mas solida
		Alumno alumno1 = new Alumno("juan", notas);
		alumno1.addNota(new Nota(4, "ingles"));
		assertThat(alumno1.getNotas(),hasItem(new Nota(4,"ingles")));
	}

	@Test
	void testBorrarNotaAlumno() {

		
		Alumno alumno1 = new Alumno("juan", notas);
		alumno1.removeNota(new Nota(5, "matematicas"));
		assertThat(alumno1.getNotas(),not (hasItem(new Nota(5,"matematicas"))));

	}
	
	@Test
	void testNumeroDeSobreSalientes() {

		Alumno alumno1 = new Alumno("juan", notas);
		assertThat(1,equalTo(alumno1.getSobreSalientes()));
	}
	
	@Test
	void testNumeroSuspensos() {

		Alumno alumno1 = new Alumno("juan", notas);
		
		// flojea porque no testea concretamente loque queremos
		// sino una situacion cercana
		assertThat(2,lessThanOrEqualTo(alumno1.getSuspensos()));
	}
	
	@Test
	void testNumeroMuyDeficientes() {

		Alumno alumno1 = new Alumno("juan", notas);
		assertThat(1,equalTo(alumno1.getMuyDeficientes()));
	}
	
	@AfterEach
	void tearDown() {
		// cerrar recursos en cada ejecuci�n de un test
		notas=null;
	}

}
