package it.uniroma3.diadia;

import it.uniroma3.diadia.IOConsole.*;


import java.util.Scanner;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private Giocatore giocatore;
	private Borsa borsa;
	private IO io;
	
	public DiaDia(IO console) {
		this.partita = new Partita();
		this.giocatore = new Giocatore();
		this.borsa = new Borsa();
		this.io = console;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;		
		//System.out.println(MESSAGGIO_BENVENUTO);
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));	
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	
	/* private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

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
			io.mostraMessaggio("comando sconosciuto!");
		if (this.partita.getLabirinto().vinta()) {
			io.mostraMessaggio("hai vinto!!");
			return true;
		} else
			return false;
	}   */
	
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.isVinta()) 				
		System.out.println("Hai vinto!");
		
		
		if (!this.partita.giocatoreIsVivo())			
		System.out.println("Hai esaurito i CFU... Hai perso mi dispiace"); 	//bisogna mettere verifica cfu

		return this.partita.isFinita();
		}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
			io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int appoggioCfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--appoggioCfu);
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("cfu: " + partita.getGiocatore().getCfu());
	}

	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	/*private void prendi(String attrezzoTerra) {
		
		/*if(attrezzoTerra==null) {
			System.out.println("seleziona l'attrezzo che vuoi raccogliere");
		}
		Attrezzo attrezzo = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoTerra);
		if(attrezzo==null) {
			io.mostraMessaggio("attrezzo non presente nella stanza / inserisci l'attrezzo da prendere");
		}
		else {
			if(this.partita.getBorsa().addAttrezzo(attrezzo)) {
				this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
				io.mostraMessaggio("hai raccolto l'attrezzo!");
			}else {
				io.mostraMessaggio("qualcosa è andato storto :( ");
			}
			
		}				
	}
	
	
	private void posa(String attrezzoDaPosare) {
		
		Attrezzo attrezzo = this.partita.getBorsa().getAttrezzo(attrezzoDaPosare);
		if(attrezzo==null) {
			io.mostraMessaggio("non hai questo attrezzo nella tua borsa");
		}
		else {
			if(this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo)) {
				this.partita.getBorsa().removeAttrezzo(attrezzoDaPosare);
				io.mostraMessaggio("oggetto posato dalla borsa alla stanza!");
			}else {
				io.mostraMessaggio("ops qualcosa è andato storto");
			}
		}
		
	}*/

	public static void main(String[] argc) {
		IO console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}