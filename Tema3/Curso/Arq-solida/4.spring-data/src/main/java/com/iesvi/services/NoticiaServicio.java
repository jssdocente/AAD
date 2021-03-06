package com.iesvi.services;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;
import com.iesvi.dto.*;
import com.iesvi.repos.generic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticiaServicio {

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
        return noticiaRepo.findOne(id);
    }

    @Transactional
    public void update(NoticiaDto noticedto) throws Exception {

        Noticia nbd = noticiaRepo.findOne(noticedto.getId());
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
