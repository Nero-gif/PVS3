package opakovani.oop;

import fileworks.DataExport;

import java.util.Random;
import java.util.Scanner;

public class all {
    public static void main(String[] args) {
        Random rand = new Random();

        DataExport de = new DataExport("C:/Users/user/IdeaProjects/PVS3/testdata/out/randomNumbers.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Kolik má mít soubor řádek?");
        int nubberOfLines = sc.nextInt();
        for (int i = 0; i < nubberOfLines; i++) {
            String line = "";
            for (int j = 0; j < 3; j++) {
                line = line + rand.nextInt(0, 99) + ";";
            }
            line = line + rand.nextInt(0, 99);
            de.writeLine(line);
        }

        de.finishExport();
    }
}
