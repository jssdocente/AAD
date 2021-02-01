package com.iesvi.test.repos.estandar.errOrden;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;
import com.iesvi.repos.estandar.jpa.ComentarioRepositoryJPA;
import com.iesvi.repos.estandar.jpa.NoticiaRepositoryJPA;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ComentarioReposotoryTest extends JPAUnitTest {

    ComentarioRepositoryJPA repo;
    NoticiaRepositoryJPA repoNotice;

    Noticia noticiaTest;

    @Override
    public void setup() {
        super.setup();
        repo = new ComentarioRepositoryJPA();
        repo.setEntityManager(em);

        repoNotice = new NoticiaRepositoryJPA();
        repoNotice.setEntityManager(em);

        noticiaTest = repoNotice.findOne(1);
    }

    @Test
    public void inyectarEntityManager() {
        Assert.assertNotNull(em);
    }

    @Test
    public void seleccionarTodasComentarios() {
        Iterable<Comentario> comentarios=repo.findAll();
        Assert.assertEquals("Obtiene todas las comentarios",1,((ArrayList) comentarios).size());
    }

    @Test
    public void insertarComentario() {
        //Arrange
        em.getTransaction().begin();
        Comentario newcomment = new Comentario("Comentario-2","Manuel",noticiaTest);
        repo.save(newcomment); //ACT
        em.getTransaction().commit();

        em.clear();

        //Utilizo el EntityManager para que un Test-unitario no dependa de otro Test-unitario (el test de buscar)
        Comentario comment = em.find(Comentario.class,newcomment.getId());

        //Assert
        Assert.assertEquals(newcomment.getId(),comment.getId());
    }

    @Test
    public void updateComentario() {

        //Arrange
        Comentario comment = em.find(Comentario.class,1);
        comment.setAutor("JAVIER");
        comment.setTexto("Texto cambiado");

        //ACT
        em.getTransaction().begin();
        repo.save(comment);
        em.getTransaction().commit();  //La transaccion es obligatoria para asegurar que persiste los datos

        em.clear(); //para limpiar la BD

        Comentario commentBd = em.find(Comentario.class,1);

        //Assert
        Assert.assertEquals(comment,commentBd);
    }

    @Test
    public void deleteComentario() {
        //Arrange

        Comentario noticeDel = em.find(Comentario.class,1);
        em.getTransaction().begin();
        repo.delete(noticeDel); //ACT
        em.getTransaction().commit();

        Comentario noticiaBd = em.find(Comentario.class,1);

        //Assert
        Assert.assertNull(noticiaBd);

    }

}
