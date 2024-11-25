/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDao;

/**
 *
 * @author YEIMI
 */

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
    public List listar() {
        ArrayList<Prestamos>list=new ArrayList<>();
        String sql="select * from Prestamo";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Prestamos per=new Prestamos();
                per.setID_Prestamo(rs.getInt("id"));
                per.set_CantidadPrestada(rs.getString("CantidadPrestada"));
                per.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                per.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                per.setID_Libro(rs.getInt("idLibro"));
                per.setID_Cliente(rs.getInt("idCliente"));
                list.add(per);
            }
        } catch (Exception e) {
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
                p.set_CantidadPrestada(rs.getString("CantidadPrestada"));
                p.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                p.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                p.setID_Libro(rs.getInt("idLibro"));
                p.setID_Cliente(rs.getInt("idCliente"));
            }
        } catch (SQLException e) {
        } finally {
            closeConnection();
        }
        return p;
    }

    @Override
    public boolean add(Prestamos prestamo) {
        String sql = "INSERT INTO Prestamo (CantidadPrestada, fechaPrestamo, fechaDevolucion,idLibro, idCliente) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.get_CantidadPrestada());
            ps.setDate(2, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(3, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            ps.setInt(4, prestamo.getID_Libro());
            ps.setInt(5, prestamo.getID_Cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            closeConnection();
        }
    }

    @Override
    public boolean edit(Prestamos prestamo) {
        String sql = "UPDATE Prestamo SET CantidadPrestada = ?, fechaPrestamo = ?, fechaDevolucion = ?, idLibro = ?, idCliente = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.get_CantidadPrestada());
            ps.setDate(2, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(3, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            ps.setInt(4, prestamo.getID_Libro());
            ps.setInt(5, prestamo.getID_Cliente());
            ps.setInt(6, prestamo.getID_Prestamo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
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
        }
    }


}
