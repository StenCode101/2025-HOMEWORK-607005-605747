package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new Giocatore();
		
	}

	@Test
	void testNumeroDiCfuIniziali() {
		assertEquals(20,this.giocatore.getCfu());
	}

}
