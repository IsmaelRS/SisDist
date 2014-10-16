package lista02.questao01;

import lista02.questao01.cliente.TCPClient;

public class User {

	public static void main(String[] args) {
		TCPClient cliente = new TCPClient("localhost", 7896);
		cliente.sendRequest("calc 10 - 5");

		System.out.println(cliente.getResponse());
	}

}
