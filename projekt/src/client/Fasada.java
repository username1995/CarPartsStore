package client;

public class Fasada {
	
	private Client client;
	
	
ing ip, short port) throws Exception{
		client.connect(ip, port);
	}
	public void connectAsAdmin(String ip, short port) throws Exception{
		client.connect(ip, port);
		client.login("admin","admin" );
	}
	
	public void login(String user, String pass){
	client.login(user, pass);
	}
	

	public void register(String user, String pass){
	//client.register(user, pass);
	}

	public String retrievePartsFromDatabase(){
		return client.show();
	}
		
	/*public boolean buy()*/
	}





