package br.dev.rodrigocury.gerenciador.models;

public class Usuario {
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public boolean autentica(String login, String senha) {
		if (this.login.equals(login) & this.senha.equals(senha))
			return true;
		return false;
	}
	
	
}
