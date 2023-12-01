/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.petsmile.repository;

import com.petsmile.models.UserEntity;
import java.sql.SQLException;

/**
 *
 * @author nico_
 */
public interface IUserRepository {

    UserEntity getByLogin(final String username, final String password) throws SQLException;
}
