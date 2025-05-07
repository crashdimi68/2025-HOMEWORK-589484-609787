package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io=io;
	}
	
	@Override
	public void esegui(Partita partita) {
		
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getBorsa().toString());
		io.mostraMessaggio("ti restano: " +partita.getGiocatore().getCfu()+ "CFU");	
		
	}
	
	
	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	
	
}
