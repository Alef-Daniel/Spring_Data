package br.com.alef.springdata.servico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alef.springdata.modelo.Funcionario;
import br.com.alef.springdata.repositorio.FuncionarioRepository;
import br.com.alef.springdata.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	
	public void inicial(Scanner scanner) {
		System.out.println("Por favor digite um nome: ");
		String nome = scanner.next();
		if(nome.equalsIgnoreCase("NULL")){
			nome = null;
		}
		
		System.out.println("Por favor digite um cpf: ");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("NULL")){
			cpf = null;
		}
		System.out.println("Por favor digite um salario: ");
		BigDecimal salario = scanner.nextBigDecimal();
		
		if(salario.equals("0")){
			salario = null;
		}
		
		System.out.println("Por favor digite uma data de contratação: ");
		String data = scanner.next();
		LocalDate dataContratacao= null;
		
		if(data.equalsIgnoreCase("NULL")){
			data = null;
		}else {
			dataContratacao = LocalDate.parse(data, format);
		}
				
		List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification
				.where(SpecificationFuncionario.nome(nome))
				.or(SpecificationFuncionario.cpf(cpf))
				.or(SpecificationFuncionario.salario(salario))
				.or(SpecificationFuncionario.dataContracao(dataContratacao)));
		
		funcionarios.forEach(f -> System.out.println(f.toString()));
		
	}

}
