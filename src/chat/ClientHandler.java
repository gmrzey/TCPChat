package chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ClientHandler> clients;

	public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
		this.client = clientSocket;
		this.clients = clients;		
		out = new PrintWriter(client.getOutputStream(), true);
	}

	@Override
	public void run() {

		BufferedReader keyRead;
		try {

			keyRead = new BufferedReader(new InputStreamReader(System.in));
			OutputStream ostream = client.getOutputStream();			
			InputStream istream = client.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
			String receiveMessage, sendMessage;

			if ((receiveMessage = receiveRead.readLine()) != null) {
				System.out.println(receiveMessage);
				Broadcast(receiveMessage);
			}			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Broadcast(String msg) {
		for (ClientHandler egyKliens : clients) {
			
			egyKliens.out.println(msg);
		}


	}
}
