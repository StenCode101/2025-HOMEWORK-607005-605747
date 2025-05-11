package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza biblioteca;
	private Stanza atrio;
	
	@BeforeEach
	void setUp() throws Exception{
		this.labirinto = new Labirinto(biblioteca,atrio);
	}

	@Test
	void testSetStanzaIniziale() {
		this.labirinto.setStanzaIniziale(null);
		assertNull(this.labirinto.getStanzaIniziale());
		this.labirinto.setStanzaIniziale(this.biblioteca);
		assertEquals(this.biblioteca,this.labirinto.getStanzaIniziale());	
	}
	
	@Test
	void testSetStanzaFinale() {
		this.labirinto.setStanzaFinale(null);
		assertNull(this.labirinto.getStanzaFinale());
		this.labirinto.setStanzaFinale(this.atrio);
		assertEquals(this.atrio,this.labirinto.getStanzaFinale());	
	}

}
