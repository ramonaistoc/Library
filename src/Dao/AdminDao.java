package Dao;
import Domain.Admin;
import java.util.ArrayList;

public class AdminDao
{
    private ArrayList<Admin> admin = new ArrayList<>();

    public void printAdminArray() {
        for (Admin i : admin) {
            System.out.print(" ");
            System.out.print(i.getFirstName());
            System.out.print("  ");
            System.out.print(i.getLastName());
            System.out.print(" ");
            System.out.print(i.getAge());
            System.out.print(" ");
            System.out.print(i.getBirthday());
            System.out.print(" ");
            System.out.print(i.getCity());
            System.out.println("");
        }
    }

    public ArrayList<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(ArrayList<Admin> admin) {
        this.admin = admin;
    }

    public ArrayList<Admin> getAdminArray()
    {
        return admin;
    }

    public void addAdmin(String lastName, String firstName, int age, String city, String birthday)
    {
        Admin newUser = new Admin(lastName, firstName, age, city, birthday);
        admin.add(newUser);
    }

    public void deleteAdminLastName(String lastName)
    {
        boolean containsName = admin.contains(lastName);
        if(containsName)
            for(Admin i : admin)
                if(i.getLastName().equals(lastName)) {
                    admin.remove(i);
                }
    }

    public void deleteAdminFirstName(String firstName)
    {
        boolean containsName = admin.contains(firstName);

        if(containsName)
            for(Admin i : admin)
                if(i.getLastName().equals(firstName)){
                    admin.remove(i);
                }
    }

    public Admin searchAdminFirstName(String firstName)
    {
        boolean containsName = admin.contains(firstName);

        if(containsName)
            for(Admin i : admin)
                if(i.getFirstName().equals(firstName)) {
                    return i;
                }
        return null;
    }
    public Admin searchAdminLastName(String lastName)
    {
        boolean containsName = admin.contains(lastName);

        if(containsName)
            for(Admin i : admin)
                if(i.getFirstName().equals(lastName)) {
                    return i;
                }
        return null;
    }

}
