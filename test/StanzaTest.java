import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;


class StanzaTest {
	private Stanza stanza;
	private Attrezzo spada;
	private Attrezzo lancia;
	private Attrezzo bastone;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("n11");
		this.spada = new Attrezzo("spada",10);
		this.lancia= new Attrezzo("lancia",5);
		this.bastone = new Attrezzo("bastone",7);
	}

	
	@Test
	void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testRemoveAttrezzoSolo() {
		assertFalse(this.stanza.removeAttrezzo(spada));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.removeAttrezzo(spada));
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testRemoveAttrezzoMultipli() {

		this.stanza.addAttrezzo(this.spada);
		this.stanza.addAttrezzo(this.lancia);
		this.stanza.addAttrezzo(this.bastone);
		assertTrue(this.stanza.removeAttrezzo(lancia));
		assertFalse(this.stanza.hasAttrezzo("lancia"));
		assertTrue(this.stanza.hasAttrezzo("spada"));
		assertTrue(this.stanza.hasAttrezzo("bastone"));
		
		assertTrue(this.stanza.removeAttrezzo(spada));
		assertTrue(this.stanza.removeAttrezzo(bastone));
		
	}

}
