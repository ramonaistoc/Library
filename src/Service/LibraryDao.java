package Service;
import Dao.AudioBookDao;
import Dao.BookDao;
import Dao.EbookDao;
import Domain.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryDao
{
    private ArrayList<Book> library = new ArrayList<>();
    BookDao b = new BookDao();
    EbookDao e = new EbookDao();
    AudioBookDao a = new AudioBookDao();

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Book> library) {
        this.library = library;
    }

    public BookDao getB() {
        return b;
    }

    public void setB(BookDao b) {
        this.b = b;
    }

    public EbookDao getE() {
        return e;
    }

    public void setE(EbookDao e) {
        this.e = e;
    }

    public AudioBookDao getA() {
        return a;
    }

    public void setA(AudioBookDao a) {
        this.a = a;
    }

    public void printEbookArray()
    {
       e.printEbookArray();
    }

    public void printBookArray()
    {
        b.printBookArray();
    }

    public void printAudioBookArray()
    {
        a.printAudioBookArray();
    }

    public void addbook(String title, String author, String publisher)
    {
        b.addBook(title, author, publisher);
    }
    public void addaudiobook(String title, String author, String publisher)
    {
        a.addAudioBook(title, author, publisher);
    }
    public void addebook(String title, String author, String publisher)
    {
        e.addEbook(title, author, publisher);
    }

    public void deleteBook(String title)
    {
        b.deleteBookTitle(title);
    }

    public void deleteEbook(String title)
    {
        e.deleteEbookTitle(title);
    }

    public void deleteAudioBook(String title)
    {
        a.deleteAudioBookTitle(title);
    }


    public Book searchBookTitle(String title)
    {
        return b.searchBookTitle(title);
    }

    public Ebook searchEbookTitle(String title)
    {
        return e.searchEbookTitle(title);
    }

    public AudioBook searchAudioBookTitle(String title)
    {
        return a.searchAudioBookTitle(title);

    }

    public ArrayList<AudioBook> getAudioBooks()
    {
        return a.getaudio();
    }

    public ArrayList<Ebook> getEbooksArray()
    {
        return e.getebook();
    }

    public ArrayList<Book> getBookArray()
    {
        return b.getBookArray();
    }


}
