import javax.swing.*;

public class Sale
{
	public int mSellId;
	public int mSellNum;
	public int mSellBookId;
	public String mSellerName;
	public float mSellBookPrice;
	public float mSumPrice;
	public String mSellBookName;
	
	public boolean update(Book book,int nSell)
	{

		int store=book.getStore()-nSell;
		//检测是否还有库存
		if(store<0)
		{
			JOptionPane.showMessageDialog(null,"库存不足","警告",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else 
		{
			book.setStore(store);
			return true;
		}
	}
	public Book checkInputBookId(Book[] books,int id) {
		for (Book book: books) {
			if (book.getId()==id) {
				return book;
			}
		}
		return null;
	}
	public boolean check_sale_info(Book[] books,Sale sale)
	{
		Book salebook=checkInputBookId(books,sale.mSellBookId);
//		if(sale.mSellerName==""||String.valueOf(sale.mSellBookId)==""
//				||String.valueOf(sale.mSellNum).isEmpty())
//		{
//			JOptionPane.showMessageDialog(null,"你没有输入信息","警告",JOptionPane.WARNING_MESSAGE);
//			return false;
//		}	
		if(salebook==null)
		{
		
			JOptionPane.showMessageDialog(null,"请输入正确信息","警告",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(sale.mSellNum<=0)
		{
			JOptionPane.showMessageDialog(null,"请输入正确信息","警告",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(update(salebook, sale.mSellNum)==false)
		{
			return false;
		}
		else
		{
			sale.mSellBookId=salebook.getId();
			sale.mSellBookPrice=salebook.getPrice();
			sale.mSellBookName=salebook.getName();
			sale.mSumPrice=salebook.getPrice()*sale.mSellNum;
			return true;
		}
	}
}