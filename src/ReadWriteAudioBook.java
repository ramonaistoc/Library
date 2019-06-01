import Domain.AudioBook;
import Domain.Book;
import Service.AdminS;
import Service.AuditS;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteAudioBook
{

    private static ReadWriteAudioBook read = null;

    private ReadWriteAudioBook(){};

    public static ReadWriteAudioBook get_instance()
    {
        if(read==null)
            read = new ReadWriteAudioBook();
        return read;
    }

    public void readAudioBook(AdminS adaugBook, String path )
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
                adaugBook.getLibrary().addaudiobook(title,author,publisher);
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

    public void writeAudioBook(AdminS admin, String pathName)throws IOException
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Title");
        sb.append(',');
        sb.append("Author");
        sb.append(',');
        sb.append("Publisher");
        sb.append('\n');
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathName, true))) {

            ArrayList<AudioBook> bookList = admin.getLibrary().getAudioBooks();
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

