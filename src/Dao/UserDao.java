package Dao;
import Domain.User;
import java.util.ArrayList;

public class UserDao
{
     private ArrayList<User> user = new ArrayList<>();

     public ArrayList<User> getUserArray()
     {
         return user;
     }

    public void printUserArray()
    {
        for(User i : user) {
            System.out.println(i.getLastName());
            System.out.println(i.getFirstName());
            System.out.println(i.getAge());
            System.out.println(i.getCity());
            System.out.println(i.getBirthday());
        }
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public void addUser(String lastName, String firstName, int age, String city, String birthday)
    {
        User newUser = new User(lastName, firstName, age, city, birthday);
        user.add(newUser);
    }

    public void deleteUserLastName(String lastName)
    {
        boolean containsName = user.contains(lastName);
        if(containsName)
            for(User i : user)
                if(i.getLastName().equals(lastName)) {
                    user.remove(i);
                }
    }

    public void deleteUserFirstName(String firstName)
    {
        boolean containsName = user.contains(firstName);

        if(containsName)
            for(User i : user)
                if(i.getLastName().equals(firstName)){
                    user.remove(i);
            }
    }

    public User searchUserFirstName(String firstName)
    {
        boolean containsName = user.contains(firstName);

        if(containsName)
            for(User i : user)
                if(i.getFirstName().equals(firstName)) {
                    return i;
                }
        return null;
    }
    public User searchUserLastName(String lastName)
    {
        boolean containsName = user.contains(lastName);

        if(containsName)
            for(User i : user)
                if(i.getFirstName().equals(lastName)) {
                    return i;
                }
        return null;
    }

}
