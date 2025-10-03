package oop.inheritance.hospitalTest;

public class Surgeon extends Doctor {

    final static int SURGEON_BONUS = 30000;

    public Surgeon(String name, int salary) {
        //omezeni: kdyz to, od ceho dedim, ma konstruktor
        //-> ja musim mit minimalne stejnej
        super(name, salary);
        this.salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Cutting open...");
    }
}
