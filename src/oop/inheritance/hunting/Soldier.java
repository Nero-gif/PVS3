package oop.inheritance;

public class Soldier extends Hunter {

    public Soldier(String name) {
        super(name);
        gold += 40;
    }

    public void killBandits(){
        System.out.println(name + " is going againts bandits");
        gold += 100;
    }
}
