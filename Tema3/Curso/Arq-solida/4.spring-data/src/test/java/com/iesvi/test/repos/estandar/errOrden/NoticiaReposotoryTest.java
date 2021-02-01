package com.iesvi.test.repos.estandar.errOrden;

import com.iesvi.bo.Noticia;
import com.iesvi.repos.estandar.jpa.NoticiaRepositoryJPA;
import com.iesvi.test.shared.domain.builder.NoticiaBuilder;
import com.iesvi.test.shared.domain.builder.NoticiaMother;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class NoticiaReposotoryTest extends JPAUnitTest {

    NoticiaRepositoryJPA repo;
    private Noticia newnotice;

    @Override
    public void setup() {
        super.setup();
        repo = new NoticiaRepositoryJPA();
        repo.setEntityManager(em);
    }

    @Test
    public void inyectarEntityManager() {
        Assert.assertNotNull(em);
    }

    @Test
    public void seleccionarTodasNoticias() {
        Iterable<Noticia> noticias=repo.findAll();
        Assert.assertEquals("Obtiene todas las noticias",1,((ArrayList) noticias).size());
    }

    @Test
    public void buscarNoticia() {
        em.clear();
        Noticia noticia = repo.findOne(1);
        Assert.assertEquals("Encuentra noticia id=1",noticia.getId(),1);
    }

    @Test
    public void insertarNoticia() {

        //Arrange
        em.getTransaction().begin();
        Noticia newnotice = new Noticia(2,"Noticia-2","Manel",new Date());
        repo.save(newnotice); //ACT
        em.getTransaction().commit();

        Noticia noticia = em.find(Noticia.class,newnotice.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia.getId());
    }

    @Test
    public void insertarNoticiaBuilder() {

        //Arrange
        em.getTransaction().begin();

        //Noticia x defecto
        Noticia newnotice = new NoticiaBuilder().build();

        //Noticia cambiando algo
        Noticia newnotice2 = new NoticiaBuilder()
                .withAutor("Ramon ropero")
                .withTitle("Java 11!")
                .build();


        repo.save(newnotice); //ACT
        em.getTransaction().commit();

        Noticia noticia = em.find(Noticia.class,newnotice.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia.getId());
    }

    @Test
    public void insertarNoticiaMother() {

        //Arrange
        em.getTransaction().begin();

        //Noticia x defecto
        Noticia newnotice = NoticiaMother.general();

        //Noticia x defecto
        Noticia newnot_edge = NoticiaMother.edgeCase();

        repo.save(newnotice); //ACT
        repo.save(newnot_edge); //ACT
        em.getTransaction().commit();

        Noticia noticia1 = em.find(Noticia.class,newnotice.getId());
        Noticia noticia2 = em.find(Noticia.class,newnot_edge.getId());

        //Assert
        Assert.assertEquals(newnotice.getId(),noticia1.getId());
        Assert.assertEquals(newnot_edge.getId(),noticia2.getId());
    }

    @Test
    public void updateNoticia() {

        //Arrange
        Noticia noticia =repo.findOne(1);
        noticia.setAutor("JAVIER");
        noticia.setTitulo("Titulo cambiado");

        //ACT
        em.getTransaction().begin();
        repo.save(noticia);
        em.getTransaction().commit();  //La transaccion es obligatoria para asegurar que persiste los datos

        em.clear(); //para limpiar la BD

        Noticia noticiaBd = em.find(Noticia.class,1);

        //Assert
        Assert.assertEquals(noticia,noticiaBd);
    }

    @Test
    public void deleteNoticia() {
        //Arrange
        em.getTransaction().begin();
        Noticia noticeDel = em.find(Noticia.class,1);
        repo.delete(noticeDel); //ACT
        em.getTransaction().commit();

        Noticia noticiaBd = em.find(Noticia.class,1);

        //Assert
        Assert.assertNull(noticiaBd);
    }

}
