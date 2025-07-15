package com.adrian.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String metodoHttp = req.getMethod(); // Obtiene el método con el que recibimos la petición: POST, GET, etc.
        String requestUri = req.getRequestURI(); // Ruta del recurso solicitado dentro del servidor. /product/motors
        String requestUrl = req.getRequestURL().toString(); // URL completa usada por el cliente. https://servidor/product/motors
        String contextPath = req.getContextPath(); // Nombre con el que se desplegó la app en el servidor.
        String servletPath = req.getServletPath(); // Ruta del servlet que procesa la petición.
        String ipCliente= req.getRemoteAddr(); // Recuperamos la ip del cliente
        String ip=req.getLocalAddr();
        int port=req.getLocalPort();
        String scheme=req.getScheme();
        String host= req.getHeader("host");
        String url=scheme+"://"+host+contextPath+servletPath;
        String url2=scheme+"://"+ip+":"+port+contextPath+servletPath;

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println("     <meta charset=\"UTF-8\">");
            out.println("     <title>Cabeceras HTTP Request</title>");
            out.println(" <body>");
            out.println(" <ul>");
            out.println(" <li> metodo http: "+metodoHttp+"</li>");
            out.println(" <li> request uri: "+requestUri+"</li>");
            out.println(" <li> request url: "+requestUrl+"</li>");
            out.println(" <li> context path: "+contextPath+"</li>");
            out.println(" <li> servlet path: "+servletPath+"</li>");
            out.println(" <li> ip local: "+ip+"</li>");//Va mostrar la ipV6 o ipV4 segun el navegador
            out.println(" <li> ip cliente: "+ipCliente+"</li>");
            out.println(" <li> puerto local: "+port+"</li>");
            out.println(" <li> scheme: "+scheme+"</li>");
            out.println(" <li> host: "+host+"</li>");
            out.println(" <li> url: "+url+"</li>");
            out.println(" <li> url2: "+url2+"</li>");

            Enumeration<String> headerNames=req.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String cabecera=headerNames.nextElement();
                out.println("<li>"+cabecera+": "+req.getHeader(cabecera)+"</li>");
            }
            out.println(" </ul>");
            out.println(" </body>");
            out.println(" </head>");
            out.println("</html>");
        }
    }
}
