package com.iesvi.repos.estandar;

import com.iesvi.bo.Noticia;

public interface NoticiaRepository {
    
    Noticia findOne(int id);
    Iterable<Noticia> findAll();
    void save(Noticia Noticia);
    void delete (Noticia Noticia);
    
}
