package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{

	private String attrezzoDaPosare;
	private IO io;
	
	public ComandoPosa(IO io) {
		this.io=io;
	}
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getBorsa().getAttrezzo(attrezzoDaPosare);
		if(attrezzo==null) {
			io.mostraMessaggio("non hai questo attrezzo nella tua borsa");
		}
		else {
			if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo)) {
				partita.getBorsa().removeAttrezzo(attrezzoDaPosare);
				io.mostraMessaggio("oggetto posato dalla borsa alla stanza!");
			}else {
				io.mostraMessaggio("ops qualcosa è andato storto");
			}
		}
		
	}	
	
	@Override
	public void setParametro(String parametro) {
		this.attrezzoDaPosare=parametro;
	}

	
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	
}	
