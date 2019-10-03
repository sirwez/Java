package felipeDaRochaTorres.pregaoServicos;

public class Contratante extends Usuario{
	private boolean contratoEmVigor;
	private int avaliacaoMediaContratante=0;
	
	public Contratante(String email, String nome, String telefone) {
		super(email, nome, telefone);
	}
	
	public boolean isContratoEmVigor() {
		return contratoEmVigor;
	}
	public void setContratoEmVigor(boolean contratoEmVigor) {
		this.contratoEmVigor = contratoEmVigor;
	}

	public int getAvaliacaoMediaContratante() {
		int i;
		for(i=0; i<this.avaliacoesNota.size();i++) {
			avaliacaoMediaContratante += this.avaliacoesNota.get(i);
		}
		return avaliacaoMediaContratante/i;
	}


	
}
