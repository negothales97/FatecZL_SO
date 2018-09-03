package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


//Classe "ListController"
public class ListController {
//	Construtor "ListController"q
	public ListController(){
//		Classe para usar a classe "object" do java		
		super();
	}//Fim construtor "ListController"
	
//	Sistema operacional
	public String sistema(){
		String so = System.getProperty("os.name");
		return so;
	}
//	Classe "processos"
	public void processos(){
		String so = sistema();
		
			try {
				Process proc = null;
//				Realiza a leitura de um processo
				if(so.contains("Windows 10")){
					proc = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				}
				else{
					if(so.contains("Linux")){
						proc = Runtime.getRuntime().exec("ps -ef");
					}
				}
				
				
//				Gera a busca pelas informações
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
//				Enquanto existir a lista, apresentar no console
				while (linha != null){
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
			} 
//			Caso apresente erro, buscá-lo e apresentá-lo no console			
			catch (IOException e) {
				e.printStackTrace();
			}
	}

//	Classe "chamaProcesso" - Inicia processos dentro do computador
	public void chamaProcesso(String path){
//		Tenta rodar o "path"
		try {
			Runtime.getRuntime().exec(path);
		} 
//		Caso apresente o erro, será gerado uma string com o erro e buscará pelo código do erro
		catch (IOException e) {
			e.getMessage();
		}
	}//Fim classe "chamaProcesso"
	
	public void mataPid(String kill){
//		Comando para finalizar o processo, junto com o PID
		String so = sistema();
		String cmdPid = null;
		if(so.contains("Windows 10")){
			cmdPid = "TASKKILL /PID ";
		}else{
			if(so.contains("Linux")){
				cmdPid = "kill -9 ";
			}
		}
		int pid = 0;
		
		StringBuffer buffer = new StringBuffer();
		
//		Junta as variáveis dentro do sistema, para executar o comando
		try {
			pid = Integer.parseInt(kill);
			buffer.append(cmdPid);
			buffer.append(pid);
		}
//		Caso não rode o comando acima, é concatenado o dado presente na variável "cmdNome", com a "infoProcesso"
		catch (NumberFormatException e){
			e.printStackTrace();
		}	
		chamaProcesso(buffer.toString());
	}
	
	public void mataNome(String kill){
//		Comando para finalizar o processo, junto com o PID
		String so = sistema();
		
		String cmdNome = null;
		if(so.contains("Windows 10")){
			cmdNome = "TASKKILL /IM ";
		}else{
			if(so.contains("Linux")){
				cmdNome = "killall"; 
			}
		}
		StringBuffer buffer = new StringBuffer();
		
//		Junta as variáveis dentro do sistema, para executar o comando
		try {
			buffer.append(cmdNome);
			buffer.append(kill);
		}
//		Caso não rode o comando acima, é concatenado o dado presente na variável "cmdNome", com a "infoProcesso"
		catch (NumberFormatException e){
			e.printStackTrace();
		}
		chamaProcesso(buffer.toString());
	}

}//Fim classe "ListController"
