/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 * Representa una entrada comprada por un cliente para una butaca en una sala.
 */
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;

    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        if (cliente == null || sala == null || butaca == null) {
            throw new NullPointerException("Cliente, sala y butaca no pueden ser nulos.");
        }
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public Butaca getButaca() {
        return butaca;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Entrada:");
        sb.append("\n  Cliente: ").append(cliente.getNombre());
        sb.append("\n  Sala: ").append(sala.getNumero());
        sb.append("\n  Pelicula: ").append(sala.getPelicula());
        sb.append("\n  Fila: ").append(butaca.getFila());
        sb.append("\n  Asiento: ").append(butaca.getNumero());
        return sb.toString();
    }
}
