package model;

import javax.validation.constraints.Email;

public class Buyer {

    private int id;

    private String name;

    private String surname;

    private int phone;

    @Email
    private int email;
}
