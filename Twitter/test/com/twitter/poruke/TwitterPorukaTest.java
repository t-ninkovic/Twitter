package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	
	private TwitterPoruka t;

	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testSetKorisnik() {
		t.setKorisnik("tijana");
		assertEquals("tijana", t.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		t.setKorisnik("");
	}

	@Test
	public void testSetPoruka() {
		t.setPoruka("random poruka");
		assertEquals("random poruka", t.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		t.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPreduga() {
		t.setPoruka("Poruka koja je duza od 140 karaktera asdfghjkl asdfghjkl asdfghjkl asdfghjkl asdfghjkl asdfghjkl asdfghjkl asdfghjkl asdfghjkl sdfghjkl asdfghjkl");
	}

	@Test
	public void testToString() {
		t.setKorisnik("tijana");
		t.setPoruka("random poruka");
		assertEquals("KORISNIK:tijana PORUKA:random poruka", t.toString());
	}

}
