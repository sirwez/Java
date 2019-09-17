package weslleyAquinoFerreiraLocadora;

//import java.util.ArrayList;

public abstract class Veiculo {

	protected String marca;
	protected String modelo;
	protected int anoDeFabricacao;
	protected double valorAvaliado;
	protected double valorDiaria;
	protected String placa;

	public abstract double seguro();
	 //Seguro Moto = (valor do bem * 11%)/365
    //Seguro Carro = (valor do bem * 3%)/365
    //Seguro Caminhao = (valor do bem * 8%)/365
    //Seguro onibus = (valor do bem * 20%)/365
	
	public double aluguel(int dias) {
		return (valorDiaria + seguro()) * dias;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}
	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}
	public double getValorAvaliado() {
		return valorAvaliado;
	}
	public void setValorAvaliado(double valorAvaliado) {
		this.valorAvaliado = valorAvaliado;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
