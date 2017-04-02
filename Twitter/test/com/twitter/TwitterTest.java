package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterTest {
	
	private Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testUnesi() {
		t.unesi("tijana", "random poruka");
		
		assertEquals ("tijana", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals ("random poruka", t.vratiSvePoruke().getLast().getPoruka());
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
