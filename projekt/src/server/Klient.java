package server;

public class Klient {
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
