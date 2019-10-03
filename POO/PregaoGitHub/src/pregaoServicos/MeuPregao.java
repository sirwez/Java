package pregaoServicos;


import java.util.ArrayList;
import java.util.Date;

public class MeuPregao implements InterfacePregao{
		ArrayList<Contratante> contratantes = new ArrayList<Contratante>();
		ArrayList<Prestador> prestadores = new ArrayList<Prestador>();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		ArrayList<TipoDeServico> tipos = new ArrayList<TipoDeServico>();
		
		public Servico pesquisarServicoTipo(int tipo) {
			for(Servico c:servicos) {
				if(c.getTipo()==tipo) {
					return c;
				}
			}
			return null;
		}
		
		public Servico pesquisarServicoCodigo(int codigo) {
			for(Servico c:servicos) {
				if(c.getCodigoServico()==codigo) {
					return c;
				}
			}
			return null;
		}
		
		public Contratante pesquisarContratante(String emailContratante) {
			for(Contratante c:contratantes) {
				if(c.getEmail().equals(emailContratante)) {
					return c;
				}
			}
			return null;
		}
		
		public Prestador pesquisarPrestador(String email) {
			for(Prestador p:prestadores) {
				if(p.getEmail().equals(email)) {
					return p;
				}
			}
			return null;
		}
		
		public TipoDeServico pesquisarTipoDeServico(int cod, String descr){
			for(TipoDeServico t:tipos) {
				if(t.getCod()==cod && t.getDescr().equals(descr)) {
					return t;
				}
			}
			return null;
		}
		
		// Só podemos ter um servico aberto por contratante em um dado momento.
		public int cadastrarServico(String emailContratante, String descricao, double valor, int prazoMaximo, int codTipoDeServico) {
			Contratante c = pesquisarContratante(emailContratante);
			if(c.isContratoEmVigor() || c==null) {return -1;}//ja tem um contrato ativo no momento ou nao existe
			Servico s = new Servico(emailContratante, descricao, valor, prazoMaximo, codTipoDeServico);
			s.setContratante(c);
			servicos.add(s);
			return (int)(s.getValor()+s.getPrazoMaximo());
		}

		// Lista todos os serviços que atendam aos critérios de pesquisa (>=)
		public ArrayList<Servico> listarServicos(double valor, int prazoMaximo, int tipo, boolean contratado, boolean finalizado, int avaliacaoMediaContratante){
			 ArrayList<Servico> s = new  ArrayList<Servico>();
			 for(Servico c:servicos) {
				 if(c.getValor() >= valor && c.getPrazoMaximo() >= prazoMaximo && c.getTipo()==tipo && c.isContratado()==contratado && c.isFinalizado()==finalizado && c.getAvaliacaoMediaContratante() >= avaliacaoMediaContratante) {
					 s.add(c);
				 }
			 }
			return s;
		}
		
		
		// Verifica que não existe já cadastrado como contratante. Email deve ser único.
		public void cadastrarContratante(String email, String nome, String telefone) {
			if(pesquisarContratante(email) == null) {
				Contratante c = new Contratante(nome, email, telefone);
				contratantes.add(c);
			}
		}
		
		
		
		// Verifica que não existe já cadastrado como prestador. Email deve ser único.
		public void cadastrarPrestador(String email, String nome, String telefone) {
			if(pesquisarPrestador(email) == null) {
				Prestador p = new Prestador(nome, email, telefone);
				prestadores.add(p);
			}
		}

		// Verifica que prestador e serviço existem.
		public void adicionarServicoPrestador(String email, int tipo) {
			Servico s = pesquisarServicoTipo(tipo);
				if( s != null) {
					for(Prestador p:prestadores) {
						if(p.getEmail().equals(email)) {
							TipoDeServico t = new TipoDeServico(s.getCodigoServico(), s.getDescricao());
							p.servicoRealizado.add(t);
						}
					}
				}
			
		}
		
		// Verifica que não existe já cadastrado. Código e descrição devem ser únicos.
		public void adicionarTipoDeServico(int cod, String descr) {
			if(pesquisarTipoDeServico(cod,descr)==null) {
				TipoDeServico t = new TipoDeServico(cod,descr);
				tipos.add(t);
			}
		}

		// Cadastra proposta de um prestador para um serviço. Deve verificar compatibilidade entre os tipos de servicós
		// prestados pelo prestador e o serviço solicitado. Valor e prazo devem ser no máximo igual ao previsto.
		public void cadastrarProposta(int codigoServico, String emailPrestador, double valor, int prazo) {
			Prestador p = pesquisarPrestador(emailPrestador);
			if(p==null) {return;}
			Servico s = pesquisarServicoCodigo(codigoServico);
			if(s==null) {return;}
			
			for(TipoDeServico prestado : p.servicoRealizado) {
				if(prestado.getCod()==s.getCodigoServico()) {
					if(s.getPrazoMaximo()>=prazo && s.getValor()>=valor) {
						Proposta prop = new Proposta(codigoServico, emailPrestador, valor, prazo);
						prop.setPrestador(p);
						s.propostas.add(prop);
					}
				}
			}
		}
		
		// valor 0 significa todas ou então apenas valores abaixo de um valor. 
		// prazo 0 significa todas ou então apenas prazos menores que um máximo.
		// avaliacao 0 significa todas ou então apenas avaliações acima de um limite mínimo.
		// somente as não contratadas e finalizadas
		public ArrayList<Proposta> listarPropostas(int codigoServico, double valor, int prazoMaximo, int avaliacaoMediaPrestador){
		
			ArrayList<Proposta> p = new ArrayList<Proposta>();
			
			Servico s = pesquisarServicoCodigo(codigoServico);
		
			for(Proposta c: s.propostas) {
			
				if(valor == 0 && prazoMaximo == 0 && avaliacaoMediaPrestador ==0)
				{
					if(c.isContratado() == false && c.isFinalizado()) {
			             p.add(c);
		            }
				}
				
				if(valor == 0 && prazoMaximo == 0 && avaliacaoMediaPrestador !=0)
				{
					if(c.isContratado() == false && c.isFinalizado() && c.getAvaliacaoMediaPrestador() >= avaliacaoMediaPrestador) {
			             p.add(c);
		            }
				}
				
				if(valor == 0 && prazoMaximo != 0 && avaliacaoMediaPrestador !=0)
				{
					if(c.getPrazo() <prazoMaximo && c.isContratado() == false && c.isFinalizado() && c.getAvaliacaoMediaPrestador() >= avaliacaoMediaPrestador) {
			             p.add(c);
		            }
				}
				
				if(valor == 0 && prazoMaximo != 0 && avaliacaoMediaPrestador ==0)
				{
					if(c.getPrazo() <prazoMaximo && c.isContratado() == false && c.isFinalizado()) {
			             p.add(c);
		            }
				}
						
				if(valor != 0 && prazoMaximo != 0 && avaliacaoMediaPrestador !=0)
				{
					if(valor>c.getValor() && c.getPrazo() <prazoMaximo && c.isContratado() == false && c.isFinalizado() && c.getAvaliacaoMediaPrestador() >= avaliacaoMediaPrestador) {
			             p.add(c);
		            }
				}
				
				if(valor != 0 && prazoMaximo == 0 && avaliacaoMediaPrestador !=0)
				{
					if(valor>c.getValor() && c.isContratado() == false && c.isFinalizado() && c.getAvaliacaoMediaPrestador() >= avaliacaoMediaPrestador) {
			             p.add(c);
		            }
				}
				
				if(valor != 0 && prazoMaximo == 0 && avaliacaoMediaPrestador ==0)
				{
					if(valor>c.getValor() && c.isContratado() == false && c.isFinalizado()) {
			             p.add(c);
		            }
				}
				
				if(valor != 0 && prazoMaximo != 0 && avaliacaoMediaPrestador ==0)
				{
					if(valor>c.getValor() && c.getPrazo() <prazoMaximo && c.isContratado() == false && c.isFinalizado()) {
			             p.add(c);
		            }
				}				
		   	}
			return p;
		}

		// Marca serviço como contratado liberando para o cadastro de outros serviços pelo contratante
		public void contratarProposta(int codigoServico, String emailPrestador) {
			Prestador p = pesquisarPrestador(emailPrestador);
			if(p==null) {return;}
		}
		
		// Proposta deve ter sido contratada. Marca serviço como finalizado.
		public void finalizarServico(int codigoServico, Date data) {
			
		}
		// Servico deve ter sido finalizado. 
		public void avaliarPrestador(int codigoServico, int nota, String observacoes) {
			
		}
		
		// Servico deve ter sido finalizado.
		public void avaliarContratante(int codigoServico, int nota, String observacoes) {
			Servico s = pesquisarServicoCodigo(codigoServico);
			if(s.getCodigoServico()==codigoServico && s.isFinalizado()){
				s.setAvaliacaoMediaContratante(nota);
				Contratante c = pesquisarContratante(s.getEmailContratante());
				c.setObservacoes(observacoes);
			}
			
		}
}
