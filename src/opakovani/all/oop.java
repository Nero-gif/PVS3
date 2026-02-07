package opakovani.all;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class oop {

    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        System.out.println("Which gun do you want to buy?\n1 M4\n2 Glock 19");
        Scanner sc = new Scanner(System.in);
        int gun = sc.nextInt();
        switch (gun){
            case 1: m4();
            case 2: glock();
        }

    }
    static void m4(){
        Gun m4 = new M4();
        System.out.println("You buyed an M4");
        System.out.println("Bullets: " + m4.getBullets() + "\nMagazine: " + m4.getMagazine() + "\nDemage: " + m4.getDamage());
        actions(m4);
    }
    static void glock() {
        Gun glock = new GlockG19();
        System.out.println("You buyed a Glock 19");
        System.out.println("Bullets: " + glock.getBullets() + "\nMagazine: " + glock.getMagazine() + "\nDemage: " + glock.getDamage());
        actions(glock);
    }
    static void actions(Gun gun){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWhat do you want to do?");
        System.out.println("\n1 Shoot\n2 Reload\n3 Check magazine\n4 Exit");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                if (gun.getBullets() == 0) {
                    System.out.println("No bullets left!");
                    actions(gun);
                }else {
                    System.out.println("You shot!");
                    gun.setBullets(gun.getBullets() - 1);
                    actions(gun);
                }
            case 2:
                try {
                    sleep(gun.getReloadTime());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("You reloaded!");
                gun.setBullets(gun.getMagazine());
                actions(gun);
            case 3:
                System.out.println("Magazine: " + gun.getBullets());
                actions(gun);
            case 4:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
    }

    public static class Gun{
        int bullets;
        int magazine;
        int reloadTime;
        int damage;

        public Gun(int bullets, int magazine, int reloadTime, int damage) {
            this.bullets = bullets;
            this.magazine = magazine;
            this.reloadTime = reloadTime;
            this.damage = damage;
        }

        public int getBullets() {
            return bullets;
        }

        public void setBullets(int bullets) {
            this.bullets = bullets;
        }

        public int getMagazine() {
            return magazine;
        }

        public void setMagazine(int magazine) {
            this.magazine = magazine;
        }

        public int getReloadTime() {
            return reloadTime;
        }

        public void setReloadTime(int reloadTime) {
            this.reloadTime = reloadTime;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }
    }
    public static class GlockG19 extends Gun{
        public GlockG19(int bullets, int magazine, int reloadTime, int damage) {
            super(bullets, magazine, reloadTime, damage);
        }
        public GlockG19(){
            super(15,15,10,50);
        }
    }
    public static class M4 extends Gun{
        public M4(int bullets, int magazine, int reloadTime, int damage) {
            super(bullets, magazine, reloadTime, damage);
        }
        public M4(){
            super(30,30,30,150);
        }
    }
}
