package com.iesvi.test.repos.generic.spring;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;
import com.iesvi.config.ConfigurationSpring;
import com.iesvi.repos.generic.ComentarioRepository;
import com.iesvi.repos.generic.NoticiaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationSpring.class)
public class ComentarioRepositorySpringTest {

    @Autowired
    ComentarioRepository repoComment;

    Noticia noticiaTest;

    @Test
    public void inyectarRepositorioTest() {
        Assert.assertNotNull(repoComment);
    }

    @Test
    public void seleccionarTodasComentarios() {
        Iterable<Comentario> comentarios= repoComment.findAll();
        Assert.assertEquals("Obtiene todas las comentarios",1,((ArrayList) comentarios).size());
    }

    @Test
    @Transactional
    public void insertarComentario() {
        //Arrange
        Comentario newcomment = new Comentario("Comentario-2","Manuel",noticiaTest);
        repoComment.save(newcomment); //ACT

        //Utilizo el EntityManager para que un Test-unitario no dependa de otro Test-unitario (el test de buscar)
        Comentario comment = repoComment.findOne(newcomment.getId());

        //Assert
        Assert.assertEquals(newcomment.getId(),comment.getId());
    }

    @Test
    @Transactional
    public void updateComentario() {

        //Arrange
        Comentario comment = repoComment.findOne(1);
        comment.setAutor("JAVIER");
        comment.setTexto("Texto cambiado");

        //ACT
        repoComment.save(comment);

        Comentario commentBd = repoComment.findOne(1);

        //Assert
        Assert.assertEquals(comment,commentBd);
    }

    @Test
    @Transactional
    public void deleteComentario() {
        //Arrange

        Comentario noticeDel = repoComment.findOne(1);
        repoComment.delete(noticeDel); //ACT

        Comentario noticiaBd = repoComment.findOne(1);

        //Assert
        Assert.assertNull(noticiaBd);

    }

}
