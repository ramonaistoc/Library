package Dao;

import Domain.AudioBook;


import java.util.ArrayList;

public class AudioBookDao {
    ArrayList<AudioBook> audio = new ArrayList<AudioBook>();

    public void printAudioBookArray() {
        for (AudioBook i : audio) {
            System.out.println(i.getTitle());
            System.out.print(i.getAuthor());
            System.out.print(i.getPublisher());
        }
    }

    public ArrayList<AudioBook> getaudio() {
        return audio;
    }

    public void setaudio(ArrayList<AudioBook> audio) {
        this.audio = audio;
    }

    public void addAudioBook( String title, String author, String publisher)
    {
        AudioBook book = new AudioBook(title, author, publisher);

        audio.add(book);
    }

    public  void deleteAudioBookTitle(String titlu)
    {
        for(AudioBook i : audio)
            if(i.getTitle().equals(titlu)) {
                audio.remove(i);
                return;
            }
    }

    public AudioBook searchAudioBookTitle(String title)
    {
        for(AudioBook i : audio)
            if(i.getTitle().equals(title)){
                return i;
            }
        return null;
    }
}
