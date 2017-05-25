package demo01_abstract;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**内部类的功能：1访问外部类成员信息与封闭信息
 * 2.回调
 * 通过开发一个界面程序体现内部类的功能
 * @author Administrator
 *
 */
public class Inner_Window  extends JFrame{
 
	public Inner_Window(){
		JLabel jbl = new JLabel("专业：");
		JTextField jt = new JTextField(20);
		jt.setEditable(false);
		
		JButton jbtn = new JButton("请选择");
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


