package ambientiTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza stanza;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Stanza laboratorio;
	
	

	@BeforeEach
	public void setUp() {
		stanza = new Stanza("stanza");
		laboratorio = new Stanza("Laboratorio");
		attrezzo1 = new Attrezzo("attrezzo1", 1);
		attrezzo2 = new Attrezzo("attrezzo2", 2);
		attrezzo3 = new Attrezzo("attrezzo3", 3);
		laboratorio.addAttrezzo(attrezzo2);
	}
	
	//Test per getStanzaAdiacente
	@Test
	public void testGetStanzaAdiacenteGiusta() {
	    Stanza atrio = new Stanza("Atrio");
	    Stanza aulaN11 = new Stanza("Aula N11");
	    atrio.impostaStanzaAdiacente("est", aulaN11);
	    Stanza stanzaAdiacente = atrio.getStanzaAdiacente("est");
	    assertEquals("Aula N11", stanzaAdiacente.getNome());
	}
	
	@Test
	public void testGetStanzaAdiacenteErrata() {
		Stanza aulaN11 = new Stanza("Aula N11");
		stanza.impostaStanzaAdiacente("sud", aulaN11);
		assertNotEquals("Aula N11", stanza.getStanzaAdiacente("nord"));
		
	}
	@Test
	public void testGetStanzaAdiacenteNull() {
		Stanza atrio = new Stanza("atrio");
		stanza.impostaStanzaAdiacente("nord", atrio);
		assertNull(stanza.getStanzaAdiacente("sud"));
	}
	
	
	//test per impostaStanzaAdiacente
	@Test
	public void testImpostaStanzaAdiacenteGiusta() {
		Stanza atrio = new Stanza("atrio");
		Stanza biblioteca = new Stanza("biblioteca");
		biblioteca.impostaStanzaAdiacente("nord", atrio);
		Stanza verifica = biblioteca.getStanzaAdiacente("nord");
		assertEquals("atrio", verifica.getNome());		
	}
	
	
	@Test
	public void testImpostaStanzaAdiacenteSovrascrittura() {
	    Stanza atrio = new Stanza("atrio");
	    Stanza aulaN11 = new Stanza("aula N11");
	    Stanza aulaN10 = new Stanza("aula N10");	    
	   
	    atrio.impostaStanzaAdiacente("nord", aulaN11);
	    Stanza stanzaAdiacente = atrio.getStanzaAdiacente("nord");
	    assertEquals("aula N11", stanzaAdiacente.getNome());	    
	    atrio.impostaStanzaAdiacente("nord", aulaN10);
	    Stanza nuovaStanzaAdiacente = atrio.getStanzaAdiacente("nord");
	    assertEquals("aula N10", nuovaStanzaAdiacente.getNome());
	}
	
	@Test
	public void testImpostaStanzaAdiacenteNull() {
		Stanza atrio = new Stanza("atrio");
		Stanza verifica = atrio.getStanzaAdiacente("nord");
		assertNull(verifica);
	}
	
	
	
	//test per addAttrezzo
	 @Test
	public void testAddAttrezzoOk() {
		 assertTrue(stanza.addAttrezzo(attrezzo1));
	}
	
	 @Test
	public void testAddAttrezzoStanzaPiena() {
	        for(int i = 0; i < 10; i++) {
	            stanza.addAttrezzo(new Attrezzo("attrezzo" + i, i));	        
	        }
	        assertFalse(stanza.addAttrezzo(attrezzo3));
	}
	 
	 
	 @Test
	 public void testAddAttrezzoNull() {
	     assertTrue(stanza.addAttrezzo(null));
	 }


	// Test per il metodo getAttrezzo
		@Test
		public void testGetAttrezzoStanzaVuota() {
			assertNull(new Stanza("stanza").getAttrezzo("attrezzo"));
		}
		
		@Test
		public void testGetAttrezzoStanzaAttrezzoPresente() {
			Stanza stanza = new Stanza("stanza");
			stanza.addAttrezzo(new Attrezzo("attrezzo", 1));
			assertNotNull(stanza.getAttrezzo("attrezzo"));
		}
		
		@Test
		public void testGetAttrezzoStanzaAttrezzoNonPresente() {
			Stanza stanza = new Stanza("stanza");
			stanza.addAttrezzo(new Attrezzo("attrezzo", 1));
			assertNull(stanza.getAttrezzo("attrezzoNonPresente"));
		}
		
		
		
		//test removeAttrezzo
		@Test
		public void testRemoveAttrezzoNonPresente() {		    
		    assertFalse(laboratorio.removeAttrezzo(attrezzo3));
		}
		
		@Test
		public void testRemoveAttrezzoPresente() {
			assertTrue(laboratorio.removeAttrezzo(attrezzo2));
		}
		
		//test hasAttrezzo
		@Test
		public void testHasAttrezzo() {
	        stanza.addAttrezzo(attrezzo2);
	        assertTrue(stanza.hasAttrezzo("attrezzo2"));
	    }
		@Test
	    public void testHasAttrezzoNonEsistente() {
	        assertFalse(stanza.hasAttrezzo("attrezzoNonEsistente"));
	    }

	    @Test
	    public void testHasAttrezzoNull() {
	        assertFalse(stanza.hasAttrezzo(null));
	    }
	 
}	 

