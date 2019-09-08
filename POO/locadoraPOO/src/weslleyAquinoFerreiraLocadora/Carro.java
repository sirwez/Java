package weslleyAquinoFerreiraLocadora;

public class Carro extends Veiculo {
    int TipoCarro;

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
	TipoCarro = tipoCarro;
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
