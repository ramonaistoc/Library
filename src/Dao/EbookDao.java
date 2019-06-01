package Dao;

import Domain.Ebook;

import java.util.ArrayList;

public class EbookDao
{
    ArrayList<Ebook> ebook  = new ArrayList<Ebook>();

    public ArrayList<Ebook> getebook() {
        return ebook;
    }

    public void setebook(ArrayList<Ebook> ebook) {
        this.ebook = ebook;
    }

    public void printEbookArray() {
        for (Ebook i : ebook) {
            System.out.println(i.getTitle());
            System.out.print(i.getAuthor());
            System.out.print(i.getPublisher());
        }
    }

    public void addEbook( String title, String author, String publisher)
    {
        Ebook book = new Ebook(title, author, publisher);

        ebook.add(book);
    }

    public void deleteEbookTitle(String titlu)
    {

        for( Ebook i : ebook)
            if(i.getTitle().equals(titlu)) {
                ebook.remove(i);
                return;
            }
    }

    public Ebook searchEbookTitle(String title)
    {
        for(Ebook i : ebook)
            if(i.getTitle().equals(title)){
                return i;
            }
        return null;
    }

}
