package com.vicperry.projetojava.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicperry.projetojava.model.domain.Magico;
import com.vicperry.projetojava.model.domain.Trapezista;

@Repository
public interface TrapezistaRepository extends CrudRepository<Trapezista, Integer> {
	
	@Query("from Trapezista t where t.usuario.id = :userId")
	List<Trapezista> obterLista(Integer userId, Sort sort);


}
