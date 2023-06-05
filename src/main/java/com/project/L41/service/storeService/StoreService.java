package com.project.L41.service.storeService;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.productModel.Product;
import com.project.L41.model.storeModel.Store;

import java.util.List;

public interface StoreService {
    void addStore(Store store);
    List<Store> loadAllStore();
    Store findStoreByID(long id);
    void deleteStoreByID(long id);
    void updateStore(Store store);

    List<Employee> loadAllEmployeeByStore(long idStore);
    List<Employee> loadGroupsEmployeeByStore(long idStore, String employeeGroup);
    List<Product>  loadAllProductByStore( long idStore);
    List<Product> loadGorpusProductByStore(long idStore, String prodcutGroups);

}
