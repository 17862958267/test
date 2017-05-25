package demo02_thread;

import org.junit.Test;

/**
 * 如果将One前面加上static那么可以直接调用内部类的方法而不需要去实例化当前类
 * 只需要One one=new One()然后再调用
 * @author Administrator
 *
 */
public class Demo01_FieldThread {
	//声明一个成员内部类
	class One{
		public void say(){
			System.out.println("我在说话");
		}
	}
	public static void main(String[] args) {
		//由于内部类One不是静态的，所以要想调用必须实例化当前类
		Demo01_FieldThread demo01 = new Demo01_FieldThread();
		One one = demo01.new One();
		one.say();
	}
}
