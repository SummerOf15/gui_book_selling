import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//库存信息显示
public class PhoneFrame
{
	
	public void display(Book[] books) {
		JFrame jf=new JFrame("库存信息");
		//设置列的属性
		Object name[]={"编号","名称","库存"};
		
		JTable table;
		JButton jbutton1=new JButton("OK");
		int row=books.length;
		Object[][] a=new Object[row][3];
		for(int i=0;i<row;i++) {
			a[i][0]=books[i].getId();
			a[i][1]=books[i].getName();
			a[i][2]=books[i].getStore();
		}
		table=new JTable(a,name);	
	
	//start event listening
		jbutton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
			}
		});
	//event
		JPanel jp=new JPanel();
		jp.add(jbutton1);
		jf.add(new JScrollPane(table),BorderLayout.CENTER);
		jf.setSize(450,200);
		jf.add(jp,BorderLayout.SOUTH);
		jf.setVisible(true);
	}
}