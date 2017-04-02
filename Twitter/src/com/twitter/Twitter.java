package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka; 

/**
 * Klasa <b>Twitter</b> koja radi sa twitter porukama
 * 
 * @author Tijana Ninkovic
 * @version 1.0
 *
 */
public class Twitter {
	
	/**
	 * Lista twitter poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>(); 
	
	/**
	 * Vraca listu svih twitter poruka
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){ 
		return poruke; 
	} 
	
	/**
	 * Unosi novu poruku sa zadatim parametrima na kraj liste twitter poruka
	 * @param korisnik ime korisnika
	 * @param poruka sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) { 
		//Pravi se nova poruka i puni podacima. 
		TwitterPoruka tp = new TwitterPoruka(); 
		tp.setKorisnik("korisnik"); 
		tp.setPoruka(poruka); 
		
		//Poruka se unosi u listu na kraj 
		poruke.addLast(tp);
	}
		 
	/**
	 * Pretrazuje listu poruka i vraca niz sa svim porukama koje sadrze zadati tag 
	 * @param maxBroj maksimalan broj poruka koje metoda vraca
	 * Ako uneta vrednost nije veca od nule, maksimalan broj se postavlja na 100
	 * @param tag string na osnovu kojeg se vracaju poruke
	 * @return niz poruka koje sadrze tag
	 * @throws java.lang.RuntimeException ako je tag:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) { 
		if (tag==null || tag.isEmpty()) 
			throw new RuntimeException("Morate uneti tag"); 
		
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka 
		if (maxBroj<=0) 
			maxBroj = 100;     
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka 
		int brojac = 0; 
		
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace 
		//sve poruke koje u sebi imaju zadati tag
		
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj]; 
		
		//Pretrazuju se poruke i traze se one koje sadrze tag. 
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj 
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga 
		//se prekida. 
		
		for (int i = 0; i < poruke.size(); i++) 
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1) 
				if (brojac < maxBroj){ 
					rezultat[brojac+1]=poruke.get(i); 
					brojac++; 
				} 
				else break; 
		 return rezultat;
	}

}
