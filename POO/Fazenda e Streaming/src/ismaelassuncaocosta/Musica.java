package ismaelassuncaocosta;

import java.util.Date;

public class Musica {
	private String nome;
	private Banda banda;
	private Date dataLancamento;
	private int tempoDuracao;
	private String estilo;
	private String link;
	
	public Musica() {
		nome = "";
		banda = null;
		dataLancamento = null;
		tempoDuracao = 0;
		estilo = "";
		link = "";
	}

	public String getNome() {
		return nome;
	}
	
	public Banda getArtista() {
		return banda;
	}
	
	public String getEstilo() {
		return estilo;
	}
	
	public Date getDataLancamento() {
		return dataLancamento;
	}
	
	public int getTempoDuracao() {
		return tempoDuracao;
	}
	
	public void setNome(String nomeNovo) {
		nome = nomeNovo;
	}
	
	public void setArtista(Banda artistaNovo) {
		banda = artistaNovo;
	}
	
	public void setDataLancamento(Date dataLancamentoNovo) {
		dataLancamento = dataLancamentoNovo;
	}
	
	public void setTempoDuracao(int tempoDuracaoNovo) {
		tempoDuracao = tempoDuracaoNovo;
	}
	
	public void setEstilo(String estiloNovo) {
		estilo = estiloNovo;
	}

	
	public void setLink(String linkNovo) {
		link = linkNovo;
	}
}
