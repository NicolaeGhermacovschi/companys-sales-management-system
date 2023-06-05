package com.project.L41.controller.salesController;

import com.project.L41.model.salesModel.Sales;
import com.project.L41.service.SalesService.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController  {
    @Autowired
    private SalesService salesService;
    @PostMapping("/add")
    public void addSales(@RequestBody Sales sales){
        salesService.addSales(sales);
    }
    @GetMapping("/all")
    public List<Sales> loadAllSales(){
      return   salesService.loadAllSales();
    }
    @GetMapping("/id/{idSale}")
    public Sales findSaleByID(@PathVariable long idSale){
        return salesService.findSaleById(idSale);
    }
    @DeleteMapping("/id/{idSale}")
    void deleteSales(@PathVariable long idSale){
        salesService.deleteSaleByID(idSale);
    }

    @PutMapping("/update")
    void updateSales(Sales sales){
        salesService.updateSatusSale(sales);
    }
    @GetMapping("/status/id/{idSale}")
    StringBuilder showSatusSale(@PathVariable long idSale){
        return salesService.showSatutsSale(idSale);
    }


}
