package com.iesvi.test.utilidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.iesvi.utilidades.Calculadora;

class CalculadoraTest {

	@Test
	@DisplayName("suma de dos numeros")
	void testSuma() {

		// arrange (preparacion)
		Calculadora calculadora = new Calculadora();
		// act (ejecutar)
		double suma = calculadora.sumar(2, 2);

		// assert (confirmacion)
		assertEquals(4, suma);

	}

	@Test
	@DisplayName("resta de dos numeros")
	void testRestar() {

		// arrange (preparacion)
		Calculadora calculadora = new Calculadora();
		// act (ejecutar)
		double resta = calculadora.restar(2, 2);

		// assert (confirmacion)
		assertEquals(0, resta);

	}

	@Test
	@DisplayName("multiplicacion de dos numeros")
	void testMultiplicar() {

		// arrange (preparacion)
		Calculadora calculadora = new Calculadora();
		// act (ejecutar)
		double multiplicar = calculadora.multiplicar(2, 3);

		// assert (confirmacion)
		assertEquals(6, multiplicar);

	}

	@Test
	@DisplayName("dividir de dos numeros")
	void testDividir() {

		// arrange (preparacion)
		Calculadora calculadora = new Calculadora();
		// act (ejecutar)
		double dividir = calculadora.dividir(4, 2);

		// assert (confirmacion)
		assertEquals(2, dividir);

	}

}
