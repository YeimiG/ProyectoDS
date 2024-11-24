/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDao;


import Config.Conexion;
import Interfaces.CrudCliente;
import Modelos.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements CrudCliente {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Clientes p = new Clientes();

    @Override
    public List listar() {
        ArrayList<Clientes> list = new ArrayList<>();
        String sql = "select * from Cliente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes per = new Clientes();
                per.setID_Cliente(rs.getInt("id"));
                per.set_Nombre(rs.getString("nombre"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreo(rs.getString("correo"));
                per.setID_Libro(rs.getInt("idLibro"));
                per.setID_Usuario(rs.getInt("idUsuario"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }


    @Override
    public Clientes list(int id) {
        String sql = "select * from Cliente where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setID_Cliente(rs.getInt("id"));
                p.set_Nombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                p.setID_Libro(rs.getInt("idLibro"));
                p.setID_Usuario(rs.getInt("idUsuario"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Clientes per) {
        String sql = "insert into Cliente(nombre, direccion, telefono, correo, idLibro, idUsuario) values('" + per.get_Nombre() + "','" + per.getDireccion() + "','" + per.getTelefono() + "','" + per.getCorreo() + "','" +per.getID_Libro() + "','"+ per.getID_Usuario()+ "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Clientes per) {
        String sql = "update Cliente set nombre='" + per.get_Nombre() + "',direccion='" + per.getDireccion() + "',telefono='" + per.getTelefono() + "',correo='" + per.getCorreo() + "',idLibro= '"+ per.getID_Libro() + "', idUsuario= '"+ per.getID_Usuario()+ "' where id=" + per.getID_Cliente();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from Cliente where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}


