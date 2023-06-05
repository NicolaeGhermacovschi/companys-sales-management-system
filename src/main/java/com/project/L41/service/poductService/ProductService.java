package com.project.L41.service.poductService;

import com.project.L41.model.producerModel.Producer;
import com.project.L41.model.productModel.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> loadAllProduct();
    Product findProductByID(long id);
    List<Product> findProductByBarCode(String code);
    List<Product> productByGroups(String group);
    void deleteProductByID(long id);
    void updateProduct(Product product);


}
