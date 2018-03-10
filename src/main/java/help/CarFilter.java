package help;

public class CarFilter {

    private String brand;
    private String model;
    private int yearFrom;
    private int yearTo;
    private int priceFrom;
    private int priceTo;

    public CarFilter() {
    }

    public CarFilter(String brand, String model, int yearFrom, int yearTo, int priceFrom, int priceTo) {
        this.brand = brand;
        this.model = model;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }
}


/*

         @RequestParam(name = "brand", defaultValue = "all") String brand,
                                       @RequestParam(name = "model", defaultValue = "all") String model,
                                       @RequestParam(name = "yearFrom", defaultValue = "1899") int yearFrom,
                                       @RequestParam(name = "yearTo", defaultValue = "2020") int yearTo,
                                       @RequestParam(name = "priceFrom", defaultValue = "0") int priceFrom,
                                       @RequestParam(name = "priceTo", defaultValue = "2147483647") int priceTo,
 */