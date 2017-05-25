package cn.domain;
/**
 * 如果一个JavaBean与表的字段一一一对应，则这个JavaBean名称：领域对象
 * POJO(简单Java对象) ->JavaBean -> 领域Domain对象
 * @author Antony.xu
 *
 */
public class Stud {
	private String id;
	private String name;
	private Integer age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Stud [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
