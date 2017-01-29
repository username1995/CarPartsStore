package server;

import client.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Session {
	private String username;
	private Socket socket;
//	private PrintWriter outputWriter;
	//private BufferedReader inputBuffer;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	
	/** Ustanawia polaczenie dla podanego socketu
	 * 
	 * @param socket A po³aczony socket do komunikacji
	 */
	Session(Socket socket) {
            this.socket = socket;
            try {
          //      inputBuffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); 
             //   outputWriter = new PrintWriter(this.socket.getOutputStream(), true);
            	os = new ObjectOutputStream(socket.getOutputStream());
    			is = new ObjectInputStream(socket.getInputStream());
            } catch(IOException e) {
                System.err.println(e);
                e.printStackTrace();
            }
	}
/*	

	public void write(String msg) {
            outputWriter.println(msg);
            outputWriter.flush();
	}

	public String read() {
            String line = "";
            try {
                line = inputBuffer.readLine();
            }
            catch(SocketException e) {
            	System.out.println("Klient sie rozlaczyl, koniec sesji");
            }
            catch(IOException e) {
                System.err.println(e);
                e.printStackTrace();
            }
            return line;
	}
	

	public boolean disconnect() {
            try {
                socket.close();
                inputBuffer.close();
            } catch(IOException e) {
                System.err.println(e);
                e.printStackTrace();
                return false;
            }
            outputWriter.close();
            return true;
	}
	*/
	
	public Socket getSocket() { return socket; }
	
}
