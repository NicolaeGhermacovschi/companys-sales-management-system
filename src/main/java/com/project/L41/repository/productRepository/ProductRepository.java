package com.project.L41.repository.productRepository;

import com.project.L41.model.productModel.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {

    void createProduct(Product product) throws SQLException;
    List<Product> loadAllProdcut() throws SQLException;
    Product findProductByID(long id) throws  SQLException;
    List<Product> findProductByBarCode(String code) throws SQLException;
    List<Product> productByGroups(String group) throws SQLException;

    void deleteProductByID(long id) throws SQLException;

    void updateProduct(Product product) throws SQLException;

}
