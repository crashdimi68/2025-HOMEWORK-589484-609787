
//public @interface StanzaTest1 {}

	
public class StanzaTest1 {
	
	public static void main(String[] args) {
			
	Stanza bar = new Stanza("bar");
	Stanza mensa = new Stanza("mensa");
	
	bar.impostaStanzaAdiacente("nord", mensa);
	mensa.impostaStanzaAdiacente("sud", bar);
	
	Stanza stanzaNordBar = new Stanza("stanzaNordBar");
	stanzaNordBar=bar.getStanzaAdiacente("nord");
	
	Stanza stanzaSudMensa = new Stanza("stanzaSudMensa");
	stanzaSudMensa=mensa.getStanzaAdiacente("sud");
	
	
	System.out.println("descrizione stanza nord bar: " + stanzaNordBar.getDescrizione());
	System.out.println("");
	System.out.println("descrzione stanza sud della mensa: " + stanzaSudMensa.getDescrizione());
	
	
	
	
	
			
	
	
	
	}
		
		
		
}	
	
	
	
	

