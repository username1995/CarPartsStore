package server;

import client.*;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {
	private Connection db;

	private String url;
	private String username;
	private String password;
	
	
	public DBManager(){
		
    db =Database.getInstance().getConnection();;
     System.out.println("Dokonano po³aczenia z baz¹ danych");
	}
	
/////////////////rejestracja
	
	public boolean addKlient(Klient klient){
		  
		   PreparedStatement ps=null;
          String sql = "INSERT INTO Klient (id, login, haslo, imie, nazwisko,email, miejscowosc,ulica, nrMieszkania,telefon)"
				+ " VALUES(null,'"+klient.getLogin()
				+"','"+klient.getHaslo()+"','"+klient.getImie()+"','"+klient.getNazwisko()
				+"','"+klient.getEmail()+"','"+klient.getMiejscowosc()+"','"+klient.getUlica()
				+"','"+klient.getNrMieszkania()+"','"+klient.getTelefon()+"');";
		try {
			   ps=db.prepareStatement(sql);
			 ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/////////logowanie
	
		public Klient fetchKlient(String login, String haslo){
			   PreparedStatement ps = null;
			   ResultSet rs = null;
			String sql = "SELECT * FROM Klient WHERE login='" + login + "' AND haslo='" + haslo +"';";
			 
			try {
				 ps = db.prepareStatement(sql);
				rs = ps.executeQuery(sql);
				if(rs.next()){
					int id = rs.getInt("id");
					//String login = rs.getString("login");
					String imie = rs.getString("imie");
					String nazwisko = rs.getString("nazwisko");
					String email = rs.getString("email");
					String miejscowosc = rs.getString("miejscowosc");
					String ulica = rs.getString("ulica");
					String nrMieszkania = rs.getString("nr mieszkania");
					String telefon = rs.getString("telefon");
					
					return new Klient(id, login, haslo, imie, nazwisko,email, miejscowosc,ulica, nrMieszkania,telefon);
				}else{
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return null;
			}
		}
		
//wyciagniecie czesci do prototypu	
		public Czesc fetchCzesc(String nazwa){
			   PreparedStatement ps = null;
			   ResultSet rs = null;
			String sql = "SELECT * FROM czesc WHERE nazwa='" + nazwa +"';";
			 
			try {
				 ps = db.prepareStatement(sql);
				rs = ps.executeQuery(sql);
				if(rs.next()){
					int id = rs.getInt("id");
         //     int model = rs.getInt("model");
   			String nazwaa = rs.getString("nazwa");
   			float cena = rs.getFloat("cena");
   			
   	
					return new Czesc(id,nazwaa,cena );
				}else{
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return null;
			}
		}
		
		
		
		
		
		
		
		
		/*
	//dodawanie zamowienia	
		public boolean addZamowienie(Zamowienie zamowienie){
			  
			   PreparedStatement ps=null;
	          String sql = "INSERT INTO Klient (id, login, haslo, imie, nazwisko,email, miejscowosc,ulica, nrMieszkania,telefon)"
					+ " VALUES(null,'"+klient.getLogin()
					+"','"+klient.getHaslo()+"','"+klient.getImie()+"','"+klient.getNazwisko()
					+"','"+klient.getEmail()+"','"+klient.getMiejscowosc()+"','"+klient.getUlica()
					+"','"+klient.getNrMieszkania()+"','"+klient.getTelefon()+"');";
			try {
				   ps=db.prepareStatement(sql);
				 ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}*/
	//do generowania faktury Builderem
		//zwroc klientowi zamowienie ze statusem o jego id (powiazane z kontem)
		public ArrayList<Zamowienie> fetchZamowienie(Zamowienie z){
			ArrayList<Zamowienie> list = new ArrayList<>();
			   PreparedStatement ps = null;
			   ResultSet rs = null;
		
			String sql = "SELECT * FROM zamowienie WHERE akceptacja='niepotwierdzone' ";
			/*if(p.getNrRej()!=null)
				sql += "nr_rej='"+p.getNrRej()+"' AND ";
			if(p.getModel()!=null)
				sql += "model='"+p.getModel()+"' AND ";
			if(p.getMarka()!=null)
				sql += "marka='"+p.getMarka()+"' AND ";
			if(p.getTyp()!=null)
				sql += "typ='"+p.getTyp()+"' AND ";
			if(p.getKategoria()!=null)
				sql += "kategoria='"+p.getKategoria()+"' AND ";
			if(p.getMoc()!=null)
				sql += "moc="+p.getMoc()+" AND ";
			if(p.getLadownosc()!=null)
				sql += "ladownosc="+p.getLadownosc()+" AND ";
			if(p.getKolor()!=null)
				sql += "kolor='"+p.getKolor()+"' AND ";
			if(p.getCzyKlima()!=null)
				sql += "czy_klima='"+p.getCzyKlima()+"' AND ";
			if(p.getCzyCentralny()!=null)
				sql += "czy_centralny='"+p.getCzyCentralny()+"' AND ";
			if(p.getCzyElektryczne()!=null)
				sql += "czy_elektryczne='"+p.getCzyElektryczne()+"' AND ";
			if(p.getCzyAirbag()!=null)
				sql += "czy_airbag='"+p.getCzyAirbag()+"' AND ";
			if(p.getStan()!=null)
				sql += "stan='"+p.getStan()+"' AND ";
			sql = sql.substring(0, sql.length()-4);*/
			
			
			System.out.println(sql);
			try {
				 ps = db.prepareStatement(sql);
					rs = ps.executeQuery(sql);
				while(rs.next()){
					//zapisywanie do zmiennych tego co wyszukano w bazie danych
				//	Zamowienie zamowienie = new Zamowienie(rsId, rsRej, rsModel, rsMarka, rsTyp, rsKategoria, rsMoc, rsLadownosc, rsKolor, rsKlima, rsCentralny, rsElektryczne, rsAirbag, rsStan, rsCena);
				//	list.add(zamowienie);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return list;
			}
		}
		//pobierz czesci
		//public ArrayList<Czesc> fetchCzesci(Zamowienie z);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	///////zwroc zamowienia ktore maja niepotwierdzony status
	
	/*public ArrayList<Zamowienie> fetchZamowienia(Zamowienie z){
		ArrayList<Zamowienie> list = new ArrayList<>();
		   PreparedStatement ps = null;
		   ResultSet rs = null;
	
		String sql = "SELECT * FROM zamowienie WHERE akceptacja='niepotwierdzone' ";
	}	/*if(p.getNrRej()!=null)
			sql += "nr_rej='"+p.getNrRej()+"' AND ";
		if(p.getModel()!=null)
			sql += "model='"+p.getModel()+"' AND ";
		if(p.getMarka()!=null)
			sql += "marka='"+p.getMarka()+"' AND ";
		if(p.getTyp()!=null)
			sql += "typ='"+p.getTyp()+"' AND ";
		if(p.getKategoria()!=null)
			sql += "kategoria='"+p.getKategoria()+"' AND ";
		if(p.getMoc()!=null)
			sql += "moc="+p.getMoc()+" AND ";
		if(p.getLadownosc()!=null)
			sql += "ladownosc="+p.getLadownosc()+" AND ";
		if(p.getKolor()!=null)
			sql += "kolor='"+p.getKolor()+"' AND ";
		if(p.getCzyKlima()!=null)
			sql += "czy_klima='"+p.getCzyKlima()+"' AND ";
		if(p.getCzyCentralny()!=null)
			sql += "czy_centralny='"+p.getCzyCentralny()+"' AND ";
		if(p.getCzyElektryczne()!=null)
			sql += "czy_elektryczne='"+p.getCzyElektryczne()+"' AND ";
		if(p.getCzyAirbag()!=null)
			sql += "czy_airbag='"+p.getCzyAirbag()+"' AND ";
		if(p.getStan()!=null)
			sql += "stan='"+p.getStan()+"' AND ";
		sql = sql.substring(0, sql.length()-4);*/
		
		/*
		System.out.println(sql);
		try {
			 ps = db.prepareStatement(sql);
				rs = ps.executeQuery(sql);
			while(rs.next()){
				//zapisywanie do zmiennych tego co wyszukano w bazie danych
				Zamowienie zamowienie = new Zamowienie(rsId, rsRej, rsModel, rsMarka, rsTyp, rsKategoria, rsMoc, rsLadownosc, rsKolor, rsKlima, rsCentralny, rsElektryczne, rsAirbag, rsStan, rsCena);
				list.add(zamowienie);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
	}
	
*/
	
	
	
	
	
	
	
	
	
	
	/*public ArrayList<Zamowienie> fetchZamowienia(Zamowienie zamowienie){
		ArrayList<Pojazd> listaPojazdow = fetchPojazd(p);
		checkDriver();
		Connection conn = connectToDatabase();
		Statement stmt = createStatement(conn);
		String sql = "SELECT id_poj FROM Rezerwacja WHERE NOT (data_wyp<'"+r.getDataWyp().toString()+
				"' AND data_zwr>'"+r.getDataZwr().toString()+"');";
		System.out.println(sql);
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<Integer> rList = new ArrayList<>();
			while(rs.next()){
				rList.add(rs.getInt("id_poj"));				
			}
			for(Pojazd poj: listaPojazdow)
				for(Integer i: rList)
					if(poj.getId() == i)
						listaPojazdow.remove(poj);
			return listaPojazdow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listaPojazdow;
		}
	}
	*/
	
	
	
	
	
   public boolean authenticate(String username, String password) throws SQLException, NoSuchAlgorithmException
   {
       PreparedStatement ps = null;
       ResultSet rs = null;
       try {
           boolean userExist = true;
           // wALIDAcja wpisania uzytkownika
           if (username == "" || password == "") {
               userExist = false;
               username = "";
               password = "";
           }
 
           ps = db.prepareStatement("SELECT HASLO FROM SKLEP.KLIENT WHERE LOGIN = ?");
           ps.setString(1, username);
           rs = ps.executeQuery();
          
		  String digest;
           if (rs.next()) {
               digest = rs.getString("HASLO");
             
               // DATABASE VALIDATION
               if (digest == "") {
                   throw new SQLException("Wystapil problem z baza danych");
               }
             
           } else {
        	   // TIME RESISTANT (even if the user does not exist the
               // computation time is equal to the time needed for a legitimate user)
        	   System.out.println("Proba zalogowania uzytkownika" + username);

               userExist = false;
           }
 
           
           return userExist;
       }
       finally{
           close(rs);
           close(ps);
       }
   }
   
   
   public boolean userExists(String username) {
	   boolean exists = false;
	   
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   
	   try {
	       ps = db.prepareStatement("SELECT 1 FROM CREDENTIAL WHERE PESEL='" + username + "' LIMIT 1");
	       rs = ps.executeQuery();
	       if (rs.next()) exists = true;
	   } catch (SQLException e) {
		   System.err.println(e);
		   e.printStackTrace();
	   }
	   
	   return exists;
   }
   
 
  
 
   
   public boolean createUser(String username, String password,String name,String surname, String mail) throws SQLException, NoSuchAlgorithmException
   {	   
       PreparedStatement ps = null;
       try {
           if (username != null && password != null && username.length() <= 100) {
        	   
    
               ps = db.prepareStatement("");
               ps.setString(1,username);
               ps.setString(2,password);
               ps.setString(3,name);
			   ps.setString(4,surname);
			   ps.setString(5,mail);
               ps.executeUpdate();
               return true;
           } else {
               return false;
           }
       } finally {
           close(ps);
       }
   }


   public void close(Statement ps) {
       if (ps!=null){
           try {
               ps.close();
           } catch (SQLException ignore) {
           }
       }
   }
 
  /**
    * Zamyka polaczenie JDBC typu Statement
    * 
    *
    */
   public void close(ResultSet rs) {
       if (rs!=null){
           try {
               rs.close();
           } catch (SQLException ignore) {
           }
       }
   }

   
   ///////////////////////////////////////////////////////////////////////////////////////////////////
   /*
   
   
   
   CRUD
   
   dla klienta
   Create :zamowienie, konto
   Read:Czesci, zamowienie,konto
   Update
   Delete :Zamowienie (jesli zamowienie jeszcze nie zatwierdzone przez admina)
   
   
   
   
   dla admina
   Create czesci- z uzyciem wzorcow
   Read Czesci
   Update status zamowienia, czesci
   Delete czesci
   
     */
   
   

   public boolean createOrder(String client, String czesc) throws SQLException, NoSuchAlgorithmException
   {	   
       PreparedStatement ps = null;
       try {
//////////////////////////
    	   
    	  // abstrahuje cale jdbc
        	   
    
           //    ps = db.prepareStatement("");
       
               ps.setString(2,"dupa");
               ps.setString(4,"cwela");
			 
               ps.executeUpdate();
               return true;
          
       } finally {
           close(ps);
       }
   }
   
   
   
   
   
   
   
   /** 
    * Wydobywa dane z bazy danych
    * @return String dane wyciagniete z bazy danych w postac zakodowanej wiadomosci    */

   
   
   public String getData(){
   
   PreparedStatement ps = null;
   ResultSet rs =null;;
   String data = "";  
   
  
   
   try{
		 ps = db.prepareStatement("SELECT * FROM CZESC"); 
          rs = ps.executeQuery();
		if(rs==null){System.out.println("Nie udalo sie pobrac danych z bazy"); }else System.out.println("Udalo sie pobrac dane z bazdy"); 
		while (rs.next())
			
		{data+=rs.getInt("id");
	 		data+=",";
	 		data+=rs.getInt("model");
			data+=",";
			data+=rs.getString("nazwa");
			data+=",";
			data+=rs.getFloat("cena");
			data+=",";
			data+=rs.getInt("ilosc");
			data+=",";
			data+=rs.getString("opis");
		}
	 
	 		
	 	}catch (SQLException e){
			System.err.println(e);
	        e.printStackTrace();
		}
		return data;
			
   
   
   
   
   
   
   
   
   
   
   
   
   //tutaj wyciaganie danych z bazy
   
   
   //i zapisywanie tak jak u dolu
   
   //zwracane
   //return data;
   
}
   public String getDataFrom(String PESEL, String password)
 {
	 PreparedStatement ps = null;
     ResultSet rs =null;
     String data = "";
	try{
	 ps = db.prepareStatement("SELECT * FROM CREDENTIAL WHERE PESEL=? AND PASSWORD=?"); 
	 ps.setString(1,PESEL);
	 ps.setString(2,password);
     rs = ps.executeQuery();
	if(rs==null){System.out.println("Nie udalo sie pobrac danych z bazy"); }else System.out.println("Udalo sie pobrac dane z bazdy"); 
	while (rs.next())
		
	{data+=rs.getString("PESEL");
 		data+=",";
 		data+=rs.getString("NAME");
		data+=",";
		data+=rs.getString("SURNAME");
		data+=",";
		data+=rs.getString("MAIL");
	}
 
 		
 	}catch (SQLException e){
		System.err.println(e);
        e.printStackTrace();
	}
	return data;
		
 }
 
 public boolean updateData(String data,String PESEL){
	 
	 
	   PreparedStatement ps = null;
	   ResultSet rs = null;

	  try{
	   ps=db.prepareStatement("'");
	  ps.executeUpdate();
	  return true;
	  }
	   catch(Exception e){
		  System.err.println(e);
		  e.printStackTrace();
		  return false;
	  }
	  
	  
	  
 }
 
 
 
 
 
 
   /**
    * Sprawdza czy uzytkownik istnieje w bazie danych
    * 
    * @param String nazwa uzytkownika (PESEL)
    * @return boolean true jezeli istnieje taki PESEL w bazie, false w przeciwnym wypadku
    */
  
}
