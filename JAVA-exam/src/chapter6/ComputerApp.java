package chapter6;
import java.util.Scanner;
public class ComputerApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ������");
		int a = sc.nextInt();
		System.out.println("������ڶ�������");
		int b = sc.nextInt();
		System.out.println("�������һ���ַ���");
		String m =sc.next();
		System.out.println("������ڶ����ַ���");
		String n =sc.next();
		Computer computer = new Computer();
		computer.sum(a,b);
		computer.sum(m,n);
		
	}

}
