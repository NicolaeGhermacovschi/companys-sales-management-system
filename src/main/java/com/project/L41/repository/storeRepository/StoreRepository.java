package com.project.L41.repository.storeRepository;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.productModel.Product;
import com.project.L41.model.storeModel.Store;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StoreRepository {

    void addStore(Store store) throws SQLException;

    List<Store> loadAllStore() throws SQLException;

    Store findStoreByID(long id) throws SQLException;

    void deleteStoreByID(long id) throws SQLException;

    void updateStore(Store store) throws SQLException;

    List<Employee> loadAllEmployeeByStore(long idStore) throws SQLException;

    List<Employee> loadGroupsEmployeeByStore(long idStore, String employeeGroup) throws SQLException;

    List<Product> loadAllProductByStore(long idStore) throws SQLException;

    List<Product> loadGorpusProductByStore(long idStore, String prodcutGroups) throws SQLException;

}
