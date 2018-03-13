package model;

public class Password {

    private Long id;

    private String value;

    private Long holderId;

    public Password() {
    }

    public Password(Long id, String value, Long holderId) {
        this.id = id;
        this.value = value;
        this.holderId = holderId;
    }

    public Password(String value, Long holderId) {
        this.value = value;
        this.holderId = holderId;
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

    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }
}


