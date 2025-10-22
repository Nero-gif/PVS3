package oop.interfaces.examLOTR;

import java.util.ArrayList;

public class GreatTale {

    /**
     * Tato metoda by mela zvladnout praci s TextMsg i Book
     */
//    static int wordCount(){
//    }


    public static void main(String[] args) {
        ArrayList<String> LOTR = new ArrayList<>();
        LOTR.add("One Ring to rule them all."); //stranka #1
        LOTR.add("Folk takes their peril with them into Lorien.");
        LOTR.add("Hinder me? Thou fool. No living man may hinder me!");
        LOTR.add("Don’t the great tales never end?"); //stranka #4

        TextMsg msg = new TextMsg("Johnny", "27-06-2003", "Oh, Hi Mark!");
        Book LordOTR = new Book("Lord of the rings", "J. R. R. Tolkien", "29-07-1968", 243, LOTR);
        Book LordOfTheRings = new Book("Lord of the rings", "John Ronald Reuel Tolkien", "29-07-1968", 243, LOTR);
        System.out.println(LordOTR.equals(LordOfTheRings));
        //....melo by vratit True, maji stejne knizni ID (IBM)

        System.out.println("Wordcount for LOTR: "  + wordCount(LordOTR));
        System.out.println("Wordcount for Msg: " + wordCount(msg));

        System.out.println(LordOTR.getText());
        //System.out.println("LOTR read:");
        //LordOfTheRings.read();

        //System.out.println("Message read:");
        //msg.read();
    }

    private static int wordCount(Book text) {
        return text.getText().split("\\s").length;
    }
    private static int wordCount(TextMsg text) {
        return text.getText().split("\\s").length;
    }


}
interface Readable {
    void read();

    String getText();

}

/**
 * Zde je vas ukol pro implementaci dle zadani
 */
class Book implements Readable {
    public Book(String lordOfTheRings, String s, String s1, int i, ArrayList<String> lotr) {
    }

    @Override
    public void read() {

    }

    @Override
    public String getText() {
        return String.join(" ", pages);
    }

    String name, author, date;
    /**
     * ID pro knihu
     */
    int IBM;
    ArrayList<String> pages;
}

class TextMsg  implements Readable, Comparable<TextMsg>{
    String sender;
    String date;
    String text;


    public TextMsg(String sender, String date, String text) {
        this.sender = sender;
        this.date = date;
        this.text = text;
    }

    @Override
    public int compareTo(TextMsg o) {
        String another = o.sender;
        return this.sender.compareTo(another);
    }

    @Override
    public void read() {
        System.out.println("Message received " + date);
        System.out.println(sender + " wrote: ");
        System.out.println(text);
    }

    @Override
    public String getText() {
        return text;
    }
}
