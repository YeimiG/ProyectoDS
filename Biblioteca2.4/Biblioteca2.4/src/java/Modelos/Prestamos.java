/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author YEIMI
 */
public class Prestamos {
     private int idPrestamo;
    private String CantidadPrestada;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private int idCliente;
    private int idLibro;
    private int idUsuario;
    
    /**
     * @return the ID_Empleado
     */
    public int getID_Prestamo() {
        return idPrestamo;
    }

    /**bro
     * @param idPrestamo
     */
    public void setID_Prestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return the DUI_Empleado
     */
    public String get_CantidadPrestada() {
        return CantidadPrestada;
    }

    /**
     * @param CantidadPrestada
     * 
     */
    public void set_CantidadPrestada(String CantidadPrestada) {
        this.CantidadPrestada= CantidadPrestada;
    }

    /**
     * @return the nombresEmpleado
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * 
     * @param fechaPrestamo
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo= fechaPrestamo;
    }
   
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * 
     * @param fechaDevolucion
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion= fechaDevolucion;
    }
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
