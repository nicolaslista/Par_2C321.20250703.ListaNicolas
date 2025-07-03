/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import modelo.Entrada;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class ConfirmacionVista {
    private Stage stage;
    private Entrada entrada;

    public ConfirmacionVista(Stage stage, Entrada entrada) {
        this.stage = stage;
        this.entrada = entrada;
    }

    public void mostrar() {
        VBox contenedor = new VBox(20);
        contenedor.setPadding(new Insets(20));

        Label titulo = new Label("Compra confirmada");
        Label cliente = new Label("Cliente: " + entrada.getCliente().getNombre());
        Label sala = new Label("Sala: " + entrada.getSala().getNumero());
        Label pelicula = new Label("Película: " + entrada.getSala().getPelicula());
        Label butaca = new Label("Butaca: Fila " + entrada.getButaca().getFila() +
                                 ", Nº " + entrada.getButaca().getNumero());
        
        Button salirButton = new Button("Salir.");
        
        salirButton.setOnAction(e -> {
            System.out.println("Saliendo...");
            stage.close();
        });

        contenedor.getChildren().addAll(titulo, cliente, sala, pelicula, butaca, salirButton);

        stage.setTitle("Confirmación de compra");
        stage.setScene(new Scene(contenedor, 400, 250));
        stage.show();
    }
}