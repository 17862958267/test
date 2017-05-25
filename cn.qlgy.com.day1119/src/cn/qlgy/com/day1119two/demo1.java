package cn.qlgy.com.day1119two;
public class demo1 
{
	public static void main(String[] args)
	{
		//int[][] myArray2;//定义二维数组
		//int[][] myArray1,myArray2;//一条语句可定义多个相同类型的数组变量
		//int myArray3[][];//作用与上述一样
		//new int[2][3]二维数组的创建：new 数据类型[行数][列数]
		//int[][] myArray1 = new int[3][];//先分配行数
       int[][] array;
       array = new int[2][];
       array[0] = new int[3];
       array[1] = new int[5];
       for(int i = 0;i < array.length;i++)
       {
    	   for(int j = 0; j < array[i].length;i++)
    	   {
    		   System.out.println("第i行j列的元素为："+array[i][j]);
    	   }
       }
    	   
		
		
	}
	

}
