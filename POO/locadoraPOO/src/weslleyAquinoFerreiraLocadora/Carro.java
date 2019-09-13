package weslleyAquinoFerreiraLocadora;

public class Carro extends Veiculo {
   private int TipoCarro;

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.03)/365;
		return aux;
	}

	public int getTipoCarro() {
	return TipoCarro;
}
    public void setTipoCarro(int tipoCarro) {
	this.TipoCarro = tipoCarro;
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
