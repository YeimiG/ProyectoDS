/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Clientes;
import java.util.List;

/**
 *
 * @author YEIMI
 */
public interface CrudCliente {
    public List listar();
    public Clientes list(int id);
    public boolean add(Clientes per);
    public boolean edit(Clientes per);
    public boolean eliminar(int id);   
}
