package client;

import server.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {

		   System.out.println("SKLEP Z CZESCIAMI SAMOCHODOWYMI");
		  Fasada fasada = new Fasada();
		
		//if admin
		   try {
		         fasada.connectAsAdmin("127.0.0.1", (short) 1337); 
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
		  
		//else czyli zwykly klient
		
	/*
        try {
         fasada.connect("127.0.0.1", (short) 1337); 
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
  
     */
        
  
       
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
