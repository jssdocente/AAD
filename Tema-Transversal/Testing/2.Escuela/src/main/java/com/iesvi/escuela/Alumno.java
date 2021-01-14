package com.iesvi.escuela;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String nombre;
	private List<Nota> notas = new ArrayList<Nota>();

	public void addNota(Nota nota) {

		this.notas.add(nota);

	}

	public void removeNota(Nota nota) {

		this.notas.remove(nota);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Alumno(String nombre, List<Nota> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	public Alumno() {
		super();
	}

	public int getSobreSalientes() {

		int sobreSalientes = 0;
		for (Nota nota : this.getNotas()) {

			if (nota.getValor() >= 9) {

				sobreSalientes++;
			}
		}
		return sobreSalientes;
	}
	
	public int getSuspensos() {

		int suspensos = 0;
		for (Nota nota : this.getNotas()) {

			if (nota.getValor() < 5) {

				suspensos++;
			}
		}
		return suspensos;
	}
	
	public int getMuyDeficientes() {

		int deficientes = 0;
		for (Nota nota : this.getNotas()) {

			if (nota.getValor() < 3) {

				deficientes++;
			}
		}
		return deficientes;
	}
	
	

}
