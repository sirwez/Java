package weslleyAquinoFerreiraLocadora;

//import java.util.Date;
import java.util.GregorianCalendar;

public class Aluguel {
private Veiculo veiculo;
private int cpfCliente;
private GregorianCalendar dateInicio;
private GregorianCalendar dateFim;
private int dias;
private double valor;

public int getDias() {
	return dias;
}
public void setDias(int dias) {
	this.dias = dias;
}

public GregorianCalendar getDateInicio() {
	return dateInicio;
}
public void setDateInicio(GregorianCalendar dateInicio) {
	this.dateInicio = dateInicio;
}
public GregorianCalendar getDateFim() {
	return dateFim;
}
public void setDateFim(GregorianCalendar dateFim) {
	this.dateFim = dateFim;
}
public Veiculo getVeiculo() {
	return veiculo;
}
public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
public int getCpfCliente() {
	return cpfCliente;
}
public void setCpfCliente(int cpfCliente) {
	this.cpfCliente = cpfCliente;
}
}
