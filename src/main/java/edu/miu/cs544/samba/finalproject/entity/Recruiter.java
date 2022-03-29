package edu.miu.cs544.samba.finalproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recruiter extends Company{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String name;
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();

    public Recruiter() {
    }


    public Recruiter(String name, Address address) {
        super(name, address);
    }

    public List<Client> getClients() {
        return clients;
    }


    public void addClient(Client client) {
        this.clients.add(client);
        client.setRecruiter(this);
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "id=" + id +
                ", clients=" + clients +
                '}';
    }
}
