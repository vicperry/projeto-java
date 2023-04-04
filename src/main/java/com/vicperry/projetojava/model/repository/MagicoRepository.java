package com.vicperry.projetojava.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicperry.projetojava.model.domain.Magico;
import com.vicperry.projetojava.model.domain.Palhaco;

@Repository
public interface MagicoRepository extends CrudRepository<Magico, Integer> {
	
	@Query("from Magico m where m.usuario.id = :userId")
	List<Magico> obterLista(Integer userId, Sort sort);

}
