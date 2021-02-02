package com.iesvi.services;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;
import com.iesvi.bo.filter.NoticiaFilter;
import com.iesvi.dto.NoticiaDto;
import com.iesvi.repos.springdata.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NoticiaServicioSpringdata {

    @Autowired
    NoticiaRepository noticiaRepo;
    @Autowired
    ComentarioRepository commentRepo;

    public void setNoticiaRepo(NoticiaRepository noticiaRepo) {
        this.noticiaRepo = noticiaRepo;
    }

    public void setCommentRepo(ComentarioRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Transactional
    public Noticia createNoticia(NoticiaDto noticedto) {

        //Crear Noticia-entity desde noticia-dto (por ahora lo creamos manualmente)
        Noticia newnotice = new Noticia(noticedto.getId(),noticedto.getTitulo(),noticedto.getAutor(),noticedto.getFecha());

        return noticiaRepo.save(newnotice);
    }

    public Noticia findNoticia(int id) {
        return noticiaRepo.getOne(id);
    }

    public List<Noticia> findByFechaInterval(Date fecha1, Date fecha2) {
        return noticiaRepo.findByDateInterval(fecha1, fecha2);
    }

    public List<Noticia> findCriteria(NoticiaFilter filter) {

        List<Noticia> lista;
        //aplicamos el patrón criteria/espcification
        if (filter.isFilterByAutor() && filter.isFilterByTitulo()) {
            lista = noticiaRepo.findByTituloAndAutor(filter.getTitulo(),filter.getAutor());
        } else if (filter.isFilterByTitulo()) {
            lista = noticiaRepo.findByTitulo(filter.getTitulo());
        } else if (filter.isFilterByAutor()) {
            lista = noticiaRepo.findByAutor(filter.getAutor());
        } else {
            lista = noticiaRepo.findAll();
        }

        return lista;

    }

    @Transactional
    public void update(NoticiaDto noticedto) throws Exception {

        Noticia nbd = noticiaRepo.getOne(noticedto.getId());
        if (nbd==null)
            throw new Exception("Noticia no existe");

        //Crear Noticia-entity desde noticia-dto (por ahora lo creamos manualmente)
        Noticia updnotice = new Noticia(nbd.getId(),noticedto.getTitulo(),noticedto.getAutor(),noticedto.getFecha());

        noticiaRepo.save(updnotice);
    }

    @Transactional
    public void createNoticiaWithCommentsIsolated(Noticia noticia, List<Comentario> comentarios) {

        noticiaRepo.save(noticia);

        for (Comentario comentario: comentarios) {
            comentario.setNoticia(noticia);
            commentRepo.save(comentario);
        }
    }

    @Transactional
    public void createNoticiaWithComments(Noticia noticia, List<Comentario> comentarios) {

        //Agregamos todos los comentario, a la noticia antes de guardar la noticia, y la noticia se encarga de persistir los comentarios.
        for (Comentario comentario: comentarios) {
            noticia.addComentario(comentario);
        }

        //En este caso, no necesitamos el repositorio de Comentario, ya que la noticia es un "Agregado" que sabe persistir el conjunto.
        noticiaRepo.save(noticia);
    }
}
