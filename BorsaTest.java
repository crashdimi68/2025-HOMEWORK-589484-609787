package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	
	
	@BeforeEach
	public  void  SetUp() {
		borsa  = new Borsa();
	}
	
	

	//Test Get Peso Max
	@Test
	void testGetPesoMaxZero() {
		Borsa borsa = new Borsa(0);
		assertEquals(0,borsa.getPesoMax());
	}
	
	
	@Test
	void TestGetPesoMaxDefault() {
		Borsa borsa = new Borsa();
		assertEquals(Borsa.DEFAULT_PESO_MAX_BORSA, borsa.getPesoMax());
	}
	
	@Test
	void testGetPesoMax() {
		Borsa borsa = new Borsa(28);
		assertEquals(28,borsa.getPesoMax());
	}
	
	
	
	//Test GetPeso
	@Test
	void TestGetPesoBorsaEmpty() {
		Borsa borsa = new Borsa();
		assertEquals(0,borsa.getPeso());	
	}
	
	@Test
	void TestGetPesoUnAttrezzo() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Lima",1);
		borsa.addAttrezzo(attrezzo);
		assertEquals(1,borsa.getPeso());
	}
	
	@Test
	void TestGetPesoPiuAttrezzi() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo1 = new Attrezzo("Pinza",4);
		Attrezzo attrezzo2 = new Attrezzo("Martello",5);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		assertEquals(9,borsa.getPeso());
		
	}
	
	
	
	//Test isEmpty
	
	@Test
	void TestBorsaEmpty() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test

	void TestBorsaNotEmpty() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Chiave Inglese",2);
		borsa.addAttrezzo(attrezzo);
		assertFalse(borsa.isEmpty());
	}
	
	@Test
	void TestBorsaIsEmpty() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Cacciavite",3);
		borsa.addAttrezzo(attrezzo);
		borsa.removeAttrezzo("Cacciavite");
		assertTrue(borsa.isEmpty());
	}
	
	
	
	
}
