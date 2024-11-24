/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author YEIMI
 */
public class Clientes {
     private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private int idLibro;
    private int idUsuario;
    
    /**
     * @return the ID_Empleado
     */
    public int getID_Cliente() {
        return idCliente;
    }

    /**bro
     * @param idCliente
     */
    public void setID_Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the DUI_Empleado
     */
    public String get_Nombre() {
        return nombre;
    }

    /**
     * @param nombre
     * 
     */
    public void set_Nombre(String nombre) {
        this.nombre= nombre;
    }

    /**
     * @return the nombresEmpleado
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion= direccion;
    }
   
    public String getTelefono() {
        return telefono;
    }

    /**
     * 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono= telefono;
    }
    public String getCorreo() {
        return correo;
    }

    /**
     * 
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo= correo;
    }
    /**
     * @return the ID_Empleado
     */
    public int getID_Libro() {
        return idLibro;
    }

    /**bro
     * @param idLibro
     */
    public void setID_Libro(int idLibro) {
        this.idLibro = idLibro;
    }
    /**
     * @return the ID_Empleado
     */
    public int getID_Usuario() {
        return idUsuario;
    }

    /**bro
     * @param idUsuario
     */
    public void setID_Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}