package oop.inheritance.hospitalTest;

public class Surgeon extends Doctor {

    final static int SURGEON_BONUS = 30000;

    public Surgeon(String name) {
        super(name);
        this.salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Cutting open...");
        salary += 45000;
    }
}
