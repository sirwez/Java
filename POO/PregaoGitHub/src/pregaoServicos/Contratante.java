package pregaoServicos;


public class Contratante extends Usuario{
	private boolean contratoEmVigor;
	private int avaliacaoMediaContratante;
	
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
		return avaliacaoMediaContratante;
	}

	public void setAvaliacaoMediaContratante(int avaliacaoMediaContratante) {
		this.setQuantDeAvaliacoes(this.getQuantDeAvaliacoes()+1);
		this.setSomaDasAvaliacoes(this.getSomaDasAvaliacoes()+avaliacaoMediaContratante);
		this.avaliacaoMediaContratante =this.getSomaDasAvaliacoes()/this.getQuantDeAvaliacoes();
	}
}
