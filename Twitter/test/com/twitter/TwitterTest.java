package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterTest {
	
	private Twitter t;
	private TwitterPoruka tp;
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
		tp = null;
	}
	
	@Test
	public void testVratiSvePoruke(){
		t.unesi("tijana", "abc");
		t.unesi("leia", "may the force be with you");
		
		assertEquals("leia", t.vratiSvePoruke().get(1).getKorisnik());
		assertEquals("may the force be with you", t.vratiSvePoruke().get(1).getPoruka());
		assertEquals(2, t.vratiSvePoruke().size());
		
	}

	@Test
	public void testUnesi() {
		
		t.unesi("clark kent", "son of krypton");
		t.unesi("bruce wayne", "bat of gotham");
		t.unesi("random korisnik", "random poruka");
		
		tp.setKorisnik("random korisnik");
		tp.setPoruka("random poruka");
		
		assertEquals (tp.toString(), t.vratiSvePoruke().getLast().toString());
		assertEquals(3, t.vratiSvePoruke().size());
		
	}

	@Test
	public void testVratiPoruke() {
				
		t.unesi("tijana", "twitter is the best social network");
		t.unesi("pera", "asdfghjkl");
		t.unesi("ana", "poruka twitter");
		
		assertEquals (t.vratiSvePoruke().get(0), t.vratiPoruke(2, "twitter")[0]);
		assertEquals (t.vratiSvePoruke().get(2), t.vratiPoruke(2, "twitter")[1]);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(2, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(2, "");
	}

}
