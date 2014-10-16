package lista02.questao02.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	String serverIp = null;
	int serverPort = 0;
	
	Socket s = null;
	DataOutputStream out;
	DataInputStream in;
	
	public TCPClient(String serverIp, int serverPort){
		this.serverIp = serverIp;
		this.serverPort = serverPort;
		try{
			s = new Socket(serverIp, serverPort);			
		}catch (UnknownHostException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline:" + e.getMessage());
		}
	}
	public void sendRequest(String request){
		
		try {
			out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(request); // UTF is a string encoding see Sn. 4.4

		} catch (UnknownHostException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline:" + e.getMessage());
		} 
	}
	
	public String getResponse(){
		String response = null;
		try {
			in = new DataInputStream( s.getInputStream());
			response = in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;	
	}
	
	public void close(){
		if (s != null)
			try {
				s.close();
			} catch (IOException e) {
				System.out.println("close:" + e.getMessage());
			}
	}
	
}
