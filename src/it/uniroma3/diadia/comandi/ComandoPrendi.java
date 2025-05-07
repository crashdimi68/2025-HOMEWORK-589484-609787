package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String attrezzoTerra;
	private IO io;
	
	
	public ComandoPrendi(IO io) {
		this.io=io;
	}
	
	@Override 
	public void esegui(Partita partita) {
		
		Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoTerra);
		if(attrezzo==null) {
			io.mostraMessaggio("attrezzo non presente nella stanza / inserisci l'attrezzo da prendere");
		}
		else {
			if(partita.getBorsa().addAttrezzo(attrezzo)) {
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
				io.mostraMessaggio("hai raccolto l'attrezzo!");
			}else {
				io.mostraMessaggio("qualcosa è andato storto :( ");
			}
			
		}
		
	}

	@Override 
	public void setParametro(String parametro) {
		this.attrezzoTerra=parametro;
	}
	
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	
}
