import java.io.IOException;
import java.util.ArrayList;

public class fillingDepression {
    static ArrayList<Reading> validReadings = new ArrayList<>();
    static ArrayList<InvalidReading> invalidReadings = new ArrayList<>();

    static void reportReadings(String dirPath) throws IOException {

    }

    public static void main(String[] args) {
        try {
            reportReadings("dataSensors");
        } catch (IOException e){
            System.out.println("Problem reading the directory:");
            System.out.println(e.getMessage());
        }
    }

}
class Reading1{
    String sensorID;
    int measuredValue;

    public Reading1(String sensorID, int measuredValue) {
        this.sensorID = sensorID;
        this.measuredValue = measuredValue;
    }

    @Override
    public String toString() {
        return sensorID + ": " + measuredValue;
    }
}
class InvalidReading1{
    String fileName;
    int lineNumber;
    Reading1 reading;

}
