package assignment2;
/**
 *Braeden Bodily
 *Julian Whitteron
 */
import java.util.GregorianCalendar;

public class LibraryBook extends Book
{
	private String holder = null;
	private GregorianCalendar dueDate = null;
	
	public LibraryBook(long _isbn, String _author, String _title) 
	{
		super(_isbn, _author, _title);
	}

	public String getHolder()
	{
		return this.holder;
	}

	public GregorianCalendar getDueDate()
	{
		return this.dueDate;
	}

	public void setHolder(String holder) 
	{
		this.holder = holder;
	}

	public void setDueDate(GregorianCalendar dueDate) 
	{
		this.dueDate = dueDate;
	}
	
	
	
}
