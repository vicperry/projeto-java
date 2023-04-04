package com.vicperry.projetojava.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicperry.projetojava.model.domain.Contrato;
import com.vicperry.projetojava.model.domain.Palhaco;

@Repository
public interface PalhacoRepository extends CrudRepository<Palhaco, Integer> {
	
	@Query("from Palhaco p where p.usuario.id = :userId")
	List<Palhaco> obterLista(Integer userId, Sort sort);
}
