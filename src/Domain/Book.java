package Domain;

public class Book extends LibraryItems
{
    public  Book(String title, String author, String publisher)
    {
        super(title,author,publisher);
    }

    public String getTitle()
    {
        return title;
    }
}
