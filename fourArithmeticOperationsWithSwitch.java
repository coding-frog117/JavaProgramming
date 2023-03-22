package fourArithmeticOperations;

import java.util.Scanner;

public class fourArithmeticOperationsWithSwitch {
	public static int addition(int n1, int n2) {
		return n1 + n2;
	}
	
	public static int subtraction(int n1, int n2) {
		return n1 - n2;
	}
	
	public static int multipulication(int n1, int n2) {
		return n1 * n2;
	}
	
	public static int divistion(int n1, int n2) {
		return n1 / n2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num1 = scanner.nextInt();
		String operation = scanner.next();
		int num2 = scanner.nextInt();
		
		switch (operation) {
			case '+':
				System.out.printf(num1+"+"+num2+"의 계산결과는"+addition(num1,num2)+"입니다.");
			break;
			case '-':
				System.out.printf(num1+"+"+num2+"의 계산결과는"+subtraction(num1,num2)+"입니다.");
			break;
			case '*':
				System.out.printf(num1+"+"+num2+"의 계산결과는"+addition(num1,num2)+"입니다.");
			break;
			case '/':
				if (num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				System.out.printf(num1+"+"+num2+"의 계산결과는"+divistion(num1,num2)+"입니다.");
				break;
		}
		
	}
}