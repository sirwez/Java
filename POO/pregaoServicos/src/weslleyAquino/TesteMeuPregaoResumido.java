package weslleyAquino;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TesteMeuPregaoResumido {

	@Test
	public void testarCadastroDeServico() {
		InterfacePregao pregao = new MeuPregao();
		pregao.adicionarTipoDeServico(1, "Jardinagem");
		pregao.adicionarTipoDeServico(2, "Elétrico");
		
		pregao.cadastrarContratante("pasn@ufpi.edu.br", "Pedro Santos Neto", "9999-9999");
		pregao.cadastrarContratante("rai@ufpi.edu.br", "Raimundo Moura", "8888-8888");
		pregao.cadastrarContratante("erico@ufpi.edu.br", "Erico Leao", "7777-7777");
		
		
		int cod1 = pregao.cadastrarServico("pasn@ufpi.edu.br", "Corte de grama em jardim de 20m2", 100, 2, 1);
		ArrayList<Servico> servs = pregao.listarServicos(100, 0, 0, false, false, 0);
		assertEquals(1, servs.size());

		int cod2 = pregao.cadastrarServico("pasn@ufpi.edu.br", "Corte de grama em jardim de 20m2", 100, 2, 1);
		servs = pregao.listarServicos(100, 0, 0, false, false, 0);
		assertEquals(1, servs.size());
		assertEquals(-1, cod2);

		int cod3 = pregao.cadastrarServico("rai@ufpi.edu.br", "Troca de fiação", 300, 8, 2);
		servs = pregao.listarServicos(100, 0, 0, false, false, 0);
		assertEquals(2, servs.size());

		int cod4 = pregao.cadastrarServico("erico@ufpi.edu.br", "Troca de fiação", 400, 9, 2);
		servs = pregao.listarServicos(100, 0, 0, false, false, 0);
		assertEquals(3, servs.size());

		// Listando só tipo 2 - elétrico
		servs = pregao.listarServicos(100, 0, 2, false, false, 0);
		assertEquals(2, servs.size());

	}

	@Test
	public void testarCadastroDeProposta() {
		InterfacePregao pregao = new MeuPregao();
		pregao.adicionarTipoDeServico(1, "Jardinagem");
		pregao.adicionarTipoDeServico(2, "Elétrico");
		pregao.adicionarTipoDeServico(3, "Pet in house");
		pregao.adicionarTipoDeServico(4, "Churrasqueiro");
		pregao.adicionarTipoDeServico(5, "Faxina");
		
		pregao.cadastrarContratante("pasn@ufpi.edu.br", "Pedro Santos Neto", "9999-9999");
		pregao.cadastrarContratante("rai@ufpi.edu.br", "Raimundo Moura", "8888-8888");
		pregao.cadastrarContratante("erico@ufpi.edu.br", "Erico Leao", "7777-7777");
		
		int cod1 = pregao.cadastrarServico("pasn@ufpi.edu.br", "Corte de grama em jardim de 20m2", 100, 4, 1);

		int cod2 = pregao.cadastrarServico("rai@ufpi.edu.br", "Troca de fiação", 300, 8, 2);

		int cod3 = pregao.cadastrarServico("erico@ufpi.edu.br", "Troca de fiação", 400, 9, 2);
		
		pregao.cadastrarPrestador("jesus@gmail.com", "Maria de Jesus", "9999-1111");
		pregao.adicionarServicoPrestador("jesus@gmail.com", 5);
		pregao.cadastrarPrestador("toni@gmail.com", "Toni Silva", "8888-1111");
		pregao.adicionarServicoPrestador("toni@gmail.com", 5);
		pregao.adicionarServicoPrestador("toni@gmail.com", 4);
		pregao.adicionarServicoPrestador("toni@gmail.com", 1);
		pregao.cadastrarPrestador("gago@gmail.com", "Antonio Gago", "7777-1111");
		pregao.adicionarServicoPrestador("gago@gmail.com", 1);
		pregao.adicionarServicoPrestador("gago@gmail.com", 2);
		pregao.adicionarServicoPrestador("gago@gmail.com", 3);

		// Cadastrando duas propostas válidas
		pregao.cadastrarProposta(cod1, "toni@gmail.com", 100, 2);
		pregao.cadastrarProposta(cod1, "gago@gmail.com", 80, 4);
		ArrayList<Proposta> props = pregao.listarPropostas(cod1, 0, 0, 0);
		assertEquals(2, props.size());
		
		// Cadastrando uma proposta invalida acima do preco
		pregao.cadastrarProposta(cod2, "gago@gmail.com", 301, 8);
		// Cadastrando uma proposta invalida acima do prazo
		pregao.cadastrarProposta(cod2, "gago@gmail.com", 300, 9);
		// Cadastrando uma proposta invalida: prestador sem o serviço
		pregao.cadastrarProposta(cod2, "toni@gmail.com", 100, 2);
		props = pregao.listarPropostas(cod2, 0, 0, 0);
		assertEquals(0, props.size());
		// Cadastrando uma proposta valida
		pregao.cadastrarProposta(cod2, "gago@gmail.com", 300, 8);
		props = pregao.listarPropostas(cod2, 0, 0, 0);
		assertEquals(1, props.size());
	}
}