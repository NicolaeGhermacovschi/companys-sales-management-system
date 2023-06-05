package com.project.L41.controller.buyersController;

import com.project.L41.model.buyersModel.Buyer;
import com.project.L41.service.buyersService.BuyersService;
import com.sun.jdi.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerController {
    @Autowired
    BuyersService buyersService;

    @PostMapping("/buyer/add")
    public void createBuyer(@RequestBody Buyer buyer) {
        buyersService.addBuyers(buyer);
    }

    @GetMapping("/buyers/all")
    List<Buyer> loadAllBuyers() {
        return buyersService.loagAllBuyers();
    }
    @GetMapping("buyer/id/{id}")
    Buyer findBuyerByID(@PathVariable Long id){
        return buyersService.findBuyerByID(id);
    }
    @GetMapping("/buyers/name/{name}")
    List<Buyer> findBuyersByName(@PathVariable String name){
        return buyersService.findBuyersByName(name);
    }
    @DeleteMapping("buyer/id/{id}")
    void deleteBuyerByID(@PathVariable Long id){
        buyersService.deleteBuyerByID(id);
    }
    @PutMapping("/buyer/update")
    void updateBuyer(@RequestBody Buyer buyer){
        buyersService.updateBuyer(buyer);
    }
}
