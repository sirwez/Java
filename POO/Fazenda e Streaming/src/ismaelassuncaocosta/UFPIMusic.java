package ismaelassuncaocosta;

import java.util.ArrayList;
import java.util.Date;

public class UFPIMusic implements InterfaceStreaming {
	ArrayList<String> estilos;
	ArrayList<Usuario> usuarios;
	ArrayList<Musica> musicas;
	
	public UFPIMusic() {
		estilos = new ArrayList<String>();
		usuarios = new ArrayList<Usuario>();
		musicas = new ArrayList<Musica>();
	}

	@Override
	public void cadastrarEstilo(String nome) throws ValorInvalido, EstiloJaCadastrado {
		if (nome == "") {
			throw new ValorInvalido();
		}
		if(estilos.contains(nome))
			throw new EstiloJaCadastrado();
		estilos.add(nome);

	}

	@Override
	public ArrayList<Musica> pesquisarPorEstilo(String nome) {
		ArrayList<Musica> musicasPorEstilo = new ArrayList<Musica>();
		
		for (Musica musica : musicas) {
			if(musica.getEstilo() == nome)
				musicasPorEstilo.add(musica);
		}
		
		return musicasPorEstilo;
	}

	@Override
	public ArrayList<Musica> pesquisarPorData(Date inicial) {
		ArrayList<Musica> musicasPorData = new ArrayList<Musica>();
		
		for (Musica musica : musicas) {
			if(musica.getDataLancamento() == inicial)
				musicasPorData.add(musica);
		}
		
		return musicasPorData;
	}

	@Override
	public ArrayList<Musica> pesquisarPorArtista(String nome) {
		ArrayList<Musica> musicasPorArtista = new ArrayList<Musica>();
		
		for (Musica musica : musicas) {
			if(musica.getArtista().getNome() == nome)
				musicasPorArtista.add(musica);
		}
		
		return musicasPorArtista;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) throws ValorInvalido, UsuarioJaCadastrado {
		if(
				usuario == null ||
				usuario.getNome() == "" ||
				usuario.getNome() == null ||
				usuario.getIdentificador() == "" ||
				usuario.getIdentificador() == null ||				
				usuario.getEmail() == "" ||
				usuario.getEmail() == null ||
				usuario. getSenha() == "" ||
				usuario. getSenha() == null
				)
			throw new ValorInvalido();
		for (Usuario u : usuarios) {
			if (usuario == u) {
				throw new UsuarioJaCadastrado();
			}
		}
		usuarios.add(usuario);

	}

	@Override
	public void adicionarMusica(String idUsu, String nomeMusica, String estilo, String link, int duracao,
			Date lancamento) throws ValorInvalido, UsuarioNaoCadastrado, MusicaJaCadastrada, EstiloNaoCadastrado {
		if(
				idUsu == "" ||
				idUsu == null ||
				nomeMusica == "" ||
				nomeMusica == null ||
				estilo == "" ||
				estilo == null ||
				link == "" ||
				link == null ||
				duracao < 1 ||
				lancamento == null ||
				!(lancamento instanceof Date)
				)
			throw new ValorInvalido();
		
		try {
			for (Usuario U : usuarios) {
				if (U.getIdentificador() == idUsu) {
					throw new UsuarioJaCadastrado();
				}
			}
			throw new UsuarioNaoCadastrado();
		} catch (UsuarioJaCadastrado e) {
			//handler
		}
		
		for (Usuario u : usuarios) {
			if (u.getIdentificador() == idUsu) {
				if(!(u instanceof Banda))
					throw new UsuarioNaoCadastrado();
			}
		}

		for (Musica M : musicas) {
			if(M.toString() == nomeMusica && M.getArtista().toString() == idUsu)
				throw new MusicaJaCadastrada();
		}
		
		try {
			for(String S : estilos)
				if (S == estilo) {
					throw new EstiloJaCadastrado();
				}
			throw new EstiloNaoCadastrado();
		} catch (EstiloJaCadastrado e) {
			// TODO: handle exception
		}
		
		Musica newMusica = new Musica();
		
		for (Usuario U : usuarios) {
			if(U.getIdentificador() == idUsu)
				newMusica.setArtista((Banda) U);
		}
		newMusica.setNome(nomeMusica);
		newMusica.setEstilo(estilo);
		newMusica.setLink(link);
		newMusica.setTempoDuracao(duracao);
		newMusica.setDataLancamento(lancamento);
		musicas.add(newMusica);
	}

	@Override
	public void criarPlaylist(String idUsu, String nomeLista)
			throws ValorInvalido, UsuarioNaoCadastrado, PlaylistExistente {
		if (idUsu == "" || nomeLista == "" || idUsu == null || nomeLista == null) {
			throw new ValorInvalido();
		}
		
		Usuario usuarioIndicado = null;
		
		try {
			for (Usuario U : usuarios) {
				if (U.getIdentificador() == idUsu) {
					usuarioIndicado = U;
					throw new UsuarioJaCadastrado();
				}
				throw new UsuarioNaoCadastrado();
			}
		} catch (UsuarioJaCadastrado e) {
			// TODO: handle exception
		}
		if(usuarioIndicado != null) {
			for (Playlist P : usuarioIndicado.getBiblioteca()) {
				if (P.getNome() == nomeLista) {
					throw new PlaylistExistente();
				}
			}
			
			usuarioIndicado.getBiblioteca().add(new Playlist(nomeLista));
		}
	}

	@Override
	public void adicionarMusicaPlaylist(String idUsu, String nomeLista, String nomeAutor, String nomeMusica)
			throws UsuarioNaoCadastrado, PlaylistNaoExistente, MusicaNaoCadastrada, MusicaJaCadastrada {
		Usuario usuarioIndicado = null;
		
		try {
			for (Usuario U : usuarios) {
				if (U.getIdentificador() == idUsu) {
					usuarioIndicado = U;
					throw new UsuarioJaCadastrado();
				}
				throw new UsuarioNaoCadastrado();
			}
		} catch (UsuarioJaCadastrado e) {
			// TODO: handle exception
		}
		
		Playlist playlistIndicada = null; 
		try {
			for (Playlist P : usuarioIndicado.getBiblioteca()) {
				if (P.getNome() == nomeLista) {
					playlistIndicada = P;
					throw new PlaylistExistente();
				}
				throw new PlaylistNaoExistente();
			}
		} catch (PlaylistExistente e) {
			// TODO: handle exception
		}
		
		Musica musicaIndicada = null;
		try {
			for (Musica M : musicas) {
				if (M.getArtista().getNome() == nomeAutor && M.toString() == nomeMusica) {
					musicaIndicada = M;
					throw new MusicaJaCadastrada();
				}
				throw new MusicaNaoCadastrada();
			}
		} catch (MusicaJaCadastrada e) {
		}
		
		for (Musica M : playlistIndicada.getMusicas()) {
			if (M.getArtista().getNome() == nomeAutor && M.toString() == nomeMusica) {
				throw new MusicaJaCadastrada();
			}
		}
		
		playlistIndicada.getMusicas().add(musicaIndicada);
		playlistIndicada.incrementsDuracaoTotal(musicaIndicada.getTempoDuracao());

	}

	@Override
	public Playlist pesquisaPlaylistUsuario(String idUsu, String nomeLista)
			throws UsuarioNaoCadastrado, PlaylistNaoExistente {
		
		Usuario usuarioIndicado = null;
		try {
			for (Usuario U : usuarios) {
				if (U.getIdentificador() == idUsu) {
					usuarioIndicado = U;
					throw new UsuarioJaCadastrado();
				}
				throw new UsuarioNaoCadastrado();
			}
		} catch (UsuarioJaCadastrado e) {
			// TODO: handle exception
		}
		
		for (Playlist P : usuarioIndicado.getBiblioteca()) {
			if (P.getNome() == nomeLista) {
				return P;
			}
		}
		
		throw new PlaylistNaoExistente();
	}

	@Override
	public ArrayList<Playlist> pesquisaPlaylistEstilo(String idUsu, String estilo)
			throws UsuarioNaoCadastrado, PlaylistNaoExistente {
		
		Usuario usuarioIndicado = null;
		try {
			for (Usuario U : usuarios) {
				if (U.getIdentificador() == idUsu) {
					usuarioIndicado = U;
					throw new UsuarioJaCadastrado();
				}
				throw new UsuarioNaoCadastrado();
			}
		} catch (UsuarioJaCadastrado e) {
			// TODO: handle exception
		}
		
		ArrayList<Playlist> playlistsDadoEstilo = new ArrayList<Playlist>();
		for (Playlist P : usuarioIndicado.getBiblioteca()) {
			if (P.getEstilos().contains(estilo)) {
				playlistsDadoEstilo.add(P);
			}
		}
		
		if (playlistsDadoEstilo.isEmpty()) {
			throw new PlaylistNaoExistente();
		}
		
		return playlistsDadoEstilo;
	}
}
