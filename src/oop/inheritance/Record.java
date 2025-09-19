package oop.inheritance;

public class Record {
    String name;
    int lenght;
    void play(){
        System.out.println(name + "is playing");
    }
}

class Vinyl extends Record{
    int speed;
}
class Wav extends Record{
    boolean broken = true;
}
class Mp3 extends Record{
    boolean isCompressed;
    void compression(){
        System.out.println("compressing file...");
    }
}