package chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private static ArrayList <ClientHandler> clients = new ArrayList<>();
	
	private static ExecutorService pool = Executors.newFixedThreadPool(4);
	
	public static void main(String[] args)throws IOException{
		
		ServerSocket ss = new ServerSocket(1500);
		System.out.println("A szerver kliens csatlakozására vár..");
		while(true) {		
			Socket client = ss.accept();
			System.out.println("Csatlakozott egy új felhasználó");
			ClientHandler clientThread = new ClientHandler(client, clients);
			clients.add(clientThread);
			pool.execute(clientThread);
		}
		
		
		
	}

}
