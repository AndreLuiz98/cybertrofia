package br.edu.ifpb.entidade;

public class Pessoa {

	private Integer id;

	private String nome;

	private String email;

	private String senha;	
	
	private Double imc;
	
	public Pessoa(Integer id, String nome, String email, String senha, Double imc) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.imc = imc;
		
	}

	public Pessoa() {}

	public Integer getId() {

		return id;

	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public void setId(Integer id) {

		this.id = id;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getSenha() {

		return senha;

	}

	public void setSenha(String senha) {

		this.senha = senha;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}	

}
