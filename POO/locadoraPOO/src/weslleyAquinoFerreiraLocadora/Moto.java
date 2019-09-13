package weslleyAquinoFerreiraLocadora;

public class Moto extends Veiculo {

	
	private int Cilindrada;


	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.11)/365;
		return aux;
	}
	public void setCilindrada(int cilindrada) {
		this.Cilindrada = cilindrada;
	}
	public int getCilindrada() {
		return Cilindrada;
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
