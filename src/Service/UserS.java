package Service;
import Dao.*;
import Domain.*;
import Domain.User;
import java.util.ArrayList;

public class UserS
{
    private PersonalLibraryDao personalLibrary = new PersonalLibraryDao();
    private UserDao user = new UserDao();

    public void printUsers()
    {
        user.printUserArray();
    }

    public void printAllBooks()
    {
        personalLibrary.printBookArray();
        personalLibrary.printAudioBookArray();
        personalLibrary.printEbookArray();
    }

    public void printEbooks()
    {
        personalLibrary.printEbookArray();
    }

    public void printAudioBooks()
    {
        personalLibrary.printAudioBookArray();
    }

    public void printBooks()
    {
        personalLibrary.printBookArray();
    }


    public PersonalLibraryDao getPersonalLibrary() {
        return personalLibrary;
    }

    public void setPersonalLibrary(PersonalLibraryDao personalLibrary) {
        this.personalLibrary = personalLibrary;
    }

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    public void addBooksToPersonalLibrary(String title, String author, String publisher)
    {
        personalLibrary.addbook(title,author,publisher);
    }

    public void deleteEbookFromLibraryTitle(String title)
    {
        personalLibrary.deleteEbook(title);
    }

    public void deleteAudioBookFromLibraryTitle(String title)
    {
        personalLibrary.deleteAudioBook(title);
    }

    public void searchBookInPersonalLibraryTitle(String title)
    {
        personalLibrary.searchBookTitle(title);
    }

    public void searchEbookInPersonalLibraryTitle(String title)
    {
        personalLibrary.searchEbookTitle(title);
    }

    public void searchAudioBookInPersonalLibraryTitle(String title)
    {
        personalLibrary.searchAudioBookTitle(title);
    }

    public ArrayList<Book> getAllBooksFromPersonalLibrary()
    {
        return personalLibrary.getBookArray();
    }

    public ArrayList<Ebook> getAllEbooksFromPersonalLibrary()
    {
        return personalLibrary.getEbooksArray();
    }

    public ArrayList<AudioBook> getAllAudioBooksFromPersonalLibrary()
    {
        return personalLibrary.getAudioBooks();
    }

    public void addUser(String lastName, String firstName, int age, String city, String birthday)
    {
        user.addUser(lastName,firstName,age,city,birthday);
    }

    public void deleteUserUsingLastName(String lastName)
    {
        user.deleteUserLastName(lastName);
    }

    public void deleteUserUsingFirstName(String firstName)
    {
        user.deleteUserFirstName(firstName);
    }

    public User searchUserUsingFirstName(String firstName)
    {
        return user.searchUserFirstName(firstName);
    }

    public User searchUserUsingLastName(String lastName)
    {
        return user.searchUserLastName(lastName);
    }

    public ArrayList<User> getUserArray()
    {
        return user.getUserArray();
    }

}
