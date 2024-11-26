/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDao;

import Config.Conexion;
import Interfaces.CrudPrestamo;
import Modelos.Prestamos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDao implements CrudPrestamo {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Prestamos> listar() {
        ArrayList<Prestamos> list = new ArrayList<>();
        String sql = "SELECT * FROM Prestamo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Prestamos per = new Prestamos();
                per.setID_Prestamo(rs.getInt("id"));
                per.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                per.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                per.setID_Libro(rs.getInt("idLibro"));
                per.setID_Cliente(rs.getInt("idUsuario"));
                list.add(per);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public Prestamos list(int id) {
        Prestamos p = null;
        String sql = "SELECT * FROM Prestamo WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Prestamos();
                p.setID_Prestamo(rs.getInt("id"));
                p.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                p.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                p.setID_Libro(rs.getInt("idLibro"));
                p.setID_Cliente(rs.getInt("idUsuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return p;
    }

    @Override
    public boolean add(Prestamos prestamo) {
        String sqlInsert = "INSERT INTO Prestamo(fechaPrestamo, fechaDevolucion, idUsuario, idLibro) VALUES (?, ?, ?, ?)";
        String sqlUpdateCantidad = "UPDATE Libro SET cantidadLibro = cantidadLibro - 1 WHERE id = ? AND cantidadLibro > 0"; // Evita cantidad negativa

        try {
            con = cn.getConnection();
            con.setAutoCommit(false); // Inicia transacción

            // Inserta el préstamo
            ps = con.prepareStatement(sqlInsert);
            ps.setDate(1, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(2, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            ps.setInt(3, prestamo.getID_Cliente());
            ps.setInt(4, prestamo.getID_Libro());
            ps.executeUpdate();

            // Actualiza la cantidad del libro
            ps = con.prepareStatement(sqlUpdateCantidad);
            ps.setInt(1, prestamo.getID_Libro());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                con.rollback(); // Revertir si no hay cantidad disponible
                return false;
            }

            con.commit(); // Confirma transacción
            return true;

        } catch (SQLException e) {
            try {
                if (con != null) con.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean edit(Prestamos prestamo) {
        String sql = "UPDATE Prestamo SET fechaPrestamo = ?, fechaDevolucion = ?, idUsuario = ?, idLibro = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(2, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            ps.setInt(3, prestamo.getID_Cliente());
            ps.setInt(4, prestamo.getID_Libro());
            ps.setInt(5, prestamo.getID_Prestamo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Prestamo WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

