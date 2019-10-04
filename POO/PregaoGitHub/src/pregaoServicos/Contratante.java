package pregaoServicos;

public class Contratante extends Usuario{
	private boolean servicoEmVigor;
	private int avaliacaoMediaContratante=0;
	
	public Contratante(String email, String nome, String telefone) {
		super(email, nome, telefone);
	}
	
	public boolean isServicoEmVigor() {
		return servicoEmVigor;
	}
	public void setServicoEmVigor(boolean contratoEmVigor) {
		this.servicoEmVigor = contratoEmVigor;
	}

	public int getAvaliacaoMediaContratante() {
		int i;
		for(i=0; i<this.avaliacoesNota.size();i++) {
			avaliacaoMediaContratante += this.avaliacoesNota.get(i);
		}
		return avaliacaoMediaContratante/i;
	}
	
}
