package model;


public class Car {

    private long id;

    private String branch;

    private String model;

    private int year;

//    private int capacity;
//
//    private int power;
//
//    private String petrol;
//
//    private int price;


    public Car() {
    }

    public Car(String branch, String model, int year) {
        this.branch = branch;
        this.model = model;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
}
