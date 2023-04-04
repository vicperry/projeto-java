package com.vicperry.projetojava.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicperry.projetojava.model.domain.Contratante;

@Repository
public interface ContratanteRepository extends CrudRepository<Contratante, Integer> {
	@Query("from Contratante c where c.usuario.id = :usuarioId")
	List<Contratante> obterLista(Integer usuarioId, Sort sort);
}
