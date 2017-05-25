package demo03_oop;
/**成员变量:  定义在类中变量
      局部变量:  定义在方法中变量
 应用范围  
1.成员变量在整个类内都有效    
2.局部变量只在其声明的方法内有效
2.生命周期  
1.成员变量: 它属于对象，它随着对象的创建而创建，随着对象的消失而消失 
局部变量: 使用完马上释放空间。
3.存储位置  成员变量属于对象，它存储在堆内，堆内的实体，当没有引用指向其时，才垃圾回收清理 局部变量存在栈内存中，当不在使用时，马上就会被释放。
4.初始值 
成员变量它存储在堆中，如果没有赋初值，它有默认值。
局部变量，如果要想使用必须手动初始化.存在栈中
*/
public class RepairCar {
	public static void main(String[] args) {
		Car c = new Car();
		new Car().run();//匿名对象，没有名字的实体
		c.run();
		c.num = 3;
		c.run();
		CarFactory cf = new CarFactory();
		cf.name ="车汇美";
		cf.addr ="扬州高邮";
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
		System.out.println("车子坏了，赶紧去修");
		}else{
			System.out.println("车子能跑起来");
		}
	}
}
class CarFactory{
	String name;
	String addr;
	public void repair(Car c){
		c.num =4;
		System.out.println("车子修好了");
		
	}
	
}
