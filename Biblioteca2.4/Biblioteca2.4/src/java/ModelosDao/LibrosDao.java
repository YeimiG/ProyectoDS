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
import Interfaces.CrudLibro;
import Modelos.Libros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LibrosDao implements CrudLibro{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Libros p=new Libros();
    
    @Override
    public List listar() {
        ArrayList<Libros>list=new ArrayList<>();
        String sql="select * from Libro";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Libros per=new Libros();
                per.setID_Libro(rs.getInt("id"));
                per.set_Titulo(rs.getString("Titulo"));
                per.setGenero(rs.getString("Genero"));
                per.setAutor(rs.getString("Autor"));
                per.set_CantidadLibro(rs.getInt("CantidadLibro"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }
    @Override
    public List listarLibrosClientes() {
        ArrayList<Libros>list=new ArrayList<>();
        String sql="select * from Libro";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Libros per=new Libros();
                per.setID_Libro(rs.getInt("id"));
                per.set_Titulo(rs.getString("Titulo"));
                per.setGenero(rs.getString("Genero"));
                per.setAutor(rs.getString("Autor"));
                per.set_CantidadLibro(rs.getInt("CantidadLibro"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Libros list(int id) {
        String sql="select * from Libro where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setID_Libro(rs.getInt("id"));
                p.set_Titulo(rs.getString("Titulo"));
                p.setGenero(rs.getString("Genero"));
                p.setAutor(rs.getString("Autor"));
                p.set_CantidadLibro(rs.getInt("CantidadLibro"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Libros per) {
       String sql="insert into Libro(Titulo, Genero, Autor, CantidadLibro)values('"+per.get_Titulo()+"','"+per.getGenero()+"','"+ per.getAutor()+ "','" + per.get_CantidadLibro()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Libros per) {
        String sql="update Libro set Titulo='"+per.get_Titulo()+"',Genero='"+per.getGenero()+"',Autor='"+per.getAutor()+"',CantidadLibro='"+per.get_CantidadLibro()+"'where id="+per.getID_Libro();
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
        String sql="delete from Libro where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
