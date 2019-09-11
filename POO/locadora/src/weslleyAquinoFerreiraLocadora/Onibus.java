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
		return Passageiros;
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
