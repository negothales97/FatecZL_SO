//package controller
package controller;

//Classe Construtora "ThreadCalc"
public class ThreadCalc extends Thread {

	private int a;
	private int b;
	private int op;

	// Construtor "ThreadCalc"
	public ThreadCalc(int a, int b, int op) {
		this.a = a;
		this.b = b;
		this.op = op;
	}// Fim construtor "ThreadCalc"

	@Override
	public void run() {
		calc();
	}
	
	public void calc(){
		int tempo = 100 * op;
		try {
			Thread.sleep(tempo);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int res = 0;
		String operacao = "";
		switch (op) {
		case 0:
			res = a + b;
			operacao = "+";
			break;
		case 1:
			res = a - b;
			operacao = "-";
			break;
		case 2:
			res = a * b;
			operacao = "*";
			break;
		case 3:
			res = a / b;
			operacao = "/";
			break;
		default:
			break;
		}
		
		System.out.println(a + " " + operacao + b + " = " + res);
	}

}
