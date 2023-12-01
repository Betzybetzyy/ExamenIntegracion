/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petsmile.repository;

import com.petsmile.connection.MySqlDbConnection;
import com.petsmile.models.PetEntity;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico_
 */
public class PetRepository implements IPetRepository {
    
    private final static String QUERY_PETS = "SELECT * FROM PET";

    @Override
    public List<PetEntity> getPets() throws SQLException {
        List<PetEntity> pets = new ArrayList<>();

        try (MySqlDbConnection db = MySqlDbConnection.getInstance(); PreparedStatement stmt = db.getConnection().prepareStatement(QUERY_PETS); ResultSet resultSet = stmt.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                PetEntity pet = new PetEntity();
                pet.setRut(resultSet.getString("rut"));
                pet.setTipomascota(resultSet.getString("tipomascota"));
                pet.setEdad(resultSet.getString("edad"));
                pet.setNombremascota(resultSet.getString("nombremascota"));
                
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OwnerRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OwnerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pets;
    }
}
