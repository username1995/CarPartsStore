package server;
import java.net.*;
import java.util.ArrayList;

import test.Czesc;
import test.FabrykaCzesci;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server {

	private int connections;
    private ServerSocket listener;
   private DBManager db;
/*
 * 
 * 
 * 
 * 
 * 
 */

	Server(short port) {
		connections = 0;
		try {
			listener = new ServerSocket(port);
			
		} catch(IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

public void Create(){
	FabrykaCzesci czesci = new FabrykaCzesci();
	Czesc czesc=czesci.getCzesc("podstawowa");
	System.out.println(czesc);
	
}
	
	
	
	
	public void run(String[] args) throws IOException {
		
	     System.out.println("Serwer uruchoomiony, oczekiwanie na po³¹czenia");
	     db = new DBManager();		
		
		while (true) {
		Socket client = listener.accept();
		new Thread(new ClientHandler(client, db)).start();
	}
		
	}
		public static void main(String args[]) {
		
		final short PORT = 1337;
		Server server = new Server(PORT);
		try {
			server.run(args);
		} catch (IOException e) {
			System.err.print(e);
			e.printStackTrace();
		}
	}
	
}

class ClientHandler implements Runnable {
	private Session client;
	private DBManager db;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private Socket socket;
	
	ClientHandler(Socket socket, DBManager database) {
		System.out.println("Jestem tu,czy nie?");
		//client = new Session(socket);
		this.socket=socket;
		try{
		os = new ObjectOutputStream(socket.getOutputStream());
		is = new ObjectInputStream(socket.getInputStream());
		}
		 catch(IOException e) {
             System.err.println(e);
             e.printStackTrace();
         }
		System.out.println("Klient polaczony, stworzono nowy watek");
		db = database;
	}
@Override
	public void run() {
		try {
			String cmd = "";
			do{
				
				
		cmd=(String)	is.readObject();
		System.out.println(cmd);
		if(cmd.equals("/pobierz")){
			System.out.println("jestenm tu");
		fetchKlient();}
		
		else if(cmd.equals("/czesc"))
				fetchCzesc();
				
		/*	if(cmd.equals("/logowanie"))
				//	login();
				if(cmd.equals("/usuwanie"))
				//	delete();
				if(cmd.equals("/szukaj"))
				//	search();
			*/
			}while(cmd.equals("/exit"));
		} 
			catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	try {
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public void fetchKlient() throws IOException, ClassNotFoundException{
		System.out.println("pobieranie klienta");
	//Klient p = (Klient)is.readObject();
//	os.writeObject("/pobierz");
		Klient klient = db.fetchKlient("user","user");
		System.out.println(klient);
		os.writeObject(klient);
		os.flush();
	}
	public void fetchCzesc() throws IOException, ClassNotFoundException{
		System.out.println("pobieranie czesci");
	//Klient p = (Klient)is.readObject();
//	os.writeObject("/pobierz");
		Czesc czesc = db.fetchCzesc("silnik");
		System.out.println();
		os.writeObject(czesc);
		os.flush();
	}
	
	
/*public void generujFakture()
 *wyciagam dane z bazy
 * posylam do konstruktora i tak ju¿ dalej w³aja¿ w³aja¿
 * 
 * 
 * 
 * 
 * 
 *pod spodem przykladowy klient
 * Director szef = new Director();
Builder builder = new Faktura();
Builder builder2 = new Paragon();

szef.setBuilder(builder);
szef.skladaj();

ZestawKomputerowy zestaw1 = szef.getZestaw();
szef.setBuilder(builder2);
szef.skladaj();
ZestawKomputerowy zestaw2 = szef.getZestaw();
zestaw1.show();
System.out.println("\n\nZESTAW2");
zestaw2.show();
 * 
 * 
 * bede w ponizszej metodzie korzystal z commanda chyba
 * 
 * public void zamow()
 *    aktualizacja w bazie tabeli zamowienie i klient
 * 
 * public void dodajCzesci()
 *   **stworzenie obiektu klasyFabrykaCzesci i tam wybor
 *  **czy tworzymy caly szkielet
 * ** czy tylko dodajemy konkretna czesc poprzez sklonowanie
 *  ** prototyp
 *
 *s
 *
 */
	}
