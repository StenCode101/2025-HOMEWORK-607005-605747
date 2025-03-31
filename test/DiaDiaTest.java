

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.partita.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class DiaDiaTest {
	
	private DiaDia diadia;
	private Attrezzo bastone;
	private Stanza aula;
	
	@BeforeEach
	void setUp() throws Exception
	{
		this.diadia = new DiaDia();
		this.bastone = new Attrezzo("bastone",3);
		this.aula = new Stanza("aula");
	}
	
	
	@Test
	void testPrendi() {
		this.diadia.getPartita().setStanzaCorrente(aula);
		this.aula.addAttrezzo(bastone);
		
		assertEquals(bastone,this.diadia.getPartita().getStanzaCorrente().getAttrezzo("bastone"));
		assertTrue(this.diadia.getPartita().getStanzaCorrente().hasAttrezzo("bastone"));
		this.diadia.getPartita().getStanzaCorrente().removeAttrezzo(bastone);
		assertFalse(this.diadia.getPartita().getStanzaCorrente().hasAttrezzo("bastone"));
		this.diadia.getPartita().getGiocatore().getBorsa().addAttrezzo(bastone);
		assertTrue(this.diadia.getPartita().getGiocatore().getBorsa().hasAttrezzo("bastone"));
	}

}
