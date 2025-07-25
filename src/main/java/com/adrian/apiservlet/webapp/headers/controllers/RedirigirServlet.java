package com.adrian.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirigir")
public class RedirigirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Primera forma
        //        resp.setHeader("Location",req.getContextPath()+"/productos.html");
        //        resp.setStatus(HttpServletResponse.SC_FOUND);
        //Redirigimos esta es la segunda forma
        resp.sendRedirect(req.getContextPath()+"/productos.html");

    }
}
