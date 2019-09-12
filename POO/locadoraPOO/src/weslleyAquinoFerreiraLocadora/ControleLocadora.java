package weslleyAquinoFerreiraLocadora;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
  
	public int validarCPF(int cpf)
{
    for (Cliente c : clientes) {
			if (c.getCpf() == cpf) {
			     return 1; //retorna 1 se exstir
			}
	      }
    return 0;
}
    
	@Override
	public boolean registrarAluguel(String placa, Date data, int dias, int cpf) {
           Aluguel alugando = new Aluguel();
           GregorianCalendar gc = new GregorianCalendar();
  /*         Date a = new Date();
           a.setDate(a.getDate()+dias);
           */
           
           int c;
           c=validarCPF(cpf);
           for(String x: placasLocadas) {
        	   if ((x==placa.trim()) && (c!=1) ) {
        		   return false;//veiculo ja alugado
        	   }
           }
           for(Veiculo v:veiculos)
           {
        	   if(v.getPlaca().equals(placa.trim()))
        	   {
        		   gc.setTime(data);
        		   alugando.setDateInicio(gc);
        		  // gc.add(Calendar.DATE, dias); //esse?
        		   gc.add(Calendar.DAY_OF_MONTH, dias);
        		  // gc.add(gc.DAY_OF_MONTH, dias);
        		   alugando.setDateFim(gc);
        		   alugando.setCpfCliente(cpf);
        		   alugando.setVeiculo(v);
        		   alugando.setDias(dias);
        		   double valor = calcularAluguel(placa, dias);
        		   alugando.setValor(valor);
        		   aluguel.add(alugando);
        		   placasLocadas.add(placa);
        		   
        		   return true; //tudo certo
        	   }
           }
		return false;
	}

	@Override
	public boolean registrarDevolucao(String placa) {
        Aluguel alugando = new Aluguel();
        
        for(String x: placasLocadas) {
     	   if (x!=placa.trim()) {
     		   return false;//veiculo nao alugado
     	   }
        }
        for(Veiculo v:veiculos)
        {
     	   if(v.getPlaca().equals(placa.trim()))
     	   {
     		   alugando.setVeiculo(v);
     		   aluguel.remove(alugando);
     		   placasLocadas.remove(placa);
     		   return true; //removido
     	   }
        }
		return false;
	}

	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
		taxaDepreciacao/=100;
		if(tipo==0) {
			for(Veiculo v: veiculos)
			{
				if(v instanceof Moto) {
					((Moto) v).diminuirDiaria(taxaDepreciacao);
				   }else if(v instanceof Carro) {
					((Carro) v).diminuirDiaria(taxaDepreciacao);
			            	}else if(v instanceof Caminhao) {
					((Caminhao) v).diminuirDiaria(taxaDepreciacao);
				                   }else if(v instanceof Onibus) {
					((Onibus) v).diminuirDiaria(taxaDepreciacao);
				}
			}
		}
		
		if(tipo==1) {
			for(Veiculo v: veiculos) {
				if(v instanceof Moto) {
					((Moto) v).diminuirDiaria(taxaDepreciacao);
				} 
			}
		}
		
		if(tipo==2) {
			for(Veiculo v: veiculos) {
				if(v instanceof Carro) {
					((Carro) v).diminuirDiaria(taxaDepreciacao);
				}
			}
		}
		
		if(tipo==3) {
			for(Veiculo v: veiculos) {
				if(v instanceof Caminhao) {
					((Caminhao) v).diminuirDiaria(taxaDepreciacao);
				}
			}
		}
		
		if(tipo==4) {
			for(Veiculo v: veiculos) {
				if(v instanceof Onibus) {
					((Onibus) v).diminuirDiaria(taxaDepreciacao);
				}
			}
		}
	}

	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) {
    taxaAumento/=100;
		if(tipo==0) {
			for(Veiculo v: veiculos)
			{
				if(v instanceof Moto) {
					((Moto) v).diminuirDiaria(taxaAumento);
				   }else if(v instanceof Carro) {
					((Carro) v).diminuirDiaria(taxaAumento);
			            	}else if(v instanceof Caminhao) {
					((Caminhao) v).diminuirDiaria(taxaAumento);
				                   }else if(v instanceof Onibus) {
					((Onibus) v).diminuirDiaria(taxaAumento);
				}
			}
		}
		if(tipo==1) {
			for(Veiculo v: veiculos) {
				if(v instanceof Moto) {
					((Moto) v).aumentarDiaria(taxaAumento);
				}
			}
		}
		
		if(tipo==2) {
			for(Veiculo v: veiculos) {
				if(v instanceof Carro) {
					((Carro) v).aumentarDiaria(taxaAumento);
				}
			}
		}
		
		if(tipo==3) {
			for(Veiculo v: veiculos) {
				if(v instanceof Caminhao) {
					((Caminhao) v).aumentarDiaria(taxaAumento);
				}
			}
		}
		
		if(tipo==4) {
			for(Veiculo v: veiculos) {
				if(v instanceof Onibus) {
					((Onibus) v).aumentarDiaria(taxaAumento);
				}
			}
		}
		
	}

	@Override
	public double faturamentoTotal(int tipo, Date inicio, Date fim) {
		
double total=0;

GregorianCalendar gc1 = new GregorianCalendar();
GregorianCalendar gc2 = new GregorianCalendar();

gc1.setTime(inicio);
gc2.setTime(fim);

if(tipo==0) {
	
		for(int k=0; k<aluguel.size(); k++) {
			if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime())) {
			   total+=aluguel.get(k).getValor();
		
			}
	}
		return total;
}
		
if(tipo==1) {		 
		for(int k=0; k<aluguel.size(); k++) {
				if(aluguel.get(k).getVeiculo() instanceof Moto) {
					if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime())) {
						   total+=aluguel.get(k).getValor();
					
						}
					}
				}
		return total;
		}
		
if(tipo==2) {		 
	    for(int k=0; k<aluguel.size(); k++) {
	        	if(aluguel.get(k).getVeiculo() instanceof Carro) {
	    			if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime())) {
	    				   total+=aluguel.get(k).getValor();
	    			
	    				}
			}
		}
		return total;
}
		
if(tipo==3) {		 
	    for(int k=0; k<aluguel.size(); k++) {
	        	if(aluguel.get(k).getVeiculo() instanceof Caminhao) {
	    			if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime())) {
	    				   total+=aluguel.get(k).getValor();
	    			
	    				}
			}
		}
		return total;
}
if(tipo==4) {		 
	    for(int k=0; k<aluguel.size(); k++) {
	        	if(aluguel.get(k).getVeiculo() instanceof Onibus) {
	    			if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime())) {
	    				   total+=aluguel.get(k).getValor();
	    			
	    				}
			}
		}
		return total;
}
		return 0;
		
	}

	@Override
	public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim) {
		int total=0;
		GregorianCalendar gc1 = new GregorianCalendar();
		GregorianCalendar gc2 = new GregorianCalendar();

		gc1.setTime(inicio);
		gc2.setTime(fim);
		
		if(tipo==0) {
				for(int k=0; k<aluguel.size(); k++) {
					if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime()))
					   total+=aluguel.get(k).getDias();
					
			}
				return total;
		}
				
		if(tipo==1) {		 
				for(int k=0; k<aluguel.size(); k++) {
						if(aluguel.get(k).getVeiculo() instanceof Moto) {
							if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime()))
							total+=aluguel.get(k).getDias();
							}
						}
				return total;
				}
				
		if(tipo==2) {		 
			    for(int k=0; k<aluguel.size(); k++) {
			        	if(aluguel.get(k).getVeiculo() instanceof Carro) {
			        		if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime()))
			        		total+=aluguel.get(k).getDias();
					}
				}
				return total;
		}
				
		if(tipo==3) {		 
			    for(int k=0; k<aluguel.size(); k++) {
			        	if(aluguel.get(k).getVeiculo() instanceof Caminhao) {
			        		if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime()))
			        		total+=aluguel.get(k).getDias();
					}
				}
				return total;
		}
		if(tipo==4) {		 
			    for(int k=0; k<aluguel.size(); k++) {
			        	if(aluguel.get(k).getVeiculo() instanceof Onibus) {
			        		if(aluguel.get(k).getDateInicio().after(gc1.getTime()) && aluguel.get(k).getDateFim().before(gc2.getTime()))
			        		total+=aluguel.get(k).getDias();
					}
				}
				return total;
		}
				return 0;
	}
}
