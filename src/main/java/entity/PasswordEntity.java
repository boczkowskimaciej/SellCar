package entity;

import model.Holder;

import javax.persistence.*;

@Entity
@Table(name="password", catalog = "sellcar")
public class PasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;

    private Long holderId;

    public PasswordEntity() {
    }

    public PasswordEntity(String value, Long holderId) {
        this.value = value;
        this.holderId = holderId;
    }

    public PasswordEntity(Long id, String value, Long holderId) {
        this.id = id;
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
