package com.autana.domains;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "autana_phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String number;
    private String citycode;
    private String contrycode;

    Phone() {
    }

    public Phone(String number, String citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public String getNumber() {
        return this.number;
    }

    public String getCityCode() {
        return this.citycode;
    }

    public String getContryCode() {
        return this.contrycode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCityCode(String citycode) {
        this.citycode = citycode;
    }

    public void setContryCode(String contrycode) {
        this.contrycode = contrycode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Phone))
            return false;
        Phone phone = (Phone) o;
        return Objects.equals(this.id, phone.id) && Objects.equals(this.number, phone.number)
                && Objects.equals(this.citycode, phone.citycode) && Objects.equals(this.contrycode, phone.contrycode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.number, this.citycode, this.contrycode);
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + this.id + ", name='" + this.number + '\'' + ", citycode='" + this.citycode
                + ", contrycode='" + this.contrycode + '\'' + '}';
    }

}
