package br.com.alef.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alef.springdata.modelo.Cargo;
import br.com.alef.springdata.repositorio.CargoRepository;
import br.com.alef.springdata.servico.CargoServico;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoServico cargoServico;
	
	private boolean system = true;
	
	public SpringDataApplication(CargoServico cargoServico) {
		this.cargoServico = cargoServico;
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
			int action = scanner.nextInt();
			if(action == 1) {
				cargoServico.inicial(scanner);
			}else {
				system = false;
			}
		}
		
	}

}
