package br.com.alef.springdata.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="unidade_trabalho")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String endereço;
	
	@ManyToMany(mappedBy = "unidades", fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Unidade() {
		
	}

	public Unidade(String descricao, String endereço, List<Funcionario> funcionarios) {
		super();
		this.descricao = descricao;
		this.endereço = endereço;
		this.funcionarios = funcionarios;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
