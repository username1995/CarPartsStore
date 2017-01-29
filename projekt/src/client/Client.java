package client;
import server.*;              

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ConnectException;
import java.net.UnknownHostException;



public class Client {
	private Socket server;
    private PrintWriter outputWriter;
    private BufferedReader inputBuffer;
    private String username;
    private ObjectInputStream is;
	private ObjectOutputStream os;

    
    public void dupa(){
    	 System.out.println("Jestem w dupie");
    }
    
    
    public void testPobieraniaKlienta() throws IOException, ClassNotFoundException{
		Klient k = new Klient("user", "user");
		os.writeObject("/pobierz");
		os.flush();
		os.writeObject(k);
		os.flush();
		System.out.println((String)is.readObject());
	}
    
    
    public void connect(String ip, short port) throws ConnectException, UnknownHostException, IOException {
    	
    	server = new Socket(ip, port);
        try {
            
         //   inputBuffer = new BufferedReader(new InputStreamReader(server.getInputStream()));
            //outputWriter = new PrintWriter(server.getOutputStream());
    		os = new ObjectOutputStream(server.getOutputStream());
    		is = new ObjectInputStream(server.getInputStream());
            System.out.println("Polaczono z serwerem");
            
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }    
    }
    
    
   /* public boolean register(String user, String pass) {
        boolean accepted = false;
        
        outputWriter.println("NEWUSER: " + login+ "," + pass1+","+imie+","+nazwisko+","+mail");
        outputWriter.flush();
        String response;
        try {
            response = inputBuffer.readLine();
            System.out.println("Response: " + response);
            if(response.equals("USERCREATED")) {
                accepted = true;
                username = user;
            }
        } catch(IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        
        return accepted;
    }
    */
    
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
 
    public String showOrders() {
 	   outputWriter.println("ORDERS: ");
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

  public void disconnect(){
        outputWriter.println("exit");
        outputWriter.flush();
     }
      
    
  public void write(String msg) {
        outputWriter.println(msg);
        outputWriter.flush();
    }

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
