package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private static final String MESSAGGIO_BUIO = "qui c'è un buio pesto";
	
	private String AttrezzoLuce;

	public StanzaBuia(String nome, String AttrezzoLuce) {
		super(nome);
		this.AttrezzoLuce=AttrezzoLuce;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(AttrezzoLuce))
			return MESSAGGIO_BUIO;
		else
			return super.getDescrizione();	
	}	
}
