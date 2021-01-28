package com.iesvi.test.services.unit;

import com.iesvi.bo.Noticia;
import com.iesvi.dto.NoticiaDto;
import com.iesvi.repos.generic.jpa.NoticiaRepositoryJPA;
import com.iesvi.services.NoticiaServicio;
import com.iesvi.test.shared.domain.builder.NoticiaBuilder;
import com.iesvi.test.shared.domain.builder.dto.NoticiaDtoMother;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class NoticiaServicioTest {

    NoticiaRepositoryJPA noticeMock;
    NoticiaServicio servicioNoticias;

    @Before
    public void setUp() {
        servicioNoticias= new NoticiaServicio();
    }

    @Test
    public void createNoticiaTest() {

        NoticiaRepositoryJPA noticeMock = Mockito.mock(NoticiaRepositoryJPA.class);
        NoticiaDto ndto = NoticiaDtoMother.general();

        //Crear Noticia-entity desde noticia-dto (por ahora lo creamos manualmente)
        Noticia newnotice = new Noticia(ndto.getId(),ndto.getTitulo(),ndto.getAutor(),ndto.getFecha());

        //Arrange
        Mockito.when(noticeMock.save(newnotice)).thenReturn(newnotice);
        servicioNoticias.setNoticiaRepo(noticeMock);

        Noticia createdNotice= servicioNoticias.createNoticia(ndto);

        Assert.assertEquals(newnotice.getId(),createdNotice.getId());
    }

    @Test
    public void findNoticia() {

        int noticiaId=36;
        NoticiaRepositoryJPA noticeMock = Mockito.mock(NoticiaRepositoryJPA.class);

        //Arrange
        Mockito.when(noticeMock.findOne(36)).thenReturn(new NoticiaBuilder().withId(36).build());
        servicioNoticias.setNoticiaRepo(noticeMock);

        Noticia findedNotice= servicioNoticias.findNoticia(noticiaId);

        Assert.assertEquals(noticiaId,findedNotice.getId());
    }

}
