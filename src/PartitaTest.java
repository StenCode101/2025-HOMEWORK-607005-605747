import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
		partita.setCfu(0);
		assertFalse(this.partita.vinta());
	}
	
}
