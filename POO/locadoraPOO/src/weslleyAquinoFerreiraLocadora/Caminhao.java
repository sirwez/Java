package weslleyAquinoFerreiraLocadora;

public class Caminhao extends Veiculo{

	double carga;
	public void setCarga(double carga) {
		this.carga = carga;
	}

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.08)/365;
		return aux;
	}

	public int getCarga() {
		// TODO Auto-generated method stub
		return 0;
	}
}
