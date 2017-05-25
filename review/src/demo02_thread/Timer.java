package demo02_thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import demo01_abstract.Window;

public class Timer extends JFrame {
	
	public Timer(){
		
		JTextField jtf = new JTextField(15);
		jtf.setEditable(false);
		JButton btn1 = new JButton("开始");
		
		
	Container con = getContentPane();
    con.setLayout(new FlowLayout());
	con.add(btn1);
    con.add(new Label("时间:"));
	con.add(jtf);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(400,400);
	setTitle("Timer");
	setVisible(true);
	class MyTimer extends Thread{
		@Override
		public void run(){
			SimpleDateFormat sdf = new SimpleDateFormat();
			while(true){
				String str =sdf.format(new Date());
				System.out.println(str);
				jtf.setText(str);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
	}
	btn1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			MyTimer t1 = new MyTimer();
			t1.start();
		}
		
	});
	}
	
	
	
	public static void main(String[] args) {
		new Timer();
	}
}
