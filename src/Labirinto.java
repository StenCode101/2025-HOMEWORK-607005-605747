/**
 * questa classe modella il labirinto inizializzando la stanza iniziale e quella finale
 * 
 *  @see Stanza
 *  @version 0.1.0*/
public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	
	
/**
 *  crea il labirinto e assegna la stanza iniziale e quella finale.
 * @param stanzaIniziale stanza iniziale del labirinto
 * @param stanzaFinale stanza finale del labirinto*/
	
	public Labirinto (Stanza stanzaIniziale, Stanza stanzaFinale) {
		
		this.stanzaIniziale = stanzaIniziale;
		this.stanzaFinale = stanzaFinale;
	}
	
	
	/**restituisce la stanza iniziale del labirinto
	 * @return stanza iniziale */
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	

	/**
	 * restituisce la stanza finale del labirinto
	 * @return stanza finale */
	
	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}
	
	
	/**
	 *  modifica la stanza iniziale
	 * @param stanzaIniziale stanza iniziale del labirinto*/
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		
		this.stanzaIniziale = stanzaIniziale;
	}
	
	
	/**
	 *  modifica la stanza finale
	 * @param stanza finale stanza finale del labirinto*/
	
public void setStanzaFinale(Stanza stanzaFinale) {
		
		this.stanzaFinale = stanzaFinale;
	}
}
/**ciao*/