//Package
package controller;

//imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

//Classe "RedesController"
public class RedesController {
//	Construtor "RedesController"	
	public RedesController(){
//		Classe para usar a classe "object" do java
		super();
	}//Fim construtor "RedesController"
	
	
//Classe "ip"
	public void ip(String path){
		String so = System.getProperty("os.name");
		
		if(so.contains("Windows 10")){
			try {
				Process proc = Runtime.getRuntime().exec(path);

//				Realiza a execucao do comando
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
//				Criação lista
				ArrayList<String> listIp = new ArrayList();
				
//				Enquanto existir linha, apresentar no console
				while(linha != null){
//					Se localizar "Adaptador" e "IPv4", guardar na lista
					if(linha.contains("Adaptador") || linha.contains("IPv4")){
						listIp.add(linha);
					}
					linha = buffer.readLine();
				}//Fim while
				
				int i = 0;
				int n = listIp.size();
				//Caso a linha possua "IPv4", apresentar na tela a anterior e a atual
				for(i=0; i<n; i++){
					if(listIp.get(i).contains("IPv4")){
						System.out.println(listIp.get(i-1));
						System.out.println(listIp.get(i).substring(49));
					}//Fim "if"
					
				}//Fim "for"
			}//Fim "try" 
			
			catch (IOException e) {
				e.printStackTrace();
			}//Fim "catch"
		}//Fim "if"
	}//Fim classe "ip"
	
	
//	Classe "ping"
	public void ping(String path){
		String so = System.getProperty("os.name");
		
		if(so.contains("Windows 10")){
			try {
				Process proc = Runtime.getRuntime().exec(path);

//				Realiza a execucao do comando
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				
//				Enquanto existir linha, apresentar no console
				while(linha != null){
//					é criado um vetor, para quebrar as linhas no console
//					e retornado somente as linhas que possui "tempo",
//					apresentando somente o tempo
					String[] vetPing = linha.split(" ");
					for(String ping: vetPing){
						if(ping.contains("tempo")){
							System.out.println(ping.substring(6));
						}
					}
					linha = buffer.readLine();
				}//Fim while
			}//Fim "try" 
			
			catch (IOException e) {
				e.printStackTrace();
			}//Fim "catch"
		}//Fim "if"
	}//Fim classe "ping"
}//Fim classe "RedesController"
