package demo01_abstract;

import org.junit.Test;

public class MyExtends {
	@Test
	public void test(){
		Dog dog = new Dog(null,0);
		dog.say();
		System.out.println(dog.name);//Jack
		System.out.println(dog.age);//3
	}

}
class Dog extends Animal{

	public Dog(String name, int age) {
		super(name, age);
		
	}

	@Override
	public void say() {
		System.out.println("我是狗");
		
	}
	
	
}
class Animal{
	String name="Jack";
	int age=3;
	public Animal(String name,int age){
		
	}
	public void say(){
		System.out.println("我是一只动物");
	}
}
