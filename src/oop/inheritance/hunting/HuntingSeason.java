package oop.inheritance.hunting;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {

    static void doRandomJob(Hunter hunter){
        Random r = new Random();

        switch(r.nextInt(1,4)){
            case 1:
                hunter.hunt();
                break;
            case 2:
                if (hunter instanceof Soldier) {
                    ((Soldier) hunter).killBandits();
                }
                break;
            case 3:
                if (hunter instanceof Witcher) {
                    ((Witcher) hunter).slayMonster();
                }
                break;
        }
    }

    static void doJob(Hunter hunter, String pismeno){
        if (pismeno.equals("M") && hunter instanceof Witcher) {
            ((Witcher) hunter).slayMonster();
            return;
        }
        if (pismeno.equals("K") && hunter instanceof Soldier) {
            ((Soldier) hunter).killBandits();
            return;
        }
        if (pismeno.equals("H")) {
            hunter.hunt();
        }
    }


    public static void main(String[] args) {

        DataImport di = new DataImport("./testdata/hunters.txt");

        Hunter hunter1 = null;

        while (di.hasNext()){
            String line = di.readLine();
            String[] parts = line.split(",");

            if (parts[1].equals("Hunter")){
                hunter1 = new Hunter(parts[0]);

            } else if (parts[1].equals("Soldier")) {
                hunter1 = new Soldier(parts[0]);

            } else if (parts[1].equals("Witcher")){
                hunter1 = new Witcher(parts[0]);

            }
            for (int i = 2; i < parts.length; i++){
                doJob(hunter1, parts[i]);
            }
            System.out.println(hunter1.name + "get" + hunter1.gold);
        }
//        Hunter hunter = new Hunter("Theodore Roosvelt");
//        hunter.hunt();
//
//        System.out.println(hunter.name + " má " + hunter.gold);
//
//        Soldier soldier = new Soldier("Solid Snake");
//        soldier.hunt();
//        soldier.killBandits();
//
//        System.out.println(soldier.name + " má " + soldier.gold);
//
//        Witcher witcher = new Witcher("Vesemir");
//        witcher.hunt();
//        witcher.killBandits();
//        witcher.slayMonster();
//
//        System.out.println(witcher.name + " má " + witcher.gold);

//    Hunter randomak = new Witcher("Eskel");
//    Soldier another = new Soldier("Eskel");
//    randomak.hunt();
//
//    ((Witcher) randomak).slayMonster();
//    ((Witcher) another).slayMonster();

        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Hornet"));
        hunters.add(new Soldier("George S Patton"));
        hunters.add(new Soldier("Robert Duvall"));
        hunters.add(new Witcher("Geralt"));
        hunters.add(new Witcher("Coën"));

        for(Hunter hunter : hunters){
            doRandomJob(hunter);
        }
    }
}
