/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cineapp4;

import modelo.*;
import persistencia.*;
import vista.*;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class CineApp4 extends Application {

    private Cine sistemaCine;

    @Override
    public void init() {
        // Intentar cargar estado guardado
        try {
            sistemaCine = PersistenciaDatos.cargarEstado();
        } catch (Exception ex) {
            System.err.println("No se pudo cargar el estado del cine: " + ex.getMessage());
            sistemaCine = new Cine();
        }

        // Si no hay salas, agregar algunas por defecto
        if (sistemaCine.getSalas().isEmpty()) {
            sistemaCine.agregarSala(new Sala(1, "F1 la pelicula", 10, 8));
            sistemaCine.agregarSala(new Sala(2, "Jurassic Park", 6, 8));
            sistemaCine.agregarSala(new Sala(3, "Exterminio", 5, 7));
        }
    }

    @Override
    public void start(Stage ventanaPrincipal) {
        // Crear vista de login y mostrarla
        LoginVista login = new LoginVista(ventanaPrincipal, sistemaCine);
        login.mostrarLogin();
    }

    @Override
    public void stop() {
        // Guardar el estado del sistema al cerrar la aplicación
        try {
            PersistenciaDatos.guardarEstado(sistemaCine);
        } catch (Exception ex) {
            System.err.println("Error al guardar estado: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
