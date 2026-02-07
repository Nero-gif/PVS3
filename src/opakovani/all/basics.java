package opakovani.all;

import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(" ");
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
        sc.close();
    }
}
