package lista02.questao01.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	ServerSocket listenSocket;
	int serverPort;
	public TCPServer(int serverPort){
		try{
			ServerSocket listenSocket = new ServerSocket(serverPort);
			System.out.println("Servidor iniciado");
			while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
	
	
}
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	
	
	public void run(){
		try {			                 // an echo server
			String response;
			String data = getRequest();
			String[] x = data.split(" ");
			if (x[0].equals("calc")) {
				double op1 = Double.parseDouble(x[1]);
				double op2 = Double.parseDouble(x[3]);
				double resultado = 0;
				
				
				if (x[2].equals("+")) {
					resultado = Calc.add(op1, op2);
				} else if (x[2].equals("-")) {
					resultado = Calc.sub(op1, op2);
				} else if (x[2].equals("*")) {
					resultado = Calc.mult(op1, op2);
				} else if (x[2].equals("/")) {
					resultado = Calc.div(op1, op2);
				}
				response = Double.toString(resultado);
				
			}else{
				response = "Operacao invalida: " + data;
			}
			sendResponse(response);			
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
	
	public String getRequest(){
		String data = null;
		try {
			data = in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}	                  // read a line of data from the stream
		return data;
	}
	
	public void sendResponse(String response){
		try {
			out.writeUTF(response.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}