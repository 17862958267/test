package demo03_oop;
/**构造方法(构造函数，构造器):对对象进行初始化
 * 构造方法实在对象建立时，由JVM调用，对对象进行初始化，一般伴随new的使用。
 * 构造函数的函数名要与类名一致，没有返回值类型。
 * 在一个类中定义多个构造方法，对对象进行不同的初始化(参数不同)，这就是重载的定义，即函数名称相同，参数不同。
 * 如果没有构造器，系统会默认定义一个空构造器。
 * 构造代码块：对对象进行统一的初始化。
 * @author Antony xu
 *
 */
public class Construtor_Method {
	public static void main(String[] args) {
		Person p = new Person("Jack",14);//根据创建的对象个数，jvm会去寻找合适的构造方法，
		System.out.println(p.name+","+p.age);
	}

}
class Person{
	String name;
	int age;
	//无参构造
	Person(){
		
	}
	//构造方法
	Person(String name,int age){
		this.name = name;
		this.age =age;
		
	}
}
