package com.iesvi.test.repos.generic.spring;

import com.iesvi.bo.Noticia;
import com.iesvi.config.ConfigurationSpring;
import com.iesvi.repos.generic.NoticiaRepository;
import com.iesvi.repos.generic.jpa.NoticiaRepositoryJPA;
import com.iesvi.test.shared.domain.builder.NoticiaBuilder;
import com.iesvi.test.shared.domain.builder.NoticiaMother;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationSpring.class)
public class NoticiaRepositorySpringTest {

    @Autowired
    NoticiaRepository repo;  // antes NoticiaRepositoryJPA repo;
    private Noticia newnotice;

    //La parte de inicialización ya no es necesaria
//    @Override
//    public void setup() {
//        super.setup();
//        repo = new NoticiaRepositoryJPA();
//        repo.setEntityManager(em);
//    }

    //Cambiamos este test por ==> inyectarRepositorioTest, porque si funciona la inyección del repositorio
    // .. también funciona el EntityManager, ya que el Repositorio depende del Entitymanager
        //    @Test
        //    public void inyectarEntityManager() {
        //        Assert.assertNotNull(em);
        //    }

    @Test
    public void inyectarRepositorioTest() {
        Assert.assertNotNull(repo);
    }

    @Test
    public void seleccionarTodasNoticias() {
        Iterable<Noticia> noticias=repo.findAll();
        Assert.assertEquals("Obtiene todas las noticias",1,((ArrayList) noticias).size());
    }

    @Test
    public void buscarNoticia() {
        Noticia noticia = repo.findOne(1);
        Assert.assertEquals("Encuentra noticia id=1",noticia.getId(),1);
    }

    @Test
    public void insertarNoticia() {

        //Arrange
        //em.getTransaction().begin();
        Noticia newnotice = new Noticia(2,"Noticia-2","Manel",new Date());
        repo.save(newnotice); //ACT
        //em.getTransaction().commit();

        Noticia noticia = repo.findOne(newnotice.getId()); // reemplaza a ==> em.find(Noticia.class,newnotice.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia.getId());
    }

    @Test
    public void insertarNoticiaBuilder() {

        //Arrange
        //em.getTransaction().begin();

        //Noticia x defecto
        Noticia newnotice = new NoticiaBuilder().build();

        //Noticia cambiando algo
        Noticia newnotice2 = new NoticiaBuilder()
                .withAutor("Ramon ropero")
                .withTitle("Java 11!")
                .build();


        repo.save(newnotice); //ACT
        //em.getTransaction().commit();

        Noticia noticia = repo.findOne(newnotice.getId());  //reemplaza a ==> em.find(Noticia.class,newnotice.getId());
        //Assert
        Assert.assertEquals(newnotice.getId(),noticia.getId());
    }

    @Test
    public void insertarNoticiaMother() {

        //Arrange

        //Noticia x defecto
        Noticia newnotice = NoticiaMother.general();

        //Noticia x defecto
        Noticia newnot_edge = NoticiaMother.edgeCase();

        repo.save(newnotice); //ACT
        repo.save(newnot_edge); //ACT

        Noticia noticia1 = repo.findOne(newnotice.getId());
        Noticia noticia2 = repo.findOne(newnot_edge.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia1.getId());
        Assert.assertEquals(newnot_edge.getId(),noticia2.getId());
    }

    @Test
    @Transactional
    public void updateNoticia() {

        //Arrange
        Noticia noticia =repo.findOne(1);
        noticia.setAutor("JAVIER");
        noticia.setTitulo("Titulo cambiado");

        //ACT
        repo.save(noticia);

        Noticia noticiaBd = repo.findOne(1);

        //Assert
        Assert.assertEquals(noticia,noticiaBd);
    }

    @Test
    @Transactional
    public void deleteNoticia() {
        //Arrange
        Noticia noticeDel = repo.findOne(1);
        repo.delete(noticeDel); //ACT

        Noticia noticiaBd = repo.findOne(1);

        //Assert
        Assert.assertNull(noticiaBd);
    }

}
