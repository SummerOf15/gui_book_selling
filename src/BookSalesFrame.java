import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class BookSalesFrame
{
	//store sale information
	int id=1;
	Vector<Sale> sales=new Vector<Sale>();
	public void start(Book[] books)
	{
		String s="序号	编号	名称	销售员	数量	单价	总价";
		JButton btStock=new JButton("显示库存");
		JButton btChart=new JButton("销售图表");
		JButton btSave=new JButton("保存并退出");
		JTextArea text=new JTextArea(10,7);
		JButton btClear = new JButton("清空");
		JButton btSubmit = new JButton("提交");
		JLabel jl1=new JLabel("售货员"),jl2=new JLabel("商品编号"),jl3=new JLabel("数量");
		JTextField tfSellerName=new JTextField(""),tfSellBookId=new JTextField(""),tfSellBookNum=new JTextField("");
		JPanel jpanel=new JPanel();
		JPanel jpanel3=new JPanel();
		JFrame jf=new JFrame("销售统计");
		text.append(s+"\n");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		jpanel.setLayout(new GridLayout(1,3));
		jpanel.add(btStock);
		jpanel.add(btChart);
		jpanel.add(btSave);
		//设置界面上的按钮和标签的布局		
		Box boxbutton=Box.createVerticalBox();
		boxbutton.add(btClear);
		boxbutton.createVerticalStrut(15);
		boxbutton.add(btSubmit);
		
		Box box1=Box.createVerticalBox();
		box1.add(jl1);
		box1.add(Box.createVerticalStrut(5));
		box1.add(jl2);
		box1.add(Box.createVerticalStrut(5));
		box1.add(jl3);
		
		Box box2=Box.createVerticalBox();
		box2.add(tfSellerName);
		box2.add(Box.createVerticalStrut(5));
		box2.add(tfSellBookId);
		box2.add(Box.createVerticalStrut(5));
		box2.add(tfSellBookNum);
		Box baseBox=Box.createHorizontalBox();
		baseBox.add(box1);
		baseBox.createHorizontalStrut(7);
		baseBox.add(box2);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new GridLayout(1,2));
		JPanel jp2=new JPanel(); 
		jp2.add(boxbutton,BorderLayout.CENTER);
		jp1.add(jp2);
		jp1.add(baseBox,BorderLayout.CENTER);
		jf.add(jpanel,BorderLayout.NORTH);
		jf.add(text,BorderLayout.CENTER);
		jf.add(jp1,BorderLayout.SOUTH);
		jf.add(new JPanel(),BorderLayout.EAST);
		jf.add(new JPanel(),BorderLayout.WEST);
		//设置完毕
		
		//监控事件
		btSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfSellerName.getText()==""||tfSellBookId.getText()==""
						||tfSellBookNum.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"你没有输入信息","警告",JOptionPane.WARNING_MESSAGE);
				}else {
					Sale sale=new Sale();
					sale.mSellId=id;
					sale.mSellerName=tfSellerName.getText();
					sale.mSellBookId=Integer.valueOf(tfSellBookId.getText()).intValue();
					sale.mSellNum=Integer.valueOf(tfSellBookNum.getText()).intValue();
					if(sale.check_sale_info(books, sale))
					{
						sales.addElement(sale);
						id++;
						String sale_info=sale.mSellId+"\t"+sale.mSellBookId+"\t"+sale.mSellBookName
								+"\t"+sale.mSellerName+"\t"+sale.mSellNum+"\t"+sale.mSellBookPrice
								+"\t"+sale.mSumPrice+"\r\n";
						text.append(sale_info);
					}
				}
				
			}
		});
		btStock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhoneFrame stock=new PhoneFrame();
				stock.display(books);
			}
		});
		btClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfSellBookId.setText("");
				tfSellBookNum.setText("");
				tfSellerName.setText("");
			}
		});
		btSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SaleList saleList=new SaleList();
				saleList.save_to_file("src/sales.txt", sales, books);
				System.exit(0);
			}
		});
		//监控结束
		jf.setSize(700,500);		
		jf.setLocation(200,200);
		jf.setVisible(true);
	}
	
}