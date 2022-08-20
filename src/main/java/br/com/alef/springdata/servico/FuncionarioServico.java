package br.com.alef.springdata.servico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.type.LocalDateType;
import org.springframework.stereotype.Service;

import br.com.alef.springdata.modelo.Cargo;
import br.com.alef.springdata.modelo.Funcionario;
import br.com.alef.springdata.modelo.Unidade;
import br.com.alef.springdata.repositorio.CargoRepository;
import br.com.alef.springdata.repositorio.FuncionarioRepository;
import br.com.alef.springdata.repositorio.UnidadeRepository;

@Service
public class FuncionarioServico {

	private Boolean system = true;

	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeRepository unidadeRepository;

	public FuncionarioServico(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository,
			UnidadeRepository unidadeRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.unidadeRepository = unidadeRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de funcionario deseja executar?");
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
		System.out.println("nome do Funcionario");
		String nome = scanner.next();
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do Funcionario");
		BigDecimal salario = scanner.nextBigDecimal();
		System.out.println("Cargo do Funcionario");
		Integer cargoId = scanner.nextInt();
		List<Unidade> unidades = unidade(scanner);
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);
		Funcionario funcionario = new Funcionario(nome,cpf,salario,LocalDate.now(),cargo.get(),unidades);
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}
	

	private void atualizar(Scanner scanner) {
		System.out.println("ID do Funcionario");
		Integer id = scanner.nextInt();
		System.out.println("nome do Funcionario");
		String nome = scanner.next();
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do Funcionario");
		BigDecimal salario = scanner.nextBigDecimal();
		System.out.println("Cargo do Funcionario");
		Integer cargoId = scanner.nextInt();
		List<Unidade> unidades = unidade(scanner);
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);
		Funcionario funcionario = new Funcionario(nome,cpf,salario,LocalDate.now(),cargo.get(),unidades);
		funcionario.setId(id);
		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}

	private void deletar(Scanner scanner) {
		System.out.println("ID: ");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Registro deletado!");
	}
	
	private List<Unidade> unidade(Scanner scanner) {
        Boolean isTrue = true;
        List<Unidade> unidades = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o unidadeId (Para sair digite 0)");
            Integer unidadeId = scanner.nextInt();

            if(unidadeId != 0) {
                Optional<Unidade> unidade = unidadeRepository.findById(unidadeId);
                unidades.add(unidade.get());
            } else {
                isTrue = false;
            }
        }

        return unidades;
    }
}
