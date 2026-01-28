import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SensorTask {
    static ArrayList<Reading> validReadings = new ArrayList<>();
    static ArrayList<InvalidReading> invalidReadings = new ArrayList<>();

    static void reportReadings(String dirPath) throws IOException {
        validReadings.clear();
        invalidReadings.clear();

        Path dir = Paths.get(dirPath);
        if (!Files.isDirectory(dir)) {
            throw new IOException("Hole in universe: " + dir.toAbsolutePath());
        }

        for (int i = 1; i <= 20; i++) {
            Path file = dir.resolve("sen" + i + ".txt");
            if (!Files.exists(file) || Files.isDirectory(file)) {
                continue;
            }
            try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                String line;
                int numberOfLine = 0;
                while ((line = br.readLine()) != null) {
                    numberOfLine++;
                    //System.out.println("numberOfLine " + numberOfLine);
                    //System.out.println(line);
                    if (line.trim().isEmpty()) {
                        System.out.println("Empty line");
                        invalidReadings.add(new InvalidReading(
                                file.getFileName().toString(),
                                numberOfLine,
                                new Reading("", Double.NaN)
                        ));
                        continue;
                    }

                    String[] parts = line.split(",", 2);
                    String sensor = parts[0].trim();
                    double value;
                    boolean parsed = false;

                    if (parts.length == 1) {
                        String valueStr = parts[0].trim();
                        try {
                            value = Double.parseDouble(valueStr);
                            parsed = true;
                        } catch (NumberFormatException ex) {
                            value = Double.NaN;
                        }
                    } else {
                        value = Double.NaN;
                    }

                    System.out.println(value);
                    if (parsed && value >= -200.0 && value <= 500.0
                    ) {
                        validReadings.add(new Reading(sensor, value));
                    } else {
                        invalidReadings.add(new InvalidReading(
                                file.getFileName().toString(),
                                numberOfLine,
                                new Reading(sensor, value)
                        ));
                    }
                }
            }
        }

        System.out.println("Validních čtení: " + validReadings.size());
        System.out.println("Nevalidních čtení: " + invalidReadings.size());
    }

    public static void main(String[] args) {
        try {
            reportReadings("C:\\Users\\user\\IdeaProjects\\PVS3\\testdata\\dataSensors");
        } catch (IOException e){
            System.out.println("Problem reading the directory:");
            System.out.println(e.getMessage());
        }
    }

}
class Reading{
    String sensorID;
    double measuredValue;

    public Reading(String sensorID, double measuredValue) {
        this.sensorID = sensorID;
        this.measuredValue = measuredValue;
    }

    @Override
    public String toString() {
        return sensorID + ": " + measuredValue;
    }
}
class InvalidReading{
    String fileName;
    int lineNumber;
    Reading reading;

    public InvalidReading(String fileName, int lineNumber, Reading reading) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.reading = reading;
    }

    @Override
    public String toString() {
        return "InvalidReading{file='" + fileName + "', line=" + lineNumber + ", reading=" + reading + "}";
    }
}
