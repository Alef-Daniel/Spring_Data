package br.com.alef.springdata.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Funcionario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private BigDecimal salario;
	@Column(name = "data_contratacao")
	private LocalDate dataContratação;
	@ManyToOne
	@JoinColumn(name="cargo.id")
	private Cargo cargo;
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="funcionarios_unidades", joinColumns = {@JoinColumn(name="fk_funcionario")},inverseJoinColumns = {@JoinColumn(name="fk_unidade")})
	private List<Unidade> unidades= new ArrayList<>();
	
	
	
	
	
	
	public Funcionario() {
		
	}


	public Funcionario(String nome, String cpf, BigDecimal salario, LocalDate dataContratação, Cargo cargo,
			List<Unidade> unidades) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataContratação = dataContratação;
		this.cargo = cargo;
		this.unidades = unidades;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public LocalDate getDataContratação() {
		return dataContratação;
	}


	public void setDataContratação(LocalDate dataContratação) {
		this.dataContratação = dataContratação;
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	public List<Unidade> getUnidades() {
		return unidades;
	}


	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
