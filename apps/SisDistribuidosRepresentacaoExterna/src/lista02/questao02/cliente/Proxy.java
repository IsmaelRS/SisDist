package lista02.questao02.cliente;

import lista02.questao02.model.Municipio;

public class Proxy {
	
	public static Municipio findMunicipio(){
		//return request(endereco, busca);
		return null;
	}
	
	
	private static double request(String endereco, String busca){
		
		TCPClient cliente = new TCPClient("localhost", 7896);
		//cliente.sendRequest("calc " + op1 +" " + operador + " " + op2);
		return Double.parseDouble(cliente.getResponse());
	}
}
