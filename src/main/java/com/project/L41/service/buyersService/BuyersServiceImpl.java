package com.project.L41.service.buyersService;

import com.project.L41.model.buyersModel.Buyer;
import com.project.L41.repository.buyersRepository.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuyersServiceImpl implements BuyersService {
    @Autowired
    private BuyersRepository buyersRepository;

    @Override
    public void addBuyers(Buyer buyer) {
        System.out.println("Register Buyer");
        try {
            buyersRepository.createBuyer(buyer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Buyer> loagAllBuyers() {
        System.out.println("Load all buyers");
        List<Buyer> buyerList = new ArrayList<>();
        try {
            buyerList = buyersRepository.loadAllBuyers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerList;
    }

    @Override
    public Buyer findBuyerByID(Long id) {
        System.out.println("find element by id");
        Buyer buyer = null;
        try {
            buyer = buyersRepository.findBuyerByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyer;
    }

    @Override
    public List<Buyer> findBuyersByName(String name) {
        System.out.println("find buyers by name ");
        List<Buyer> buyerList = new ArrayList<>();
        try {
            buyerList = buyersRepository.findBuyerByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerList;
    }

    @Override
    public void deleteBuyerByID(Long id) {
        System.out.println("detele buyer by id");
        try {
            buyersRepository.deleteBuyerByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateBuyer(Buyer buyer) {
        System.out.println("update buyer ");
        try {
            buyersRepository.updateBuyer(buyer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
