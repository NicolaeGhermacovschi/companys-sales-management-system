package com.project.L41.model.producerModel;

import jakarta.persistence.*;

@Entity
@Table
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProducer;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public Producer() {
    }

    public long getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(long idProducer) {
        this.idProducer = idProducer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "idProducer=" + idProducer +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
