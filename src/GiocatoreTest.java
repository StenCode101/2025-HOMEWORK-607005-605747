import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class GiocatoreTest {
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp() throws Exception {
		giocatore = new Giocatore();
		
	}

	@Test
	void testNumeroDiCfu() {
		assertEquals(20,giocatore.getCfu());
	}

}
