package javabootcamp.basic.methods;

public class Runner {

	public static void main(String[] args) {
		
		int exam1=92, exam2=94, exam3= 97;
		float grade;
		
		grade = avergaGrade(exam1, exam2, exam3);
		
		System.out.printf("The average is: %.2f", grade);
	}

	public static float avergaGrade(int exam1,int exam2,int exam3) {
		float grade = 0;
		
		grade = (exam1+exam2+exam3)/3f;
		
		return grade;
	}
	
	
}
