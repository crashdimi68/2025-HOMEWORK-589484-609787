package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	
	private Labirinto labirinto;
	@BeforeEach
	
	public  void  SetUp() {
		labirinto  = new Labirinto();
	}

	/**
	 * Test Stanza Vincente
	 */
	
	@Test
	public void TestGetStanzaVincenteCorretta() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void TestGetStanzaVincenteNotNull() {
		Labirinto labirinto = new Labirinto();
		assertNotNull(labirinto.getStanzaVincente());
	}
	
	@Test
	public void TestGetStanzaVincenteNull() {
		Labirinto labirinto = new Labirinto();
		assertNull(labirinto.getStanzaVincente());
		
	}
	
	/** 
	 * Test  set stanza Corrente
	 */
	
	@Test
	public void TestSetStanzaCorrenteValida() {
		Labirinto labirinto = new Labirinto();
		Stanza n10 = new Stanza("Aula n10");
		labirinto.setStanzaCorrente(n10);
		assertEquals("Aula n10", labirinto.getStanzaCorrente().getNome());

		
	}
	
	@Test
	public void TestSetStaznaCorrenteNulla() {
		Labirinto labirinto = new Labirinto();
		labirinto.setStanzaCorrente(null);
		assertNull(labirinto.getStanzaCorrente());

	}
	
	@Test
	public void TestSetStanzaCorrenteSovrascritta() {
		Labirinto labirinto = new Labirinto();
		Stanza aulaN18 = new Stanza("Aula N18");
		labirinto.setStanzaCorrente(aulaN18);
		Stanza aulaStudio = new Stanza("Aula Studio");
		labirinto.setStanzaCorrente(aulaStudio);
		assertEquals("Aula studio", labirinto.getStanzaCorrente().getNome());

	}
	
	/**
	 * test get stanza corrente
	 */
	
	
	@Test
	public void TestGetStanzaCorrenteValida() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void TestGetStanzaCorrenteNull() {
		Labirinto labirinto = new Labirinto();
		labirinto.setStanzaCorrente(null);
		assertNull(labirinto.getStanzaCorrente());
		
	}
	
	@Test
	public void TestGetStanzaCorrente() {
		Labirinto labirinto = new Labirinto();
		Stanza campus = new Stanza("Aula Campus");
		Stanza laboratorio = new Stanza("Laboratorio");
		labirinto.setStanzaCorrente(campus);
		labirinto.setStanzaCorrente(laboratorio);
		
		assertEquals("Aula Campus", labirinto.getStanzaCorrente().getNome());
		assertEquals("Laboratorio", labirinto.getStanzaCorrente().getNome());
	}
	
	
	/**
	 * test vinta
	 */
	
	@Test
	public void TestPartitaVinta() {
		Labirinto labirinto = new Labirinto();
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(labirinto.vinta());
	}
	
	@Test
	public void TestPartitaNonVinta() {
		Labirinto labirinto = new Labirinto();
		Stanza aulaN11 = new Stanza("Aula n11");
		labirinto.setStanzaCorrente(aulaN11);
		assertFalse(labirinto.vinta());
		
	}
	
	
	@Test
	public void TestPartitaNull() {
		Labirinto labirinto = new Labirinto();
		assertFalse(labirinto.vinta());
	}

}
