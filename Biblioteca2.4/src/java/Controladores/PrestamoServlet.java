/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Prestamos;
import ModelosDao.PrestamosDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.text.SimpleDateFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

// Servlet anotado
public class PrestamoServlet extends HttpServlet {

    String listar="vistas/prestamos.jsp";
    String addprestamo="vistas/addprestamo.jsp";
    String editprestamo="vistas/editprestamo.jsp";
    String mensaje="vistas/Mensaje.jsp";
    Prestamos p=new Prestamos();
    PrestamosDao dao=new PrestamosDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
    String acceso = "";
    String action = request.getParameter("accion");

    try {
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("addprestamo")) {
            acceso = addprestamo;
        }else if (action.equalsIgnoreCase("mensaje")) {
            acceso = mensaje;
        } else if (action.equalsIgnoreCase("Agregar")) {
            // Captura los parámetros del formulario
            String CantidadPrestada = request.getParameter("txtCantidadPrestada");
            String FechaPrestamo = request.getParameter("txtFechaPrestamo");
            String FechaDevolucion = request.getParameter("txtFechaDevolucion");
            int idLibro = Integer.parseInt(request.getParameter("txtidLibro"));
            int idCliente = Integer.parseInt(request.getParameter("txtidCliente"));

            // Asigna los valores al objeto Prestamos
            p.set_CantidadPrestada(CantidadPrestada);
            p.setFechaPrestamo(sdf.parse(FechaPrestamo)); // Convierte la fecha
            p.setFechaDevolucion(sdf.parse(FechaDevolucion)); // Convierte la fecha
            p.setID_Libro(idLibro);
            p.setID_Cliente(idCliente);

            // Llama al método correcto del DAO
            dao.add(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = editprestamo;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String CantidadPrestada = request.getParameter("txtCantidadPrestada");
            String FechaPrestamo = request.getParameter("txtFechaPrestamo");
            String FechaDevolucion = request.getParameter("txtFechaDevolucion");
            int idLibro = Integer.parseInt(request.getParameter("txtidLibro"));
            int idCliente = Integer.parseInt(request.getParameter("txtidCliente"));

            // Asigna los valores al objeto Prestamos
            p.set_CantidadPrestada(CantidadPrestada);
            p.setFechaPrestamo(sdf.parse(FechaPrestamo));
            p.setFechaDevolucion(sdf.parse(FechaDevolucion));
            p.setID_Libro(idLibro);
            p.setID_Cliente(idCliente);

            // Llama al método correcto del DAO
            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            acceso = listar;
        } else {
            acceso = "vistas/error.jsp";
            request.setAttribute("error", "Acción desconocida: " + action);
        }
    } catch (Exception e) {
        e.printStackTrace();
        acceso = "vistas/error.jsp";
        request.setAttribute("error", "Ocurrió un error: " + e.getMessage());
    }

    // Redirección a la vista correspondiente
    RequestDispatcher vista = request.getRequestDispatcher(acceso);
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
