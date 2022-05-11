package bootcamp.oop.enumeration;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		
		Level lev = Level.HIGH;
		System.out.println(Level.values());
	}
	
	public static Level checkTemp(double temp) {
		if(temp>100) {
			return Level.HIGH;
		}else {
			return Level.LOW;
		}
	}
	
}

enum Level{
	LOW,MEDIUM,HIGH
}