package pedroSantosNeto.fazenda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

public class TesteAnimal {

	@Test
	public void testarInsercaoAnimal() throws ClassNotFoundException, SQLException {

		Date data = new Date();
		Animal a = new Bovino(1, "Bravo", data, 0, 5000, 10000, true, false, false);
		DAOAnimal daoA = new DAOAnimal();
		daoA.removerTodos();
		daoA.inserir(a);
		
		Animal outro = daoA.pesquisarPor(1);
		assertEquals("Bravo", outro.getNome());
	}
}
