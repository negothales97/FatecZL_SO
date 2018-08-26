package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redes = new RedesController();
		
		int opc = 0;
		String path;
		
//		Menu de intera��o dos m�todos
		while(opc != 9 ){
			opc = Integer.parseInt(JOptionPane.showInputDialog("[--SELECIONE UMA DAS OPCOES--] " +
					"\n1 - Apresenta��o dos Adaptadores com IPv4 \n2 - Ping do site Google \n9 - Finaliza"));
			
			switch (opc) {
			case 1:
				path = "ipconfig";
				redes.ip(path);
				break;
			case 2:
				path = "ping -n 10 www.google.com.br";
				redes.ping(path);
				break;
			case 9: JOptionPane.showMessageDialog(null, "FINALIZADO!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "OP��O INV�LIDA");
				break;
			}
		}
		
		
	}

}
