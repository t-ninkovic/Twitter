package com.twitter.poruke;

/**
 * Klasa koja predstavlja twitter poruku
 * 
 * @author Tijana Ninkovic
 * @version 1.0
 *
 */
public class TwitterPoruka {

	/**
	 * Ime korisnika
	 */
	 private String korisnik;
	 /**
	  * Sadrzaj poruke
	  */
	 private String poruka; 
	 
	 /**
	  * Vraca vrednost atributa korisnik
	  * @return string korisnik
	  */
	 public String getKorisnik() { 
		 return korisnik; 
	 }
	 
	 /**
	  * Postavlja novu vrednost za atribut korisnik
	  * @param korisnik
	  * @throws java.lang.RuntimeException ako je uneti string:
	  * <ul>
	  * <li>null</li>
	  * <li>prazan string</li>
	  * </ul>
	  */
	 public void setKorisnik(String korisnik) { 
		 if (korisnik==null || korisnik.isEmpty()) 
			 throw new RuntimeException( "Ime korisnika mora biti uneto"); 
		 this.korisnik = korisnik; 
	 }
	 
	 /**
	  * Vraca vrednost atributa poruka
	  * @return string poruka
	  */
	 public String getPoruka() { 
		 return poruka; 
	 }
	 
	 /**
	  * Postavlja novu vrednost za atribut poruka
	  * @param poruka
	  * @throws java.lang.RuntimeException ako je uneti string:
	  * <ul>
	  * <li>null</li>
	  * <li>prazan string</li>
	  * <li>duzi od 140 znakova</li>
	  * </ul>
	  */
	 public void setPoruka(String poruka) { 
		 if (poruka==null || poruka.isEmpty() || poruka.length() > 140) 
			 throw new RuntimeException( "Poruka mora biti uneta i mora imati najvise 140 znakova"); 
		 this.poruka = poruka; 
	 } 
	 
	 /**
	  * Vraca string sa svim atributima klase
	  * @return ime korisnika i sadrzaj poruke
	  */
	 public String toString(){ 
		 return "KORISNIK:"+korisnik+" PORUKA:"+poruka; 
	 }

}
