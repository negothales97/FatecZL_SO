package controller;

import java.util.concurrent.Semaphore;

public class ThreadCavaleiro extends Thread{
	private int idCavaleiro;
	public static boolean bTocha = false;
	public static boolean bPedra = false;
	public static int port;
	int porta = 0;
	
	private Semaphore semaforo;
	
	public ThreadCavaleiro(int idCavaleiro, Semaphore semaforo){
		this.idCavaleiro = idCavaleiro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
			CavaleiroRun();
			
			try {
				semaforo.acquire();
				Porta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
			
	}
	
	
	public void CavaleiroRun(){
		int distTotal = 2000;
		int distPercorrida = 0;
		int tempo = 50;
		
		while (distPercorrida < distTotal){
			int deslocamento = (int)((Math.random() * 3)+2);
			distPercorrida += deslocamento;
			
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(distPercorrida >= 500 && bTocha == false){
				bTocha = true;
				deslocamento+=2;
				System.out.println(idCavaleiro+" pegou a tocha");
			}
			if(distPercorrida >=1500 && bPedra == false){
				bPedra = true;
				deslocamento+=2;
				System.out.println(idCavaleiro+" pegou a pedra");
			}
		
		}
		System.out.println("Cavaleiro #" +idCavaleiro+" chegou");
	}
	
	public void Porta(){
		int port = (int)(Math.random()*5);
		if(porta == port){
			System.out.println(idCavaleiro+" Viveu");
		}else{
			System.out.println(idCavaleiro+" Ta Morto");
		}
		porta++;
	}
}
