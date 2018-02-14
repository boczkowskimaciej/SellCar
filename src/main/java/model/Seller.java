package model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;

public class Seller {

    private int id;

    private String name;

    private String surname;

    private int phone;

    @Email
    private int email;
}
