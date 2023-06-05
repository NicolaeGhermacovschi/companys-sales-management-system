package com.project.L41.model.storeModel;

import jakarta.persistence.*;

public class Store {

    private long idStore;

    private String name;

    private String address;

    public Store() {
    }

    public Store(String name, String address) {
        this.name = name;
        this.address = address;

    }

    public Store(long idStore, String name, String address) {
        this.idStore = idStore;
        this.name = name;
        this.address = address;

    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
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
        return "Store{" +
                "idStore=" + idStore +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
