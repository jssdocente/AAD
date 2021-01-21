package com.iesvi.repos.generic;

import com.iesvi.bo.Comentario;

public interface GenericRepository<T,K> {

	public T findOne(K numero);
	public Iterable<T> findAll();
	public void save(T comentario);
	public void delete(T comentario);

}
