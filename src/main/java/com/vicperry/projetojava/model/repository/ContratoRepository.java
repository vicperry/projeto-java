package com.vicperry.projetojava.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicperry.projetojava.model.domain.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Integer> {
	
	@Query("from Contrato c where c.usuario.id = :userId")
	List<Contrato> obterLista(Integer userId);

}
