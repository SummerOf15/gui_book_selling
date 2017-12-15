import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Book
{
	private int mId;
	private String mName;
	private float mPrice;
	private int mInstore;
	public Book(){
		this.mId=0;
		this.mName="";
		this.mPrice=0;
		this.mInstore=0;
	}
	
	public int getId() {
		return mId;
	}
	public String getName() {
		return mName;
	}
	public float getPrice() {
		return mPrice;
	}
	public int getStore() {
		return mInstore;
	}
	public void setStore(int num) {
		this.mInstore=num;
	}
	public Book[] read_data(String fileName) {
		try 
		{
			
			File file = new File(fileName);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s=in.readLine();
			Vector<Book> books=new Vector<Book>();
			int i=0;
			while ((s=in.readLine())!=null)
			{
				Book book=new Book();
				String item[]=s.split("\t");
				book.mId=Integer.valueOf(item[0]).intValue();
				book.mName=item[1];
				book.mPrice=Float.valueOf(item[2]).floatValue();
				book.mInstore=100;
				books.addElement(book);
			}
			in.close();
			System.out.println("read data OK");
			Book[] bookArray=new Book[3];
			books.copyInto(bookArray);
			return bookArray;
		}
		catch(IOException e)
		{
			System.out.println(e);
			return null;
		}
	}
}