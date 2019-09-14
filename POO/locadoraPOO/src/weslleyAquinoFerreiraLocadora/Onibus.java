package weslleyAquinoFerreiraLocadora;

public class Onibus extends Veiculo{

	private int Passageiros;

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.2)/365;
		return aux;
	}

	public int getPassageiros() {
		return Passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.Passageiros = passageiros;
	}

	public void aumentarDiaria(double aumento) {
		this.setValorDiaria(this.valorDiaria*aumento);
	}
	public void diminuirDiaria(double diminuir) {
		this.setValorDiaria(this.valorDiaria*diminuir);
	}
	public void reduzirValorAvaliado(double reduzir) {
		this.setValorAvaliado(this.valorAvaliado*reduzir);
	}
	public void aumentarValorAvaliado(double aumentar) {
		this.setValorAvaliado(this.valorAvaliado*aumentar);
	}

}
