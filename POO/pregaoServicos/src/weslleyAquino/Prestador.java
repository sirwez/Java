package weslleyAquino;

import java.util.ArrayList;

public class Prestador extends Usuario{
	
	ArrayList<TipoDeServico> servicoRealizado = new ArrayList<TipoDeServico>(); 
	private int avaliacaoMediaPrestador=0;
	
	public Prestador(String email, String nome, String telefone) {
		super(email, nome, telefone);
	}

	public int getAvaliacaoMediaPrestador() {
		int i;
		for(i=0; i<this.avaliacoesNota.size();i++) {
			avaliacaoMediaPrestador += this.avaliacoesNota.get(i);
		}
		return avaliacaoMediaPrestador/i;
	}

	
}