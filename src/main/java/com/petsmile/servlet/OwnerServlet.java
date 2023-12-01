/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.petsmile.servlet;

import com.google.gson.Gson;
import com.petsmile.models.OwnerEntity;
import com.petsmile.repository.OwnerRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author betzy
 */
@WebServlet(name = "OwnerServlet", urlPatterns = {"/OwnerServlet"})
public class OwnerServlet extends HttpServlet {

    private OwnerRepository ownerRepository;

    public OwnerServlet() {
        this.ownerRepository = new OwnerRepository();
    }

    public OwnerServlet(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            List<OwnerEntity> owners = ownerRepository.getOwners();
            String jsonResponse = new Gson().toJson(owners);
            response.getWriter().write(jsonResponse);
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Error al obtener dueños\"}");
            e.printStackTrace();
        }
    }

}
