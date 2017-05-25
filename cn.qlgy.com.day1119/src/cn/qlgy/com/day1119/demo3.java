package cn.qlgy.com.day1119;
import java.util.Arrays;
import java.util.Scanner;
public class demo3 
{//一次输入五个成员姓名，查找是否有jack
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    String [] names = new String[5];
	    for(int i =0;i < names.length; i++)
	   {
	    	System.out.println("请输入第"+(i+1)+"个成员姓名");
	    	names[i] = sc.next();
	   }
	        //打印输入的姓名System.out.println(Arrays.toString(names));
	        boolean flag = false;
	       for(String n : names)//数组遍历，查找有无jack这个人
	       {
	    	   if("jack".equals(n))
	    	   {
	    		System.out.println("jack是小组成员");
	    		flag = true;
	    	   }
	       }
	       if(flag)
	       {
	    	   System.out.println("jack是本小组成员");
	       }
	       else
	       {
	    	   System.out.println("jack不本小组成员");
	       }
        
    }
}
