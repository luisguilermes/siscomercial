package com.techipster.siscomercial.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techipster.siscomercial.domain.Categoria;
import com.techipster.siscomercial.domain.Produto;

@Repository
@Transactional(readOnly=true)
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	public Page<Produto> search(
			@Param("nome") String nome,
			@Param("categorias") List<Categoria> categorias,
			Pageable pageRequest);
	
	//Podeira gera a consulta com padroes do spring
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	//public Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
	
}
