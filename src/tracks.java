import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class tracks {
    public static void main(String[] args) throws IOException {
        String path = "./testdata/tracks.txt";
        System.out.println(Files.exists(Path.of(path)));
        
    List<Track4> tracks = new ArrayList<>();
    try{
    Files.lines(Path.of(path))
            .map(line -> line.split(";"))
            .map(tokens -> new Track4(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Integer.parseInt(tokens[3])
                )
            )
            .filter(track -> track.getRating() > 8.5)
            .forEach(System.out::println);
            ;            
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
    }
   
}
class Track4 {
    String name;
    int year;
    double rating;
    int length;

    public Track4(String name, int year, double rating, int length) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Track4{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", length=" + length +
                '}';
    }
}
