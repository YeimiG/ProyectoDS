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
import java.sql.Date;

public class PrestamoServlet extends HttpServlet {

    String listar = "vistas/prestamos.jsp";
    String listarClientes = "vistas/prestamoCliente.jsp";
    String addprestamo = "vistas/addprestamo.jsp";
    String editprestamo = "vistas/editprestamo.jsp";
    String mensaje = "vistas/Mensaje.jsp";
    String listarLibrosClientes = "vistas/listarLibrosCliente.jsp";
    String ReportePrestamo="vistas/ReportePrestamo.jsp";
    String botones="vistas/botones.jsp";
    Prestamos p = new Prestamos();
    PrestamosDao dao = new PrestamosDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            } else if (action.equalsIgnoreCase("mensaje")) {
                acceso = mensaje;
            } else if (action.equalsIgnoreCase("listarLibrosClientes")) {
                acceso = listarLibrosClientes;
            }else if(action.equalsIgnoreCase("ReportePrestamo")){
            acceso=ReportePrestamo;
            }else if(action.equalsIgnoreCase("botones")){
            acceso=botones;
            
            }
            else if (action.equalsIgnoreCase("listarPrestamos")) {
                acceso = listarClientes;
            } else if (action.equalsIgnoreCase("editar")) {
                request.setAttribute("idper", request.getParameter("id"));
                acceso = editprestamo;
            } else if (action.equalsIgnoreCase("Actualizar")) {
                id = Integer.parseInt(request.getParameter("txtid"));
                String FechaPrestamo = request.getParameter("txtFechaPrestamo");
                String FechaDevolucion = request.getParameter("txtFechaDevolucion");
                int idLibro = Integer.parseInt(request.getParameter("txtidLibro"));
                int idCliente = Integer.parseInt(request.getParameter("txtidUsuario"));

                // Asigna los valores al objeto Prestamos
                p.setID_Prestamo(id);
                p.setFechaPrestamo(sdf.parse(FechaPrestamo));
                p.setFechaDevolucion(sdf.parse(FechaDevolucion));
                p.setID_Libro(idLibro);
                p.setID_Cliente(idCliente);

                // Llama al método correcto del DAO
                if (dao.edit(p)) {
                    acceso = listar;
                } else {
                    acceso = "vistas/error.jsp";
                    request.setAttribute("error", "No se pudo actualizar el préstamo. Verifica los datos.");
                }
            } else if (action.equalsIgnoreCase("eliminar")) {
                id = Integer.parseInt(request.getParameter("id"));
                if (dao.eliminar(id)) {
                    acceso = listar;
                } else {
                    acceso = "vistas/error.jsp";
                    request.setAttribute("error", "No se pudo eliminar el préstamo con ID: " + id);
                }
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
        String accion = request.getParameter("accion");

        if ("Agregar".equalsIgnoreCase(accion)) {
            // Obtén los parámetros del formulario
            Date fechaPrestamo = Date.valueOf(request.getParameter("fechaPrestamo"));
            Date fechaDevolucion = Date.valueOf(request.getParameter("fechaDevolucion"));
            int idLibro = Integer.parseInt(request.getParameter("ID_Libro"));
            int idCliente = Integer.parseInt(request.getParameter("ID_Cliente"));

            // Crea el objeto Prestamo y llama al método add de tu DAO
            Prestamos prestamo = new Prestamos();
            prestamo.setFechaPrestamo(fechaPrestamo);
            prestamo.setFechaDevolucion(fechaDevolucion);
            prestamo.setID_Libro(idLibro);
            prestamo.setID_Cliente(idCliente);

            PrestamosDao prestamosDao = new PrestamosDao();
            boolean exito = prestamosDao.add(prestamo);

            if (exito) {
                response.sendRedirect("PrestamoServlet?accion=listarLibrosClientes");
            } else {
                response.getWriter().println("Error al agregar el préstamo.");
            }
        } else {
            processRequest(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

