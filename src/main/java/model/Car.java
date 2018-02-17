package model;


public class Car {

    private long id;
    private String brand;
    private String model;
    private int year;
    private String link;

//    private int capacity;
//
//    private int power;
//
//    private String petrol;
//
//    private int price;


    public Car() {
    }

    public Car(String brand, String model, int year, String link) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
