package server;

public class Klient {
	private int id;
	private String login;
	private String haslo;
	private String imie;
	private String nazwisko;
	private String ulica;
	private String nrZamieszkania;
	private String telefon;
	private int ilosc;
	private String opis;
	private Zamowienie zamowienie;
	
	public Klient(int id, String login, String haslo, String imie, String nazwisko, String ulica, String nrZamieszkania,
			String telefon, int ilosc, String opis, Zamowienie zamowienie) {
		super();
		this.id = id;
		this.login = login;
		this.haslo = haslo;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.ulica = ulica;
		this.nrZamieszkania = nrZamieszkania;
		this.telefon = telefon;
		this.ilosc = ilosc;
		this.opis = opis;
		this.zamowienie = zamowienie;
	}
	
	

}
