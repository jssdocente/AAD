package com.iesvi.escuela;

public class Nota {

	private double valor;
	private String asignatura;
	private Alumno alumno;
	// una enumeraci�n es un grupo de valores limitados
	// que se define a nivel de clase normalmente
	public enum Tipo {

		MUYDEFICIENTE, INSUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE

	}
	
	
	public Nota(double valor, String asignatura, Alumno alumno) {
		super();
		this.valor = valor;
		this.asignatura = asignatura;
		this.alumno = alumno;
	}

	public Nota(double valor, String asignatura) {
		super();
		this.setValor(valor);
		this.setAsignatura(asignatura);
	}

	public Nota() {
		super();
	}

	
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	// dos notas comparten misma asignatura
	public boolean esMismaAsignatura(Nota otra) {
		
		if (this.getAsignatura().equals(otra.getAsignatura())) {
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean esMayor(Nota otra) {
		
		if (this.esMismaAsignatura(otra)) {
			
			if (this.getValor()>otra.getValor()) {
				
				return true;
			}else {
				return false;
			}
		}else {
			
			throw new RuntimeException("las notas no son comparables por no coincidir asignatura");
		}
		
	}
	
	public Tipo geTipo() {

		if (getValor() >= 0 && getValor() < 3) {
			//retorno una enumaci�n
			return Tipo.MUYDEFICIENTE;
		} else if (getValor() >= 3 && getValor() < 5) {
			return Tipo.INSUFICIENTE;
		} else if (getValor() >= 5 && getValor() < 7) {
			return Tipo.BIEN;
		} else if (getValor() >= 7 && getValor() < 9) {
			return Tipo.NOTABLE;
		} else {
			return Tipo.SOBRESALIENTE;
		}
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
	
	

}
