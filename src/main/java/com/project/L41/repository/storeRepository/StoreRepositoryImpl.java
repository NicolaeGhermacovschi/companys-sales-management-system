package com.project.L41.repository.storeRepository;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.employeeModel.EmployeeFunction;
import com.project.L41.model.productModel.Product;
import com.project.L41.model.productModel.ProductType;
import com.project.L41.model.storeModel.Store;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreRepositoryImpl implements StoreRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L41";
    private static String user = "postgres";
    private static String password = "admin";

    @Override
    public void addStore(Store store) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO store(name, address) VALUES(?,?);");
            preparedStatement.setString(1, store.getName());
            preparedStatement.setString(2, store.getAddress());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Store> loadAllStore() {
        List<Store> storeList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM store;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long idStore = resultSet.getLong(1);
                String address = resultSet.getString(3);
                String name = resultSet.getString(2);
                Store store = new Store(idStore, name, address);
                storeList.add(store);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storeList;
    }

    @Override
    public Store findStoreByID(long id) {
        Store store = null;
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM store WHERE id_store = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idStore = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);

                store = new Store(idStore, name, address);

            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;
    }

    @Override
    public void deleteStoreByID(long id) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("DELETE FROM store WHERE id_store = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStore(Store store) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE store SET name = ?,  address  = ? WHERE id_store = ?;");
            preparedStatement.setString(1, store.getName());
            preparedStatement.setString(2, store.getAddress());
            preparedStatement.setLong(3, store.getIdStore());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> loadAllEmployeeByStore(long idStore) {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT employees.id, employees.first_name, employees.last_name, " +
                            "employees.employee_function, employees.salary, employees.id_store" +
                            " FROM employees  JOIN store ON employees.id_store = store.id_store " +
                            "WHERE store.id_store = ?;");
            preparedStatement.setLong(1, idStore);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);
                Long idStoreDB = resultSet.getLong(6);

                Employee empl = new Employee(id, firstName, lastName, employeeFunction, salary, idStoreDB);
                employeeList.add(empl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> loadGroupsEmployeeByStore(long idStore, String employeeGroup) {
        List<Employee> employeeListGroup = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT employees.id, employees.first_name, employees.last_name, " +
                            "employees.employee_function, employees.salary, employees.id_store" +
                            " FROM employees  JOIN store ON employees.id_store = store.id_store " +
                            "WHERE store.id_store = ? and employees.employee_function = ? ;");
            preparedStatement.setLong(1, idStore);
            preparedStatement.setString(2, employeeGroup.toUpperCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);
                Long idStoreDB = resultSet.getLong(6);

                Employee empl = new Employee(id, firstName, lastName, employeeFunction, salary, idStoreDB);
                employeeListGroup.add(empl);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeListGroup;
    }

    @Override
    public List<Product> loadAllProductByStore(long idStore) {
        List<Product> productList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT product.id_product, product.name," +
                    " product.product_type, product.price, product.barcode, product.id_producer, product.id_store," +
                    " product.product_quantity  FROM product JOIN store ON product.id_store = store.id_store " +
                    "  WHERE store.id_store = ?;");
            preparedStatement.setLong(1, idStore);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String name = resultSet.getString(2);
                ProductType productType = ProductType.valueOf(resultSet.getString(3));
                double price = resultSet.getDouble(4);
                String barcode = resultSet.getString(5);
                Long idProducer = resultSet.getLong(6);
                Long idStoreDB = resultSet.getLong(7);
                Long productQuantity = resultSet.getLong(8);

                Product product = new Product(idDB, name, productType, price, barcode, idProducer, idStoreDB, productQuantity);
                productList.add(product);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> loadGorpusProductByStore(long idStore, String prodcutGroups) {
        List<Product> productListGroups = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT product.id_product, product.name," +
                    " product.product_type, product.price, product.barcode, product.id_producer, product.id_store," +
                    " product.product_quantity  FROM product JOIN store ON product.id_store = store.id_store " +
                    "  WHERE store.id_store = ? and product.product_type = ? ;");
            preparedStatement.setLong(1, idStore);
            preparedStatement.setString(2, prodcutGroups.toUpperCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String name = resultSet.getString(2);
                ProductType productType = ProductType.valueOf(resultSet.getString(3));
                double price = resultSet.getDouble(4);
                String barcode = resultSet.getString(5);
                Long idProducer = resultSet.getLong(6);
                Long idStoreDB = resultSet.getLong(7);
                Long productQuantity = resultSet.getLong(8);

                Product product = new Product(idDB, name, productType, price, barcode, idProducer, idStoreDB, productQuantity);
                productListGroups.add(product);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productListGroups;
    }
}
