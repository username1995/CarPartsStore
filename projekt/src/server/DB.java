import java.sql.*;
     
public class Join {

  public static void main(String args[]) {
      
    String url = "jdbc:mySubprotocol:myDataSource";
    Connection con;
    String query = "select SUPPLIERS.SUP_NAME, COFFEES.COF_NAME " +
             "from COFFEES, SUPPLIERS " +
             "where SUPPLIERS.SUP_NAME like 'Acme, Inc.' and " +
             "SUPPLIERS.SUP_ID = COFFEES.SUP_ID";
    Statement stmt;
  
    try {
      Class.forName("myDriver.ClassName");

    } catch(java.lang.ClassNotFoundException e) {
      System.err.print("ClassNotFoundException: ");
      System.err.println(e.getMessage());
    }
  
    try {
      con = DriverManager.getConnection (url, 
                   "myLogin", "myPassword");
  
      stmt = con.createStatement();              
  
      ResultSet rs = stmt.executeQuery(query);
      System.out.println("Supplier, Coffee:");
      while (rs.next()) {
        String supName = rs.getString(1);
        String cofName = rs.getString(2);
        System.out.println("    " + supName + ", " + cofName);
      }

      stmt.close();
      con.close();

    } catch(SQLException ex) {
      System.err.print("SQLException: ");
      System.err.println(ex.getMessage());
    }  
  }
}



