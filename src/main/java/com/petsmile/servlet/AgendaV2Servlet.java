/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.petsmile.servlet;

import com.petsmile.repository.AgendaRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico_
 */
@WebServlet(name = "AgendaV2Servlet", urlPatterns = {"/AgendaV2Servlet"})
public class AgendaV2Servlet extends HttpServlet {

    private AgendaRepository agendaRepository;

    public AgendaV2Servlet() {
        this.agendaRepository = new AgendaRepository();
    }

    public AgendaV2Servlet(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mascota = request.getParameter("mascota");
        String rut = request.getParameter("rut");
        String nombremascota = request.getParameter("nombremascota");
        String hora = request.getParameter("hora");
        String fecha = request.getParameter("fecha");

        try {
            agendaRepository.postAgenda(mascota, rut, nombremascota, hora, fecha);
            response.sendRedirect("home.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error al crear la cita", e);
        }
    }
}
