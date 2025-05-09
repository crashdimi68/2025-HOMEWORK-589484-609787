package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	private IO io;
	
	public ComandoFine(IO io) {
		this.io=io;
	}
	
	@Override 
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio("partita conclusa, grazie di aver giocato!");
	}
	
	
	
	@Override
	public void setParametro(String parametro) {		
	}
	
	
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
}
