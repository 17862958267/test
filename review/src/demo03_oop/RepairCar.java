package demo03_oop;
/**��Ա����:  ���������б���
      �ֲ�����:  �����ڷ����б���
 Ӧ�÷�Χ  
1.��Ա�������������ڶ���Ч    
2.�ֲ�����ֻ���������ķ�������Ч
2.��������  
1.��Ա����: �����ڶ��������Ŷ���Ĵ��������������Ŷ������ʧ����ʧ 
�ֲ�����: ʹ���������ͷſռ䡣
3.�洢λ��  ��Ա�������ڶ������洢�ڶ��ڣ����ڵ�ʵ�壬��û������ָ����ʱ���������������� �ֲ���������ջ�ڴ��У�������ʹ��ʱ�����Ͼͻᱻ�ͷš�
4.��ʼֵ 
��Ա�������洢�ڶ��У����û�и���ֵ������Ĭ��ֵ��
�ֲ����������Ҫ��ʹ�ñ����ֶ���ʼ��.����ջ��
*/
public class RepairCar {
	public static void main(String[] args) {
		Car c = new Car();
		new Car().run();//��������û�����ֵ�ʵ��
		c.run();
		c.num = 3;
		c.run();
		CarFactory cf = new CarFactory();
		cf.name ="������";
		cf.addr ="���ݸ���";
		cf.repair(c);
		c.run();
		
	}

}
class Car{
	String name = "smart";
	String color = "red";
	int num = 4;
	public void run(){
		if(num<4){
		System.out.println("���ӻ��ˣ��Ͻ�ȥ��");
		}else{
			System.out.println("������������");
		}
	}
}
class CarFactory{
	String name;
	String addr;
	public void repair(Car c){
		c.num =4;
		System.out.println("�����޺���");
		
	}
	
}
