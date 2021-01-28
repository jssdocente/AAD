package com.iesvi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com.iesvi")
@EnableTransactionManagement
public class ConfigurationSpring {

    //integrar el entitymanager factory en spring framework
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        //usamos un contenedor-local
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        //decimos que usamos hibernate
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //asigno el vendor(hibernate) para utilizar con el EntityManager
        em.setJpaVendorAdapter(vendorAdapter);
        //y al entityManager a la unidad de persistencia
        em.setPersistenceUnitName("curso");
        return em;
    }

    //ejecutar transacciones ==> Asignar un gestor transaccional al EntityManager
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    //Traductor de excepciones de Spring
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
