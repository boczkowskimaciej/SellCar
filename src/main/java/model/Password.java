package model;

public class Password {

    private Long id;

    private String value;

    private Holder holder;

    public Password() {
    }

    public Password(Long id, String value, Holder holder) {
        this.id = id;
        this.value = value;
        this.holder = holder;
    }

    public Password(String value, Holder holder) {
        this.value = value;
        this.holder = holder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }
}


