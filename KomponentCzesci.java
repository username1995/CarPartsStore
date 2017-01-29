 package server;

import java.util.ArrayList;



public abstract class KomponentCzesci extends Czesc {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name; 

	 
	  public abstract void add(KomponentCzesci component); 
	   public abstract void remove(KomponentCzesci component); 
	   public abstract KomponentCzesci getComponent(int index); 
	   public abstract String getNazwa(); 
	   public abstract void wyswietlNazwa(); 
	   public abstract ArrayList<KomponentCzesci> zwroc();

}
