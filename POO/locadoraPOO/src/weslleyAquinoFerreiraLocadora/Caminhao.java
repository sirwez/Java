package weslleyAquinoFerreiraLocadora;

public class Caminhao extends Veiculo{

	int carga;
	
	@Override
	public double seguro() {
		return (this.getValorAvaliado() * 0.08)/365;
	}
	
	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
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
	
	public Caminhao(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria,String placa, int carga) {
		this.marca=marca;
		this.modelo=modelo;
		this.anoDeFabricacao=anoDeFabricacao;
		this.valorAvaliado=valorAvaliado;
		this.valorDiaria=valorDiaria;
		this.placa=placa;
		this.carga=carga;
	}
}
