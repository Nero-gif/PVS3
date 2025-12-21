package opakovani.oop;

import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadejte udaj");
        String userText = sc.nextLine();

        String[] userData = userText.split(":");
        System.out.println("Zadal jste informaci " + userData[0]);
        System.out.println("Její hodnota je " + userData[1]);

        int nevim = Integer.parseInt(userData[1]) + 6;
        System.out.println(nevim);

    }
}





