package com.project.L41.service.SalesService;

import com.project.L41.model.salesModel.Sales;
import com.project.L41.repository.salesRepository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public void addSales(Sales sales) {
        System.out.println("add sales");
        try {
            salesRepository.addSales(sales);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Sales> loadAllSales() {
        List<Sales> salesList = new ArrayList<>();
        System.out.println("load all sales");
        try {
            salesList = salesRepository.loadAllSales();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    @Override
    public Sales findSaleById(long idSale) {
        System.out.println("delete sales by id");
        Sales sales = null;
        try {
            sales = salesRepository.findSaleById(idSale);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public void deleteSaleByID(long idSale) {
        System.out.println("delete sales  by id");
        try {
            salesRepository.deleteSaleByID(idSale);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public StringBuilder showSatutsSale(long idSale) {
        System.out.println("show satus sales");

        try {
            return salesRepository.showSatutsSale(idSale);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSatusSale(Sales sales) {
        System.out.println("update sales");
        try {
            salesRepository.updateSatusSale(sales);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
