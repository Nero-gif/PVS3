import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookMaps {

    public static void printAuthorPages(List<Book> books, String name) {
        int totalPages = books.stream()
                .filter(idk -> idk.getAuthor().equals(name))
                .flatMap(idk2 -> idk2.getChapters().stream())
                .mapToInt(Chapter::getPages)
                .sum();

        System.out.println("Total pages written by " + name + ": " + totalPages);
    }

    public static void printNumberOfBooksOfEveryAuthor(List<Book> books) {
        List<String> authors = books.stream()
                .filter(hhd -> hhd.getAuthor() != null)
                .map(Book::getAuthor)
                .distinct()
                .toList();
        
        for (String author : authors) {
            int numberOfBooks = Math.toIntExact(books.stream()
                    .filter(fd -> fd.getAuthor().equals(author))
                    .mapToInt(Book::getBookId)
                    .distinct()
                    .count());

            System.out.println(author + ": " + numberOfBooks + " books");
        }

        

    }



    public static void printTopFiveAutorsByWritenPages(List<Book> books) {
        System.out.println("Tady si představte že proběhl sort autorů a že se vypsalo 5 autorů co napsalo nejvíce stránek! :)");
    }

    public static void main(String[] args) throws IOException {
        String pathToBooks = "testdata/mapData/books.csv";
        String pathToChapters = "testdata/mapData/chapters.csv";

        List<Chapter> chapters = Files.lines(Path.of(pathToChapters))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Chapter(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2],
                        Integer.parseInt(parts[3])))
                .toList();

        List<Book> books = Files.lines(Path.of(pathToBooks))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Book(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        chapters.stream()
                                .filter(ch -> ch.getChapterId() == Integer.parseInt(parts[0]))
                                .toList()))
                .toList();

        printAuthorPages(books, "Hector Jacobs");
        System.out.println("");

        printNumberOfBooksOfEveryAuthor(books);
        System.out.println("");

        printTopFiveAutorsByWritenPages(books);

        // TODO: Vypište top 5 autorů dle počtu napsaných stran - tohle negunguje
    }
}

class Book {
    private int bookId;
    private String title;
    private String author;
    private List<Chapter> chapters = new ArrayList<>();

    public Book(int bookId, String title, String author, List<Chapter> chapters) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", chapters=" + chapters +
                '}';
    }
//    public int getTotalPages(){
//        // TODO, dodělat, nebo smazat
//        return 0;
//    }
}

class Chapter {
    private int chapterId;
    private int bookID;
    private String title;
    private int pages;

    public Chapter(int chapterId, int bookID, String title, int pages) {
        this.chapterId = chapterId;
        this.bookID = bookID;
        this.title = title;
        this.pages = pages;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId=" + chapterId +
                ", bookID=" + bookID +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}