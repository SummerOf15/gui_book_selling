public class TestPro
{
	public static void main(String[]args)
	{
		
		BookSalesFrame f=new BookSalesFrame();
		Book file=new Book();
		Book[] books=file.read_data("src/Books.txt");
		f.start(books);
	}
}