package server;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static Database dbIsntance;
    private static Connection con ;
   // private static Statement stmt;


    private Database() {
      // private constructor //
    }

    public static Database getInstance(){
    if(dbIsntance==null){
        dbIsntance= new Database();
    }
    return dbIsntance;
    }

    public  Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:mysql://localhost:3306/sklep";
                String username = "hr";
                String password = "";
                con = DriverManager.getConnection( host, username, password );
            } catch (SQLException ex) {
             	System.err.println(ex);
                ex.printStackTrace();
            }
        }

        return con;
    }
}