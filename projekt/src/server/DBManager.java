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

/** DBManager.java
 * 
 * Klasa zajmuj¹ca siê cala komunikacja z baza danych za pomoca JDBC
 * @author Dominik Szczerek
 * 
 */
public class DBManager {
	private Connection db;

	private String url;
	private String username;
	private String password;
	
	
	public DBManager(String host, String user, String pass) {
		url = host;
	    username = user;
	    password = pass;

    //wywo³anie singletona - klasa kliencka
            db =Database.getInstance().getConnection();;
     
        
        System.out.println("Dokonano po³aczenia z baz¹ danych");
	}

   /** 
    * Probuje zalogowac uzytkownika w bazie danych
    * 
    *
    * @param Stringusername String proponowany PESEL
    * @param Stringpassword proponowane haslo
    * @return boolean true jesli zalogowano, false w przeciwnym razie
    * @throws SQLException jesli jest jakis problem po stronie SQL-a
    * 
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
   /** 
    * Wydobywa dane z bazy danych
    * @return String dane wyciagniete z bazy danych w postac zakodowanej wiadomosci    */

   
   
   public String getData(){
   
   PreparedStatement ps = null;
   ResultSet rs =null;;
   String data = "";  
   
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
   
 
   /**
    * Dodaje uzytkownika do bazy danych
    * 
    * @param username String PESEL nowego uzytkownika
    * @param password String haslo nowego uzytkownika
    *
    *@throws SQLException Ijezeli baza danych niedostepna
    * M
    */
 
   
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

/**
    * Zamyka polaczenie JDBC typu Statement
    * 
    */
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
}
