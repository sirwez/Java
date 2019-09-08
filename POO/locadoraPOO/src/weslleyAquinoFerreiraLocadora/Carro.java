package weslleyAquinoFerreiraLocadora;

public class Carro extends Veiculo {
    int TipoCarro;

	@Override
	public double seguro() {
		double aux;
		aux= (valorAvaliado* 0.03)/365;
		return aux;
	}
    public double valorAluguel() {
    	return 12.2;
    }
	public int getTipoCarro() {
	return TipoCarro;
}
    public void setTipoCarro(int tipoCarro) {
	TipoCarro = tipoCarro;
}

}
