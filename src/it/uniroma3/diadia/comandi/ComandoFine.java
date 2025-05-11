package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	final static public String MESSAGGIO_FINE = "partita conclusa, grazie di aver giocato!";
	private IO io;
	
	public ComandoFine(IO io) {
		this.io=io;
	}
	
	@Override 
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);
	}
	
	
	
	@Override
	public void setParametro(String parametro) {		
	}
	
	
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
}
