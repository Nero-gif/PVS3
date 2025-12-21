package opakovani.oop;

import fileworks.DataImport;

import java.util.ArrayList;

public class ParseFile {
    public static void main(String[] args) {
        DataImport di = new DataImport("C:/Users/user/IdeaProjects/PVS3/testdata/special.txt");
        ArrayList<Track> tracks = new ArrayList<>();
        while(di.hasNext()){
            Track track = parseLine(di.readLine());
            tracks.add(track);
        }

        /*for (int i = 0; i < tracks.size(); i++) {
            System.out.println(tracks.get(i).getName());
        }*/

        longestTrack(tracks);
        shortestTrack(tracks);

    }

    static Track parseLine(String line){
        String[] dataPieces = line.split(";");
        Track track = new Track(
                dataPieces[0],
                Integer.parseInt(dataPieces[1]),
                Double.parseDouble(dataPieces[2]),
                Integer.parseInt(dataPieces[3])
        );
        return track;
    }

    static void longestTrack(ArrayList<Track> tracks){
        int indexOfLongest = 0;
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getLength() > tracks.get(indexOfLongest).getLength()) {
                indexOfLongest = i;
            }
        }
        int minutes = tracks.get(indexOfLongest).getLength() / 60;
        int seconds = tracks.get(indexOfLongest).getLength() % 60;
        System.out.println("Longest track is '" + tracks.get(indexOfLongest).getName() + "' which have " + tracks.get(indexOfLongest).getLength() + " seconds (" +  minutes + ":" + seconds + ")");
    }

    static void shortestTrack(ArrayList<Track> tracks){
        int indexOfShortest = 0;
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getLength() < tracks.get(indexOfShortest).getLength()) {
                indexOfShortest = i;
            }
        }
        int minutes = tracks.get(indexOfShortest).getLength() / 60;
        int seconds = tracks.get(indexOfShortest).getLength() % 60;
        System.out.println("Shortest track is '" + tracks.get(indexOfShortest).getName() + "' which have " + tracks.get(indexOfShortest).getLength() + " seconds (" +  minutes + ":" + seconds + ")");
    }
}
class Track{
    String name;
    int year;
    double rating;
    int length;
    public Track(String name, int year, double rating, int length) {
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
}
