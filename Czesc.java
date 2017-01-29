package server;

import java.io.Serializable;

public class Czesc implements Serializable{
private int id;
private String nazwa;
private Float cena;
private int ilosc;
private String opis;




@Override
public String toString() {
	return "Czesc [id=" + id + ", nazwa=" + nazwa + ", cena=" + cena + ", ilosc=" + ilosc + ", opis=" + opis + "]";
}

public Czesc(int id, String nazwa, Float cena) {
	super();
	this.id=id;
	this.nazwa = nazwa;
	this.cena = cena;
}

public Czesc(String nazwa) {
	super();
	this.nazwa = nazwa;
}
public Czesc() {
	super();
}
public Czesc clone()
{
    Czesc sklonowane = null;
    try
    {
        sklonowane = (Czesc) super.clone(); 
      //  sklonowane.setPrice(price);
        sklonowane.setNazwa(nazwa);
    }
    catch (CloneNotSupportedException e)
    {
        e.printStackTrace();
    }
    return sklonowane;
}

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
