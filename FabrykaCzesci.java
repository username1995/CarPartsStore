package server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FabrykaCzesci {
	
	
	private static final String nazwa = null;
	private Map<String, Czesc> czesci = new HashMap<String, Czesc>();

	public  Czesc  getCzesc(String typCzesci){  
	           
	    	 if(typCzesci == null){  
	          return null;  }  
	    	
	    	 else if(typCzesci.equalsIgnoreCase("podstawowa")) {  
	              return  getCzescPodstawowa("felgi"); 
	             
             }   
	         
	    	 //jak zwrocic kolekcje obiektow jak ma byc typ czesc
	    	 else if(typCzesci.equalsIgnoreCase("zlozona")){  
	     return 	null;//this.zbudujKompozycjeObiektow(nazwa);
         }   
         
	
	   return null;  
  }  

	 public   ArrayList<KomponentCzesci> zbudujKompozycjeObiektow(String model)
	 {
		 
		 KomponentCzesci zawartosc = new KompozytCzescZlozona("seicento");
		
		 KomponentCzesci silnik = new KompozytCzescZlozona("silnik");
		 KomponentCzesci kola = new KompozytCzescZlozona("ko³a");
		 KomponentCzesci drzwi = new KompozytCzescZlozona("drzwi");

		 KomponentCzesci srubki = new KompozytCzescPodstawowa("srubki");
		 KomponentCzesci czescSilnika = new KompozytCzescPodstawowa("czescSilnika");
		 KomponentCzesci felgi = new KompozytCzescPodstawowa("felgi");

	        silnik.add(czescSilnika);
	        kola.add(felgi);
	       drzwi.add(srubki);
	        
	       zawartosc.add(silnik);
	       zawartosc.add(kola);
	       zawartosc.add(drzwi);
	       
	       
	       // zawartosc.wyswietlNazwa();
	        return  zawartosc.zwroc();
		
	  }

	
public Czesc getCzescPodstawowa(String nazwaCzesci) {
	
	Map<String, Czesc> czesci = new HashMap<String, Czesc>();
	Czesc czesc = null;

			czesc = czesci.get(nazwaCzesci);

			if (czesc == null) {
				
				switch (nazwaCzesci) {
				case "silnik":

				czesc =new Czesc("silnik");//ten obiekt co stworzony terac
				 
				break;
			  
				case "felgi": //bierzesz z bazy danych, kopiujesz
			   czesc = czesci.get("silnik").clone();
		        break;
		}
				czesci.put(nazwaCzesci, czesc);
			}
		
			return czesc;
		}
	}


