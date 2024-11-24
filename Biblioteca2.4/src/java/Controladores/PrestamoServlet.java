/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Prestamos;
import ModelosDao.PrestamosDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet anotado
@WebServlet(name = "PrestamoServlet", urlPatterns = {"/PrestamoServlet"})
public class PrestamoServlet extends HttpServlet {

    PrestamosDao dao = new PrestamosDao();
    Prestamos prestamo = new Prestamos();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion != null ? accion : "listar") {
            case "listar":
                List<Prestamos> lista = dao.listar();
                request.setAttribute("prestamos", lista);
                request.getRequestDispatcher("vistas/prestamos.jsp").forward(request, response);
                break;
            case "mensaje":
               int idLibro = Integer.parseInt(request.getParameter("id")); // Capturar el ID del libro
               request.setAttribute("idLibro", idLibro); // Enviar el ID del libro al formulario
               request.getRequestDispatcher("vistas/Mensaje.jsp").forward(request, response); // Redirigir al formulario
                break;

            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Prestamos prestamo = dao.list(id);
                request.setAttribute("prestamo", prestamo);
                request.getRequestDispatcher("editarPrestamo.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("Prestamos?accion=listar");
                break;

            default:
                response.sendRedirect("Prestamos?accion=listar");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion != null ? accion : "listar") {
            case "guardar":
                try {
                    String cantidadPrestada = request.getParameter("cantidadPrestada");
                    String fechaPrestamoStr = request.getParameter("fechaPrestamo");
                    String fechaDevolucionStr = request.getParameter("fechaDevolucion");

                    prestamo.set_CantidadPrestada(cantidadPrestada);
                    prestamo.setFechaPrestamo(sdf.parse(fechaPrestamoStr));
                    prestamo.setFechaDevolucion(sdf.parse(fechaDevolucionStr));

                    dao.add(prestamo);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("Prestamos?accion=listar");
                break;

            case "actualizar":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String cantidadPrestada = request.getParameter("cantidadPrestada");
                    String fechaPrestamoStr = request.getParameter("fechaPrestamo");
                    String fechaDevolucionStr = request.getParameter("fechaDevolucion");

                    prestamo.setID_Prestamo(id);
                    prestamo.set_CantidadPrestada(cantidadPrestada);
                    prestamo.setFechaPrestamo(sdf.parse(fechaPrestamoStr));
                    prestamo.setFechaDevolucion(sdf.parse(fechaDevolucionStr));

                    dao.edit(prestamo);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("Prestamos?accion=listar");
                break;

            default:
                response.sendRedirect("Prestamos?accion=listar");
                break;
        }
    }
}

