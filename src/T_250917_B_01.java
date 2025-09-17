import fileworks.DataImport;

import java.util.ArrayList;
import java.util.logging.Filter;

public class T_250917_B_01 {
    public static void main(String[] args) {
        DataImport di = new DataImport("./testdata/movieList.txt");

        ArrayList<Movie> movies =  new ArrayList<>();
        while (di.hasNext()) {
            Movie movie = parseLine(di.readLine());
            movies.add(movie);
        }

        FilterByRating(movies, 9.9);
        FilterByGenre(movies,  "Thriller",0);
        di.finishImport();
    }


    static Movie parseLine(String line) {
        String[] dataPieces = line.split(";");

        Movie movie = new Movie(
                dataPieces[0],
                dataPieces[1],
                dataPieces[2],
                Double.parseDouble(dataPieces[3])
        );
        return movie;
    }

    static void FilterByRating(ArrayList<Movie> m, Double filter) {
        System.out.println("Filmy s ratingem více než " + filter + ":");
        for (Movie movie : m) {
            if (movie.getRating() > filter){
                System.out.println(movie.getTitle() + ";" +  movie.getRating());
            }
        }
    }

    static void FilterByGenre(ArrayList<Movie> m, String genre, int CountOfGenre) {
        for (Movie movie : m) {
            if (movie.getGenre().equals(genre)){
                CountOfGenre ++;
            }
        }
        System.out.println("V seznamu je " + CountOfGenre + " filmů žánru " + genre);
    }

}



class Movie {
    private String title;
    private String year;
    private String genre;
    private double rating;

    public Movie(String title, String year, String genre, double rating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Název: %s | Kontinent: %s | Populace: %,d | Dožití: %.2f", title, year, genre, rating);
    }
}
