/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Clientes;
import ModelosDao.ClienteDao;
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
public class ClienteServlet extends HttpServlet {

    String listarCliente="vistas/listarCliente.jsp";
    String addCliente="vistas/DatosClientes.jsp";
    String editlibro="vistas/editCliente.jsp";
    String listarLibrosClientes="vistas/listarLibrosCliente.jsp";
    
    Clientes p=new Clientes();
    ClienteDao dao=new ClienteDao();
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
            acceso=listarCliente;          
        }else if(action.equalsIgnoreCase("addClientes")){
            acceso=addCliente;
        }
       
       
        else if(action.equalsIgnoreCase("Agregar")){
            String Nombre=request.getParameter("txtNombre");
            String Direccion=request.getParameter("txtDireccion");
            String Telefono=request.getParameter("txtTelefono");
            String Correo=request.getParameter("txtCorreo");
            int IdLibro=Integer.parseInt(request.getParameter("txtidLibro"));
            int IdUsuario=Integer.parseInt(request.getParameter("txtidUsuario"));
            p.set_Nombre(Nombre);
            p.setDireccion(Direccion);
             p.setTelefono(Telefono);
            p.setCorreo(Correo);
            p.setID_Libro(IdLibro);
            p.setID_Usuario(IdUsuario);
            dao.add(p);
            acceso=listarLibrosClientes;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=editlibro;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
           String Nombre=request.getParameter("txtNombre");
            String Direccion=request.getParameter("txtDireccion");
            String Telefono=request.getParameter("txtTelefono");
            String Correo=request.getParameter("txtCorreo");
            int IdLibro=Integer.parseInt(request.getParameter("txtidLibro"));
            int IdUsuario=Integer.parseInt(request.getParameter("txtidUsuario"));
            p.set_Nombre(Nombre);
            p.setDireccion(Direccion);
             p.setTelefono(Telefono);
            p.setCorreo(Correo);
            p.setID_Libro(IdLibro);
            p.setID_Usuario(IdUsuario);
            dao.add(p);
            acceso=listarCliente;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setID_Libro(id);
            dao.eliminar(id);
            acceso=listarCliente;
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
