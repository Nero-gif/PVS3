package opakovani.oop;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class all {
    public static void main(String[] args) {
        createFile();

        //process file
        DataImport di = new DataImport("C:/Users/user/IdeaProjects/PVS3/testdata/out/randomNumbers.txt");
        ArrayList<Number> numbers = new ArrayList<>();
        while (di.hasNext()) numbers.add(parseLine(di.readLine()));
        di.finishImport();

        missingNumbers(numbers);
    }
    public static void createFile(){
        Random rand = new Random();

        DataExport de = new DataExport("C:/Users/user/IdeaProjects/PVS3/testdata/out/randomNumbers.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Kolik má mít soubor řádek?");
        int nubberOfLines = sc.nextInt();
        for (int i = 0; i < nubberOfLines; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 4; j++) line.append(rand.nextInt(0, 100)).append(";");
            line.append(rand.nextInt(0, 99));
            de.writeLine(line.toString());
        }
        de.finishExport();
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

    public static void missingNumbers(ArrayList<Number> numbers){
        String missingNumbers;
        missingNumbers = MNRowOne(numbers);
        missingNumbers = missingNumbers + MNRowTwo(numbers);
        missingNumbers = missingNumbers + MNRowThree(numbers);
        missingNumbers = missingNumbers + MNRowFour(numbers);
        missingNumbers = missingNumbers + MNRowFive(numbers);
        System.out.println("Celkem chybí " + missingNumbers);
    }

    public static String MNRowOne(ArrayList<Number> numbers){
        String notMissing = "";
        String missing = "";
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < 100; j++) {
                if (numbers.get(i).getNoOne() == j){
                    notMissing = notMissing + (String.valueOf(j)) + "; ";
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (!notMissing.contains(String.valueOf(i))){
                missing = missing + (String.valueOf(i)) + "; ";
            }
        }
        System.out.println("V prvním sloupci chybí " + missing);
        return missing;
    }

    public static String MNRowTwo(ArrayList<Number> numbers){
        String notMissing = "";
        String missing = "";
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < 100; j++) {
                if (numbers.get(i).getNoTwo() == j){
                    notMissing = notMissing + (String.valueOf(j)) + "; ";
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (!notMissing.contains(String.valueOf(i))){
                missing = missing + (String.valueOf(i)) + "; ";
            }
        }
        System.out.println("V prvním sloupci chybí " + missing);
        return missing;
    }

    public static String MNRowThree(ArrayList<Number> numbers){
        String notMissing = "";
        String missing = "";
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < 100; j++) {
                if (numbers.get(i).getNoThree() == j){
                    notMissing = notMissing + (String.valueOf(j)) + "; ";
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (!notMissing.contains(String.valueOf(i))){
                missing = missing + (String.valueOf(i)) + "; ";
            }
        }
        System.out.println("V prvním sloupci chybí " + missing);
        return missing;
    }

    public static String MNRowFour(ArrayList<Number> numbers){
        String notMissing = "";
        String missing = "";
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < 100; j++) {
                if (numbers.get(i).getNoFour() == j){
                    notMissing = notMissing + (String.valueOf(j)) + "; ";
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (!notMissing.contains(String.valueOf(i))){
                missing = missing + (String.valueOf(i)) + "; ";
            }
        }
        System.out.println("V prvním sloupci chybí " + missing);
        return missing;
    }

    public static String MNRowFive(ArrayList<Number> numbers){
        String notMissing = "";
        String missing = "";
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < 100; j++) {
                if (numbers.get(i).getNoFive() == j){
                    notMissing = notMissing + (String.valueOf(j)) + "; ";
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (!notMissing.contains(String.valueOf(i))){
                missing = missing + (String.valueOf(i)) + "; ";
            }
        }
        System.out.println("V prvním sloupci chybí " + missing);
        return missing;
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