package com.project.L41.controller.storeController;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.productModel.Product;
import com.project.L41.model.storeModel.Store;
import com.project.L41.service.storeService.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/add")
    public void addStore(@RequestBody Store store) {
        storeService.addStore(store);
    }

    @GetMapping("/all")
    public List<Store> loadAllStore() {
        return storeService.loadAllStore();
    }

    @GetMapping("/id/{id}")
    public Store getStoreByID(@PathVariable long id) {
        return storeService.findStoreByID(id);
    }

    @DeleteMapping("/id/{id}")
    void deleteStoreByID(@PathVariable long id) {
        storeService.deleteStoreByID(id);
    }

    @PutMapping("/update")
    void updateStore(@RequestBody Store store) {
        storeService.updateStore(store);
    }

    @GetMapping("/employee/idstore/{idStore}")
    public List<Employee> loadAllEmployeeByStore(@PathVariable long idStore) {
        return storeService.loadAllEmployeeByStore(idStore);
    }
    @GetMapping("/employee/groups/{idStore}/{employeeGroups}")
    public List<Employee> loadGroupsEmployeeByStore(@PathVariable long idStore, @PathVariable String employeeGroups){
        return storeService.loadGroupsEmployeeByStore(idStore,employeeGroups);
    }
    @GetMapping("/product/id/{idStore}")
    public List<Product> loadAllProductByStore(@PathVariable long idStore){
        return storeService.loadAllProductByStore(idStore);
    }
    @GetMapping("/product/groups/{idStore}/{prodcutgroups}")
    public  List<Product> loadGorpusProductByStore(@PathVariable long idStore, @PathVariable String prodcutgroups){
        return storeService.loadGorpusProductByStore(idStore, prodcutgroups);
    }
}
