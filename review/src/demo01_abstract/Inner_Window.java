package demo01_abstract;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**�ڲ���Ĺ��ܣ�1�����ⲿ���Ա��Ϣ������Ϣ
 * 2.�ص�
 * ͨ������һ��������������ڲ���Ĺ���
 * @author Administrator
 *
 */
public class Inner_Window  extends JFrame{
 
	public Inner_Window(){
		JLabel jbl = new JLabel("רҵ��");
		JTextField jt = new JTextField(20);
		jt.setEditable(false);
		
		JButton jbtn = new JButton("��ѡ��");
		jbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new MajorChoose(new IBack(){

					@Override
					public void BackMsg(String name) {
						jt.setText(name);
						
					}
					
				});
				
				
			}
			
		});
		Container con =getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jbl);
		con.add(jt);
		con.add(jbtn);
		
		
		setVisible(true);
		setSize(400,400);
	}
	
	
	public static void main(String[] args) {
		new Inner_Window();
	}
}

interface IBack{
	public void BackMsg(String name);
}


