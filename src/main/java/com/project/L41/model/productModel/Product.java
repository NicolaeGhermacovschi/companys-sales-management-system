package com.project.L41.model.productModel;

public class Product {
    private long id;
    private String name;
    private ProductType productType;
    private double price;
    private String barCode;
    private long idProducer;
    private long idStore;
    private long productQuantity;

    public Product() {
    }

    public Product(long id, String name, ProductType productType, double price, String barCode, long idProducer, long idStore, long productQuantity) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.barCode = barCode;
        this.idProducer = idProducer;
        this.idStore = idStore;
        this.productQuantity = productQuantity;
    }

    public Product(String name, ProductType productType, double price, String barCode, long idProducer, long idStore, long productQuantity) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.barCode = barCode;
        this.idProducer = idProducer;
        this.idStore = idStore;
        this.productQuantity = productQuantity;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public long getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(long idProducer) {
        this.idProducer = idProducer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                ", barCode='" + barCode + '\'' +
                ", idProducer=" + idProducer +
                '}';
    }
}
