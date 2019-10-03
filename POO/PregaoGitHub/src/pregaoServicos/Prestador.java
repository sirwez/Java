package pregaoServicos;

import java.util.ArrayList;

public class Prestador extends Usuario{
	
	ArrayList<TipoDeServico> servicoRealizado = new ArrayList<TipoDeServico>(); 
	private int avaliacaoMediaPrestador;
	
	public Prestador(String email, String nome, String telefone) {
		super(email, nome, telefone);
	}

	public int getAvaliacaoMediaPrestador() {
		return avaliacaoMediaPrestador;
	}

	public void setAvaliacaoMediaPrestador(int avaliacaoMediaPrestador) {
		this.setQuantDeAvaliacoes(this.getQuantDeAvaliacoes()+1);
		this.setSomaDasAvaliacoes(this.getSomaDasAvaliacoes()+avaliacaoMediaPrestador);
		this.avaliacaoMediaPrestador =this.getSomaDasAvaliacoes()/this.getQuantDeAvaliacoes();
	}
}