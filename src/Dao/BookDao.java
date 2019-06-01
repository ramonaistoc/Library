package Dao;
//pachete ligtere mici
import Domain.Book;

import java.util.ArrayList;

public class BookDao
{
    ArrayList<Book> books  = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void printBookArray() {
        for (Book i : books) {
            System.out.println(i.getTitle());
            System.out.print(i.getAuthor());
            System.out.print(i.getPublisher());
        }
    }

    public ArrayList<Book> getBookArray()
    {
        return books;
    }

    public void addBook( String title, String author, String publisher)
    {
       Book book = new Book(title, author, publisher);

        books.add(book);
    }

    public  void deleteBookTitle(String titlu)
    {

        for( Book i : books)
            if(i.getTitle().equals(titlu)) {
                books.remove(i);
                return;
            }
    }

    public Book searchBookTitle(String title)
    {
        for(Book i : books)
            if(i.getTitle().equals(title)){
                return i;
            }
        return null;
    }

}
