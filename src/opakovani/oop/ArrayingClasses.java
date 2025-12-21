package opakovani.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayingClasses {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Karel", 54, 12.8));
        people.add(new Person("Sára", 19, 20.0));

        System.out.println("list of peoples:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(i + ": " + people.get(i).name);
        }

        boolean another = true;
        while (another) {
            System.out.println("for more info chose noumfer of person");
            Scanner sc = new Scanner(System.in);
            int moreInfo = sc.nextInt();

            System.out.println("name: " + people.get(moreInfo).getName());
            System.out.println("age: " + people.get(moreInfo).age);
            System.out.println("person have " + people.get(moreInfo).fingerCount + " fingers");

            System.out.println("Do you wanna inspect another person? yes/no");
            String answer = sc.next();
            if (answer.equals("yes")) {
                another = true;
            }else  {
                another = false;
            }
        }
    }
    static class Person{
        String name;
        int age;
        double fingerCount;

        public Person(String name, int age, double fingerCount){
            this.name = name;
            this.age = age;
            this.fingerCount = fingerCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getFingerCount() {
            return fingerCount;
        }

        public void setFingerCount(double fingerCount) {
            this.fingerCount = fingerCount;
        }
    }
}
