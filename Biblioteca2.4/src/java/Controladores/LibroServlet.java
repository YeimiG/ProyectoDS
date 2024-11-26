/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Libros;
import ModelosDao.LibrosDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author YEIMI
 */
public class LibroServlet extends HttpServlet {

    String listar="vistas/listar.jsp";
    String listarlibrocliente = "vistas/listarLibrosCliente.jsp";
    String addlibro="vistas/addlibro.jsp";
    String editlibro="vistas/editlibro.jsp";
    String Reportes="vistas/Reportes.jsp";
    String botones="vistas/botones.jsp";
    String inicioAdmin="vistas/MenuAdmin.jsp";
    Libros p=new Libros();
    LibrosDao dao=new LibrosDao();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;          
        }else if(action.equalsIgnoreCase("listarLibroClientes")){
            acceso=listarlibrocliente;
        }else if(action.equalsIgnoreCase("addlibro")){
            acceso=addlibro;
        }else if(action.equalsIgnoreCase("Reportes")){
            acceso=Reportes;
            
        }else if(action.equalsIgnoreCase("botones")){
            acceso=botones;
            
        }
          if(action.equalsIgnoreCase("inicioAdmin")){
            acceso=inicioAdmin;          
        }
          
        else if(action.equalsIgnoreCase("Agregar")){
            String Titulo=request.getParameter("txtTitulo");
            String Genero=request.getParameter("txtGenero");
            String Autor=request.getParameter("txtAutor");
            int CantidadLibro=Integer.parseInt(request.getParameter("txtCantidadLibro"));
            p.set_Titulo(Titulo);
            p.setGenero(Genero);
             p.setAutor(Autor);
            p.set_CantidadLibro(CantidadLibro);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=editlibro;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String Titulo=request.getParameter("txtTitulo");
            String Genero=request.getParameter("txtGenero");
            String Autor=request.getParameter("txtAutor");
            int CantidadLibro=Integer.parseInt(request.getParameter("txtCantidadLibro"));
             p.set_Titulo(Titulo);
            p.setGenero(Genero);
             p.setAutor(Autor);
            p.set_CantidadLibro(CantidadLibro);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setID_Libro(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


   
}