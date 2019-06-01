import Domain.Book;
import Domain.User;
import Service.AuditS;
import Service.AdminS;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteBook
{

    private static ReadWriteBook read = null;

    private ReadWriteBook(){};

    public static ReadWriteBook get_instance()
    {
        if(read==null)
            read = new ReadWriteBook();
        return read;
    }

    public void readBook(AdminS adaugBook, String path )
    {
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] book = line.split(",");
                String title = book[0];
                String author = book[1];
                String publisher = book[2];
                adaugBook.getLibrary().addbook(title,author,publisher);
                AuditS.write_action("Read a book on: ", "actions.csv");
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

    public void writeBook(AdminS admin, String pathName)throws IOException
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Title");
        sb.append(',');
        sb.append("Author");
        sb.append(',');
        sb.append("Publisher");
        sb.append('\n');
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true))) {

            ArrayList<Book> bookList = admin.getLibrary().getBookArray();
            for (int i = 0; i < bookList.size(); i++) {
                sb.append(bookList.get(i).getTitle());
                sb.append(',');
                sb.append(bookList.get(i).getAuthor());
                sb.append(',');
                sb.append(bookList.get(i).getPublisher());
                sb.append('\n');
                AuditS.write_action("Wrote a book on :", "actions.csv");

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

