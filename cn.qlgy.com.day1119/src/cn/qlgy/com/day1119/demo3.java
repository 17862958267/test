package cn.qlgy.com.day1119;
import java.util.Arrays;
import java.util.Scanner;
public class demo3 
{//һ�����������Ա�����������Ƿ���jack
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    String [] names = new String[5];
	    for(int i =0;i < names.length; i++)
	   {
	    	System.out.println("�������"+(i+1)+"����Ա����");
	    	names[i] = sc.next();
	   }
	        //��ӡ���������System.out.println(Arrays.toString(names));
	        boolean flag = false;
	       for(String n : names)//�����������������jack�����
	       {
	    	   if("jack".equals(n))
	    	   {
	    		System.out.println("jack��С���Ա");
	    		flag = true;
	    	   }
	       }
	       if(flag)
	       {
	    	   System.out.println("jack�Ǳ�С���Ա");
	       }
	       else
	       {
	    	   System.out.println("jack����С���Ա");
	       }
        
    }
}
