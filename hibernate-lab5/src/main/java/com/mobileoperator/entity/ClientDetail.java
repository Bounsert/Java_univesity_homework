package com.mobileoperator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client_details")
public class ClientDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private String address;

    public ClientDetail() {}
    public ClientDetail(String passportNumber, String address) {
        this.passportNumber = passportNumber;
        this.address = address;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}