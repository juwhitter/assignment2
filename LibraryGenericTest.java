package assignment2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Testing class for LibraryGeneric.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBookGeneric<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("801.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))  
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    //Testing sorting by Author--------------------------------------------------------------------------------
    LibraryGeneric<String> lib3 = new LibraryGeneric<String>();
    lib3.addAll("Mushroom_Publishing.txt");
    //Get order by ISBN
    for (int i = 0; i < lib3.getInventoryList().size(); i++)
    {
    	System.out.print(lib3.getInventoryList().get(i).getIsbn() + "     ");
    	System.out.print(lib3.getInventoryList().get(i).getAuthor() + "     ");
    	System.out.println(lib3.getInventoryList().get(i).getTitle());
    	
    }
    	
    System.out.println("\n");
    
    //Ordered by Author
    ArrayList<LibraryBookGeneric<String>> lib3test = lib3.getOrderedByAuthor();
    for (int i = 0; i < lib3test.size(); i++)
    {
    	System.out.print(lib3test.get(i).getIsbn() + "     ");
    	System.out.print(lib3test.get(i).getAuthor() + "     ");
    	System.out.println(lib3test.get(i).getTitle());
    }
    
    

    //Testing sorting by Due Date--------------------------------------------------------------------------------
    System.out.println("\n Checking sort by due date \n");
    
    lib3.checkout(9781843190349L, "Bob", 11, 10, 2010);
    lib3.checkout(9781843190028L, "Sally", 10, 13, 2011);
    lib3.checkout(9781843192701L, "Billy", 9, 24, 2011);
    
    lib3test = lib3.getOverdueList(11, 11, 2011);
    for (int i = 0; i < lib3test.size(); i++)
    {
    	//System.out.print(lib3test.get(i).getDueDate() + "     ");
    	System.out.print(lib3test.get(i).getHolder() + "     ");
    	System.out.println(lib3test.get(i).getTitle());
    }
    

    
    System.out.println("Testing done.");
  }
}
