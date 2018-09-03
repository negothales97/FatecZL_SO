package view;

import javax.swing.JOptionPane;

import controller.ListController;

public class Main {
	public static void main(String[] args) {
		ListController list = new ListController();
		
		int opc = 0;
		String kill = null;
		
		
//		Menu de interação dos métodos
		while(opc != 9){
			opc = Integer.parseInt(JOptionPane.showInputDialog("[--SELECIONE UMA DAS OPCOES--] " +
					"\n1 - Lista Processos do sistema\n2 - Finaliza processo via PID \n3 - Finaliza processo via nome"
                        + "\n9 - Finaliza"));
			switch (opc) {
			case 1:
				list.processos();
				break;
			case 2:
				kill = JOptionPane.showInputDialog("Informe o programa que deseja finalizar via Pid:");
				list.mataPid(kill);
				break;
			case 3:
				kill = JOptionPane.showInputDialog("Informe o programa que deseja finalizar via nome:");
				list.mataNome(kill);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "FINALIZADO");
				break;
			default:
				JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
				break;
			}
		}
		

		
	}
}
