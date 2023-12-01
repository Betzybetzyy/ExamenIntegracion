/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petsmile.repository;

import com.petsmile.models.PetEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nico_
 */
public interface IPetRepository {
    List<PetEntity> getPets() throws SQLException;
}
