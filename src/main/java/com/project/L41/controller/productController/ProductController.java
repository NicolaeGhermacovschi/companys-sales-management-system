package com.project.L41.controller.productController;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.productModel.Product;
import com.project.L41.service.poductService.ProductService;
import com.project.L41.service.poductService.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product/add")
    public void createProduct(@RequestBody  Product product){
        productService.addProduct(product);
    }
    @GetMapping("/product/all")
    List<Product> getAllProduct(){
        return productService.loadAllProduct();
    }


    @GetMapping("/product/id/{id}")
    Product getProductByID(@PathVariable Long id ){

        return productService.findProductByID(id);
    }
    @GetMapping("/product/barcode/{barcode}")
    List<Product> getProductByBarCode(@PathVariable String code){

        return productService.findProductByBarCode(code);
    }
    @GetMapping("/product/group/{group}")
    List<Product> productByGroups(@PathVariable  String group){
        return productService.productByGroups(group);
    }
    @DeleteMapping("/product/id/{id}")
    void deleteProductByID(@PathVariable Long id){

        productService.deleteProductByID(id);
    }
    @PutMapping("/product/update")
    void updateProduct(@RequestBody Product product) {

        productService.updateProduct(product);
    }


}
