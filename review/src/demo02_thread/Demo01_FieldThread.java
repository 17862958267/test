package demo02_thread;

import org.junit.Test;

/**
 * �����Oneǰ�����static��ô����ֱ�ӵ����ڲ���ķ���������Ҫȥʵ������ǰ��
 * ֻ��ҪOne one=new One()Ȼ���ٵ���
 * @author Administrator
 *
 */
public class Demo01_FieldThread {
	//����һ����Ա�ڲ���
	class One{
		public void say(){
			System.out.println("����˵��");
		}
	}
	public static void main(String[] args) {
		//�����ڲ���One���Ǿ�̬�ģ�����Ҫ����ñ���ʵ������ǰ��
		Demo01_FieldThread demo01 = new Demo01_FieldThread();
		One one = demo01.new One();
		one.say();
	}
}
