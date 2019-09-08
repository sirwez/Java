package weslleyAquinoFerreiraLocadora;

public class Onibus extends Veiculo{

	int Passageiros;
	public void setPassageiros(int passageiros) {
		Passageiros = passageiros;
	}

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.2)/365;
		return aux;
	}

	public int getPassageiros() {
		// TODO Auto-generated method stub
		return 0;
	}

}
