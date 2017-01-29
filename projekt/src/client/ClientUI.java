package client;
import java.util.Scanner;
public class ClientUI {

	void przegladajTowary(){
		//wywolaj poprzed fasade metode pobierajaca dane z bazy
	}
	boolean rejestracja(){
	return true;	//to co powyzej
	}
	boolean zalogujSie()
	{return true;}
	
	void zakup(String coKupujesz){
		//troszke bardziej zaawansowane
	}
	

	
	
	
	void start(Fasada fasada)
	{
		
		boolean run=true;
		 Scanner input=new Scanner(System.in);
		while(run)
		{
			System.out.println("Wybierz opcje: ");
			System.out.println("1 .Przegladaj towary ");
			System.out.println("2  Zarejestruj sie ");
			System.out.println("3 Zaloguj sie");
			System.out.println("4 Zakup towary- dostepne tylko dla zalogowanych ");
			System.out.println("9 Wyjscie ");
			int option= input.nextInt();
	       /////////////////
			///// jak tu odniesc kupienie do zalogowania w zwiazku z tym interfejsem///
			////////
	       switch(option){
		 case 1:
	      String wynik=fasada.retrievePartsFromDatabase();
	      
	      
	      
	      System.out.println(wynik);
	      
	    String  id = wynik.split(",")[0];
	    String model =wynik.split(",")[1];
			String nazwa = wynik.split(",")[2];
			String cena =wynik.split(",")[3];
			String opis =wynik.split(",")[4];
			
			 System.out.println(id);
			 System.out.println(model);
			 System.out.println(nazwa);
			 System.out.println(cena);
			 
			
	           break;
	         case 2:
	           System.out.println("Option2");
	           break;
	         case 3:
	           System.out.println("Option3");
	           break;  
	           case 4:
	        	   boolean trwaj=true;
	        	   int wybor1, wybor2,wybor3;
	        	   String koniec;
	        	   while(trwaj){
	        			 System.out.println("Podaj nazwe czesci, ktora chcesz kupic, maksymalnie 3");
	        		   wybor1=input.nextInt();
	        		   //tu jeszcze ilosc podac
	        		   wybor2=input.nextInt();
	        		   wybor3=input.nextInt();
	        		   System.out.println("Zakonczono, status czesci bedzie mozna sledzic w koncie uzytkownika");
	        		   int zakoncz=wybor1+wybor2+wybor3;
	        		   trwaj=false;
	        	   }
	        		   
	        		   
	        		   
	        	   
		           System.out.println("Option3");
		           break;  
	       
	       
	       }
	         

	           break*/
	         



		
		
		}
	}
}