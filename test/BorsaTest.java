

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo spada;
	private Attrezzo lancia;
	private Attrezzo scudo;
	private Attrezzo matita;
	private Attrezzo penna;
	
	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa(10);
		this.spada = new Attrezzo("spada",2);
		this.lancia = new Attrezzo("lancia",5);
		this.scudo = new Attrezzo("scudo",7);
		this.matita = new Attrezzo("matita",1);
		this.penna = new Attrezzo("penna",1);
	}
	
	@Test
	void testAddAttrezzo() {
		
		this.borsa.addAttrezzo(this.spada);
		assertEquals(this.spada,this.borsa.getAttrezzo("spada"));
		this.borsa.addAttrezzo(this.lancia);
		assertEquals(this.lancia,this.borsa.getAttrezzo("lancia"));
	}
	
	@Test
	void testAddAttrezzoBorsaPienaPeso() {
		
		this.borsa.addAttrezzo(this.spada);
		this.borsa.addAttrezzo(this.lancia);
		this.borsa.addAttrezzo(this.scudo);
		assertNull(this.borsa.getAttrezzo("scudo"));
	}
	
	@Test
	void testAddAttrezzoBorsaPienaNumero() {
		
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.matita);
		this.borsa.addAttrezzo(this.penna);
		assertNull(this.borsa.getAttrezzo("penna"));
	}
	
	@Test
	void testGetPeso() {
		this.borsa.addAttrezzo(this.spada);
		assertEquals(this.spada.getPeso(),this.borsa.getPeso());
		this.borsa.addAttrezzo(this.lancia);
		assertEquals(this.lancia.getPeso()+this.spada.getPeso(),this.borsa.getPeso());
		
	}
	
	@Test
	void testIsEmpy() {
		assertTrue(this.borsa.isEmpty());
		this.borsa.addAttrezzo(this.spada);
		assertFalse(this.borsa.isEmpty());
		
	}
	
	@Test
	void testHasAttrezzo() {
		assertFalse(this.borsa.hasAttrezzo("spada"));
		this.borsa.addAttrezzo(this.spada);
		assertTrue(this.borsa.hasAttrezzo("spada"));
		this.borsa.addAttrezzo(this.lancia);
		assertTrue(this.borsa.hasAttrezzo("lancia"));
	}
	
	@Test
	void testRemoveAttrezzoEsistenteEnon() {
		
		assertNull(this.borsa.removeAttrezzo("spada"));
		this.borsa.addAttrezzo(this.spada);
		assertEquals(this.spada,this.borsa.removeAttrezzo("spada"));
		
		assertFalse(this.borsa.hasAttrezzo("spada"));
		
		assertNull(this.borsa.removeAttrezzo("lancia"));
		this.borsa.addAttrezzo(lancia);
		assertEquals(this.lancia,this.borsa.removeAttrezzo("lancia"));
		
		assertFalse(this.borsa.hasAttrezzo("lancia"));
		
	}
	


}
