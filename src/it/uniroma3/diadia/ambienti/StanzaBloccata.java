package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{

	
	
	private String direzioneBloccata;
	private String passepartout;
	
	/*private static final String MESSAGGIO = "la stanza sembra essere bloccata nella direzione: "+ direzioneBloccata+ 
			"\nper accedervi bisogna possedere: "+ passepartout+
			"\ne lasciarlo qui nella stanza";*/
			 	
	
	public StanzaBloccata (String nome, String passepartout, String direzioneBloccata) {
		super(nome);
		this.passepartout=passepartout;
		this.direzioneBloccata=direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if((direzioneBloccata.equals(direzione))&&!this.hasAttrezzo(passepartout)) {
			return this;
		}
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	
	@Override
	public String getDescrizione() {
		String messaggio = "la stanza sembra essere bloccata nella direzione: "+ direzioneBloccata+ 
				"\nper accedervi bisogna possedere: "+ passepartout+
				"\ne lasciarlo qui nella stanza";
		if(!this.hasAttrezzo(passepartout))
			return messaggio;
		else {
			return super.getDescrizione();
		}
	}
	
}