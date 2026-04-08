package lambdaTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 1. Načtěte soubor data/cars.csv
 *    - přeskočte 1. řádek souboru
 *    - všechny záznamy uložte do List<Car> cars
 * 2. Implementujte všechny metody
 */
public class CarStream {
    public static void main(String[] args) {
        String path = "testdata/cars.csv";
        List<Car> cars = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(path));

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).trim().split(",");
                cars.add(new Car(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        Integer.parseInt(parts[5])
                        )
                );
            }
            printStatistics(cars);
            getAverageTopSpeed(cars, "Porsche");
            getCarsAbovePowerByBrand(cars, "Bugatti", 420);
            
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Vypište průměrnou maximální rychlost aut značky Porsche

        // Vypište všechny auta levnější než 8000 USD

        // Vypište statistiky o autech na základě jejich "Performance"

        // Vypište všechny auta značky Bugatti nad 420 HP

        // Vypište, kolik procent aut je značky Nissan
    }

    /**
     * Vypíše základní statistiky o autech pomocí {@code summaryStatistics}
     * nad hodnotou {@code performance}.
     *
     * @param cars seznam aut
     */
    private static void printStatistics(List<Car> cars) {
        IntSummaryStatistics statistics = cars.stream()
                .mapToInt(Car -> (int) Car.performance)
                .summaryStatistics();
        System.out.println("Statistiky: " + statistics);
    }

    /**
     * Vrátí nový vyfiltrovaný seznam aut.
     *
     * @param cars seznam aut
     * @param price maximální cena (včetně), kterou mohou mít auta v novém seznamu
     * @return nový vyfiltrovaný seznam aut
     */
    private static List<Car> filterByPrice(List<Car> cars, int price) {
        return null;
    }

    /**
     * Vrátí průměrnou maximální rychlost aut od značky {@code brand}.
     *
     * @param cars vstupní seznam aut
     * @param brand název značky auta (například Škoda)
     * @return průměrná maximální rychlost aut dané značky
     */
    private static double getAverageTopSpeed(List<Car> cars, String brand) {
        double avgSpeed = cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .mapToInt(Car::getTotalSpeed)
                .average()
                .orElse(0);
        System.out.println("Průměrná maximální rychlost aut značky " + brand + " je " + avgSpeed);
        return avgSpeed;
        
    }


    /**
     * Vrátí seznam aut dané značky, jejichž výkon je větší než zadaná mez.
     *
     * @param cars vstupní seznam aut
     * @param brand název značky auta
     * @param threshold minimální výkon, který musí auto překročit
     * @return seznam aut dané značky s výkonem větším než {@code threshold}
     */
    public static List<String> getCarsAbovePowerByBrand(List<Car> cars, String brand, int threshold) {
        List<String> carsByPower = cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .filter(car -> car.getPerformance() > threshold)
                .map(Car::getCar)
                .toList();
        System.out.println("Auta značky " + brand + " s výkonem větším než " + threshold + " jsou: " + carsByPower);
        return carsByPower;
    }

    /**
     * Vrátí procentuální zastoupení aut dané značky v seznamu.
     * Výsledek je vrácen v procentech, například {@code 24.5}, nikoli {@code 0.245}.
     *
     * @param cars vstupní seznam aut
     * @param brand název značky auta
     * @return procentuální zastoupení aut dané značky v seznamu
     */
    public static double getBrandPercentage(List<Car> cars, String brand) {
        return 0;
    }
}

class Car{
    String brand;
    String car;
    int horsePower;
    int totalSpeed;
    double performance;
    int price;

    public Car(String brand, String car, int horsePower, int totalSpeed, double performance, int price) {
        this.brand = brand;
        this.car = car;
        this.horsePower = horsePower;
        this.totalSpeed = totalSpeed;
        this.performance = performance;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getTotalSpeed() {
        return totalSpeed;
    }

    public void setTotalSpeed(int totalSpeed) {
        this.totalSpeed = totalSpeed;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", car='" + car + '\'' +
                ", horsePower=" + horsePower +
                ", totalSpeed=" + totalSpeed +
                ", performance=" + performance +
                ", price=" + price +
                '}';
    }
}