package diadia;
 
 import static org.junit.jupiter.api.Assertions.*;
 
 
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;
 
 class GiocatoreTest {
 	
 	private Giocatore giocatore;
 	
 	@BeforeEach 
 	public void setUp() {
 		giocatore = new Giocatore();
 	}
 	
 	
 	@Test
 	public void TestGetCfuInizio() {
 		assertEquals(20,giocatore.getCfu());
 	}
 	
 	
 	@Test
 	public void TestGetCfuCambio() {
 		giocatore.setCfu(24);
 		assertEquals(24,giocatore.getCfu());
 	}
 	
 	
 	@Test
 	public void TestGetCfuNegativo() {
 		giocatore.setCfu(-2);
 		assertEquals(-2,giocatore.getCfu());
 	}
 	
 	
 	
 	
 	
 	@Test
 	public void TestSetCfuCorretto() {
 		giocatore.setCfu(22);
 		assertEquals(22,giocatore.getCfu());
 	}
 	
 	
 	@Test
 	public void TestSetCfuZero() {
 		giocatore.setCfu(0);
 		assertEquals(0,giocatore.getCfu());
 	}
 	
 	
 	@Test
 	public void TestSetCfuNegativo() {
 		giocatore.setCfu(-1);
 		assertEquals(-1,giocatore.getCfu());
 	}
 	
 	
 	
 	
 
 }