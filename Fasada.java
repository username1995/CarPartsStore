package client;

public class Fasada {
	
	private Client client= new Client();
	private ClientUI clientUI= new ClientUI();
	private AdminUI adminUI = new AdminUI();
	
public void connect(String ip, short port) throws Exception{
		
	client.connect(ip, port);
	
	}
	public void connectAsAdmin(String ip, short port) throws Exception{
	 	
		client.connect(ip, port);
		
client.login("admin","admin" );
	}
	
	public void login(String user, String pass){
	client.login(user, pass);
	}
	
	public void pobierz(String user, String pass){
		try{
		client.testPobieraniaKlienta();}
		catch (Exception e){}
		}
	public void register(String user, String pass){
//	client.register(user, pass);
	}

	public String retrievePartsFromDatabase(){
		return client.show();
	}
	public String retrieveOrdersFromDatabase(){
		return client.showOrders();
	}
		
	/*public boolean buy()*/
	
   public void wyswietl(boolean t){
   if(t) adminUI.start(this);
   else clientUI.start(this);

   }


}