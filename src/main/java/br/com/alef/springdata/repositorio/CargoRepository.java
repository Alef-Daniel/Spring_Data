package br.com.alef.springdata.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alef.springdata.modelo.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
	
}
