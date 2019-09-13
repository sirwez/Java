package weslleyAquinoFerreiraLocadora;

public class Caminhao extends Veiculo{

	private double carga;

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.08)/365;
		return aux;
	}
	public void setCarga(double carga) {
		this.carga = carga;
	}
	public double getCarga() {
		return carga;
	}

	public void aumentarDiaria(double aumento) {
		this.setValorDiaria(this.valorDiaria*aumento);
	}
	public void diminuirDiaria(double diminuir) {
		this.setValorDiaria(this.valorDiaria*diminuir);
	}
	public void reduzirValorAvaliado(double reduzir) {
		this.setValorAvaliado(this.valorAvaliado-reduzir);
	}
	public void aumentarValorAvaliado(double aumentar) {
		this.setValorAvaliado(this.valorAvaliado+aumentar);
	}
}
