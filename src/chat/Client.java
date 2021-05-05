package chat;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Client {
	
	public static void main(String[] args)throws IOException{
		Socket socket = new Socket("localhost", 1500);
		String username = JOptionPane.showInputDialog(null, "Írd be a felhasználóneved:");
	    System.out.println(username);
	    System.out.println("Írj valamit, majd nyomd meg az entert!");
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        
	    OutputStream ostream = socket.getOutputStream(); 
	    PrintWriter pwrite = new PrintWriter(ostream, true);

	    ServerConnect serverCon = new ServerConnect(socket);	    
	    new Thread(serverCon).start();	    

	    String receiveMessage, sendMessage;               
	    while(true)
	     {
	        sendMessage = keyRead.readLine();  
	        pwrite.println("["+username + "]:" +sendMessage);       
	        pwrite.flush();
	       
	        /*if((receiveMessage = receiveRead.readLine()) != null) 
	        {
	            System.out.println(receiveMessage);
	        }*/         
	      }     
	}

}
