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
import java.util.ArrayList;
import java.util.List;


public class PrestamosDao implements CrudPrestamo{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Prestamos p=new Prestamos();
    
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
                per.setID_Cliente(rs.getInt("idCliente"));
                per.setID_Libro(rs.getInt("idLibro"));
                per.setID_Usuario(rs.getInt("idUsuario"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }


    @Override
    public Prestamos list(int id) {
        String sql="select * from Prestamo where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setID_Prestamo(rs.getInt("id"));
                p.set_CantidadPrestada(rs.getString("CantidadPrestada"));
                p.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                p.setFechaDevolucion(rs.getDate("fechaDevolucion"));
               
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Prestamos per) {
       String sql="insert into Prestamo(CantidadPrestada, fechaPrestamo, fechaDevolucion)values('"+per.get_CantidadPrestada()+"','"+per.getFechaPrestamo()+"','"+ per.getFechaDevolucion()+ "')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Prestamos per) {
        String sql="update Prestamo set CantidadPrestada='"+per.get_CantidadPrestada()+"',fechaPrestamo='"+per.getFechaDevolucion()+"',fechaDevolucion='"+per.getFechaDevolucion()+"'where id="+per.getID_Prestamo();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from Prestamo where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public List listareppersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}