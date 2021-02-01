package com.iesvi.test.shared.domain.builder;

import com.iesvi.bo.Noticia;

public class NoticiaMother {

    public static Noticia general() {
        return new NoticiaBuilder().build();
    }

    //Noticia que sea un caso extremo para los test, con datos complejos o que den problemas
    public static Noticia edgeCase() {
        return new NoticiaBuilder()
                .withAutor(" Author muuuuuuuuuuuuuuuy largo")
                .build();
    }
}
