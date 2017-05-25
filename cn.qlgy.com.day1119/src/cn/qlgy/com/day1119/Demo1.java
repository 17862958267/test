package cn.qlgy.com.day1119;

import java.util.Arrays;

public class Demo1
{

	public static void main(String[] args)
{
	int[] myArray = {1,2,45,25,67};
	for(int i = 0; i < myArray.length; i++)
	{
		if(myArray[i] == 1)
		{
			myArray[i] =33;
		}
		
		System.out.println("myArray["+i+"]="+myArray[i]);
		//传统型for循环
	}
	    System.out.println(Arrays.toString(myArray));
	for(int i : myArray)//增强型for循环，侧重于数据集合的遍历。适用于只读的集合变量，因为在遍历时得不到数组下标，无法真正引用数组。不能对其修改。
	{
		System.out.println(i);
		
	}
	    System.out.println(Arrays.toString(myArray));
	    

}

}
