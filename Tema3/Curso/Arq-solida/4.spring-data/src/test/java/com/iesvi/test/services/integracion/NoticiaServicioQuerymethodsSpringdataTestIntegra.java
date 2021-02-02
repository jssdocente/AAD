package com.iesvi.test.services.integracion;

import com.iesvi.bo.Noticia;
import com.iesvi.bo.filter.NoticiaFilter;
import com.iesvi.dto.NoticiaDto;
import com.iesvi.repos.springdata.ComentarioRepository;
import com.iesvi.repos.springdata.NoticiaRepository;
import com.iesvi.services.NoticiaServicioSpringdata;
import com.iesvi.test.config.ConfiguracionSpringTest;
import com.iesvi.test.shared.domain.builder.NoticiaBuilder;
import com.iesvi.test.shared.domain.builder.NoticiaMother;
import com.iesvi.test.shared.domain.builder.dto.NoticiaDtoBuilder;
import com.iesvi.test.shared.domain.builder.dto.NoticiaDtoMother;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracionSpringTest.class)
public class NoticiaServicioQuerymethodsSpringdataTestIntegra {

    @Autowired
    NoticiaRepository repoNotice;
    @Autowired
    ComentarioRepository repoComment;
    @Autowired
    NoticiaServicioSpringdata servicioNoticias;

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

    @Test
    public void findByFechaInterval() {

        //Creamos varias Noticias
        NoticiaDto n1 = new NoticiaDtoBuilder().withDate(new Date(2021,1,20)) .build();
        NoticiaDto n2 = new NoticiaDtoBuilder().withDate(new Date(2021,1,23)).build();
        NoticiaDto n3 = new NoticiaDtoBuilder().withDate(new Date(2021,1,18)).build();

        //Arrange
        servicioNoticias.createNoticia(n1);
        servicioNoticias.createNoticia(n2);
        servicioNoticias.createNoticia(n3);

        //Act
        NoticiaFilter filter = new NoticiaFilter();
        filter.setTitulo(n1.getTitulo());
        List<Noticia> lista = servicioNoticias.findByFechaInterval(new Date(2021,1,20),new Date(2021,1,21));

        Assert.assertEquals(1,lista.size());
    }

    @Test
    public void findByTitulo() {

        //Creamos varias Noticias
        NoticiaDto n1 = new NoticiaDtoBuilder().build();
        NoticiaDto n2 = new NoticiaDtoBuilder().build();
        NoticiaDto n3 = new NoticiaDtoBuilder().build();

        //Arrange
        servicioNoticias.createNoticia(n1);
        servicioNoticias.createNoticia(n2);
        servicioNoticias.createNoticia(n3);

        //Act
        NoticiaFilter filter = new NoticiaFilter();
        filter.setTitulo(n1.getTitulo());
        List<Noticia> lista = servicioNoticias.findCriteria(filter);

        Assert.assertEquals(1,lista.size());
    }

    @Test
    public void findByAutor() {

        int noticiaId=1;

        //Creamos varias Noticias
        NoticiaDto n1 = new NoticiaDtoBuilder().withAutor("Javier").build();
        NoticiaDto n2 = new NoticiaDtoBuilder().withAutor("Zamorano").build();
        NoticiaDto n3 = new NoticiaDtoBuilder().withAutor("Zamorano").build();

        //Arrange
        servicioNoticias.createNoticia(n1);
        servicioNoticias.createNoticia(n2);
        servicioNoticias.createNoticia(n3);

        //Act
        NoticiaFilter filter = new NoticiaFilter();
        filter.setAutor(n3.getAutor());
        List<Noticia> lista = servicioNoticias.findCriteria(filter);

        Assert.assertEquals(2,lista.size());

    }

    @Test
    public void findByAutorAndTitulo() {

        int noticiaId=1;

        //Creamos varias Noticias
        NoticiaDto n1 = new NoticiaDtoBuilder().withAutor("Javier").withTitle("Titulo-1").build();
        NoticiaDto n2 = new NoticiaDtoBuilder().withAutor("Zamorano").withTitle("Titulo-1").build();
        NoticiaDto n3 = new NoticiaDtoBuilder().withAutor("Zamorano").withTitle("Titulo-3").build();

        //Arrange
        servicioNoticias.createNoticia(n1);
        servicioNoticias.createNoticia(n2);
        servicioNoticias.createNoticia(n3);

        //Act
        NoticiaFilter filter = new NoticiaFilter();
        filter.setAutor("Zamorano");
        filter.setTitulo("Titulo-3");
        List<Noticia> lista = servicioNoticias.findCriteria(filter);

        Assert.assertEquals(1,lista.size());

    }

    //@Test
    public void findAllOrderByAutor() {

        int noticiaId=1;

        //Creamos varias Noticias
        NoticiaDto n1 = new NoticiaDtoBuilder().withAutor("Javier").build();
        NoticiaDto n2 = new NoticiaDtoBuilder().withAutor("Anabel").build();
        NoticiaDto n3 = new NoticiaDtoBuilder().withAutor("Zamorano").build();

        //Arrange
        servicioNoticias.createNoticia(n1);
        servicioNoticias.createNoticia(n2);
        servicioNoticias.createNoticia(n3);

    }


}
