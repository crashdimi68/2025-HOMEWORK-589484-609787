package diadia;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class AttrezzoTest {

	//test per la funzione getNome
	
	@Test	
	public void testNome() {
		Attrezzo attrezzo = new Attrezzo("martello", 7);
		assertEquals("martello", attrezzo.getNome());
	}
	@Test
	public void testNomeVuoto() {
		Attrezzo attrezzo = new Attrezzo("", 5);
		assertEquals("", attrezzo.getNome());
	}
	@Test
	public void testNomeNull() {
		Attrezzo attrezzo = new Attrezzo(null, 6);
		assertEquals(null, attrezzo.getNome());
	}
	
	//test per la funzione getPeso
	
	@Test
	public void testPeso() {
		Attrezzo attrezzo = new Attrezzo("cacciavite", 5);
		assertEquals(5, attrezzo.getPeso());
	}
	@Test
	public void testPesoZero() {
		Attrezzo attrezzo = new Attrezzo("cacciavite", 0);
		assertEquals(0, attrezzo.getPeso());
	}
	@Test
	public void testPesoNegativo() {
		Attrezzo attrezzo = new Attrezzo("cacciavite", -5);
		assertEquals(-5, attrezzo.getPeso());
	}
	
	
	//test per la funzione toString
	@Test
	public void testStringa() {
		Attrezzo attrezzo = new Attrezzo("brucola", 6);
		assertEquals("brucola (6kg)", attrezzo.toString());
	}
	@Test
	public void testStringaVuoto() {
		Attrezzo attrezzo = new Attrezzo("", 0);
		assertEquals(" (0kg)",attrezzo.toString());
	}
	@Test
	public void testStringaNull() {
		Attrezzo attrezzo = new Attrezzo(null, 6);
		assertEquals("null (6kg)", attrezzo.toString());
	}
	
	
	
	
	
	
	
}
