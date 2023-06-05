package com.project.L41.repository.buyersRepository;

import com.project.L41.model.buyersModel.Buyer;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class BuyersRepositoryImpl implements BuyersRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L41";
    private static String user = "postgres";
    private static String password = "admin";

    @Override
    public void createBuyer(Buyer buyer) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO buyers(first_name, last_name, address, phone_number) VALUES (?,?,?,?);");
            preparedStatement.setString(1, buyer.getFirstName());
            preparedStatement.setString(2, buyer.getLastName());
            preparedStatement.setString(3, buyer.getAddress());
            preparedStatement.setString(4, buyer.getPhoneNumber());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Buyer> loadAllBuyers() {
        List<Buyer> buyerList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM buyers;");
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String phoneNumber = resultSet.getString(5);
                Buyer buyer = new Buyer(id, firstName, lastName, address, phoneNumber);
                buyerList.add(buyer);

            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerList;
    }

    @Override
    public Buyer findBuyerByID(long id) {

        Buyer buyer = null;

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM buyers WHERE id = ?;");
            preparedStatement.setLong(1,id);

            ResultSet resultSet =  preparedStatement.executeQuery();

            while (resultSet.next()){
                Long idDB = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String phoneNumber = resultSet.getString(5);
                buyer = new Buyer(idDB, firstName, lastName, address, phoneNumber);


            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyer;
    }

    @Override
    public List<Buyer> findBuyerByName(String name) {

        List<Buyer> buyerList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM buyers WHERE first_name = ?;");
            preparedStatement.setString(1,name);

            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String phoneNumber = resultSet.getString(5);
                Buyer buyer = new Buyer(id, firstName, lastName, address, phoneNumber);
                buyerList.add(buyer);

            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyerList;

    }

    @Override
    public void deleteBuyerByID(long id) {

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("DELETE FROM buyers WHERE id = ?;");
            preparedStatement.setLong(1,id);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateBuyer(Buyer buyer) {

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE buyers SET first_name = ?, last_name = ?, address = ?, phone_number = ? WHERE id = ?;");

            preparedStatement.setString(1, buyer.getFirstName());
            preparedStatement.setString(2, buyer.getLastName());
            preparedStatement.setString(3, buyer.getAddress());
            preparedStatement.setString(4, buyer.getPhoneNumber());
            preparedStatement.setLong(5,buyer.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
