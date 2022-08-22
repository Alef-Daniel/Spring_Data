package br.com.alef.springdata.servico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alef.springdata.modelo.Funcionario;
import br.com.alef.springdata.modelo.FuncionarioProjecao;
import br.com.alef.springdata.repositorio.FuncionarioRepository;

@Service
public class RelatoriosServico {
	
	
	private Boolean system = true;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final FuncionarioRepository funcionarioRepository;

	public RelatoriosServico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de cargo deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca Funcionario por nome");
			System.out.println("2 - Busca Funcionario por nome,salario e data de contratacao");
			System.out.println("3 - Busca Funcionario por data de contratacao");
			System.out.println("4 - Busca Funcionario por Salario");
			
			
			int op = scanner.nextInt();
			switch (op) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscaFuncionarioDataContratacao(scanner);
				break;
			case 4 :
				pesquisaFuncionarioSalario();
				break;
			default:
				system = false;
				break;
			}

		}
		
		

	}
	
	public void buscaFuncionarioPorNome(Scanner scanner) {
		System.out.println("Digit o nome que deseja pesquisar: ");
		String nome = scanner.next();
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		funcionarios.forEach(funcionario -> System.out.println(funcionarios.toString()));
	}
	
	public void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Digit o nome que deseja pesquisar: ");
		String nome = scanner.next();
		System.out.println("Digite o Salario : ");
		BigDecimal salario = scanner.nextBigDecimal();
		System.out.println("Digite a Data : ");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, format);
		List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate );
		funcionarios.forEach(funcionario -> System.out.println(funcionarios.toString()));
	}
	
	public void buscaFuncionarioDataContratacao(Scanner scanner) {
		System.out.println("Digite a Data : ");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, format);
		List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(localDate);
		funcionarios.forEach(funcionario -> System.out.println(funcionarios.toString()));
	}
	
	public void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecao> funcionarios = funcionarioRepository.findFuncionarioSalario();
		funcionarios.forEach(funcionario -> System.out.println(" Funcionario id: "+ funcionario.getId()+" Funcionario nome: "+ funcionario.getNome()+" Funcionario Salario: R$"+ funcionario.getSalario()));
	}
}
