package weslleyAquinoFerreiraLocadora;

public class Moto extends Veiculo {

	
	int cilindrada;
	
	@Override
	public double seguro() {
		return (this.getValorAvaliado() *0.11)/365;
	}
	
	public int getCilindrada() {
		return cilindrada;
	}

	void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
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
	
	public Moto(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria,String placa, int cilindrada) {
		this.marca=marca;
		this.modelo=modelo;
		this.anoDeFabricacao=anoDeFabricacao;
		this.valorAvaliado=valorAvaliado;
		this.valorDiaria=valorDiaria;
		this.placa=placa;
		this.cilindrada=cilindrada;
	}
}
