package com.iesvi.test.jpa.jpaunit.inmm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUnitTest {

	static EntityManagerFactory emf;
	protected EntityManager em;

	@BeforeClass
	public static void setupStatic() {
		//Persistence.generateSchema("cursomm", null);  //NO ES NECESARIO ==> LA LINEA DE ABAJO YA HACE ESTO TAMBIEN
		emf = Persistence.createEntityManagerFactory("cursomm");
	}

	@Before
	public void setup() {
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() {
		em.clear();
	}

	@AfterClass
	public static void tearDownStatic() {
		emf.close();
	}
}
