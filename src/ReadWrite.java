import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Dao.*;
import Domain.*;
import Service.*;
import java.io.*;

public class ReadWrite
{

    private static ReadWrite read = null;

    private ReadWrite(){};

    public static ReadWrite get_instance()
    {
        if(read==null)
            read = new ReadWrite();
        return read;
    }

    public void readAdmin(AdminS adaugAdmin, String path )
    {
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] admin = line.split(",");
                String firstName = admin[0];
                String lastName = admin[1];
                int age = Integer.parseInt(admin[2]);
                String city = admin[3];
                String birthday = admin[4];
                adaugAdmin.getAdmin().addAdmin(firstName,lastName,age,city,birthday);
                AuditS.write_action("Read an admin on: ", "actions.csv");
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

    public void writeAdmin(AdminS admin, String pathName)throws IOException
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

            ArrayList<Admin> adminList = admin.getAdmin().getAdmin();
            for (int i = 0; i < adminList.size(); i++) {
                sb.append(adminList.get(i).getFirstName());
                sb.append(',');
                sb.append(adminList.get(i).getLastName());
                sb.append(',');
                sb.append(adminList.get(i).getAge());
                sb.append(',');
                sb.append(adminList.get(i).getCity());
                sb.append(',');
                sb.append(adminList.get(i).getBirthday());
                sb.append('\n');
                AuditS.write_action("Wrote an admin on :", "actions.csv");

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

