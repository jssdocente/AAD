package com.iesvi.test.services.integracion;

import com.iesvi.bo.Noticia;
import com.iesvi.test.config.ConfiguracionSpringTest;
import com.iesvi.dto.NoticiaDto;
import com.iesvi.repos.generic.*;
import com.iesvi.services.NoticiaServicio;
import com.iesvi.test.shared.domain.builder.dto.NoticiaDtoMother;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracionSpringTest.class)
public class NoticiaServicioSpringTestIntegra {

    @Autowired
    NoticiaRepository repoNotice;
    @Autowired
    ComentarioRepository repoComment;
    @Autowired
    NoticiaServicio servicioNoticias;

    @Before
    public void setUp() {
        //Esta inicialización no es necesaria ya, pues Spring está inyectando las dependencias. No es necesario inicializarlas.
        //servicioNoticias= new NoticiaServicio();
    }

    @Test
    public void createNoticiaTest() {

        NoticiaDto ndto = NoticiaDtoMother.general();

        //Crear Noticia-entity desde noticia-dto (por ahora lo creamos manualmente)
        Noticia newnotice = new Noticia(ndto.getId(),ndto.getTitulo(),ndto.getAutor(),ndto.getFecha());

        Noticia createdNotice= servicioNoticias.createNoticia(ndto);

        Assert.assertEquals(newnotice,createdNotice);
    }

    @Test
    public void findNoticia() {

        int noticiaId=1;

        //Arrange
        Noticia findedNotice= servicioNoticias.findNoticia(noticiaId);

        Assert.assertEquals(noticiaId,findedNotice.getId());
    }

}
