package pregaoServicos;

public class Usuario {
	private String email;
	private String nome;
	private String telefone;
	private String observacoes="";
	private int quantDeAvaliacoes=0;
	private int somaDasAvaliacoes=0;
	
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getQuantDeAvaliacoes() {
		return quantDeAvaliacoes;
	}

	public void setQuantDeAvaliacoes(int quantDeAvaliacoes) {
		this.quantDeAvaliacoes = quantDeAvaliacoes;
	}

	public int getSomaDasAvaliacoes() {
		return somaDasAvaliacoes;
	}

	public void setSomaDasAvaliacoes(int somaDasAvaliacoes) {
		this.somaDasAvaliacoes = somaDasAvaliacoes;
	}
	
}
