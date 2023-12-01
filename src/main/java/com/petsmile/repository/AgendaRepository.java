/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petsmile.repository;

import com.petsmile.connection.MySqlDbConnection;
import com.petsmile.models.AgendaEntity;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author betzy
 */
public class AgendaRepository implements IAgendaRepository {

    private final static String QUERY_AGENDA = "SELECT * FROM AGENDA";
    private final static String INSERT_AGENDA = "INSERT INTO agenda (mascota, rut, nombremascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<AgendaEntity> getAgendas() throws SQLException {
        List<AgendaEntity> agendas = new ArrayList<>();

        try (MySqlDbConnection db = MySqlDbConnection.getInstance(); PreparedStatement stmt = db.getConnection().prepareStatement(QUERY_AGENDA); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                AgendaEntity agenda = new AgendaEntity();
                agenda.setId(resultSet.getString("id"));
                agenda.setMascota(resultSet.getString("mascota"));
                agenda.setRut(resultSet.getString("rut"));
                agenda.setNombreMascota(resultSet.getString("nombremascota"));
                agenda.setHora(resultSet.getString("hora"));
                agenda.setFecha(resultSet.getString("fecha"));
                agendas.add(agenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(AgendaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agendas;
    }

    @Override
    public void postAgenda(final String mascota, final String rut, final String nombremascota, final String hora, final String fecha) throws SQLException {
        try (MySqlDbConnection db = MySqlDbConnection.getInstance()) {
            try (PreparedStatement stmt = db.getConnection().prepareStatement(INSERT_AGENDA)) {
                stmt.setString(1, mascota);
                stmt.setString(2, rut);
                stmt.setString(3, nombremascota);
                stmt.setString(4, hora);
                stmt.setString(5, fecha);
                stmt.executeUpdate();
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(AgendaRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error accessing the database", ex);
        }
    }

}
