package br.com.alef.springdata.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alef.springdata.modelo.Funcionario;


@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario,Integer> {
	
}
