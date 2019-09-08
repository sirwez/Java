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

	public void aumentarDiaria(double aumento) {
		this.valorDiaria+=aumento;
	}
	public void diminuirDiaria(double diminuir) {
		this.valorDiaria+=diminuir;
	}
	public void reduzirValorAvaliado(double reduzir) {
		this.valorAvaliado+=reduzir;
	}

	public double getCarga() {
		return carga;
	}
}
