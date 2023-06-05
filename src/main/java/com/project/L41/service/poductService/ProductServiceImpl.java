package com.project.L41.service.poductService;

import com.project.L41.model.productModel.Product;
import com.project.L41.repository.productRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        System.out.println("create product service");
        try {
            productRepository.createProduct(product);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> loadAllProduct() {
        System.out.println("load all prodcut");

        List<Product> productList = new ArrayList<>();
        try {
            productList = productRepository.loadAllProdcut();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product findProductByID(long id) {
        System.out.println("find product by id ");
        Product product = null;
        try {
            product = productRepository.findProductByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findProductByBarCode(String code) {
        System.out.println("find product by barcode");
        List<Product> productList = new ArrayList<>();
        try {
            productList = productRepository.findProductByBarCode(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> productByGroups(String group) {
        List<Product> productGroupsList = new ArrayList<>();
        try {
            productGroupsList = productRepository.productByGroups(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productGroupsList;
    }

    @Override
    public void deleteProductByID(long id) {
        System.out.println("delete product");
        try {
            productRepository.deleteProductByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("update product ");
        try {
            productRepository.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
