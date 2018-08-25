package view;

import javax.swing.JOptionPane;
import controller.ProcController;
//Classe "Principal"
public class Principal {
	
	public static void main(String[] args) {
		ProcController pCont = new ProcController();
		
		int opc = 0;
		String path;
		//Menu de interação dos módulos
		while(opc != 9){
			opc = Integer.parseInt(JOptionPane.showInputDialog("[--SELECIONE UMA DAS OPCOES--] " +
					"\n1 - Propriedades do sistema \n2 - Leitura de um processo do sistema \n3 - Inicia um processo"
                        + "\n4 - Finaliza um processo iniciado \n9 - Finaliza"));
			switch (opc) {
			case 1:
				pCont.propriedades();
				break;
			case 2:
				path = "TASKLIST /FO TABLE";
				pCont.leProcesso(path);
				break;
			case 3:
				path = "C:\\Windows\\notepad.exe";
				pCont.chamaProcesso(path);
				JOptionPane.showMessageDialog(null,"PROCESSO CHAMADO");
				break;
			case 4:
				String infoProcesso = "notepad.exe";
				pCont.mataProcesso(infoProcesso);
				JOptionPane.showMessageDialog(null,"PROCESSO FINALIZADO");
				break;
			case 9: JOptionPane.showMessageDialog(null, "FINALIZADO!");	
				break;
			default:
				JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
				break;
			}
		}	
	}
}//Fim classe "Principal"