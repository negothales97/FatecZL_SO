package view;

import java.util.Random;
import controller.ThreadControl;

public class Principal {
	public static void main(String[] args){
		Random rn = new Random();
		int matriz[][] = new int[3][5];
//		Matriz
		for(int i=0; i <3;i++){
			for(int j=0; j <5;j++){
				matriz[i][j]  = (rn.nextInt(20)+1);
			}
		}//Fim matriz
		
//		Apresentaçao das somas
		for(int op=0; op <3;op++){
			Thread ThreadControl = new ThreadControl(matriz, op);
			ThreadControl.start();
		}
	}
}
