package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class LabirintoTest {
	Labirinto l;
	Stanza biblioteca;
	Stanza rettorato;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();

		biblioteca = new Stanza("Biblioteca");
		rettorato = new Stanza("rettorato");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(rettorato);
		assertEquals(rettorato, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

}	//PROVA CONSEGNA DEFINITIVA HOMEWORK C 25
