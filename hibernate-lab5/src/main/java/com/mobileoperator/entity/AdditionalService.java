package com.mobileoperator.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    @ManyToMany(mappedBy = "services")
    private List<Client> clients;

    public AdditionalService() {}
    public AdditionalService(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}