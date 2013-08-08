package assignment2;

/**
 * Class representation of a book. The ISBN, author, and title can never change
 * once the book is created.
 * 
 * Note that ISBNs are unique.
 *
 *Braeden Bodily
 *Julian Whitteron
 */
public class Book
{

  private long isbn;

  private String author;

  private String title;

  public Book(long _isbn, String _author, String _title) 
  {
    this.isbn = _isbn;
    this.author = _author;
    this.title = _title;
  }

  /**
   * @return the author
   */
  public String getAuthor() 
  {
    return this.author;
  }

  /**
   * @return the ISBN
   */
  public long getIsbn() 
  {
    return this.isbn;
  }

  /**
   * @return the title
   */
  public String getTitle()
  {
    return this.title;
  }

  /**
   * Two books are considered equal if they have the same ISBN, author, and
   * title.
   * 
   * @param other --
   *          the object begin compared with "this"
   * @return true if "other" is a Book and is equal to "this", false otherwise
   */
  public boolean equals(Object other) 
  {
	if (!(other instanceof Book))
		 return false;
	 
	Book b = (Book)other;
		 
    // FILL IN -- do not return false unless appropriate
    if ((this.isbn == b.getIsbn()) && (this.author.equals(b.getAuthor()) && (this.title.equals(b.getTitle()))))
    		return true;
    
    return false;
  }
  
  /**
   * Returns a string representation of the book.
   */
  public String toString() 
  {
    return isbn + ", " + author + ", \"" + title + "\"";
  }
}
