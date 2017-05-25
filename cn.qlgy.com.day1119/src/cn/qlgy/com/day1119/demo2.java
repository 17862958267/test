package cn.qlgy.com.day1119;
import java.util.Arrays;
import java.util.Scanner;
public class demo2
{//提示用户输入成绩，计算平均分。最大值，最小值。
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    int [] scores = new int[5];
	    for(int i =0;i < scores.length; i++)
	   {
	    	System.out.println("请输入第"+(i+1)+"个成员成绩");
	    	scores[i] = sc.nextInt();
	   }
	        System.out.println(Arrays.toString(scores));//打印输入的成绩
		//计算最高分
	        Arrays.sort(scores);//数组排序
	        System.out.println(Arrays.toString(scores));
	        System.out.println("最高分"+scores[0]);
	        System.out.println("最低分"+scores[scores.length-1]);
	        int sum = 0;
	        for(int i : scores)//遍历数组元素求和
	        {
	        	sum += i;
	        }
	        int avg = sum/scores.length;
	        System.out.println("平均分为"+avg);
	        
	}
	

}
