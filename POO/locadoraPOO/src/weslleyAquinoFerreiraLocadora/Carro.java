package weslleyAquinoFerreiraLocadora;

public class Carro extends Veiculo {
	int tipoCarro;
	
	@Override
	public double seguro() {
		return (this.getValorAvaliado() * 0.03)/365;
	}
	
	public int getTipo() {
		return tipoCarro;
	}

	void setTipoCarro(int tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public void aumentarDiaria(double valorAumento) {
		this.setValorDiaria(this.valorDiaria*valorAumento);
	}
	
	public void diminurDiaria(double valorDiminuicao) {
		this.setValorDiaria(this.valorDiaria*valorDiminuicao);
	}
	
	public void aumentarValorAvaliado(double valorAumento) {
		this.setValorAvaliado(this.valorAvaliado*valorAumento);
	}
	
	public void diminuirValorAvaliado(double valorDiminuir) {
		this.setValorAvaliado(this.valorAvaliado*valorDiminuir);
	}
	
	public Carro(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria,String placa, int tipo) {
		this.marca=marca;
		this.modelo=modelo;
		this.anoDeFabricacao=anoDeFabricacao;
		this.valorAvaliado=valorAvaliado;
		this.valorDiaria=valorDiaria;
		this.placa=placa;
		this.tipoCarro=tipo;
	}

}
