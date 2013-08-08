package assignment2;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book
{
	private Type holder = null;
	private GregorianCalendar dueDate = null;
	
	public LibraryBookGeneric(long _isbn, String _author, String _title) 
	{
		super(_isbn, _author, _title);
	}

	public Type getHolder()
	{
		return this.holder;
	}

	public GregorianCalendar getDueDate()
	{
		return this.dueDate;
	}

	public void setHolder(Type holder) 
	{
		this.holder = holder;
	}

	public void setDueDate(GregorianCalendar dueDate) 
	{
		this.dueDate = dueDate;
	}	
}
