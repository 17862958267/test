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
		//��ͳ��forѭ��
	}
	    System.out.println(Arrays.toString(myArray));
	for(int i : myArray)//��ǿ��forѭ�������������ݼ��ϵı�����������ֻ���ļ��ϱ�������Ϊ�ڱ���ʱ�ò��������±꣬�޷������������顣���ܶ����޸ġ�
	{
		System.out.println(i);
		
	}
	    System.out.println(Arrays.toString(myArray));
	    

}

}
