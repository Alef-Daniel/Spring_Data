package br.com.alef.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.alef.springdata.servico.CargoServico;
import br.com.alef.springdata.servico.FuncionarioServico;
import br.com.alef.springdata.servico.RelatorioFuncionarioDinamico;
import br.com.alef.springdata.servico.RelatoriosServico;
import br.com.alef.springdata.servico.UnidadeServico;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoServico cargoServico;
	
	private final FuncionarioServico funcionarioServico;

	private final UnidadeServico unidadeServico;
	private final RelatoriosServico relatoriosServico;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	private boolean system = true;
	
	public SpringDataApplication(CargoServico cargoServico, FuncionarioServico funcionarioServico,  
			UnidadeServico unidadeServico,RelatoriosServico relatoriosServico,RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoServico = cargoServico;
		this.funcionarioServico = funcionarioServico;
		this.unidadeServico= unidadeServico;
		this.relatoriosServico =relatoriosServico;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação voce quer executar?");
			System.out.println("0 - sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios dinâmico");
			int action = scanner.nextInt();
			switch(action){
				case 1: 
					cargoServico.inicial(scanner);
					break;
				case 2: 
					funcionarioServico.inicial(scanner);
					break;
				case 3: 
					unidadeServico.inicial(scanner);
					break;
				case 4: 
					relatoriosServico.inicial(scanner);
					break;
				case 5: 
					relatorioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system=false;
					break;
			}
		}
		
	}

}
