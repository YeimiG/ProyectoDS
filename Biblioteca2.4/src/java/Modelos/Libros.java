/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author YEIMI
 */
public class Libros {

    private int idLibro;
    private String Titulo;
    private String Genero;
    private String Autor;
    private int CantidadLibro;
    
    /**
     * @return the ID_Empleado
     */
    public int getID_Libro() {
        return idLibro;
    }

    /**
     * @param ID_Libro
     */
    public void setID_Libro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the DUI_Empleado
     */
    public String get_Titulo() {
        return Titulo;
    }

    /**
     * @param Titulo
     * @param
     */
    public void set_Titulo(String Titulo) {
        this.Titulo = Titulo;
    }

    /**
     * @return the nombresEmpleado
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the apellidosEmpleado
     */
    public String getAutor() {
        return Autor;
    }

    /**
     * @param Autor
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    /**
     * 
     * @return 
     */
    public int get_CantidadLibro() {
        return CantidadLibro;
    }

    /**
     * @param CantidadLibro
     */
    public void set_CantidadLibro(int CantidadLibro) {
        this.CantidadLibro = CantidadLibro;
    }

}
