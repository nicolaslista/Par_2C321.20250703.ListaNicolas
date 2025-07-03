/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.*;

/**
 *
 * @author PC
 */
public class CompraControlador {
    private Cine cine;

    public CompraControlador(Cine cine) {
        this.cine = cine;
    }

    public boolean comprar(Cliente cliente, Sala sala, int fila, int columna) {
        return cine.comprarEntrada(cliente, sala, fila, columna);
    }
}
