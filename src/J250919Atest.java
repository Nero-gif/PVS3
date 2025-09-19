import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class J250919Atest {
    public static void main(String[] args) {
        DataImport di = new DataImport("./testdata/tracks.txt");

        ArrayList<Track> tracks = new ArrayList<>();
        while (di.hasNext()) {
            Track track = parseLine(di.readLine());
            tracks.add(track);
        }


        FilterByRating(tracks, 8.5);
        timetofile(tracks);
        di.finishImport();
    }

    static Track parseLine(String line) {
        String[] dataPieces = line.split(";");

        Track track = new Track(
                dataPieces[0],
                Integer.parseInt(dataPieces[1]),
                Double.parseDouble(dataPieces[2]),
                Integer.parseInt(dataPieces[3])
        );
        return track;

    }

    static void FilterByRating(ArrayList<Track> t, Double filter) {
        DataExport de1 = new DataExport("./testdata/Top_10.txt");
        int nevim = 0;
        for (Track track : t) {
            nevim++;
            if (nevim < 10) {
                de1.writeLine(track.getTitle() + ";" + track.getRating());
            }
        }
        de1.finishExport();
    }

    static void timetofile(ArrayList<Track> t) {
        DataExport de2 = new DataExport("./testdata/songy.txt");
        for (Track track : t) {
            int m = track.getTimesecond() / 60;
            int s = track.getTimesecond() % 60;
            de2.writeLine(track.getTitle() + ";" + m + ":" + s);
        }
        de2.finishExport();
    }

}
class Track {
    private String title;
    private int year;
    private Double rating;
    private int timesecond;

    public Track(String title, int year, Double rating, int timesecond) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.timesecond = timesecond;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getTimesecond() {
        return timesecond;
    }

    public void setTimesecond(int timesecond) {
        this.timesecond = timesecond;
    }

    @Override
    public String toString() {
        return String.format("Název: %s | Rok vydání: %s | Hodnocení: %s | Délka: %s",  title, year, rating, timesecond);
    }
}