package com.iesvi.repos.generic.jpa;

import com.iesvi.bo.Comentario;
import com.iesvi.bo.Noticia;
import com.iesvi.repos.generic.ComentarioRepository;
import com.iesvi.repos.generic.NoticiaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ComentarioRepositoryJPA extends GenericRepositoryJPA<Comentario,Integer> implements ComentarioRepository {

    public ComentarioRepositoryJPA() {
        super(Comentario.class);
    }

}
