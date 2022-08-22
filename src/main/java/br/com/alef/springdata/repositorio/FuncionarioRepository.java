package br.com.alef.springdata.repositorio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alef.springdata.modelo.Funcionario;
import br.com.alef.springdata.modelo.FuncionarioProjecao;


@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario,Integer> {
	
	List<Funcionario> findByNome(String nome);
	
	@Query("SELECT  f FROM Funcionario f"
			+ " WHERE f.nome= :nome"
			+ " AND f.salario >= :salario "
			+ "AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, BigDecimal salario, LocalDate data);
	
	@Query(value="SELECT * FROM funcionario f WHERE f.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	
	@Query(value="SELECT f.id, f.nome, f.salario FROM funcionario f;", nativeQuery = true)
	List<FuncionarioProjecao>  findFuncionarioSalario();
	
	
	
}
