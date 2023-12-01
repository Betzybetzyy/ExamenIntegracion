/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petsmile.repository;

import com.petsmile.connection.MySqlDbConnection;
import com.petsmile.models.OwnerEntity;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author betzy
 */
public class OwnerRepository implements IOwnerRepository {

    private final static String QUERY_OWNERS = "SELECT * FROM OWNER";

    @Override
    public List<OwnerEntity> getOwners() throws SQLException {
        List<OwnerEntity> owners = new ArrayList<>();

        try (MySqlDbConnection db = MySqlDbConnection.getInstance(); PreparedStatement stmt = db.getConnection().prepareStatement(QUERY_OWNERS); ResultSet resultSet = stmt.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                OwnerEntity owner = new OwnerEntity();
                owner.setRut(resultSet.getString("rut"));
                owner.setName(resultSet.getString("name"));
                owner.setLastname(resultSet.getString("lastname"));
                owner.setAddress(resultSet.getString("address"));
                owner.setEmail(resultSet.getString("email"));
                owner.setPhone(resultSet.getString("phone"));
                owner.setPetname(resultSet.getString("petname"));
                owners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OwnerRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OwnerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owners;
    }
}
