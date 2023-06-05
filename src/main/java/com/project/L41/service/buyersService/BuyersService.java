package com.project.L41.service.buyersService;

import com.project.L41.model.buyersModel.Buyer;

import java.util.List;

public interface BuyersService {

    void addBuyers(Buyer buyer);
    List<Buyer> loagAllBuyers();
    Buyer findBuyerByID(Long id);
    List<Buyer> findBuyersByName(String name);

    void deleteBuyerByID(Long id);
    void updateBuyer(Buyer buyer);

}
