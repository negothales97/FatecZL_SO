//Package
package controller;

//imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
//fim_imports

//Classe "ProcController"
public class ProcController {
//	Construtor "ProcController"
	public ProcController() {
//		Classe para usar a classe "object" do java
		super();
	}//Fim construtor "ProcController"
	
	
	
//	Verificacao das propriedades do SO - Classe "propriedades"
	public void propriedades() {
//		Pegandos as propriedades
		String so = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		
//		Apresentando as propriedades
		System.out.println(so);
		System.out.println(arch);
		System.out.println(version);	
	}//Fim classe "propriedades"
	
	
	
//	Classe "leProcesso" - Realiza a leitura de um processo
	public void leProcesso(String path){
//		Tenta rodar o bloco de código, caso apresente algum erro, é direcionado para o "catch"
		try {
//			Realiza a leitura de um processo
			Process proc = Runtime.getRuntime().exec(path);
			
//			Gera a busca pelas informações
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
//			Enquanto existir a lista, apresentar no console
			while (linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} 
//		Caso apresente erro, buscá-lo e apresentá-lo no console
		catch (IOException e) {
			e.printStackTrace();
		}
	}//Fim classe "leProcesso
	
	
	
//	Classe "chamaProcesso" - Inicia processos dentro do computador
	public void chamaProcesso(String path){
//		Tenta rodar o "path"
		try {
			Runtime.getRuntime().exec(path);
		} 
//		Caso apresente o erro, será gerado uma string com o erro e buscará pelo código do erro
		catch (IOException e) {
			String erro = e.getMessage();
			
/*			Caso o erro "740" seja apresentado, é solicitado o comando de root do sistema: 
**			"cmd /c" e é concatenado com a variável "path"			
*/			if (erro.contains("740")){
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(path);
				
//				Após rodar o bloco acima, tenta gerar o comando novamente
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} 
//				//Caso apresente outro erro, é apresentado na tela a mensagem de erro
				catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
//			Caso seja outro erro, é apresentado o mesmo na tela
			else {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}//Fim classe "chamaProcesso"
	
//	Classe "mataProcesso" - Finaliza um programa inciado
	public void mataProcesso(String infoProcesso){
//		Comando para finalizar o processo, junto com o PID
		String cmdPid = "TASKKILL /PID ";
		String cmdNome = "TASKKILL /IM ";
		
		int pid = 0;
		
		StringBuffer buffer = new StringBuffer();
		
//		Junta as variáveis dentro do sistema, para executar o comando
		try {
			pid = Integer.parseInt(infoProcesso);
			buffer.append(cmdPid);
			buffer.append(pid);
		}
//		Caso não rode o comando acima, é concatenado o dado presente na variável "cmdNome", com a "infoProcesso"
		catch (NumberFormatException e){
			buffer.append(cmdNome);
			buffer.append(infoProcesso);
		}

		chamaProcesso(buffer.toString());
	}
}//Fim classe "mataProcesso"