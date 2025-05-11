package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Simulazione {
	public static IOSimulator creaSimulazionePartitaEGioca(String... comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		new DiaDia(io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEStanza(Stanza stanza, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanza.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
}
