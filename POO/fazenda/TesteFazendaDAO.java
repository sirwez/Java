package pedroSantosNeto.fazenda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

public class TesteFazendaDAO {

	@Test
	public void testarInsercaoFazenda() throws ClassNotFoundException, SQLException {
		Fazenda f = new Fazenda(1, "JBS");
		DAOFazenda daoF = new DAOFazenda();
		daoF.removerTodos();
		daoF.inserir(f);
		
		DAOAnimal daoA = new DAOAnimal();
		daoA.removerTodos();

		Date data = new Date();
		Animal a1 = new Bovino(1, "Bravo1", data, 0, 5000, 10000, true, false, false);
		a1.setFazenda(f);
        daoA.inserir(a1);

		Animal a2 = new Bovino(2, "Bravo2", data, 0, 5000, 10000, true, false, false);
		a2.setFazenda(f);
        daoA.inserir(a2);
		
		Animal a3 = new Bovino(3, "Bravo3", data, 0, 5000, 10000, true, false, false);
		a3.setFazenda(f);
        daoA.inserir(a3);

		Animal a4 = new Bovino(4, "Bravo4", data, 0, 5000, 10000, true, false, false);
		a4.setFazenda(f);
        daoA.inserir(a4);

		Animal a5 = new Bovino(5, "Bravo5", data, 0, 5000, 10000, true, false, false);
		a5.setFazenda(f);
        daoA.inserir(a5);

        Fazenda outra = daoF.pesquisarPor(1);
		assertEquals("JBS", outra.getNome());
		assertEquals(5, outra.getAnimais().size());
		
	}
}
