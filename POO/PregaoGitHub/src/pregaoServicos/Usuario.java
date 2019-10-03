package felipeDaRochaTorres.pregaoServicos;

import java.util.ArrayList;

public class Usuario {
	private String email;
	private String nome;
	private String telefone;
	
	ArrayList<String> avaliacoesObservacoes = new ArrayList<String>();
	ArrayList<Integer> avaliacoesNota = new ArrayList<Integer>();
	
	public Usuario(String email, String nome, String telefone) {
		this.setEmail(email);
		this.setNome(nome);
		this.setTelefone(telefone);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
