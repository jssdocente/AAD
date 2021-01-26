package com.iesvi.repos.generic.jpa;

import com.iesvi.bo.Noticia;
import com.iesvi.repos.generic.NoticiaRepository;

public class NoticiaRepositoryJPA extends GenericRepositoryJPA<Noticia,Integer> implements NoticiaRepository {

    public NoticiaRepositoryJPA() {
        super(Noticia.class);
    }

}
