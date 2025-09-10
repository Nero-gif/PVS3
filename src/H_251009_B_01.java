import fileworks.DataImport;

public class H_251009_B_01 {
    public static void main(String[] args) {
        DataImport di = new DataImport("countries.txt");
        di.printFile();
        System.out.println("1. země");
        String countryData = di.readLine();
        String[] dataPieces = countryData.split(";");
        Country firstcountry = new Country(
                dataPieces[0],
                dataPieces[1],
                Long.parseLong(dataPieces[2]),
                Double.parseDouble(dataPieces[3])
        );
        di.finishImport();
    }
}
class Country {
    public String name, continent;
    public long something;
    public double age;

    public Country(String dataPiece, String dataPiece1, long l, double v) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getSomething() {
        return something;
    }

    public void setSomething(long something) {
        this.something = something;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}