package pregaoServicos;

public class TipoDeServico {
	private int cod;
	private String descr;
	
	public TipoDeServico(int cod, String descr) {
		this.cod = cod;
		this.descr = descr;
	}
	
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
}
