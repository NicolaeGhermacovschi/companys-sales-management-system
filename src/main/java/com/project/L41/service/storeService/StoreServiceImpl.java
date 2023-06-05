package com.project.L41.service.storeService;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.productModel.Product;
import com.project.L41.model.storeModel.Store;
import com.project.L41.repository.storeRepository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void addStore(Store store) {
        System.out.println("add store");
        try {
            storeRepository.addStore(store);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Store> loadAllStore() {
        System.out.println("load all store");
        try {
            return storeRepository.loadAllStore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Store findStoreByID(long id) {
        System.out.println("finde store by id");
        Store store = null;
        try {
            store = storeRepository.findStoreByID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return store;
    }

    @Override
    public void deleteStoreByID(long id) {
        System.out.println("delete by id");
        try {
            storeRepository.deleteStoreByID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStore(Store store) {
        System.out.println("update by id");
        try {
            storeRepository.updateStore(store);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> loadAllEmployeeByStore(long idStore) {
        System.out.println("print all employee from specific store");

        List<Employee> employeeListFromStore = new ArrayList<>();
        try {
            employeeListFromStore = storeRepository.loadAllEmployeeByStore(idStore);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeListFromStore;

    }

    @Override
    public List<Employee> loadGroupsEmployeeByStore(long idStore, String employeeGroup) {

        System.out.println("print all employee  groups from specific store");

        List<Employee> employeeListGroupFromStore = new ArrayList<>();
        try {
            employeeListGroupFromStore = storeRepository.loadGroupsEmployeeByStore(idStore, employeeGroup);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeListGroupFromStore;
    }

    @Override
    public List<Product> loadAllProductByStore(long idStore) {
        System.out.println("pring all product from store");
        List<Product> productList = new ArrayList<>();
        try {
            productList = storeRepository.loadAllProductByStore(idStore);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> loadGorpusProductByStore(long idStore, String prodcutgroups) {

        System.out.println("pring all  product  groups from  store");
        List<Product> productList = new ArrayList<>();
        try {
            productList = storeRepository.loadGorpusProductByStore(idStore, prodcutgroups);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
