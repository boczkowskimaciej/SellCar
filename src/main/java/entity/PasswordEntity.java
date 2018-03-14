package entity;

import javax.persistence.*;

@Entity
@Table(name="password", catalog = "sellcar")
public class PasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;

    @OneToOne
    @JoinColumn(name = "holderId")
    private HolderEntity holderEntity;

    public PasswordEntity() {
    }

    public PasswordEntity(String value, HolderEntity holderEntity) {
        this.value = value;
        this.holderEntity = holderEntity;
    }

    public PasswordEntity(Long id, String value, HolderEntity holderEntity) {
        this.id = id;
        this.value = value;
        this.holderEntity = holderEntity;
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

    public HolderEntity getHolderEntity() {
        return holderEntity;
    }

    public void setHolderEntity(HolderEntity holderEntity) {
        this.holderEntity = holderEntity;
    }
}
