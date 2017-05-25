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

/**1.利用JAVAFX开发一个界面程序,查看接口与抽象类的功能
 * 2.开发一个监听器，用来监控按钮的状态ActionListener
 * 3.开发一个窗口监听器，监控窗口的状态WindowListener
 * 4.关闭窗口时应该调JFrame中的命令来关闭，不能直接退出虚拟机。
 * @author xuxin
 *
 */
public class Window extends JFrame {
	 
     public Window(){
     WindowListener wl= new MyWindowListener();
     addWindowListener(wl);
     JButton btn = new JButton("按钮");
     setVisible(true);
	 setSize(400,400);
	 setTitle("界面窗口");
	 Container con = getContentPane();
	 con.setLayout(new FlowLayout());
	 con.add(btn);
	 //开发按钮监听器，监听按钮的状态
	 btn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("你点了这个按钮");
		}
		 
	 });
	
     }
    public static void main(String[] args) {
		new Window();
	}
}
//开发适配器来监听窗口的状态
class MyWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("窗口最大化了");
		
	}
	

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("窗口关闭了");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("窗口正在关闭");
		//System.exit(0);直接退出java虚拟机，这个代码千万不能写
		//实现关闭功能
		JFrame jrf = (JFrame) e.getSource();
		jrf.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("窗口最小化");
		
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
		System.out.println("窗口打开了");
		
	}
	
}

