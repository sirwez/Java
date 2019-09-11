package weslleyAquinoFerreiraLocadora;

public class Aluguel {
private Veiculo veiculo;
private Cliente cliente;
private int dias;
private double valor;

public Veiculo getVeiculo() {
	return veiculo;
}
public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
}
public int getDias() {
	return dias;
}
public void setDias(int dias) {
	this.dias = dias;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
}
