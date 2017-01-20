/**
 * 
 */
package client;
import server.*;              

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ConnectException;
import java.net.UnknownHostException;
/**
 * @author Szczominik
 *
 */
public class Client {
	private Socket server;
    private PrintWriter outputWriter;
    private BufferedReader inputBuffer;
    private String username;
    /**
	* wysylanie wiadomosci do serwera z prosba o zalogowanie
	*
	*
	*/
   
    public String show() {
    	   outputWriter.println("SHOW: ");
           outputWriter.flush();
           String response="";
           try {
               response = inputBuffer.readLine();
               System.out.println("Response: " + response);
               }
           catch(IOException e) {
               System.err.println(e);
               e.printStackTrace();
           }
           return response;
    }
    
    
    
    
    
    
    
    public boolean login(String user, String pass) {
        boolean accepted = false;
        
        outputWriter.println("LOGIN: " + user + "," + pass);
        outputWriter.flush();
        String response;
        try {
            response = inputBuffer.readLine();
            System.out.println("Response: " + response);
            if(response.equals("ACCEPTED")) {
                accepted = true;
                username = user;
            }
        } catch(IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        
        return accepted;
    }
       /**
	* wysylanie wiadomosci do serwera z prosba o wyslanie maila
	*
	*
	*/
    
	public boolean send(String imie, String nazwisko, String mail, String data,String haslo,String PESEL) {
        boolean accepted = false;
        
        outputWriter.println("SEND email: "+imie+","+nazwisko+","+mail+","+data+","+haslo+","+PESEL);
        outputWriter.flush();
        String response;
        try {
            response = inputBuffer.readLine();
            System.out.println("Response: " + response);
            if(response.equals("OK")) 
            {   accepted = true;}

        } catch(IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        
        return accepted;
    }
	    /**
	* wysylanie wiadomosci do serwera z prosba o uaktualnie danych w bazie danych
	*
	*
	*/
    
public boolean update(String data,String login)
	{
		boolean accepted = false;
        
        outputWriter.println("UPDATE: "+ data+","+login);
		
			System.out.println("wyslalo");
        outputWriter.flush();
        String response;
        try {
         
		   response = inputBuffer.readLine();
		    
            System.out.println("Response: " + response);
            if(response.equals("OK")) 
            {   accepted = true;}

        } catch(IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        
        return accepted;
	}
    
      /**
	* polaczenie z serwerem o okreslonym porcie i ip
	*
	*/
    public void connect(String ip, short port) throws ConnectException, UnknownHostException, IOException {
        server = new Socket(ip, port);
        try {
            
            inputBuffer = new BufferedReader(new InputStreamReader(server.getInputStream()));
            outputWriter = new PrintWriter(server.getOutputStream());
            System.out.println("Polaczono z serwerem");
            
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }    
    }
    /** prosba o wyciagniecie danych z bazy*/
	public String retrieve(String login, String password){
        outputWriter.println("RETRIEVE data: " + login + "," + password);
        outputWriter.flush();
        String response="";
        try {
            response = inputBuffer.readLine();
            System.out.println("Response: " + response);
            }
        catch(IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return response;
    	
    }
/** konczenie polaczenia */
  public void disconnect(){
        outputWriter.println("exit");
        outputWriter.flush();
     }
      
    
    /** pisanie do socketu */
    public void write(String msg) {
        outputWriter.println(msg);
        outputWriter.flush();
    }
	
    /** odczytywanie za pomoca socketu */
    public String read() {
        String line = "";
        try {
            line = inputBuffer.readLine();
        } catch(IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return line;
    }
    
}
