/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javafx.scene.*;
import javafx.stage.*;
import javafx.geometry.*;
import modelo.Cine;
import modelo.Cliente;
import controladores.LoginControlador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author PC
 */
public class LoginVista {

    private Stage stage;
    private Cine cine;
    private LoginControlador controlador;

    public LoginVista(Stage stage, Cine cine) {
        this.stage = stage;
        this.cine = cine;
        this.controlador = new LoginControlador(cine);
    }

    public void mostrarLogin() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Iniciar sesion o registrarse:");
        TextField email = new TextField();
        email.setPromptText("Email");

        PasswordField password = new PasswordField();
        password.setPromptText("Contraseña");

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre (solo para registrarse)");

        Button loginButton = new Button("Iniciar Sesion");
        Button registrarButton = new Button("Registrarse");
        Button salirButton = new Button("Salir.");
        Label mensaje = new Label();

       

        loginButton.setOnAction(e -> {
            String emailRecibido = email.getText();
            String passwordRecibida = password.getText();
            Cliente c = controlador.login(emailRecibido, passwordRecibida);
            if (c != null) {
                mensaje.setText("Entrada exitosa. Bienvenido " + c.getNombre());
                new SalaVista(stage, cine, c).mostrar();
            } else {
                mensaje.setText("Datos Invalidos");
            }
        });

        registrarButton.setOnAction(e -> {
            String nombreRecibido = nombre.getText();
            String emailRecibido = email.getText();
            String passwordRecibida = password.getText();
            boolean registrado = controlador.registrar(nombreRecibido, emailRecibido, passwordRecibida);
            mensaje.setText(registrado ? "Registrado con exito." : "Datos insuficientes o cliente ya existente.");
        });
        
        salirButton.setOnAction(e -> {
            System.out.println("Saliendo...");
            stage.close();
        });

        root.getChildren().addAll(titulo, nombre, email, password, loginButton, registrarButton, mensaje, salirButton);
        stage.setTitle("Cine Cuyo");
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }

}
