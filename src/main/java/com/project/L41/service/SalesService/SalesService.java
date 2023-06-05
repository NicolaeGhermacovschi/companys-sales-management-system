package com.project.L41.service.SalesService;

import com.project.L41.model.salesModel.Sales;

import java.sql.SQLException;
import java.util.List;

public interface SalesService {
    void addSales(Sales sales);

    List<Sales> loadAllSales();

    Sales findSaleById(long idSale);

    void deleteSaleByID(long idSale);

    StringBuilder showSatutsSale(long idSale);

    void updateSatusSale(Sales sales);
}
