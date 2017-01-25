package server;

public class FabrykaCzesci {
	
	
	public Czesc getCzesc(String typCzesci){  
	           
	    	 if(typCzesci == null){  
	          return null;  }  
	    	
	    	 else if(typCzesci.equalsIgnoreCase("podstawowa")) {  
	               return new PrototypCzesc(); 
             }   
	         else if(typCzesci.equalsIgnoreCase("zlozona")){  
	        	 return new KompozytCzescPodstawowa();
         }   
         
	
	   return null;  
  }  

	 public void zbudujKompozycjeObiektow()
	 {
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
}
