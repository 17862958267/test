package demo01_abstract;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MajorChoose extends JFrame {
	private IBack back;
	public MajorChoose(IBack back){
		this.back=back;
		JRadioButton jrbtn1= new JRadioButton("信计");
		JRadioButton jrbtn2= new JRadioButton("信息");
		JButton jb = new JButton("确定");
        Container con =getContentPane();
        con.setLayout(new FlowLayout());
        con.add(jrbtn1);
        con.add(jrbtn2);
        con.add(jb);
        setVisible(true);
        setSize(200,200);
        jb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String major;
				if(jrbtn1.isSelected()){
					major=jrbtn1.getText();
				}else{
					major=jrbtn2.getText();
				}
				MajorChoose.this.back.BackMsg(major);
				MajorChoose.this.dispose();
				
			}
        	
        });
       
       
       
}
	protected void BackMsg(String major) {
		// TODO Auto-generated method stub
		
	}
}