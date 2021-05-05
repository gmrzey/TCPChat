package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnect implements Runnable {
	
	private Socket server;
	private BufferedReader in;
	
	
	public ServerConnect(Socket s) throws IOException {
		server=s;
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		
	}

	@Override
	public void run() {
		
		
			String serverResponse = null;
			try {
				while(true) {
				serverResponse = in.readLine();
				System.out.println(serverResponse);
			}
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					in.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	}


