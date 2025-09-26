package oop.inheritance;

public class Witcher extends Soldier{
    public Witcher(String name) {
        super(name);
        gold += 50;
    }

    public void slayMonster(){
        System.out.println(name + " is hunting for a monster");
        gold += 250;
    }

    @Override
    public void hunt() {
        System.out.println(name + " is huning a beast...and he's very good at it");
        gold += 50; // cena za odbornika :-)
    }
}
