package com.iesvi.test.escuela;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iesvi.escuela.Alumno;
import com.iesvi.escuela.Nota;

class AlumnoTest3 {
	Nota nota1;
	Nota nota2;
	Nota nota3;
	List<Nota> notas;

	@BeforeEach
	public void setUp() {
		
		nota1 = new Nota(5, "matematicas");
		nota2 = new Nota(7, "lengua");
	
		notas = new ArrayList<Nota>();
		notas.add(nota1);
		notas.add(nota2);
		
	}

	@Test
	void testAnadirNotaAlumno() {

		Alumno alumno1 = new Alumno("juan", notas);

		alumno1.addNota(new Nota(4, "ingles"));

		//assertEquals(3, alumno1.getNotas().size());
		assertThat(3,equalTo(alumno1.getNotas().size()));
	}

	@Test
	void testBorrarNotaAlumno() {

		
		Alumno alumno1 = new Alumno("juan", notas);

		// e eliminar una nota que ya existia que es la
		// de matematicas
		alumno1.removeNota(new Nota(5, "matematicas"));

		assertThat(1,equalTo(alumno1.getNotas().size()));

	}
	
	@Test
	void testNumeroDeSobreSalientes() {

		// a este test en concreto para no 
		// destruir los datos compartidos anteriores
		// esto es algo mejor que comenzar con el baile de test
		
		Nota notaNueva= new Nota(10,"ingles");
		List<Nota> notas= new ArrayList<Nota>();
		notas.add(notaNueva);
		
		Alumno alumno1 = new Alumno("juan", notas);

		//assertEquals(1, alumno1.getSobreSalientes());

		assertThat(1,equalTo(alumno1.getSobreSalientes()));
	}

}
