package chapter3;
import java.util.Scanner;
public class ScannerReader {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入第一数值：");
	int t1 =  sc.nextInt();
	System.out.println("请输入第二个数值：");
	int t2 =  sc.nextInt();
	System.out.println("请输入字符串：");
	String op = sc.next();
	if(op.equals("+"))
	{
		System.out.println(t1+t2);
	}
	else if (op.equals("-"))
	{
		System.out.println(t1-t2);
	}
	

	}

}
