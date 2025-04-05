package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {
	
	private Partita partita;
	
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
	}

	//test per isFinita	
	
	@Test
	public void testIsFinitaPartitaTerminata() {
	    partita.setFinita();
	    assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinitaPartitaVinta() {
	    Labirinto labirinto = partita.getLabirinto();
	    labirinto.setStanzaCorrente(labirinto.getStanzaVincente()); 
	    assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaGiocatoreFinisceCFU() {
	    partita.getGiocatore().setCfu(0); 
	    assertTrue(partita.isFinita());
	}

	
	//test per setFinita	
	
	@Test
	public void testSetFinitaDoppioConfronto() {
		assertFalse(partita.isFinita());
	    partita.setFinita();
	    assertTrue(partita.isFinita());
	}

	@Test
	public void testSetFinitaVerificaIsFinitaSubito() {
		partita.setFinita();
	    assertTrue(partita.isFinita());
	}

	

	
	

}
