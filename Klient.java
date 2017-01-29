package server;

import java.io.Serializable;

public class Klient implements Serializable {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiejscowosc() {
		return miejscowosc;
	}
	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getNrMieszkania() {
		return nrMieszkania;
	}
	public void setNrMieszkania(String nrMieszkania) {
		this.nrMieszkania = nrMieszkania;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@Override
	public String toString() {
		return "Klient [id=" + id + ", login=" + login + ", haslo=" + haslo + ", imie=" + imie + ", nazwisko="
				+ nazwisko + ", email=" + email + ", miejscowosc=" + miejscowosc + ", ulica=" + ulica
				+ ", nrMieszkania=" + nrMieszkania + ", telefon=" + telefon + ", zamowienie=" + zamowienie + "]";
	}
	private int id;
	private String login;
	private String haslo;
	private String imie;
	private String nazwisko;
	private String email;
	private String miejscowosc;
	private String ulica;
	private String nrMieszkania;
	private String telefon;
	private Zamowienie zamowienie;
	
	public Klient(String login, String haslo) {
		super();
		this.login = login;
		this.haslo = haslo;
	}
	public Klient(int id, String login, String haslo, String imie, String nazwisko, String email, String miejscowosc,
			String ulica, String nrMieszkania, String telefon) {
		super();
		this.id = id;
		this.login = login;
		this.haslo = haslo;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
		this.nrMieszkania = nrMieszkania;
		this.telefon = telefon;
	
	}
	public Zamowienie getZamowienie() {
		return zamowienie;
	}
	public void setZamowienie(Zamowienie zamowienie) {
		this.zamowienie = zamowienie;
	}


}
