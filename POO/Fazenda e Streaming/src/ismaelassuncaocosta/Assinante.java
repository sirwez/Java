package ismaelassuncaocosta;

public class Assinante extends Usuario {

	public Assinante(String idUsu, String nomeNovo, String novoEmail, String novaSenha) {
		setIdentificador(idUsu);
		setNome(nomeNovo);
		setEmail(novoEmail); 
		setSenha(novaSenha);
	}



}
