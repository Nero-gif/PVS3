import fileworks.DataImport;

import java.util.HashSet;

public class testCollections {
    public static void main(String[] args) {
        DataImport di = new DataImport("./testdata/movieList.txt");

        HashSet<Movie0312> movies =  new HashSet<>();
        while (di.hasNext()) {
            Movie0312 movie = parseLine(di.readLine());
            movies.add(movie);
        }

        printByYear(movies);
        genreCount(movies);

        di.finishImport();
    }
    static Movie0312 parseLine(String line) {
        String[] dataPieces = line.split(";");

        Movie0312 movie = new Movie0312(
                dataPieces[0],
                dataPieces[1],
                dataPieces[2],
                Double.parseDouble(dataPieces[3])
        );
        return movie;
    }

    static void printByYear(HashSet<Movie0312> m) {
        for (Movie0312 movie : m) {
                System.out.println(movie.getTitle() + ";" +  movie.getYear());

        }
    }
    static void genreCount(HashSet<Movie0312> m){
        String[] genres = new String[0];
        int i = 0;
        for (Movie0312 movie : m) {
            if (!m.contains(movie.getGenre())) {
                i++;
                continue;
            }
            //genres[i] = movie.getGenre();
            System.out.println(i);
        }

        System.out.println("Genre count: " + genres.length);
        for (int j = 0; j < genres.length; j++) {
            System.out.println("Genre: " + genres[j]);
        }
    }
}






class Movie0312 {
    private String title;
    private String year;
    private String genre;
    private double rating;

    public Movie0312(String title, String year, String genre, double rating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie0312() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}