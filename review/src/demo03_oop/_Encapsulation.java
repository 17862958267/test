package demo03_oop;
/**��װ��������������ص�֮һ(Encapsulation)
 * �����ʹ�÷�װ�������׸�ֵ���󣬲����κ��˶����Ը��ģ������Ϣ�Ĳ���ȫ��
 * ���岽�裺
 * �����������Ϊprivate(�ؼ���)������ʹ�ö�����.�������ķ�ʽֱ�ӷ��ʶ�������ԡ�
 * 1.��װ�ĺô�����������ľ���ʵ��
 * 2.��������ݵİ�ȫ��
 * 3.������
 * @author Administrator
 *
 */
public class _Encapsulation {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		//e1.name ="Jack";���뱨���޷�����private���εĳ�Ա���������Ҫ���ʣ�Ҫ���������������ķ���
		e1.setName("Jack");
		e1.setGender("Ů");
		e1.setId("2014001");
		e1.work();
		
	}

}
class Employee{
	//ʹ��private�����γ�Ա����
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
		System.out.println(this.name+"����Ŭ��������");
	}
	
}
