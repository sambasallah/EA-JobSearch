package edu.miu.cs544.samba.finalproject.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private int zip;
    private String state;
    private String street;
    private String city;
    @OneToOne(mappedBy = "address")
    private Company company;

    public Address() {
    }

    public Address(int zip, String state, String street, String city) {
        this.zip = zip;
        this.state = state;
        this.street = street;
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zip=" + zip +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
