package cn.qlgy.com.day1119two;
public class demo1 
{
	public static void main(String[] args)
	{
		//int[][] myArray2;//�����ά����
		//int[][] myArray1,myArray2;//һ�����ɶ�������ͬ���͵��������
		//int myArray3[][];//����������һ��
		//new int[2][3]��ά����Ĵ�����new ��������[����][����]
		//int[][] myArray1 = new int[3][];//�ȷ�������
       int[][] array;
       array = new int[2][];
       array[0] = new int[3];
       array[1] = new int[5];
       for(int i = 0;i < array.length;i++)
       {
    	   for(int j = 0; j < array[i].length;i++)
    	   {
    		   System.out.println("��i��j�е�Ԫ��Ϊ��"+array[i][j]);
    	   }
       }
    	   
		
		
	}
	

}
