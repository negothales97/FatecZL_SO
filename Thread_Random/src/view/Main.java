package view;

import controller.RandomNum;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i<5;i++){
			Thread RandomNum = new RandomNum();
			RandomNum.start();
		}

	}

}
