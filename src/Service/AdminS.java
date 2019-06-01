package Service;
import Dao.*;
import Domain.*;
import java.util.ArrayList;

public class AdminS
{
    private LibraryDao library = new LibraryDao();
    private AdminDao admin = new AdminDao();

    public void printAdmin()
    {
        admin.printAdminArray();
    }

    public void printAllBooks()
    {
        library.printBookArray();
        library.printAudioBookArray();
        library.printEbookArray();
    }
//afisare
    public void printEbooks()
    {
        library.printEbookArray();
    }

    public void printAudioBooks()
    {
        library.printAudioBookArray();
    }

    public void printBooks()
    {
        library.printBookArray();
    }

//getteri setteri

    public LibraryDao getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDao library) {
        this.library = library;
    }

    public AdminDao getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDao admin) {
        this.admin = admin;
    }

//functii de stergere

    public void deleteBookFromLibraryTitle(String title)
    {
        library.deleteBook(title);
    }

    public void deleteEbookFromLibraryTitle(String title)
    {
        library.deleteEbook(title);
    }

    public void deleteAudioBookFromLibraryTitle(String title)
    {
        library.deleteAudioBook(title);
    }

    public Book searchBookInLibraryTitle(String title)
    {
         return  library.searchBookTitle(title);
    }

    public Ebook searchEbookInLibraryTitle(String title)
    {
        return library.searchEbookTitle(title);
    }

    public AudioBook searchAudioBookInLibraryTitle(String title)
    {
       return library.searchAudioBookTitle(title);
    }
//getteri pt carti
    public ArrayList<Book> getAllBooksFromLibrary()
    {
        return library.getBookArray();
    }

    public ArrayList<Ebook> getAllEbooksFromLibrary()
    {
        return library.getEbooksArray();
    }

    public ArrayList<AudioBook> getAllAudioBooksFromLibrary()
    {
        return library.getAudioBooks();
    }

//pt admin

    public void addAdmin(String lastName, String firstName, int age, String city, String birthday)
    {
        admin.addAdmin(lastName,firstName,age,city,birthday);
    }

    public void deleteAdminUsingLastName(String lastName)
    {
        admin.deleteAdminLastName(lastName);
    }

    public void deleteAdminUsingFirstName(String firstName)
    {
        admin.deleteAdminFirstName(firstName);
    }

    public Admin searchUserUsingFirstName(String firstName)
    {
        return admin.searchAdminFirstName(firstName);
    }

    public Admin searchAdminUsingLastName(String lastName)
    {
        return admin.searchAdminLastName(lastName);
    }


}
