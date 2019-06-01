package Domain;


public class Person
{
    private String lastName;
    private String firstName;
    private int age;
    private String city;
    private String birthday;

    public Person(String lastName, String firstName, int age, String city, String birthday) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
