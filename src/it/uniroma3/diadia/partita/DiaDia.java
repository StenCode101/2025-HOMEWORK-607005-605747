package it.uniroma3.diadia.partita;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.Stanza;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	
	private IOConsole io;
	private Partita partita;
	
	public DiaDia() {
		this.io = new IOConsole();
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome()==null) return false;
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			 this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			 this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio( "Comando sconosciuto");
		//se lasciato this.partita.vinta() posso uscire dal sistema solo se vinco anche se ci sono altre casistiche
		if(this.partita.isFinita())
		{
			if (this.partita.vinta()) {
				this.io.mostraMessaggio("Hai vinto!");
			}
			return true;//finisce la partita a prescindere dalla vittoria
			
		}
		return false;
	}   

	// implementazioni dei comandi dell'utente:
	
	/** 
	 * mi consente di prendere un oggetto da una stanza*/
	public void prendi(String attrezzo)
	{
		Attrezzo attrezzoDaPrendere  = new Attrezzo();
		
		if(attrezzo==null)
		{
			this.io.mostraMessaggio("che oggetto vuoi prendere?");
			this.io.mostraMessaggio(this.partita.toString());
		}
		else
		{
			if(this.partita.getStanzaCorrente().hasAttrezzo(attrezzo))
			{
			
				attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
				if(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere))
				{	
					this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
					this.io.mostraMessaggio("oggetto acquisito");
				}
				else
				{
					this.io.mostraMessaggio("borsa piena");
				}
			}else
				this.io.mostraMessaggio("oggetto non presente nella stanza");
			
			this.io.mostraMessaggio(this.partita.toString());

		}
		
		
	}
	
	
	/** 
	 * mi consente di posare un oggetto da una stanza*/
	public void posa(String attrezzo)
	{
		if(attrezzo==null)
		{
			this.io.mostraMessaggio("che oggetto vuoi posare?");
			this.io.mostraMessaggio(this.partita.toString());


		}
		else
		{
			Attrezzo attrezzoDaPosare = new Attrezzo();;
			if(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo))
			{
				
				attrezzoDaPosare = this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
				this.io.mostraMessaggio("oggetto posato correttamente nella stanza corrente");
			}
			else
				this.io.mostraMessaggio("il giocatore non possiede questo oggetto");
			this.io.mostraMessaggio(this.partita.toString());

		}
		
	} 

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);;//perché come in C, il comando in prefisso viene eseguito e poi restituito il valore
									   //se fosse stato (cfu--) prima usa il valore cfu e poi lo aggiorna togliendo 1
		}
		
		this.io.mostraMessaggio(this.partita.toString());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
		
	}
	
	public Partita getPartita()
	{
		return this.partita;
	}
	
	
}