/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Prestamos;
import java.util.List;

/**
 *
 * @author YEIMI
 */
public interface CrudPrestamo {
   public List listar();
    public Prestamos list(int id);
    public boolean add(Prestamos per);
    public boolean edit(Prestamos per);
    public boolean eliminar(int id); 
}
