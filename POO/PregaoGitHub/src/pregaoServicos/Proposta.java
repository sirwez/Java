package felipeDaRochaTorres.pregaoServicos;

public class Proposta {
	private Prestador prestador;
	private int codigoServico;
	private int prazo;
	private double valor;
	private String emailPrestado;
	private boolean contratado;
	
	public Proposta(int codigoServico, String emailPrestado, double valor, int prazo) {
		this.setCodigoServico(codigoServico);
		this.setEmailPrestado(emailPrestado);
		this.setValor(valor);
		this.setPrazo(prazo);
		setContratado(false);
	}

	public int getAvaliacaoMediaPrestador() {
		return prestador.getAvaliacaoMediaPrestador();
	}


	public int getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(int codigoServico) {
		this.codigoServico = codigoServico;
	}

	int getPrazo() {
		return prazo;
	}

	void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getEmailPrestado() {
		return emailPrestado;
	}

	public void setEmailPrestado(String emailPrestado) {
		this.emailPrestado = emailPrestado;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public boolean isContratado() {
		return contratado;
	}

	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}
}
