package demo03_oop;
/**���췽��(���캯����������):�Զ�����г�ʼ��
 * ���췽��ʵ�ڶ�����ʱ����JVM���ã��Զ�����г�ʼ����һ�����new��ʹ�á�
 * ���캯���ĺ�����Ҫ������һ�£�û�з���ֵ���͡�
 * ��һ�����ж��������췽�����Զ�����в�ͬ�ĳ�ʼ��(������ͬ)����������صĶ��壬������������ͬ��������ͬ��
 * ���û�й�������ϵͳ��Ĭ�϶���һ���չ�������
 * �������飺�Զ������ͳһ�ĳ�ʼ����
 * @author Antony xu
 *
 */
public class Construtor_Method {
	public static void main(String[] args) {
		Person p = new Person("Jack",14);//���ݴ����Ķ��������jvm��ȥѰ�Һ��ʵĹ��췽����
		System.out.println(p.name+","+p.age);
	}

}
class Person{
	String name;
	int age;
	//�޲ι���
	Person(){
		
	}
	//���췽��
	Person(String name,int age){
		this.name = name;
		this.age =age;
		
	}
}
