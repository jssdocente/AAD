package com.iesvi.test.services.unit;

import com.iesvi.bo.Noticia;
import com.iesvi.dto.NoticiaDto;
import com.iesvi.repos.springdata.*;
import com.iesvi.services.NoticiaServicioSpringdata;
import com.iesvi.test.shared.domain.builder.NoticiaBuilder;
import com.iesvi.test.shared.domain.builder.dto.NoticiaDtoMother;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class NoticiaServicioSpringdataTest {

    NoticiaRepository noticeMock;
    NoticiaServicioSpringdata servicioNoticias;

    @Before
    public void setUp() {
        servicioNoticias= new NoticiaServicioSpringdata();
    }

    @Test
    public void createNoticiaTest() {

        NoticiaRepository noticeMock = Mockito.mock(NoticiaRepository.class);
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
        NoticiaRepository noticeMock = Mockito.mock(NoticiaRepository.class);

        //Arrange
        Mockito.when(noticeMock.getOne(36)).thenReturn(new NoticiaBuilder().withId(36).build());
        servicioNoticias.setNoticiaRepo(noticeMock);

        Noticia findedNotice= servicioNoticias.findNoticia(noticiaId);

        Assert.assertEquals(noticiaId,findedNotice.getId());
    }

}
