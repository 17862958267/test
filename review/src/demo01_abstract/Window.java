package demo01_abstract;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**1.����JAVAFX����һ���������,�鿴�ӿ��������Ĺ���
 * 2.����һ����������������ذ�ť��״̬ActionListener
 * 3.����һ�����ڼ���������ش��ڵ�״̬WindowListener
 * 4.�رմ���ʱӦ�õ�JFrame�е��������رգ�����ֱ���˳��������
 * @author xuxin
 *
 */
public class Window extends JFrame {
	 
     public Window(){
     WindowListener wl= new MyWindowListener();
     addWindowListener(wl);
     JButton btn = new JButton("��ť");
     setVisible(true);
	 setSize(400,400);
	 setTitle("���洰��");
	 Container con = getContentPane();
	 con.setLayout(new FlowLayout());
	 con.add(btn);
	 //������ť��������������ť��״̬
	 btn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("����������ť");
		}
		 
	 });
	
     }
    public static void main(String[] args) {
		new Window();
	}
}
//�������������������ڵ�״̬
class MyWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("���������");
		
	}
	

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("���ڹر���");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("�������ڹر�");
		//System.exit(0);ֱ���˳�java��������������ǧ����д
		//ʵ�ֹرչ���
		JFrame jrf = (JFrame) e.getSource();
		jrf.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("������С��");
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		System.out.println("���ڴ���");
		
	}
	
}

