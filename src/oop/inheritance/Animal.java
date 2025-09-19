package oop.inheritance;

public class Animal {
    int age;
    String name;
    boolean isalive;
    void eat(){}
}

class Cat extends Animal{
        String color;
        int taillengh;
}

class Dog extends Animal{
    boolean havelegs;
}