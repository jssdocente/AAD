package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.Uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociaciones ManyToMany unidireccionales
 *
 */
public class App {
	public static void main(String[] args) {

		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany-SinEntidad-Uni");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person1 = new Person();
		Person person2 = new Person();

		Address address1 = new Address( "Rue del Percebe", "13" );
		Address address2 = new Address( "Av. de la Constitución", "1" );

		person1.getAddresses().add(address1);
		person1.getAddresses().add(address2);

		person2.getAddresses().add(address1);

		em.persist(person1);
		em.persist(person2);

		em.flush();

		person1.getAddresses().remove( address1 );
		


		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
