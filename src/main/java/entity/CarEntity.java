package entity;

import javax.persistence.*;

@Entity
@Table(name="car", catalog = "sellcar")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String link;

    private int price;



    public CarEntity() {
    }

//    public CarEntity(String brand, String model, int year, String link) {
//        this.brand = brand;
//        this.model = model;
//        this.year = year;
//        this.link = link;
//    }
    public CarEntity(String brand, String model, int year, String link, int price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.link = link;
        this.price = price;
    }

//    public CarEntity(Long id, String brand, String model, int year, String link) {
//        this.id = id;
//        this.brand = brand;
//        this.model = model;
//        this.year = year;
//        this.link = link;
//    }

    public CarEntity(Long id, String brand, String model, int year, String link, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.link = link;
        this.price = price;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
