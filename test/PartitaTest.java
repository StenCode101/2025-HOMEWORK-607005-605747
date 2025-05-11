import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.partita.Partita;

import org.junit.jupiter.api.BeforeEach;



class PartitaTest {
	
	private Partita partita;
	
	@BeforeEach
	void setUp() throws Exception{
		this.partita = new Partita();
	}
	
	
	
	@Test
	void testNuovaPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testNuovaPartitaNonFinitaEPoiFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
		}
	
	@Test
	void testPartitaFinitaVinta() {
		partita.setStanzaCorrente(partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testPartitaFinitaPersa() {
		partita.getGiocatore().setCfu(0);
		assertFalse(this.partita.vinta());
	}
	
}
