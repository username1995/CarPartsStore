package server;
import java.net.*;
import java.io.IOException;

public class Server {

	private int connections;
    private ServerSocket listener;
   private DBManager db;


	Server(short port) {
		connections = 0;
		try {
			listener = new ServerSocket(port);
			
		} catch(IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

public void run(String[] args) throws IOException {
		
	     System.out.println("Serwer uruchoomiony, oczekiwanie na po³¹czenia");
		String dbUser = "root";
		String dbPass = "";
		
		//String dbAddress = "jdbc:mysql://localhost:3306/sklep";
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
	
	
	ClientHandler(Socket socket, DBManager database) {
		client = new Session(socket);
		
		System.out.println("Klient polaczony, stworzono nowy watek");
		db = database;
	}

	public void run() {
		System.out.println("");
	
		String clientMsg = "";
		boolean accepted = false;
		do {
			System.out.println("Jestem tu");
			clientMsg = client.read();
			
			
			if (clientMsg.startsWith("SHOW:")) {
			
				System.out.println("Dziala, czy nie, chuj WIE");
				show();
			}
			
			else
			{
				System.out.println("Niespodziewana wiadomosc od klienta lub klient zakonczyl aplikacje " + clientMsg);
				client.disconnect();
				return;
			}
		} while(!accepted);
		

	}
	

	/**
	 * Tworzy nowego u¿ytkownika (klienta) w bazie danych
	 * @param clientMsg wiadomosc od klienta zawieraj¹ca zakodowane dane niezbêdne do utworzenia konta.
	 */
	private synchronized void createUser(String clientMsg) {
		/////////
		////// 
		clientMsg = clientMsg.split(" ")[1];
	
	
		String username = clientMsg.split(",")[0];
		String password = clientMsg.split(",")[1];
		String name = clientMsg.split(",")[2];
		String surname =clientMsg.split(",")[3];
		String mail =clientMsg.split(",")[4];
		
         try {
			
			if (db.userExists(username)) {
				client.write("TAKEN");
			}
			else {
				db.createUser(username, password,name,surname,mail);			
				client.write("USERCREATED");
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private synchronized void show() {
client.write(db.getData());
}
	
	
	
	
	
	
	
	
	
	/**
	 * Probuje zalogowac sie do bazy danych z podanych przez uzytkownika haslem
	 * @param wiadomosc od klienta zawieraj¹ca zakodowane dane niezbêdne do zalogowania sie
	 * @return true jesli zalogowano false w przeciwnym razie
	 */
	private synchronized boolean authenticate(String clientMsg) {
		boolean accepted = false;
		
	
		clientMsg = clientMsg.split(" ")[1];
		String username = clientMsg.split(",")[0];
		String password = clientMsg.split(",")[1];
		
		try {
			if (db.authenticate(username, password)) {
				accepted = true;
		       client.write("ACCEPTED");
	         }
			else client.write("nie udalo sie zalogowac");
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
	return accepted;
	}
	
	
	/*
	 * Konczy watek klienta
	 */
private synchronized void disconnect() {

	client.disconnect();
		}	

	/*
	 *
	 * Pobiera imie, nazwisko, maila pacjenta z bazy danych na podstawie bnazwy uzytkownika i hasla
	 * @param wiadomosc od klienta zawieraj¹ca zakodowane dane niezbêdne do pobrania danych
	 * 
	 */	
public synchronized void retrieveData(String clientMsg){
//wyciaganie danych
//dla klienta jego konto, czesci do kupienia
//
//	client.write(db.getDataFrom(username, password));
 //
//
}


	/**
	 * Probuje wyslac sie maila do lekarza 
	 * @param wiadomosc od klienta zawieraj¹ca zakodowane dane niezbêdne do wyslania maila
	 * 
	 */
	 

/**
	 * Uaktualnia w bazie danych date wybrna przez pacjenta w panelu uzytkownika
	 * @param wiadomosc od klienta zawieraj¹ca zakodowane dane niezbêdne do uaktualnienia danych
	 * 
	 */
	 
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
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */










public synchronized boolean update(String clientMsg){

		boolean accepted = false; 
		clientMsg = clientMsg.split(": ")[1];
	

	   String data = clientMsg.split(",")[0];
	   String login = clientMsg.split(",")[1];
	
   
  

try {
			
			System.out.println("BEDE TU KIEDYS?");
			if (db.updateData(data,login)) {
				
			  client.write("OK");
	          accepted = true;

			}
			else client.write("NIE UDALO SIE ZAKTUALIZOWAC DANYCH W BAZIE");
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
return accepted;
	}
	
	

 
}
