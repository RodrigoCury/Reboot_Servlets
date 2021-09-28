package br.dev.rodrigocury.models;

import javax.naming.directory.InvalidAttributesException;

public class Empresa {
	private int id;
	private String nome;
	
	public Empresa(String nome) throws InvalidAttributesException {
		if (nome == null | nome == "")
			throw new InvalidAttributesException();
		
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
