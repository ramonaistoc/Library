import Domain.Admin;
import Domain.User;
import Service.AdminS;
import Service.AuditS;
import Service.UserS;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteUser
{

    private static ReadWriteUser read = null;

    private ReadWriteUser(){};

    public static ReadWriteUser get_instance()
    {
        if(read==null)
            read = new ReadWriteUser();
        return read;
    }

    public void readUser(UserS adaugUser, String path )
    {
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] user = line.split(",");
                String firstName = user[0];
                String lastName = user[1];
                int age = Integer.parseInt(user[2]);
                String city = user[3];
                String birthday = user[4];
                adaugUser.getUser().addUser(firstName,lastName,age,city,birthday);
                AuditS.write_action("Read an user on: ", "actions.csv");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void writeUser(UserS user, String pathName)throws IOException
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Firstname");
        sb.append(',');
        sb.append("Lastame");
        sb.append(',');
        sb.append("Age");
        sb.append(',');
        sb.append("City");
        sb.append(',');
        sb.append("Birthday");
        sb.append('\n');
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true))) {

            ArrayList<User> userList = user.getUser().getUser();
            for (int i = 0; i < userList.size(); i++) {
                sb.append(userList.get(i).getFirstName());
                sb.append(',');
                sb.append(userList.get(i).getLastName());
                sb.append(',');
                sb.append(userList.get(i).getAge());
                sb.append(',');
                sb.append(userList.get(i).getCity());
                sb.append(',');
                sb.append(userList.get(i).getBirthday());
                sb.append('\n');
                AuditS.write_action("Wrote an user on :", "actions.csv");

                // System.out.println("done!");
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}

