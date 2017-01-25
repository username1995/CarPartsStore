package server;

public class KolekcjaCzesci implements Container {
	
	  
     
	@Override  
    public Iterator getIterator() {  
	       return new KolekcjaCzesciIterator() ;  
    }  
	   private class  KolekcjaCzesciIterator implements Iterator{  
        int i;  
       @Override  
      public boolean hasNext() {  
	          if (i<czesci.length){  
	               return true;  
	        }  
	           return false;  
	        }  
	       @Override  
	      public Object next() {  
	      if(this.hasNext()){  
	               return czesci[i++];  
	        }  
	         return null;      
	        }  
	   }  
}  



