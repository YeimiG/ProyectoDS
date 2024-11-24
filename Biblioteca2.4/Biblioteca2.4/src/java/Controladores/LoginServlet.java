/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Config.Conexion;


/**
 *
 * @author owen CN
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Dependiendo de la acción, se realiza el registro o inicio de sesión
        if ("registrar".equals(action)) {
            registrarUsuario(request, response);
        } else if ("login".equals(action)) {
            
        }
    }



// Método para registrar un nuevo usuario
private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String usuario = request.getParameter("usuario");
    String clave = request.getParameter("clave");

    // Encriptar la contraseña usando MD5
    String claveEncriptada = encriptarMD5(clave);

    // Verificar la conexión a la base de datos
    try (Connection conn = new Conexion().getConnection()) {
        if (conn == null) {
            response.sendRedirect("error.jsp?error=No se pudo conectar a la base de datos");
            return;
        }

        String query = "INSERT INTO usuarios ( usuario, clave ) VALUES (?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
           
            pstmt.setString(1, usuario);
            pstmt.setString(2, claveEncriptada); // Guardamos la contraseña encriptada
            

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                response.sendRedirect("index.jsp?message=Registro exitoso. Por favor, inicie sesion.");
            } else {
                response.sendRedirect("registrar.jsp?error=Error al registrar el usuario");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendRedirect("error.jsp");
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


}
