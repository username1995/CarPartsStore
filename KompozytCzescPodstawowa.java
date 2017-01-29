package server;

import java.util.ArrayList;

public class KompozytCzescPodstawowa extends KomponentCzesci {

	public KompozytCzescPodstawowa(String name) { 
		     this.name = name; 
		   } 
	
		 
		   @Override 
		   public void add(KomponentCzesci component) { 
	
		 
	   } 
		
		 
	   @Override 
		     public void remove(KomponentCzesci component) { 
	
		 
    } 
	 
		 
	     @Override 
	   public KomponentCzesci getComponent(int index) { 
	        return null; 
		    } 
	
		 
		     @Override 
	    public String getNazwa() { 
	       return name; 
	    } 
		
		 
		   @Override 
		   public void wyswietlNazwa() { 
		        System.out.println(name); 
		    } 
		   
		   public ArrayList<KomponentCzesci> zwroc(){return null;}
	 } 

	
	
	
