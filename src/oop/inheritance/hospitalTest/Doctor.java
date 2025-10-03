package oop.inheritance.hospitalTest;

public class Doctor {
    String name;
    int salary;

    public Doctor(String name) {
        this.name = name;
        salary = 25000;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong...");
        salary += 10000;
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }

    public int getSalary() {
        return salary;
    }
}
