package ambientiTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private Attrezzo a;
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	
	
	@Before
	public void setUp() throws Exception {
		stanzaBloccata = new StanzaBloccata("Atrio", "passepartout", "ovest");
		stanzaAdiacente = new Stanza("Laboratorio");
		a = new Attrezzo("passepartout", 1);
		stanzaBloccata.impostaStanzaAdiacente("ovest", stanzaAdiacente);	
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("ovest"));
	}	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		stanzaBloccata.addAttrezzo(a);
		assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("ovest"));
		
	}
	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		stanzaBloccata.addAttrezzo(a);
		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
	}	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String messaggio = "la stanza sembra essere bloccata nella direzione: ovest" + 
		           "\nper accedervi bisogna possedere: passepartout" +
		           "\ne lasciarlo qui nella stanza";
		assertEquals(messaggio, stanzaBloccata.getDescrizione());
	}

}
