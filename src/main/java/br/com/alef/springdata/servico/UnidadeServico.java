package br.com.alef.springdata.servico;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alef.springdata.modelo.Unidade;

import br.com.alef.springdata.repositorio.UnidadeRepository;

@Service
public class UnidadeServico {

	private Boolean system = true;
	private final UnidadeRepository UnidadeRepository;


	public UnidadeServico(UnidadeRepository UnidadeRepository) {
		this.UnidadeRepository = UnidadeRepository;
		
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de Unidade deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int op = scanner.nextInt();
			switch (op) {
			case 1:
				salvar(scanner);
				break;
			case 2: 
				atualizar(scanner);
				break;
			case 3: 
				visualizar();
				break;
			case 4: 
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}

		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Descricao do Unidade");
		String descricao = scanner.next();
		System.out.println("Endereco da Unidade");
		String endereco = scanner.next();
		Unidade unidade = new Unidade(); 
		unidade.setDescricao(descricao);
		unidade.setEndereço(endereco);
		UnidadeRepository.save(unidade);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("ID: ");
		int id = scanner.nextInt();
		System.out.println("Descricao do Unidade: ");
		String descricao = scanner.next();
		Unidade Unidade = new Unidade();
		Unidade.setId(id);
		Unidade.setDescricao(descricao);
		UnidadeRepository.save(Unidade);
		System.out.println("Atualizado!");
	}
	
	private void visualizar() {
		Iterable<Unidade> Unidades =  UnidadeRepository.findAll();
		Unidades.forEach(Unidade -> System.out.println(Unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("ID: ");
		int id = scanner.nextInt();
		UnidadeRepository.deleteById(id);
		System.out.println("Registro deletado!");
	}
}
