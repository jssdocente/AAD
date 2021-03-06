package com.iesvi.hibernate.ejemplos.asociones.ManyToMany.SinEntidadIntem.Bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociaciones @ManyToMany bidireccionales
 */
public class App {
	public static void main(String[] args) {

		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany-SinEntidad-Bi");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person1 = new Person("12345");
		Person person2 = new Person("123123");

		Address address1 = new Address( "Rue del Percebe", "13", "41010" );
		Address address2 = new Address( "Av. de la Constitución", "1", "41000" );

		person1.addAddress(address1);
		person1.addAddress(address2);

		person2.addAddress(address1);

		em.persist(person1);
		em.persist(person2);

		em.flush();

		//person1.removeAddress(address1);
		


		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
