package com.project.L41.repository.salesRepository;

import com.project.L41.model.salesModel.Sales;
import com.project.L41.model.salesModel.SalesStatus;

import java.sql.SQLException;
import java.util.List;

public interface SalesRepository {
    void addSales(Sales sales) throws SQLException;

    List<Sales> loadAllSales() throws SQLException;

    Sales findSaleById(long idSale) throws SQLException;

    void deleteSaleByID(long idSale) throws SQLException;

    StringBuilder showSatutsSale(long idSale) throws SQLException;

    void updateSatusSale(Sales sales) throws SQLException;
}

