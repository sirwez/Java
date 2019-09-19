package ismaelassuncaocosta;

import java.util.ArrayList;

public class Banda extends Usuario {
	ArrayList<Banda> bandas;

	public Banda(String idUsu, String nomeNovo, String novoEmail, String novaSenha, ArrayList<Banda> bandasNovo) {
		setIdentificador(idUsu);
		setNome(nomeNovo);
		setEmail(novoEmail); 
		setSenha(novaSenha);
		
		bandas = bandasNovo;
	}
	
	public Banda(String idUsu, String nomeNovo, String novoEmail, String novaSenha) {
		setIdentificador(idUsu);
		setNome(nomeNovo);
		setEmail(novoEmail); 
		setSenha(novaSenha);
	}
	
}
