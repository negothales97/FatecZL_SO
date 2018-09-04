package controller;

import java.util.Random;

public class RandomNum extends Thread{
//	Construtor "RandomNum"
	public RandomNum(){
	}
//	Fim construtor "RandomNum"
	
	
	@Override
	public void run(){
		VerNum();
	}
	//Cria um número aleatório
	public void VerNum(){
		Random rn = new Random();
		System.out.println(rn.nextInt(50)+1);
	}
}
