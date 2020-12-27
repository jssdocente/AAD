package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.ExtraAttrb;

import com.iesvi.hibernate.ejemplos.asociones.ManyToMany.EntidadIntermedia.Address;
import com.iesvi.hibernate.ejemplos.asociones.ManyToMany.EntidadIntermedia.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociación @ManyToMany con tabla de enlace y atributos extra
 */
public class App {
	public static void main(String[] args) {

		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany-SinEntidad-ExtraAttrb");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		//PENDIENTE DE INCLUIR CÓDIGO DE EJEMPLO

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		emf.close();
	}
}
