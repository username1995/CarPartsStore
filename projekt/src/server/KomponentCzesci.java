package server;

public abstract class KomponentCzesci extends Czesc {
	protected String name; 

	 
	  public abstract void add(KomponentCzesci component); 
	   public abstract void remove(KomponentCzesci component); 
	    public abstract KomponentCzesci getComponent(int index); 
	 public abstract String getNazwa(); 
	   public abstract void wyswietlNazwa(); 

}
