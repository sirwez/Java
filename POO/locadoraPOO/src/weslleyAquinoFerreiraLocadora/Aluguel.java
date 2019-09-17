package weslleyAquinoFerreiraLocadora;

import java.util.Date;


public class Aluguel {
	private Veiculo veiculo;
	private Cliente cliente;
	private int dias;
	private double valor;
	private Date dateInicio;
	private boolean locado;

public Veiculo getVeiculo() {
	return veiculo;
}
public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Date getDateInicio() {
	return dateInicio;
}
public void setDateInicio(Date dateInicio) {
	this.dateInicio = dateInicio;
}
public int getDias() {
	return dias;
}
public void setDias(int dias) {
	this.dias = dias;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}

public Aluguel(Veiculo vei, Cliente c, Date data, int d) {
	this.cliente = c;
	this.veiculo = vei;
	this.dias = d;
	this.dateInicio = data;
	this.valor = vei.aluguel(d);
}
public boolean isLocado() {
	return locado;
}
public void setLocado(boolean locado) {
	this.locado = locado;
}
}
