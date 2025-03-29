package it.uniroma3.diadia.giocatore;


public class Giocatore {

	public static int CFU_INIZIALI = 20;
	public int cfu;

	
	public Giocatore() {
		this.cfu= CFU_INIZIALI;
	}
	
	/**
	 * Restituisce CFU giocatore
	 * @return cfu
	 */

	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Imposta i CFU giocatore
	 * @param cfu
	 */

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	/**
	 * Restituisce stringa giocatore
	 * @return rappresentazione stringa
	 */
	@Override
	
	public String toString() {
		return "CFU  = " + this.getCfu();
	}
	
}
