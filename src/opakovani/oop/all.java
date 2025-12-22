package opakovani.oop;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class all {
    public static void main(String[] args) {
        //new file creating
        Random rand = new Random();

        DataExport de = new DataExport("C:/Users/user/IdeaProjects/PVS3/testdata/out/randomNumbers.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Kolik má mít soubor řádek?");
        int nubberOfLines = sc.nextInt();
        for (int i = 0; i < nubberOfLines; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 4; j++) line.append(rand.nextInt(0, 99)).append(";");
            line.append(rand.nextInt(0, 99));
            de.writeLine(line.toString());
        }
        de.finishExport();
        //file processing
        DataImport di = new DataImport("C:/Users/user/IdeaProjects/PVS3/testdata/out/randomNumbers.txt");
        ArrayList<Number> numbers = new ArrayList<>();
        while (di.hasNext()) numbers.add(parseLine(di.readLine()));
        di.finishImport();
    }
    static Number parseLine(String line){
        String[] dataPieces = line.split(";");
        Number number = new Number(
                Integer.parseInt(dataPieces[0]),
                Integer.parseInt(dataPieces[1]),
                Integer.parseInt(dataPieces[2]),
                Integer.parseInt(dataPieces[3]),
                Integer.parseInt(dataPieces[4])
        );
        return number;
    }
}
class Number{
    int noOne;
    int noTwo;
    int noThree;
    int noFour;
    int noFive;

    public Number(int noOne, int noTwo, int noThree, int noFour, int noFive) {
        this.noOne = noOne;
        this.noTwo = noTwo;
        this.noThree = noThree;
        this.noFour = noFour;
        this.noFive = noFive;
    }

    public int getNoOne() {
        return noOne;
    }

    public void setNoOne(int noOne) {
        this.noOne = noOne;
    }

    public int getNoTwo() {
        return noTwo;
    }

    public void setNoTwo(int noTwo) {
        this.noTwo = noTwo;
    }

    public int getNoThree() {
        return noThree;
    }

    public void setNoThree(int noThree) {
        this.noThree = noThree;
    }

    public int getNoFour() {
        return noFour;
    }

    public void setNoFour(int noFour) {
        this.noFour = noFour;
    }

    public int getNoFive() {
        return noFive;
    }

    public void setNoFive(int noFive) {
        this.noFive = noFive;
    }
}