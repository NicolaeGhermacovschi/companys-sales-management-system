package com.project.L41.repository.salesRepository;

import com.project.L41.model.salesModel.Sales;
import com.project.L41.model.salesModel.SalesStatus;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalesRepositoryImpl implements SalesRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L41";
    private static String user = "postgres";
    private static String password = "admin";

    @Override
    public void addSales(Sales sales) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO sales (id_buyer, id_product, " +
                    " id_store, sales_status)  VALUES (?, ?, ?, ?);");

            preparedStatement.setLong(1, sales.getIdBuyer());
            preparedStatement.setLong(2, sales.getIdProduct());
            preparedStatement.setLong(3, sales.getIdStore());
            preparedStatement.setString(4, String.valueOf(sales.getSalesStatus()));

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Sales> loadAllSales() {
        List<Sales> salesList = null;

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM sales");
            ResultSet resultSet = preparedStatement.executeQuery();

            salesList = new ArrayList<>();

            while (resultSet.next()) {
                long idSales = resultSet.getLong(1);
                long idBuyer = resultSet.getLong(2);
                long idProduct = resultSet.getLong(3);
                long idStore = resultSet.getLong(4);
                SalesStatus salesSatauts = SalesStatus.valueOf(resultSet.getString(5));

                Sales sales = new Sales(idSales, idBuyer, idProduct, idStore, salesSatauts);
                salesList.add(sales);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {

        }

        return salesList;
    }

    @Override
    public Sales findSaleById(long idSale) {
        Sales sales = null;

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM sales WHERE  id_sale = ?;");
            preparedStatement.setLong(1, idSale);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long idSales = resultSet.getLong(1);
                long idBuyer = resultSet.getLong(2);
                long idProduct = resultSet.getLong(3);
                long idStore = resultSet.getLong(4);
                SalesStatus saleSatauts = SalesStatus.valueOf(resultSet.getString(5));

                sales = new Sales(idSales, idBuyer, idProduct, idStore, saleSatauts);

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {

        }
        return sales;
    }

    @Override
    public void deleteSaleByID(long idSale) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM sales WHERE id_sale = ?;");
            preparedStatement.setLong(1, idSale);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {

        }

    }

    @Override
    public StringBuilder showSatutsSale(long idSale) {
        StringBuilder command = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT buyers.first_name, buyers.last_name, buyers.address, buyers.phone_number, product.name, " +
                            "product.product_type, product.price, product.barcode, store.name, store.address, " +
                            "sales.sales_status FROM sales JOIN buyers ON sales.id_buyer = buyers.id " +
                            "JOIN product ON sales.id_product = product.id_product " +
                            "JOIN store ON sales.id_store = store.id_store WHERE sales.id_sale = ? ;");

            preparedStatement.setLong(1, idSale);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String productName = resultSet.getString("name");
                String productType = resultSet.getString("product_type");
                double price = resultSet.getDouble("price");
                String barcode = resultSet.getString("barcode");
                String storeName = resultSet.getString("name");
                String storeAddress = resultSet.getString("address");
                String salesStatus = resultSet.getString("sales_status");

                // Adăugarea datelor în StringBuilder
                command.append("First Name: ").append(firstName).append("\n");
                command.append("Last Name: ").append(lastName).append("\n");
                command.append("Address: ").append(address).append("\n");
                command.append("Phone Number: ").append(phoneNumber).append("\n");
                command.append("Product Name: ").append(productName).append("\n");
                command.append("Product Type: ").append(productType).append("\n");
                command.append("Price: ").append(price).append("\n");
                command.append("Barcode: ").append(barcode).append("\n");
                command.append("Store Name: ").append(storeName).append("\n");
                command.append("Store Address: ").append(storeAddress).append("\n");
                command.append("Sales Status: ").append(salesStatus).append("\n");
                command.append("\n");
            }
            System.out.println(command.toString());
        } catch (SQLException e) {

        }

        return command;

    }

    @Override
    public void updateSatusSale(Sales sales) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sales " +
                    "SET id_buyer = ?, id_product = ?, id_store = ?, sales_status = ? " +
                    "WHERE id_sale = ?; ");
            preparedStatement.setLong(1, sales.getIdBuyer());
            preparedStatement.setLong(2, sales.getIdProduct());
            preparedStatement.setLong(3, sales.getIdStore());
            preparedStatement.setString(4, String.valueOf(sales.getSalesStatus()));
            preparedStatement.setLong(5, sales.getIdSale());

            preparedStatement.executeQuery();


            preparedStatement.close();
        } catch (SQLException e) {

        }

    }
}
