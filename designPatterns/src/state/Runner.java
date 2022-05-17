package state;

import java.util.Scanner;

public class Runner {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		MachineGum appGum = new MachineGum();
		
		appGum.start();
	}

}
