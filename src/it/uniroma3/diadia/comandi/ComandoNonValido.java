package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.partita.*;

public class ComandoNonValido extends AbstractComando {

	private final static String NOME = "non valido";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando non valido");
	}
	@Override
	public String getNome() {
		return NOME;
	}
}
