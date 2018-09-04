package controller;

public class ThreadControl extends Thread{
//	Variaveis
	int[][] matriz;
	int linha;
	int t;
	
//	Construtor "ThreadControl"
	public ThreadControl(int[][] matriz, int linha){
//		Instanciando valores
		this.matriz = matriz;
		this.linha = linha;
		t = linha *1000;
//		Apresentando pausa entre Threads
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		SomaNum();
	}
	
//	Realiza a soma das linhas
	public void SomaNum(){
		int soma = 0;
		for(int i=0; i<5;i++){
			soma = soma + matriz[linha][i];
			System.out.println(matriz[linha][i]);
		}
		System.out.println("linha " + linha + " - " + soma);
	}
}
