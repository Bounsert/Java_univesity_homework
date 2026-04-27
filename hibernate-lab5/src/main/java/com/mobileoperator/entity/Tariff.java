package com.mobileoperator.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariffs")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double monthlyFee;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
    private List<Client> clients;

    public Tariff() {}
    public Tariff(String name, double monthlyFee) {
        this.name = name;
        this.monthlyFee = monthlyFee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(double monthlyFee) { this.monthlyFee = monthlyFee; }
    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}