package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Labirinto;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	/*private Stanza stanzaCorrente;
	private Stanza stanzaVincente;*/
	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;
	
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore= new Giocatore();
		this.finita = false;
	}
    
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || this.labirinto.vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	
	
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
}
