import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class pinsFolderIDK {
    public static void main(String[] args) {
        String dirPath = "C:\\Users\\user\\IdeaProjects\\PVS3_2526\\data\\pins";

        List<String> validUsernames;
        List<String> validPins;
        List<String> okAttempts = new ArrayList<>();

        int totalAttempts = 0;
        int okCount = 0;

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory not found: " + dir.getAbsolutePath());
            return;
        }

        try {
            
            validUsernames = Files.readAllLines(Path.of(dirPath, "usernames.txt"));
            validPins = Files.readAllLines(Path.of(dirPath, "AllPINs.txt"));
            // očisti případné mezery/CRLF artefakty
            validUsernames.replaceAll(s -> s.trim());
            validPins.replaceAll(s -> s.trim());

            
            for (int i = 1; i <= 5; i++) {
                Path attemptPath = Path.of(dirPath, "attempts_" + i + ".txt");
                if (Files.exists(attemptPath)) {
                    List<String> lines = Files.readAllLines(attemptPath);
                    for (String line : lines) {
                        if (line == null || line.isBlank()) {
                            continue;
                        }

                        // počítáme jen neprázdné řádky
                        totalAttempts++;

                        String[] parts = line.split("=");
                        if (parts.length >= 2) {
                            String user = parts[0].trim();
                            String pin = parts[1].trim();


                            int userIdx = validUsernames.indexOf(user);
                            if (userIdx != -1 && userIdx < validPins.size() && validPins.get(userIdx).equals(pin)) {
                                okCount++;
                                okAttempts.add(line);
                            }
                        }
                    }
                }
            }

            
            double percent = (totalAttempts > 0) ? ((double) okCount / totalAttempts) * 100 : 0;
            System.out.println("Total attempts: " + totalAttempts);
            System.out.println("Valid logins: " + okCount);
            System.out.println("Invalid logins: " + (totalAttempts - okCount));
            System.out.printf("Success rate: %.2f%%%n", percent);

            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dirPath, "validOK.txt")))) {
                for (String attempt : okAttempts) {
                    writer.write(attempt);
                    writer.newLine();
                }
            }
            System.out.println("Valid attempts saved to validOK.txt");

        } catch (Exception e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}