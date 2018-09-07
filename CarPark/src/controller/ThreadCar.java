package controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {
	
	private int idCar;
	private static int posChegada;
	private static int posSaida;
	
	private Semaphore semaforo;
	public ThreadCar(int idCar, Semaphore semaforo){
		this.idCar = idCar;
		this.semaforo = semaforo;
	}
	
	
	@Override
	public void run() {
		carroAndando();
		
		try {
			semaforo.acquire();
			carroParado();
			carroSaindo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
		
	}
	
	
	public void carroAndando(){
		int  distTotal = (int)(Math.random() * 1001) + 2000;
		int distPercorrida = 0;
		int deslocamento = 30;
		int tempo = 50;
		
		while(distPercorrida < distTotal){
			distPercorrida += deslocamento;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carro #"+idCar+" andou "+distPercorrida+"m.");
		}
		posChegada++;
		System.out.println("Carro #"+idCar+" foi o "+posChegada+"o. a chegar");
	}
	
	public void carroParado(){
		System.out.println("Carro #"+idCar+" estacionou");
		int tempoParado = (int) ((Math.random() * 2001) + 1000);
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void carroSaindo(){
		posSaida++;
		System.out.println("Carro #"+idCar+" foi o "+posSaida+"o. a sair");
	}
}
