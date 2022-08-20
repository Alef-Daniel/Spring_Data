package br.com.alef.springdata.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alef.springdata.modelo.Funcionario;
import br.com.alef.springdata.modelo.Unidade;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Integer> {
	
}
