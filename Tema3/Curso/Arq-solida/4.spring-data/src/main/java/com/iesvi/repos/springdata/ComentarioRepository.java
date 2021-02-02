package com.iesvi.repos.springdata;

import com.iesvi.bo.Comentario;
import com.iesvi.repos.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
}
