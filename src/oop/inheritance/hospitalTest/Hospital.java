package oop.inheritance.hospitalTest;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Hospital {

    static void doRandomJob(Doctor doctor){
        Random r = new Random();

        switch(r.nextInt(1,4)){
            case 1:
                doctor.diagnose();
                break;
            case 2:
                if (doctor instanceof Surgeon) {
                    ((Surgeon) doctor).surgery();
                }
                break;
            case 3:
                if (doctor instanceof CardiacSurgeon) {
                    ((CardiacSurgeon) doctor).cardiacSurgery();
                }
                break;
        }
    }

    static void doJob(Doctor doctor, String pismeno){
        if (pismeno.equals("C") && doctor instanceof CardiacSurgeon) {
            ((CardiacSurgeon) doctor).cardiacSurgery();
            return;
        } else if (pismeno.equals("C")) {
            doctor.salary -= 50000;
        }
        if (pismeno.equals("S") && doctor instanceof Surgeon) {
            ((Surgeon) doctor).surgery();
            return;
        } else if (pismeno.equals("S")) {
            doctor.salary -= 50000;
        }
        if (pismeno.equals("D")) {
            doctor.diagnose();
        }
    }

    public static void main(String[] args) {

        DataImport di = new DataImport("./testdata/hospitalData.txt");

        DataExport de = new DataExport("./testdata/salary.txt");

        Doctor doctor = null;

        String MAXsalary[] = new String[2];
        String MINsalary[] = new String[2];
        MAXsalary[1] = "0";
        MINsalary[1] = "0";

        while (di.hasNext()){
            String line = di.readLine();
            String[] parts = line.split(";");

            if (parts[1].equals("Doctor")){
                doctor = new Doctor(parts[0]);

            } else if (parts[1].equals("Surgeon")) {
                doctor = new Surgeon(parts[0]);

            } else if (parts[1].equals("CardiacSurgeon")) {
                doctor = new CardiacSurgeon(parts[0]);

            }
            for (int i = 2; i < parts.length; i++){
                doJob(doctor, parts[i]);
            }
            System.out.println(doctor.name + "get" + doctor.salary);
            de.writeLine(doctor.name + ";" +  doctor.salary);

            if (doctor.salary > Integer.parseInt(MAXsalary[1])){
                MAXsalary[1] = String.valueOf(doctor.salary);
                MAXsalary[0] = doctor.name;
            }
            if (doctor.salary < Integer.parseInt(MINsalary[1])){
                MINsalary[1] = String.valueOf(doctor.salary);
                MINsalary[0] = doctor.name;
            }
        }
        System.out.println("Nejvice dostane " + MAXsalary[0] + ";" + MAXsalary[1]);
        System.out.println("nejméně dostane " +MINsalary[0] + ";" + MINsalary[1]);
    }
}
