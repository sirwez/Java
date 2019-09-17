package weslleyAquinoFerreiraLocadora;

import java.util.ArrayList;
import java.util.Date;


public class MinhaLocadora extends Locadora{
	
	public Veiculo pesquisar (String placa) {
		for(Veiculo v: veiculos) {
			if(v.getPlaca().equals(placa.trim())) {
				return v;
			}
		}
		return null;
	}
	
	
	public Aluguel pesquisarAluguel(String placa) {
		for(Aluguel s:alugueis){
			if(s.getVeiculo().getPlaca().equals(placa)) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public boolean inserir(Veiculo v) {
		if(pesquisar(v.getPlaca()) == null) {
			veiculos.add(v);
			return true;
		}
		
		return false;
	}

	@Override
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
		
		ArrayList<Veiculo> motos= new ArrayList<Veiculo>();
		
		for(Veiculo v:veiculos) {
			if(v instanceof Moto && ((Moto) v).getCilindrada()>=cilindrada) {
				motos.add(v);
			}
		}
		return motos;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {
		ArrayList<Veiculo> carros= new ArrayList<Veiculo>();
		
		for(Veiculo v:veiculos) {
			if(v instanceof Carro && ((Carro) v).getTipo()==tipoCarro) {
				carros.add(v);
			}
		}
		return carros;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
		ArrayList<Veiculo> caminhao= new ArrayList<Veiculo>();
		for(Veiculo v:veiculos) {
			if(v instanceof Caminhao && ((Caminhao) v).getCarga()>=carga) {
				caminhao.add(v);
			}
		}
		return caminhao;
	}

	@Override
	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {
		ArrayList<Veiculo> onibus = new ArrayList<Veiculo>();
		
		for(Veiculo v:veiculos) {
			if(v instanceof Onibus && ((Onibus) v).getPassageiros()>=passageiros) {
				onibus.add(v);
			}
		}
		return onibus;
	}

	@Override
	public double calcularAluguel(String placa, int dias) {
		for(Veiculo v:veiculos) {
			if(v.getPlaca().equals(placa.trim())) {
				return v.aluguel(dias);
			}
		}
		return -1;
	}

	@Override
	public boolean registrarAluguel(String placa, Date data, int dias, int cpf) {
		
		Cliente c = pesquisarCliente(cpf);
		if(c==null) return false; //cliente nao existe
		Aluguel a= pesquisarAluguel(placa);
		if(a!=null) return false;// ja locado 
		Veiculo v = pesquisar(placa);
		if(v==null) return false;//nao existe
		
		Aluguel alugando = new Aluguel(v,c,data,dias);
		alugando.setLocado(true);
		alugueis.add(alugando);
		return true;//sucesso
	}

	@Override
	public boolean registrarDevolucao(String placa) {
		
		Veiculo v = pesquisar(placa);
		if(v==null) return false;//veiculos inexistente
		Aluguel a= pesquisarAluguel(placa);
		if(a==null || a.isLocado()==false) return false;// nao existe em alugueis ou nao esta sendo locado
		
		a.setLocado(false);//muda para false para dizer que foi devolvido
		return true;//sucesso na operacao
	}

	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
		
		taxaDepreciacao = 1 - taxaDepreciacao;
		
		if(tipo==0) {
			for(Veiculo v:veiculos) {
				if(v instanceof Moto) {
					((Moto) v).diminuirValorAvaliado(taxaDepreciacao);
				}else if(v instanceof Carro) {
					((Carro) v).diminuirValorAvaliado(taxaDepreciacao);
				}else if(v instanceof Caminhao) {
					((Caminhao) v).diminuirValorAvaliado(taxaDepreciacao);
				}else if(v instanceof Onibus) {
					((Onibus) v).diminuirValorAvaliado(taxaDepreciacao);
				}
			}
		}else if(tipo==1) {
			for(Veiculo v:veiculos) {
				if(v instanceof Moto) {
					((Moto) v).diminuirValorAvaliado(taxaDepreciacao);
				}
			}
		}else if(tipo==2) {
			for(Veiculo v:veiculos) {
				if(v instanceof Carro) {
					((Carro) v).diminuirValorAvaliado(taxaDepreciacao);
				}
			}
		}else if(tipo==3) {
			for(Veiculo v:veiculos) {
				if(v instanceof Caminhao) {
					((Caminhao) v).diminuirValorAvaliado(taxaDepreciacao);
				}
			}
		}else if(tipo==4) {
			for(Veiculo v:veiculos) {
				if(v instanceof Onibus) {
					((Onibus) v).diminuirValorAvaliado(taxaDepreciacao);
				}
			}
		} 
		
		
	}
	
	// tipo de veiculo
	// 0 (todos), 1 (moto), 2 (carro), 3 (caminhao), 4 (onibus)
	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) {
		
		taxaAumento=taxaAumento+1;
		
		if(tipo==0) {
			for(Veiculo v:veiculos) {
				if(v instanceof Moto) {
					((Moto) v).aumentarDiaria(taxaAumento);
				}else if(v instanceof Carro) {
					((Carro) v).aumentarDiaria(taxaAumento);
				}else if(v instanceof Caminhao) {
					((Caminhao) v).aumentarDiaria(taxaAumento);
				}else if(v instanceof Onibus) {
					((Onibus) v).aumentarDiaria(taxaAumento);
				}
			}
		}else if(tipo==1) {
			for(Veiculo v:veiculos) {
				if(v instanceof Moto) {
					((Moto) v).aumentarDiaria(taxaAumento);
				}
			}
		}else if(tipo==2) {
			for(Veiculo v:veiculos) {
				if(v instanceof Carro) {
					((Carro) v).aumentarDiaria(taxaAumento);
				}
			}
		}else if(tipo==3) {
			for(Veiculo v:veiculos) {
				if(v instanceof Caminhao) {
					((Caminhao) v).aumentarDiaria(taxaAumento);
				}
			}
		}else if(tipo==4) {
			for(Veiculo v:veiculos) {
				if(v instanceof Onibus) {
					((Onibus) v).aumentarDiaria(taxaAumento);
				}
			}
		} 
		
		
	}

	@Override
	public double faturamentoTotal(int tipo, Date inicio, Date fim) {//concertar
		double faturamento=0;

		if(tipo==0) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false) {
					if(a.getVeiculo() instanceof Moto) {
						faturamento+=a.getValor();
					}else if(a.getVeiculo() instanceof Carro) {
						faturamento+=a.getValor();
					}else if(a.getVeiculo() instanceof Caminhao) {
						faturamento+=a.getValor();
					}else if(a.getVeiculo() instanceof Onibus) {
						faturamento+=a.getValor();
					}
				}
			}
		}else if(tipo==1) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false) {
					if(a.getVeiculo() instanceof Moto) {
						faturamento+=a.getValor();
					}
				}
			}
		}else if(tipo==2) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false) {
					if(a.getVeiculo() instanceof Carro) {
						faturamento+=a.getValor();
					}
				}
			}
		}else if(tipo==3) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false) {
					if(a.getVeiculo() instanceof Caminhao) {
						faturamento+=a.getValor();
					}
				}
			}
		}else if(tipo==4) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false) {
					if(a.getVeiculo() instanceof Onibus) {
						faturamento+=a.getValor();
					}
				}
			}
		}
		
		return faturamento;
	}

	@Override
	public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim) {//concertar
		
		int dias=0;
		
		if(tipo==0) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false) {
					if(a.getVeiculo() instanceof Moto) {
						dias+=a.getDias();
					}else if(a.getVeiculo() instanceof Carro) {
						dias+=a.getDias();
					}else if(a.getVeiculo() instanceof Caminhao) {
						dias+=a.getDias();
					}else if(a.getVeiculo() instanceof Onibus) {
						dias+=a.getDias();
					}
				}
			}
		}else if(tipo==1) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false && a.getVeiculo() instanceof Moto) {
						dias+=a.getDias();
				}
			}
		}else if(tipo==2) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false && a.getVeiculo() instanceof Carro) {
						dias+=a.getDias();
				}
			}
		}else if(tipo==3) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false && a.getVeiculo() instanceof Caminhao) {
						dias+=a.getDias();
				}
			}
		}else if(tipo==4) {
			for(Aluguel a:alugueis) {
				if(a.getDateInicio().after(inicio) && a.isLocado()==false && a.getVeiculo() instanceof Onibus) {
						dias+=a.getDias();
				}
			}
		}
		
		return dias;
	}

}
