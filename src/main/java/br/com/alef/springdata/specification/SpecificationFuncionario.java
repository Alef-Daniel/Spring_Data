package br.com.alef.springdata.specification;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alef.springdata.modelo.Funcionario;

public class SpecificationFuncionario {
	public static Specification<Funcionario>nome(String nome){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%"+nome+"%");
	}
	
	public static Specification<Funcionario>cpf(String cpf){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario>salario(BigDecimal salario){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario>dataContracao(LocalDate dataContratacao){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
	}
	
}
