package cn.qlgy.com.day1119;
import java.util.Arrays;
import java.util.Scanner;
public class demo2
{//��ʾ�û�����ɼ�������ƽ���֡����ֵ����Сֵ��
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    int [] scores = new int[5];
	    for(int i =0;i < scores.length; i++)
	   {
	    	System.out.println("�������"+(i+1)+"����Ա�ɼ�");
	    	scores[i] = sc.nextInt();
	   }
	        System.out.println(Arrays.toString(scores));//��ӡ����ĳɼ�
		//������߷�
	        Arrays.sort(scores);//��������
	        System.out.println(Arrays.toString(scores));
	        System.out.println("��߷�"+scores[0]);
	        System.out.println("��ͷ�"+scores[scores.length-1]);
	        int sum = 0;
	        for(int i : scores)//��������Ԫ�����
	        {
	        	sum += i;
	        }
	        int avg = sum/scores.length;
	        System.out.println("ƽ����Ϊ"+avg);
	        
	}
	

}
