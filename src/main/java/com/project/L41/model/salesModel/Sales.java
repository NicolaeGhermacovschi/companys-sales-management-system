package com.project.L41.model.salesModel;

public class Sales {
    private long idSale;
    private long idBuyer;
    private long idProduct;

    private long idStore;
    private SalesStatus salesStatus;

    public Sales() {
    }

    public Sales(long idSale, long idBuyer, long idProduct, long idStore, SalesStatus salesStatus) {
        this.idSale = idSale;
        this.idBuyer = idBuyer;
        this.idProduct = idProduct;
        this.idStore = idStore;
        this.salesStatus = salesStatus;
    }

    public Sales(long idBuyer, long idProduct, long idStore, SalesStatus salesStatus) {
        this.idBuyer = idBuyer;
        this.idProduct = idProduct;
        this.idStore = idStore;
        this.salesStatus = salesStatus;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public long getIdSale() {
        return idSale;
    }

    public void setIdSale(long idSale) {
        this.idSale = idSale;
    }

    public long getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(long idBuyer) {
        this.idBuyer = idBuyer;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public SalesStatus getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(SalesStatus salesStatus) {
        this.salesStatus = salesStatus;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "idSale=" + idSale +
                ", idBuyer=" + idBuyer +
                ", idProduct=" + idProduct +
                ", salesStatus=" + salesStatus +
                '}';
    }
}
