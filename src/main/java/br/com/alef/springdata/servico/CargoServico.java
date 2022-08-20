package br.com.alef.springdata.servico;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alef.springdata.modelo.Cargo;
import br.com.alef.springdata.repositorio.CargoRepository;

@Service
public class CargoServico {

	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CargoServico(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de cargo deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");

			int op = scanner.nextInt();
			switch (op) {
			case 1:
				salvar(scanner);
				break;
			case 2: 
				atualizar(scanner);
				break;
			default:
				system = false;
				break;
			}

		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("ID: ");
		int id = scanner.nextInt();
		System.out.println("Descricao do Cargo: ");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado!");
	}
}
