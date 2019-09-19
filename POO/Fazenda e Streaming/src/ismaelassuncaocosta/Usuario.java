package ismaelassuncaocosta;

import java.util.ArrayList;

public abstract class Usuario {
	private String identificador;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Playlist> biblioteca = new ArrayList<Playlist>();

	
	public String getIdentificador() {
		return identificador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setIdentificador(String idNovo) {
		identificador = idNovo;
	}
	
	public void setNome(String novoNome) {
		nome = novoNome;
	}
	
	public void setEmail(String novoEmail) {
		email = novoEmail;
	}
	
	public void setSenha(String novaSenha) {
		senha = novaSenha;
	}
	
	public void setBiblioteca(ArrayList<Playlist> novaBiblioteca) {
		biblioteca = novaBiblioteca;
	}
	
	public ArrayList<Playlist> getBiblioteca() {
		return biblioteca;
	}
}
