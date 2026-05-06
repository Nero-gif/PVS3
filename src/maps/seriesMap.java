package maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class seriesMap {
    public static void main(String[] args)  throws IOException {
        String seriesPath = "./testdata/series.csv";
        String episodesPath = "./testdata/episodes.csv";

        List<Series> series = Files.lines(Path.of(seriesPath))
                .skip(1)
                .map(line -> line.split(";"))
                .map(parts -> new Series(parts[1], parts[0]))
                .toList();
        List<Episode> episodes = Files.lines(Path.of(episodesPath))
                .skip(1)
                .map(line -> line.split(";"))
                .map(parts -> new Episode(Integer.parseInt(parts[0]), Long.parseLong(parts[1]), Double.parseDouble(parts[2]), parts[3]))
                .toList();

        Map<Series, List<Episode>> seriesMap = episodes.stream()
                .collect(Collectors.groupingBy(ep -> series.stream()
                        .filter(s -> s.getCode().equals(ep.getCode()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Series not found for episode code: " + ep.getCode()))));
    }
}

class Episode{
    int season;
    long epNum;
    double rating;
    String code;

    public Episode(int season, long epNum, double rating, String code) {
        this.season = season;
        this.epNum = epNum;
        this.rating = rating;
        this.code = code;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public long getEpNum() {
        return epNum;
    }

    public void setEpNum(long epNum) {
        this.epNum = epNum;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", epNum=" + epNum +
                ", rating=" + rating +
                ", code='" + code + '\'' +
                '}';
    }
}

class Series{
    String name;
    String code;

    public Series(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
