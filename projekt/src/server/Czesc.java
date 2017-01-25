package server;

public abstract class Czesc implements Cloneable{
private int id;
private String nazwa;
private Float cena;
private int ilosc;
private String opis;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}
public Float getCena() {
	return cena;
}
public void setCena(Float cena) {
	this.cena = cena;
}
public int getIlosc() {
	return ilosc;
}
public void setIlosc(int ilosc) {
	this.ilosc = ilosc;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}

}
