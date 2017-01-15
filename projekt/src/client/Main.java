package client;

import server.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {

	Client client = new Client();
        try {
         client.connect("127.0.0.1", (short) 1337);
          
        } catch(ConnectException e) {
            JOptionPane.showMessageDialog(null, "Nie mozna polaczyc sie z serwerem.", "Warning", 0);
            System.exit(-1);
            return;
        } catch(UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Nieznany host serwera.", "Warning", 0);
            System.exit(-1);
            return;
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Wyjatek typu wejscie/wyjscie podczas proby polaczenia.", "Warning", 0);
            System.exit(-1);
            return;
        }
        //tu bedzie jakas chujowy interfejs z wiersza polecen wywolany
        //i tam client.wyslij
	}

}
