package weslleyAquinoFerreiraLocadora;

public class Moto extends Veiculo {

	
	int Cilindrada;
	public void setCilindrada(int cilindrada) {
		Cilindrada = cilindrada;
	}

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.11)/365;
		return aux;
	}

	public int getCilindrada() {
		// TODO Auto-generated method stub
		return 0;
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

}
