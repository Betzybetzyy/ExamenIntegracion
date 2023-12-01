/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.petsmile.servlet;

import com.google.gson.Gson;
import com.petsmile.models.PetEntity;
import com.petsmile.repository.PetRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico_
 */
@WebServlet(name = "PetServlet", urlPatterns = {"/PetServlet"})
public class PetServlet extends HttpServlet {

   private PetRepository petRepository;

    public PetServlet() {
        this.petRepository = new PetRepository();
    }

    public PetServlet(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            List<PetEntity> pets = petRepository.getPets();
            String jsonResponse = new Gson().toJson(pets);
            System.out.println("JSON  ----- * --- " + jsonResponse);
            response.getWriter().write(jsonResponse);
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Error al obtener dueños\"}");
            e.printStackTrace();
        }
    }
}
