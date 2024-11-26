/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Config.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author YEIMI
 */
public class LogServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String accion= request.getParameter("accion");
        if(accion==null){
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }else if(accion.equals("Login")){
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");

        // Dependiendo de la acción, se realiza el registro o inicio de sesión
       if ("login".equals(action)) {
            iniciarSesion(request, response);
        }else if("loginAdmin".equals(action)){
           iniciarSesionAdmin(request, response);
                
    }
    }
    
    // Método para encriptar una cadena con MD5
private String encriptarMD5(String input) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}

    
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
        // Encriptar la contraseña ingresada para compararla con la almacenada
    String claveEncriptada = encriptarMD5(clave);


            
            // Verificar la conexión a la base de datos
                try (Connection conn = new Conexion().getConnection()) {
        if (conn == null) {
            response.sendRedirect("error.jsp?error=No se pudo conectar a la base de datos");
            return;
        }

        String query = "SELECT * FROM usuarios WHERE usuario = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("clave");

                // Comparar contraseñas encriptadas
                if (claveEncriptada.equals(storedPassword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("MenuCliente.jsp");
                } else {
                    response.sendRedirect("InicioSesion.jsp?error=Usuario o clave incorrectos");
                }
            } else {
                response.sendRedirect("InicioSesion.jsp?error=Usuario no encontrado");
            }
        }
    }
     catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    private void iniciarSesionAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
     String usuario= request.getParameter("usuario");
            String clave= request.getParameter("clave");
            
            try (PrintWriter print= response.getWriter()){
                if (usuario.equals("admin") && clave.equals("root")){
                    response.sendRedirect("MenuAdmin.jsp"); 
                } else{
                    print.println("<!DOCTYPE html>");
                    print.println("<html>");
                    print.println("<head>");
                    print.println("<title>Login tienda</title>");
                    print.println("</head>");
                    print.println("<body>");
                    print.println("<h1>¡ERROR! El correo o la contraseña son incorrectos</h1>");
                    print.println("</body>");
                    print.println("</html>");
                }
            }
        }
       /**
     * Nueva funcionalidad para cerrar sesión
     */
    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false); // Obtiene la sesión sin crear una nueva
        if (session != null) {
            session.invalidate(); // Invalida la sesión actual
        }
        response.sendRedirect("index.jsp"); // Redirige al usuario a la página de inicio de sesión
    }
    
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}