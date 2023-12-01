/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.petsmile.servlet;

import com.petsmile.models.AgendaEntity;
import com.petsmile.repository.AgendaRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico_
 */
@WebServlet(name = "AgendaServlet", urlPatterns = {"/AgendaServlet"})
public class AgendaServlet extends HttpServlet {

    private AgendaRepository agendaRepository;

    public AgendaServlet() {
        this.agendaRepository = new AgendaRepository();
    }

    public AgendaServlet(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<AgendaEntity> agendas = (List<AgendaEntity>) agendaRepository.getAgendas();
            request.setAttribute("agendas", agendas);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AgendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
