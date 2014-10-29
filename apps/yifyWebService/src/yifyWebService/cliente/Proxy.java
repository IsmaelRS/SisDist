package yifyWebService.cliente;


public class Proxy {
	
	
	
	
	private static double request(String endereco, String busca){
		
		TCPClient cliente = new TCPClient("localhost", 7896);
		//cliente.sendRequest("calc " + op1 +" " + operador + " " + op2);
		return Double.parseDouble(cliente.getResponse());
	}
}
