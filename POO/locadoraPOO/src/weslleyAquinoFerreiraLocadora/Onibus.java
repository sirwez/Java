package weslleyAquinoFerreiraLocadora;

public class Onibus extends Veiculo{

	int passageiros;
	
	@Override
	public double seguro() {
		return (this.getValorAvaliado() * 0.2)/365;
	}
	
	public int getPassageiros() {
		return passageiros;
	}

	void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
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
	
	public Onibus(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria,String placa, int passageiros) {
		this.marca=marca;
		this.modelo=modelo;
		this.anoDeFabricacao=anoDeFabricacao;
		this.valorAvaliado=valorAvaliado;
		this.valorDiaria=valorDiaria;
		this.placa=placa;
		this.passageiros=passageiros;
	}

}
