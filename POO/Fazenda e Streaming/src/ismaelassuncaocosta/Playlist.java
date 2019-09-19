package ismaelassuncaocosta;

import java.util.ArrayList;

public class Playlist {
	private String nome;
	private ArrayList<String> estilos;
	private int duracaoTotal;
	private ArrayList<Musica> musicas;
	
	public Playlist() {
		nome = "";
		estilos = new ArrayList<String>();
		duracaoTotal = 0;
		musicas = new ArrayList<Musica>();
	}
	
	public Playlist(String nomeNovo) {
		nome = nomeNovo;
		estilos = new ArrayList<String>();
		duracaoTotal = 0;
		musicas = new ArrayList<Musica>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String newNome) {
		nome = newNome;
	}
	
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	
	public ArrayList<String> getEstilos() {
		return estilos;
	}
	
	public int getDuracaoTotal() {
		return duracaoTotal;
	}
	
	public void incrementsDuracaoTotal(int novo) {
		duracaoTotal += novo;

	}
}
