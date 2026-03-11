package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class countries {
    public static void main(String[] args) {
        String path = "C:\\Users\\Nero\\IdeaProjects\\PVS3\\testdata\\countries\\";

        List<String> countries = new ArrayList<>();

        try {
            String file1 = Files.readString(Path.of(path + "country1.csv"));
            String[] lines1 = file1.split("\\r?\\n");
            for (String line : lines1) {
                if (!line.trim().isEmpty()) {
                    countries.add(line.trim());
                }
            }

            String file2 = Files.readString(Path.of(path + "country2.csv"));
            String[] lines2 = file2.split("\\r?\\n");
            for (String line : lines2) {
                if (!line.trim().isEmpty()) {
                    countries.add(line.trim());
                }
            }

            String file3 = Files.readString(Path.of(path + "country3.csv"));
            String[] lines3 = file3.split("\\r?\\n");
            for (String line : lines3) {
                if (!line.trim().isEmpty()) {
                    countries.add(line.trim());
                }
            }

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path + "countries.ser"));
            out.writeObject(countries);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path + "countries.ser"));
            List<String> loaded = (List<String>) in.readObject();
            in.close();

            System.out.println("Nacteno: " + countries.size());
            System.out.println("Deserializovano: " + loaded.size());
            if (!loaded.isEmpty()) {
                System.out.println("Prvni: " + loaded.get(0));
            }
        } catch (Exception e) {
            System.out.println("Chyba");
        }
    }
}
