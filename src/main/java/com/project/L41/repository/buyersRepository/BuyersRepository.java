package com.project.L41.repository.buyersRepository;

import com.project.L41.model.buyersModel.Buyer;

import java.sql.SQLException;
import java.util.List;

public interface BuyersRepository {

    void createBuyer(Buyer buyer) throws SQLException;
    List<Buyer> loadAllBuyers() throws SQLException;

    Buyer findBuyerByID(long id) throws SQLException;
    List<Buyer> findBuyerByName(String name) throws SQLException;
    void deleteBuyerByID(long id) throws SQLException;
    void updateBuyer(Buyer buyer) throws SQLException;

}
