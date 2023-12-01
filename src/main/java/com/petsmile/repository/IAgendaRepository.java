/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petsmile.repository;

import com.petsmile.models.AgendaEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author betzy
 */
public interface IAgendaRepository {

    List<AgendaEntity> getAgendas() throws SQLException;

    void postAgenda(
            final String mascota,
            final String rut,
            final String nombremascota,
            final String hora,
            final String fecha
    ) throws SQLException;

}
