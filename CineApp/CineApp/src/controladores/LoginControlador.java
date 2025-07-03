/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelo.Cine;
import modelo.Cliente;

/**
 *
 * @author PC
 */
public class LoginControlador {

    private Cine cine;

    public LoginControlador(Cine cine) {
        this.cine = cine;
    }

    public Cliente login(String email, String contraseña) {
        return cine.login(email, contraseña);
    }

    public boolean registrar(String nombre, String email, String contraseña) {
        if (nombre == null || nombre.trim().isEmpty() || email == null || email.trim().isEmpty() || contraseña == null || contraseña.trim().isEmpty()) {
            return false;
        }
        Cliente nuevoCliente = new Cliente(nombre, email, contraseña);
        if (!cine.getClientes().contains(nuevoCliente)) {
            cine.registrarCliente(nuevoCliente);
            return true;
        }
        return false;
    }
}
