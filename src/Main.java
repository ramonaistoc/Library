
import Dao.*;
import Domain.*;

import Dao.BookDao;
import Service.AdminS;
import Service.UserS;
import java.io.IOException;

import java.sql.*;

public class Main
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/new_schema";
    public  static  void main(String args[]) throws IOException
    {
        GUI gui = new GUI();
//        Statement stmt = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = null;
//            conn = DriverManager.getConnection(DB_URL,"tonio","tonio");
//
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM carti";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while(rs.next()){
//                String first = rs.getString("titlu");
//                String last = rs.getString("autor");
//
//                System.out.print(", First: " + first);
//                System.out.println(", Last: " + last);
//            }
//
//            System.out.println("as");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//

//
//
//        AdminS d = new AdminS();
//
//        d.getAdmin().addAdmin("Ion","Popescu",13,"Bucuresti","12.11.2018");
//        d.getAdmin().addAdmin("Lilo","Pop",13,"Iasi","12.11.2018");
//        d.getAdmin().addAdmin("Stich","Gavril",13,"Bucuresti","12.11.2018");
//
//        d.deleteAdminUsingFirstName("Pop");
//
//        d.printAdmin();
//
///*
//        d.getLibrary().addaudiobook("Mara", "Ioan Slavici","rao");
//        d.getLibrary().addebook("Ion", "Liviu Rebreanu","rao");
//        d.getLibrary().addaudiobook("Mândrie și prejudecată", "Jane Austen","rao");
//        d.getLibrary().addbook("Dublura", "Tess Gerritsen","rao");
//        d.getLibrary().addbook("Fata din tren", "Paula Hawkins","rao");
//        d.getLibrary().addbook("Enigma Otiliei", "George Călinescu","rao");
//
//        System.out.println(d.searchAudioBookInLibraryTitle("Dublura"));
//        System.out.println("inainte de stergere");
//        d.printAllBooks();
//        d.deleteEbookFromLibraryTitle("Ion");
//        System.out.println("dupa stergere");
//        d.printAllBooks();
//*/
//        AdminS admin = new AdminS();
//
//        ReadWrite.get_instance().readAdmin(admin, "ReadAdmin.csv ");
//        ReadWrite.get_instance().writeAdmin(admin, "WriteAdmin.csv ");
//
//        UserS user = new UserS();
//        ReadWriteUser.get_instance().readUser(user, "ReadUser.csv");
//        ReadWriteUser.get_instance().writeUser(user, "WriteUser.csv");
//
//        ReadWriteBook.get_instance().readBook(admin, "ReadBook.csv");
//        ReadWriteBook.get_instance().writeBook(admin, "WriteBook.csv");
//
//        ReadWriteAudioBook.get_instance().readAudioBook(admin, "ReadAudioBook.csv");
//        ReadWriteAudioBook.get_instance().writeAudioBook(admin, "WriteAudioBook.csv");
//

    }
}
