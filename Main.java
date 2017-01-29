package client;
import java.util.Scanner;
import server.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
//Client client=new Client();
		   System.out.println("SKLEP Z CZESCIAMI SAMOCHODOWYMI");
		  Fasada fasada = new Fasada();
		  System.out.println("Wybierz jako kto chcesz korzystac ze sklepu");
		  System.out.println("1 admin");
		  System.out.println("2 klient");
		   
		  Scanner in = new Scanner(System.in);

		 String s = in.nextLine();
if(s=="1"){
	try {
		  System.out.println("przed");
		         fasada.connectAsAdmin("127.0.0.1", (short) 1337); 
                //  fasada.pobierz("aaa","aaa");
		         fasada.wyswietl(true);
		        } catch(ConnectException e) {
		System.exit(-1);
		            return;
		        } catch(UnknownHostException e) {
		System.exit(-1);
		            return;
		        } catch(IOException e) {
		            System.exit(-1);
		            return;}
		            catch(Exception e) {
		                System.exit(-1);
		                return;
		        }
		  
}else{
        try {
        fasada.connect("127.0.0.1", (short) 1337); 
     //    fasada.pobierz("aaa","aaa");;   
         fasada.wyswietl(false);
        } catch(ConnectException e) {
System.exit(-1);
            return;
        } catch(UnknownHostException e) {
System.exit(-1);
            return;
        } catch(IOException e) {
            System.exit(-1);
            return;}
            catch(Exception e) {
                System.exit(-1);
                return;
        }
  
}
       
  
       
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
