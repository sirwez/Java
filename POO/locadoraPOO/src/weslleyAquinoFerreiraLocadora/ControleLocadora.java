package weslleyAquinoFerreiraLocadora;

import java.util.ArrayList;

public class ControleLocadora extends Locadora {
	
	ArrayList<Aluguel> aluguel = new ArrayList<Aluguel>();
	ArrayList<String> placasLocadas = new ArrayList<String>();
	
	@Override
	public boolean inserir(Veiculo v) {
		  Veiculo veiculo = pesquisaVeiculo(v.getPlaca());
		  if (veiculo == null) {
			veiculos.add(v);
			return true;
		  }
		return false;
	}
	public Veiculo pesquisaVeiculo(String placa) {
	      for (Veiculo c : veiculos) {
			if (c.getPlaca()== placa) {
			   return c;
			}
	      }
	      return null;
		}

	@Override
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
ArrayList<Veiculo> lista = new ArrayList<Veiculo>();

		for(Veiculo v: veiculos) {
			if(v instanceof Moto && ((Moto) v).getCilindrada() >= cilindrada) {
				lista.add(v);
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {
       ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		
		for(Veiculo v: veiculos) {
			if(v instanceof Carro && ((Carro) v).getTipoCarro() >= tipoCarro) {
				lista.add(v);
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		
		for(Veiculo v: veiculos) {
			if(v instanceof Caminhao && ((Caminhao) v).getCarga() >= carga) {
				lista.add(v);
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {
ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		
		for(Veiculo v: veiculos) {
			if(v instanceof Onibus && ((Onibus) v).getPassageiros() >= passageiros) {
				lista.add(v);
			}
		}
		
		return lista;
	}

	@Override
	public double calcularAluguel(String placa, int dias) {
		
		double Aluguel = 0;
		for(int i=0; i<veiculos.size();i++) {
		if(veiculos.get(i).getPlaca()==placa) {
			Aluguel=veiculos.get(i).aluguel(dias);
		}
		}
		return Aluguel;
	}

	@Override
	public boolean registrarAluguel(String placa, int dias, Cliente c) {
           Aluguel alugando = new Aluguel();
           
           for(String x: placasLocadas) {
        	   if (x==placa.trim()) {
        		   return false;//veiculo ja alugado
        	   }
           }
           for(Veiculo v:veiculos)
           {
        	   if(v.getPlaca().equals(placa.trim()))
        	   {
        		   alugando.setCliente(c);
        		   alugando.setVeiculo(v);
        		   alugando.setDias(dias);
        		   double valor = calcularAluguel(placa, dias);
        		   alugando.setValor(valor);
        		   aluguel.add(alugando);
        		   placasLocadas.add(placa);
        		   return true; //ttudo certo
        	   }
           }
		return false;
	}

	@Override
	public boolean registrarDevolucao(String placa, Cliente c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) {
		if(tipo==1) {
			Moto moto = new Moto();
			moto.aumentarDiaria(taxaAumento);
		}
		
	}

	@Override
	public double faturamentoTotal(int tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int quantidadeTotalDeDiarias(int tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
