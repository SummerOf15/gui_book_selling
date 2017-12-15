import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

class SaleList
{
	
	public void save_to_file(String filepath,Vector<Sale> sales,Book[] books) 
	{
		ArrayList<ArrayList<String>> salesinfo=new ArrayList<ArrayList<String>>();
		sales_info_classification(sales, books,salesinfo);
		try {
			File file = new File(filepath);
			//if file not exist, then create a new file
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileWriter filewriter=new FileWriter(file);
			BufferedWriter out = new BufferedWriter(filewriter);
			out.write("        图书销售统计         "+"\r\n");
			out.write("================================="+"\r\n");
			for(ArrayList<String> infos:salesinfo) {
				for(String info:infos) {
					out.write(info);
				}
			}
			out.close();
			filewriter.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("write failed"+e);
			return;
		}
		
	}
	public void sales_info_classification(Vector<Sale> sales,Book[] books,ArrayList<ArrayList<String>> salesinfo)
	{
		String symbol="=================================="+"\r\n";
		for(Book book:books) {
			int salesum=0;
			float saleSumPrice=0;
			ArrayList<String> saleinfo=new ArrayList<String>();
			String book_info=book.getId()+"号\t"+book.getName()+"\t单价 :"+book.getPrice()+"\r\n";
			saleinfo.add(book_info);
			for(Sale sale:sales) {
				if(book.getId()==sale.mSellBookId) {
					String sale_info="C"+sale.mSellId+"\t"+sale.mSellerName+"\t"+sale.mSellNum+"@ ￥"
							+sale.mSellBookPrice+"= ¥"+"\t"+sale.mSumPrice+"\r\n";
					salesum+=sale.mSellNum;
					saleSumPrice+=sale.mSumPrice;
					saleinfo.add(sale_info);
				}
			}
			saleinfo.add(symbol);
			String sumInfo="总销量:"+salesum+"\t￥\t"+saleSumPrice+"\r\n";
			saleinfo.add(sumInfo);
			saleinfo.add(symbol);
			salesinfo.add(saleinfo);
		}
		System.out.println("write file OK");
	}
}
	