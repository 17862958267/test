package demo03_oop;
/**封装，面向对象三大特点之一(Encapsulation)
 * 如果不使用封装，很容易赋值错误，并且任何人都可以更改，造成信息的不安全。
 * 具体步骤：
 * 设置类的属性为private(关键字)，不能使用对象名.属性名的方式直接访问对象的属性。
 * 1.封装的好处：隐藏了类的具体实现
 * 2.提高了数据的安全性
 * 3.操作简单
 * @author Administrator
 *
 */
public class _Encapsulation {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		//e1.name ="Jack";编译报错，无法访问private修饰的成员变量。如果要访问，要在类中申明公开的方法
		e1.setName("Jack");
		e1.setGender("女");
		e1.setId("2014001");
		e1.work();
		
	}

}
class Employee{
	//使用private来修饰成员变量
	private String name;
	private String id;
	private String gender;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void work(){
		System.out.println(this.name+"正在努力工作！");
	}
	
}
