
//public @interface StanzaTest2 {}

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest2{
	
	public static void main(String[] args) {
		
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		
		Attrezzo tazzina = new Attrezzo("tazzina", 1);
		Attrezzo piatto = new Attrezzo("piatto", 2);
		
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
		
		Stanza stanzaNordBar = new Stanza("stanzaNordBar");
		stanzaNordBar=bar.getStanzaAdiacente("nord");
		
		Stanza stanzaSudMensa = new Stanza("stanzaSudMensa");
		stanzaSudMensa=mensa.getStanzaAdiacente("sud");
		
		
		System.out.println("descrizione stanza nord bar: " + stanzaNordBar.getDescrizione());
		System.out.println("");
		System.out.println("descrzione stanza sud della mensa: " + stanzaSudMensa.getDescrizione());
		
		
		
	}
	
}
