package br.ifpb.edu.entidades;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Pessoa.getAll", query = "from Pessoa")
public class Pessoa {
	
	@Id
	private String nome;
	private String senha;
	private String email;
	private double peso;
	private double altura;
	
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
