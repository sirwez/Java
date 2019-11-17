package pedroSantosNeto.fazenda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TesteFazenda {

	@Test
	public void testeCadastroListagemAnimais() {
		Fazenda f = new Fazenda(1, "Sítio Siqueira");
		Animal b1 = new Bovino(1, "Boi da Cara Preta", new Date(), 0, 1000, 5000);
		Animal b2 = new Bovino(2, "Malhadao", new Date(), 0, 1000, 5000);
		Animal s1 = new Suino(5, "Porqueira", new Date(), 1, 100, 500);
		Animal s2 = new Suino(6, "Barrinha", new Date(), 1, 100, 500);
		Animal c1 = new Caprino(3, "Bodao", new Date(), 0, 100, 500);
		Animal c2 = new Caprino(4, "Cabrinha", new Date(), 1, 100, 500);
		
		f.compra(b1);
		f.compra(b2);
		f.compra(c1);
		f.compra(c2);
		f.compra(s1);
		f.compra(s2);
		
		assertEquals(2, f.listarResumoDeAnimais(1, true, true)); 
		assertEquals(0, f.listarResumoDeAnimais(1, true, false)); 
		assertEquals(0, f.listarResumoDeAnimais(2, true, true)); 
		assertEquals(2, f.listarResumoDeAnimais(2, true, false)); 
		assertEquals(1, f.listarResumoDeAnimais(3, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, true, false)); 
		assertEquals(3, f.listarResumoDeAnimais(0, true, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, true, false)); 
	}
	
	@Test
	public void testeCompraNovoVelhoVacinado() {
		Fazenda f = new Fazenda(1, "Sítio Siqueira");
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(gc.MONTH, -24);
		GregorianCalendar gcBoiVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -22);
		GregorianCalendar gcBoiNovo = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -19);
		GregorianCalendar gcBodeVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -17);
		GregorianCalendar gcBodeNovo = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -13);
		GregorianCalendar gcPorcoVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -11);
		GregorianCalendar gcPorcoNovo = gc;
		
		// Boi novo
		Animal b1 = new Bovino(1, "Boi da Cara Preta", gcBoiNovo.getTime(), 0, 1000, 5000);
		// Boi velho mas vacinado
		Animal b2 = new Bovino(2, "Malhadao", gcBoiVelho.getTime(), 0, 1000, 5000);
		b2.setVacinado(true);
		//Boi velho sem vacina - não vai ser adicionado!
		Animal b3 = new Bovino(3, "Malhadao2", gcBoiVelho.getTime(), 0, 1000, 5000);
		
		// Porco novo
		Animal s1 = new Suino(10, "Porqueira", gcPorcoNovo.getTime(), 0, 100, 500);
		// Porco velho vacinado
		Animal s2 = new Suino(11, "Barrinha", gcPorcoVelho.getTime(), 0, 100, 500);
		s2.setVacinado(true);
		// Porco velho sem vacina
		Animal s3 = new Suino(12, "Barrinha2", gcPorcoVelho.getTime(), 0, 100, 500);

		// Bode novo
		Animal c1 = new Caprino(20, "Bodao", gcBodeNovo.getTime(), 0, 100, 500);
		// Bode velho vacinado
		Animal c2 = new Caprino(21, "Cabrinha", gcBodeVelho.getTime(), 0, 100, 500);
		c2.setVacinado(true);
		// Bode velho sem vacina
		Animal c3 = new Caprino(22, "Cabrinha2", gcBodeVelho.getTime(), 0, 100, 500);
		
		f.compra(b1);
		f.compra(b2);
		f.compra(b3);
		f.compra(c1);
		f.compra(c2);
		f.compra(c3);
		f.compra(s1);
		f.compra(s2);
		f.compra(s3);
		
		assertEquals(1, f.listarResumoDeAnimais(1, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(1, false, true)); 
		assertEquals(1, f.listarResumoDeAnimais(2, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(2, false, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, false, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, true, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, false, true)); 
	}
	
	@Test
	public void testeCompraVenda() {
		Fazenda f = new Fazenda(1, "Sítio Siqueira");
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(gc.MONTH, -24);
		GregorianCalendar gcBoiVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -22);
		GregorianCalendar gcBoiNovo = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -19);
		GregorianCalendar gcBodeVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -17);
		GregorianCalendar gcBodeNovo = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -13);
		GregorianCalendar gcPorcoVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -11);
		GregorianCalendar gcPorcoNovo = gc;
		
		// Boi novo
		Animal b1 = new Bovino(1, "Boi da Cara Preta", gcBoiNovo.getTime(), 0, 1000, 5000);
		// Boi velho mas vacinado
		Animal b2 = new Bovino(2, "Malhadao", gcBoiVelho.getTime(), 0, 1000, 5000);
		b2.setVacinado(true);
		// Boi velho vacinado!
		Animal b3 = new Bovino(3, "Malhadao2", gcBoiVelho.getTime(), 0, 1000, 5000);
		b3.setVacinado(true);
		
		// Porco novo
		Animal s1 = new Suino(10, "Porqueira", gcPorcoNovo.getTime(), 0, 100, 500);
		// Porco velho vacinado
		Animal s2 = new Suino(11, "Barrinha", gcPorcoVelho.getTime(), 0, 100, 500);
		s2.setVacinado(true);
		// Porco velho vacinado
		Animal s3 = new Suino(12, "Barrinha2", gcPorcoVelho.getTime(), 0, 100, 500);
		s3.setVacinado(true);

		// Bode novo
		Animal c1 = new Caprino(20, "Bodao", gcBodeNovo.getTime(), 0, 100, 500);
		// Bode velho vacinado
		Animal c2 = new Caprino(21, "Cabrinha", gcBodeVelho.getTime(), 0, 100, 500);
		c2.setVacinado(true);
		// Bode velho vacinado
		Animal c3 = new Caprino(22, "Cabrinha2", gcBodeVelho.getTime(), 0, 100, 500);
		c3.setVacinado(true);
		
		f.compra(b1);
		f.compra(b2);
		f.compra(b3);
		f.compra(c1);
		f.compra(c2);
		f.compra(c3);
		f.compra(s1);
		f.compra(s2);
		f.compra(s3);
	
		f.venda(3);
		f.venda(12);
		f.venda(22);
		
		assertEquals(1, f.listarResumoDeAnimais(1, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(1, false, true)); 
		assertEquals(1, f.listarResumoDeAnimais(2, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(2, false, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, false, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, true, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, false, true)); 
	}
	
	@Test
	public void testeMorteAbate() {
		Fazenda f = new Fazenda(1, "Sítio Siqueira");
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(gc.MONTH, -24);
		GregorianCalendar gcBoiVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -22);
		GregorianCalendar gcBoiNovo = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -19);
		GregorianCalendar gcBodeVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -17);
		GregorianCalendar gcBodeNovo = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -13);
		GregorianCalendar gcPorcoVelho = gc;
		
		gc = new GregorianCalendar();
		gc.add(gc.MONTH, -11);
		GregorianCalendar gcPorcoNovo = gc;
		
		// Boi novo
		Animal b1 = new Bovino(1, "Boi da Cara Preta", gcBoiNovo.getTime(), 0, 1000, 5000);
		// Boi velho mas vacinado
		Animal b2 = new Bovino(2, "Malhadao", gcBoiVelho.getTime(), 0, 1000, 5000);
		b2.setVacinado(true);
		// Boi velho vacinado!
		Animal b3 = new Bovino(3, "Malhadao2", gcBoiVelho.getTime(), 0, 1000, 5000);
		b3.setVacinado(true);
		
		// Porco novo
		Animal s1 = new Suino(10, "Porqueira", gcPorcoNovo.getTime(), 0, 100, 500);
		// Porco velho vacinado
		Animal s2 = new Suino(11, "Barrinha", gcPorcoVelho.getTime(), 0, 100, 500);
		s2.setVacinado(true);
		// Porco velho vacinado
		Animal s3 = new Suino(12, "Barrinha2", gcPorcoVelho.getTime(), 0, 100, 500);
		s3.setVacinado(true);

		// Bode novo
		Animal c1 = new Caprino(20, "Bodao", gcBodeNovo.getTime(), 0, 100, 500);
		// Bode velho vacinado
		Animal c2 = new Caprino(21, "Cabrinha", gcBodeVelho.getTime(), 0, 100, 500);
		c2.setVacinado(true);
		// Bode velho vacinado
		Animal c3 = new Caprino(22, "Cabrinha2", gcBodeVelho.getTime(), 0, 100, 500);
		c3.setVacinado(true);
		
		f.compra(b1);
		f.compra(b2);
		f.compra(b3);
		f.compra(c1);
		f.compra(c2);
		f.compra(c3);
		f.compra(s1);
		f.compra(s2);
		f.compra(s3);
	
		f.morte(3);
		f.morte(12);
		f.abate(22);
		
		assertEquals(1, f.listarResumoDeAnimais(1, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(1, false, true)); 
		assertEquals(1, f.listarResumoDeAnimais(2, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(2, false, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, true, true)); 
		assertEquals(1, f.listarResumoDeAnimais(3, false, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, true, true)); 
		assertEquals(3, f.listarResumoDeAnimais(0, false, true)); 
	}
}
