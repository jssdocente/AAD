package com.iesvi.test.shared.domain.builder.dto;

import com.iesvi.dto.NoticiaDto;

public class NoticiaDtoMother {

    public static NoticiaDto general() {
        return new NoticiaDtoBuilder().build();
    }

}
