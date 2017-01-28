package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FabrykaCzesci {
	
	
	private static final String nazwa = null;

	public Czesc getCzesc(String typCzesci){  
	           
	    	 if(typCzesci == null){  
	          return null;  }  
	    	
	    	 else if(typCzesci.equalsIgnoreCase("podstawowa")) {  
	               return new PrototypCzesc(); 
             }   
	         else if(typCzesci.equalsIgnoreCase("zlozona")){  
	       this.zbudujKompozycjeObiektow(nazwa);
         }   
         
	
	   return null;  
  }  

	 public void zbudujKompozycjeObiektow(String model)
	 {
		 
		 KomponentCzesci zawartosc = new KompozytCzescZlozona("calosc");
		
		 KomponentCzesci silnik = new KompozytCzescZlozona("silnik");
		 KomponentCzesci kola = new KompozytCzescZlozona("ko³a");
		 KomponentCzesci drzwi = new KompozytCzescZlozona("drzwi");

		 KomponentCzesci srubki = new KompozytCzescPodstawowa("srubki");
		 KomponentCzesci czescSilnika = new KompozytCzescPodstawowa("czescSilnika");
		 KomponentCzesci felgi = new KompozytCzescPodstawowa("felgi");

	        silnik.add(czescSilnika);
	        kola.add(felgi);
	       drzwi.add(srubki);
	        

	        zawartosc.wyswietlNazwa();
	        ArrayList<KomponentCzesci> components =zawartosc.zwroc();
		
	  }
	   public void zbudujZPrototypu(){}
	   
		private Map<String, Czesc> czesci = new HashMap<String, Czesc>();


public Czesc getCzescPodstawowa(String nazwaCzesci) {
			Czesci czesc = null;

			czesc = czesci.get(nazwaCzesci);

			if (czesc == null) {
				switch (nazwaCzesci) {
				case 'silnik':
					 
		             czesc =new Czesc()//ten obiekt co stworzony terac
		             break;
			    case 'wycieraczki':
				
		            Item czesc = registry.createBasicItem("wycieraczki")'
					czesc = czesc z gory 
		             break;
		
		DOJEBANE W PIZDUsS
		
				}
				czesci.put(nazwaCzesci, czesc);
			}

			return symbol;
		}
	}

}
