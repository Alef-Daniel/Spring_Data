package br.com.alef.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alef.springdata.modelo.Cargo;
import br.com.alef.springdata.repositorio.CargoRepository;
import br.com.alef.springdata.servico.CargoServico;
import br.com.alef.springdata.servico.FuncionarioServico;
import br.com.alef.springdata.servico.UnidadeServico;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoServico cargoServico;
	
	private final FuncionarioServico funcionarioServico;

	private final UnidadeServico unidadeServico;
	
	private boolean system = true;
	
	public SpringDataApplication(CargoServico cargoServico, FuncionarioServico funcionarioServico,  UnidadeServico unidadeServico) {
		this.cargoServico = cargoServico;
		this.funcionarioServico = funcionarioServico;
		this.unidadeServico= unidadeServico;
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
				default:
					System.out.println("Finalizando");
					system=false;
					break;
			}
		}
		
	}

}
