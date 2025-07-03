/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javafx.stage.Stage;
import modelo.*;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import controladores.CompraControlador;
/**
 *
 * @author PC
 */
public class SalaVista {
    private Stage stage;
    private Cine cine;
    private Cliente cliente;
    private CompraControlador compraControlador;

    public SalaVista(Stage stage, Cine cine, Cliente cliente) {
        this.stage = stage;
        this.cine = cine;
        this.cliente = cliente;
        this.compraControlador = new CompraControlador(cine);
    }

    public void mostrar() {
        VBox contenedor = new VBox(10);
        contenedor.setPadding(new Insets(20));

        Label titulo = new Label("Selecciona una sala");
        ComboBox<Sala> selectorSalas = new ComboBox<>();
        selectorSalas.getItems().addAll(cine.getSalas());

        GridPane grillaButacas = new GridPane();
        Label mensaje = new Label();

        selectorSalas.setOnAction(e -> {
            Sala sala = selectorSalas.getValue();
            grillaButacas.getChildren().clear();

            if (sala != null) {
                Butaca[][] butacas = sala.getButacas();

                for (int i = 0; i < butacas.length; i++) {
                    for (int j = 0; j < butacas[0].length; j++) {
                        Butaca b = butacas[i][j];
                        Button boton = new Button(b.isEstado() ? "X" : "O");
                        boton.setDisable(b.isEstado());

                        int fila = i;
                        int columna = j;

                        boton.setOnAction(ev -> {
                            boolean ok = compraControlador.comprar(cliente, sala, fila, columna);
                            if (ok) {
                                Entrada entrada = new Entrada(cliente, sala, sala.getButaca(fila, columna));
                                ConfirmacionVista vistaConfirmacion = new ConfirmacionVista(stage, entrada);
                                vistaConfirmacion.mostrar();
                            }
                        });

                        grillaButacas.add(boton, j, i);
                    }
                }
            }
        });

        contenedor.getChildren().addAll(titulo, selectorSalas, grillaButacas, mensaje);
        stage.setTitle("Salas - Cine");
        stage.setScene(new Scene(contenedor, 400, 400));
        stage.show();
    }
}
