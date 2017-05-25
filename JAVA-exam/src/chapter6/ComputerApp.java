package chapter6;
import java.util.Scanner;
public class ComputerApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个整数");
		int a = sc.nextInt();
		System.out.println("请输入第二个整数");
		int b = sc.nextInt();
		System.out.println("请输入第一个字符串");
		String m =sc.next();
		System.out.println("请输入第二个字符串");
		String n =sc.next();
		Computer computer = new Computer();
		computer.sum(a,b);
		computer.sum(m,n);
		
	}

}
