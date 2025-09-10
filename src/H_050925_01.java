import fileworks.DataImport;

import java.util.Scanner;

public class H_050925_01 {
    public static void main(String[] args) {
        DataImport dataImport = new DataImport("randomtext.txt");

        dataImport.printFile();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);

        line = dataImport.readLine();
        System.out.println(line);

        line = dataImport.readLine();
        System.out.println(line);

        while(dataImport.hasNext()){
            line = dataImport.readLine();
            System.out.println("ni**a" + line);
        }
    }
}