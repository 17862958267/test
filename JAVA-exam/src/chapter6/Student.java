package chapter6;

public class Student {
	private String name;
	private int math;
	private int english;
	private static String no;
	private static int sum;
	private static int num;
	private static int avg;
	public Student() {
		
	}
	public Student(String no,String name) {
		
		this.name=name;
		this.no=no;
		
		
	}
	public void sum(int english,int math)
	{
		System.out.println("�ܷ�="+(english+math));
		System.out.println("ƽ����="+(english+math)/2);
	}
	
	
	public void disp()
	{
		System.out.println("ѧ��"+no);
		System.out.println("����"+name);
		
		
	}
	
	

}
