package view;
import java.util.concurrent.Semaphore;

import controller.ThreadCavaleiro;
public class Corredor {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int idCavaleiro = 0; idCavaleiro <4; idCavaleiro++){
			Thread tCavaleiro = new ThreadCavaleiro (idCavaleiro, semaforo);
			tCavaleiro.start();
		}
	}

}
