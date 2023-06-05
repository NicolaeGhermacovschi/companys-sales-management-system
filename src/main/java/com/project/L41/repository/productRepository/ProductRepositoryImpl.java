package com.project.L41.repository.productRepository;

import com.project.L41.model.buyersModel.Buyer;
import com.project.L41.model.productModel.Product;
import com.project.L41.model.productModel.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L41";
    private static String user = "postgres";
    private static String password = "admin";

    @Override
    public void createProduct(Product product) throws SQLException {

        System.out.println("create a product ProductRepositoryImpl");

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO product(name, product_type, price, barcode, id_producer, " +
                            "id_store, product_quantity ) VALUES (?,?,?,?,?,?,?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, String.valueOf(product.getProductType()));
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getBarCode());
            preparedStatement.setLong(5, product.getIdProducer());
            preparedStatement.setLong(6, product.getIdStore());
            preparedStatement.setLong(7, product.getProductQuantity());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Product> loadAllProdcut() throws SQLException {
        List<Product> productList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM product;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                ProductType productType = ProductType.valueOf(resultSet.getString(3));
                double price = resultSet.getDouble(4);
                String barcode = resultSet.getString(5);
                Long idProducer = resultSet.getLong(6);
                Long idStore = resultSet.getLong(7);
                Long productQuantity = resultSet.getLong(8);

                Product product = new Product(id, name, productType, price, barcode, idProducer, idStore, productQuantity);
                productList.add(product);

            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findProductByID(long id) throws SQLException {
        System.out.println("find product by id repository");
        Product product = null;

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM product WHERE id = ?;");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String name = resultSet.getString(2);
                ProductType productType = ProductType.valueOf(resultSet.getString(3));
                double price = resultSet.getDouble(4);
                String barcode = resultSet.getString(5);
                Long idProducer = resultSet.getLong(6);
                Long idStore = resultSet.getLong(7);
                Long productQuantity = resultSet.getLong(8);

                product = new Product(idDB, name, productType, price, barcode, idProducer, idStore, productQuantity);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findProductByBarCode(String code) throws SQLException {
        List<Product> productList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM product WHERE barcode = ?;");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String name = resultSet.getString(2);
                ProductType productType = ProductType.valueOf(resultSet.getString(3));
                double price = resultSet.getDouble(4);
                String barcode = resultSet.getString(5);
                Long idProducer = resultSet.getLong(6);
                Long idStore = resultSet.getLong(7);
                Long productQuantity = resultSet.getLong(8);

                Product product = new Product(idDB, name, productType, price, barcode, idProducer, idStore, productQuantity);
                productList.add(product);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> productByGroups(String group) throws SQLException {
        System.out.println("show product grup");
        List<Product> productGrupList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM product WHERE product_type = ?;");
            preparedStatement.setString(1, group.toUpperCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String name = resultSet.getString(2);
                ProductType productType = ProductType.valueOf(resultSet.getString(3));
                double price = resultSet.getDouble(4);
                String barcode = resultSet.getString(5);
                Long idProducer = resultSet.getLong(6);
                Long idStore = resultSet.getLong(7);
                Long productQuantity = resultSet.getLong(8);

                Product product = new Product(idDB, name, productType, price, barcode, idProducer, idStore, productQuantity);
                productGrupList.add(product);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productGrupList;
    }

    @Override
    public void deleteProductByID(long id) throws SQLException {
        System.out.println("delete from repository");


        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("DELETE FROM product WHERE id = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        System.out.println("update a product ProductRepositoryImpl");
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE product SET name = ?, product_type = ? , price = ?, barcode = ?," +
                            "id_producer = ?, id_store = ?, product_quantity  = ? WHERE id = ?;");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, String.valueOf(product.getProductType()));
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getBarCode());
            preparedStatement.setLong(5, product.getIdProducer());
            preparedStatement.setLong(6, product.getIdStore());
            preparedStatement.setLong(7, product.getProductQuantity());
            preparedStatement.setLong(8, product.getId());


            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
