package server;


import java.net.*;
import java.io.IOException;


/**
 * Server.java
 * Serwer aplikacji 
 * Objekt tej klasy tworzy "nasluchiwacz" ServerSocket, ktory pozwala serwerowi nasluchiwac przychodzacych polaczen.
 * Jest to serwer wielow�tkowy
 * @author Dominik Szczerek
 * 
 */
public class Server {

	private int connections;
	
	/** Do nasluchiwania przychodzacych polaczen
	  */
	private ServerSocket listener;
	
	
	/** Serwerowy interfejs do bazyy danych MySQL*/
	private DBManager db;

	/** Flag to limit the maximum number of connections */
	private final int MAX_CONNECTIONS = 0;
	

	/**
	 * Tworzy nowy serwer
	 * 
	 * @param port Numer portu na ktorym beda nasluchiwane polaczenia
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

	/**
	 * 
	 * G�owna metoda serwera, nasluchiwanie na przychodzace polaczenia w petli
	 * .
	 */
	public void run(String[] args) throws IOException {
		System.out.println("Serwer uruchoomiony, oczekiwanie na po��czenia");
		String dbUser = "root";
		String dbPass = "";
		
		
		/**Do komunikowanie sie z baza danych */
		String dbAddress = "jdbc:mysql://localhost:3306/chatdb";
		db = new DBManager(dbAddress, dbUser, dbPass);		
		
		/** naluchiwanie na polaczenia w nieskonczonej petli*/
		while (true) {
		
			/** Only accept connections up to the limit specified by the
			    MAX_CONNECTIONS constant, 0 means no new connection limit */
			if (++connections < MAX_CONNECTIONS || MAX_CONNECTIONS == 0) {
				
				/** Zablokuj nasluchiwanie i stworz*/
				Socket client = listener.accept();
				
				/** Stworz w nowy watku klienta i od tej pory tam klient bedzie obslugiwany,
				 *  kontynuujemy nasluchiwanie na nowych klientow w watku glownym
				 */
				new Thread(new ClientHandler(client, db)).start();
							
			}
		}
	}
	
	/** Glowna metoda ktora powoduje ze serwer zaczyna dzialaac na dancym porcie( w tym przypadku ) */
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

/** Klasa ClientHandler to fundament serwera. Implementuje interfejs Runnable dzieki ktoremu
 *  mozna stworzyc nowy watek dla kazdego klienta z osobna
 * 
 * @author Dominik Szczerek
 * 
 */
class ClientHandler implements Runnable {
	private Session client;
	

	
	/** 
	 *  odniesienie do bazy danych
	 */
	private DBManager db;
	
	/**
	 * Do zarzadania kazdym z klientow
	 * 
h.    */
	ClientHandler(Socket socket, DBManager database) {
		client = new Session(socket);
		
		System.out.println("Klient polaczony, stworzono nowy watek");
		db = database;
	}
	
	/**
	 * Klasa ClientHandler implementuje interfejs Runnable, jest to metoda run()
	 * pracuj�ca we w�asnym, osobnym w�tku. run() mo�e wywo�ywa�
	*/
	public void run() {
		System.out.println("");
	
		
		String clientMsg = "";
		boolean accepted = false;
		
	
		do {
			clientMsg = client.read();
			
			
			if (clientMsg.startsWith("LOGIN: ")) {
				accepted = authenticate(clientMsg);
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
	 * Tworzy nowego u�ytkownika (klienta) w bazie danych
	 * @param clientMsg wiadomosc od klienta zawieraj�ca zakodowane dane niezb�dne do utworzenia konta.
	 */
	private synchronized void createUser(String clientMsg) {
		
		
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
		

			
	
			//	client.write(db.getDataFrom(username, password));

	}
	
	
	
	
	
	
	
	
	
	/**
	 * Probuje zalogowac sie do bazy danych z podanych przez uzytkownika haslem
	 * @param wiadomosc od klienta zawieraj�ca zakodowane dane niezb�dne do zalogowania sie
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
	 * @param wiadomosc od klienta zawieraj�ca zakodowane dane niezb�dne do pobrania danych
	 * 
	 */	
public synchronized void retrieveData(String clientMsg){

	clientMsg = clientMsg.split(": ")[1];
	
    String username = clientMsg.split(",")[0];
	String password = clientMsg.split(",")[1];

	client.write(db.getDataFrom(username, password));
 

}


	/**
	 * Probuje wyslac sie maila do lekarza 
	 * @param wiadomosc od klienta zawieraj�ca zakodowane dane niezb�dne do wyslania maila
	 * 
	 */
	 
/*public synchronized void send(String clientMsg) {
	
		System.out.println(clientMsg);
		
		clientMsg = clientMsg.split(": ")[1];
		
		String name = clientMsg.split(",")[0];
		String surname = clientMsg.split(",")[1];
		String mail =clientMsg.split(",")[2];
		String data = clientMsg.split(",")[3];
		String password = clientMsg.split(",")[4];
		String PESEL = clientMsg.split(",")[5];
		
		SendMail a = new SendMail();
		try {
		    if (a.send(name,surname,mail,data,password,PESEL))   client.write("OK");
	                else client.write("Wystapil jakis problem z wyslaniem maila");
	        }
	catch (MessagingException e) {

			System.err.println(e);
			e.printStackTrace();
		}
}*/
/**
	 * Uaktualnia w bazie danych date wybrna przez pacjenta w panelu uzytkownika
	 * @param wiadomosc od klienta zawieraj�ca zakodowane dane niezb�dne do uaktualnienia danych
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
