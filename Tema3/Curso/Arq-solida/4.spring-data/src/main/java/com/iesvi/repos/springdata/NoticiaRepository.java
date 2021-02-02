package com.iesvi.repos.springdata;

import com.iesvi.bo.Noticia;
import com.iesvi.repos.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Integer> {

    List<Noticia> findByAutor(String autor);
    List<Noticia> findByTitulo(String titulo);
    List<Noticia> findByTituloAndAutor(String titulo,String autor);

    @Query("select n from Noticia n where n.fecha between ?1 and ?2")
    List<Noticia> findByDateInterval(Date fecha1, Date fecha2);

}
