package server;

public class Zamowienie {
	private int id;
	private Klient klient;
	private boolean akceptacja;;
	private Czesc czesc1;
	private int ilosc1;
    private Czesc czesc2;
	private int ilosc2;
    private Czesc czesc3;
	private int ilosc3;
	private Float wartosc;

public Zamowienie(int id, Klient klient, boolean akceptacja, Czesc czesc1, int ilosc1, Czesc czesc2, int ilosc2,
		Czesc czesc3, int ilosc3, Float wartosc) {
	super();
	this.id = id;
	this.klient = klient;
	this.akceptacja = akceptacja;
	this.czesc1 = czesc1;
	this.ilosc1 = ilosc1;
	this.czesc2 = czesc2;
	this.ilosc2 = ilosc2;
	this.czesc3 = czesc3;
	this.ilosc3 = ilosc3;
	this.wartosc = wartosc;
}
  
  
  
}
