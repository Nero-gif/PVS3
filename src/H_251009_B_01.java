import fileworks.DataImport;

public class H_251009_B_01 {
    public static void main(String[] args) {
        //nacti soubor
        DataImport di = new DataImport("countries.txt");
        //di.printFile();
        System.out.println("prvni zeme:");
        //String countryData = di.readLine();

        //Country firstCountry = parseLine(countryData);
        ArrayList<Country> countries = new ArrayList<>();
        int i = 0;
        while(di.hasNext()){
            countries.add(parseLine(di.readLine()));
            System.out.println(countries.get(i));
            i++;
        }

//        String[] dataPieces = countryData.split(";");
//        Country firstCountry = new Country(
//                dataPieces[0],
//                dataPieces[1],
//                Long.parseLong(dataPieces[2]),
//                Double.parseDouble(dataPieces[3])
//        );

        System.out.println(firstCountry.getName());
        System.out.println(firstCountry.getAge());
        System.out.println(firstCountry);



        di.finishImport();
    }

    static Country parseLine(String line){
        String[] dataPieces = line.split(";");
        Country country = new Country(
                dataPieces[0],
                dataPieces[1],
                Long.parseLong(dataPieces[2]),
                Double.parseDouble(dataPieces[3])
        );
        return country;
    }
}

class Country {
    public String name, continent;
    public long something;
    public double age;

    public Country(String name, String continent, long something, double age) {
        this.name = name;
        this.continent = continent;
        this.something = something;
        this.age = age;
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

    @Override
    public String toString() {
        return String.format("nazev: %s | kontinent: %s | populace: %,d | doziti: %.2f", name, continent, something, age);
    }
}


