package Domain;

import Domain.Person;

import java.util.Date;

public class User extends Person
{

    public User(String lastName, String firstName, int age, String city, String birthday) {
        super(lastName, firstName, age, city, birthday);
    }
}
