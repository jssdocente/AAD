package com.iesvi.repos.generic;

import com.iesvi.bo.Comentario;

public interface GenericRepository<T,K> {

	public T findOne(K numero);
	public Iterable<T> findAll();
	public T save(T entidad);
	public void delete(T entidad);

}
