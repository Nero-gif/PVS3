import java.io.*;

public class MultiFilesFirst {
    public static void main(String[] args) {
        String pathIN = ".\\testdata\\znamky.txt";
        String pathOUT = ".\\testdata\\znamkyPrumner.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathIN));

            FileWriter fw = new FileWriter(pathOUT);

            String line;

            double bestAverage = 10;
            String bestName = "";

            double worstAverage = 0;
            String worstName = "";

            while ((line = br.readLine()) != null) {
                String[] marks = line.split(";");
                int soucet = 0;

                for (int i = 1; i < marks.length; i++) {
                    soucet += Integer.parseInt(marks[i]);
                }

                double average;
                average = (double) soucet / (marks.length - 1);
                String write = marks[0] + ";" + average;
                fw.write(write + '\n');

                if (bestAverage > average){
                    bestAverage = average;
                    bestName = marks[0];
                }

                if (worstAverage < average){
                    worstAverage = average;
                    worstName = marks[0];
                }
            }
            String best = bestName + ";" +  bestAverage;
            System.out.println("Nejlepší je " + best);

            String worst = worstName + ";" +  worstAverage;
            System.out.println("Nejhorší je " + worst);

            br.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
