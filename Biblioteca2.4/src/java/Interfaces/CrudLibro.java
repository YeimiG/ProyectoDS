/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Libros;
import java.util.List;

/**
 *
 * @author YEIMI
 */
public interface CrudLibro {
    public List listar();
    public List listarLibrosClientes();
    public Libros list(int id);
    public boolean add(Libros per);
    public boolean edit(Libros per);
    public boolean eliminar(int id);
}
