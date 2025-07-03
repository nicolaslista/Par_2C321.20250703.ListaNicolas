/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Cine;
import java.io.*;

/**
 *
 * @author juani
 */
public class PersistenciaDatos {

    private static final String NOMBRE_ARCHIVO = "cine.ser";

    public static void guardarEstado(Cine cine) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(cine);
            System.out.println("Reservas guardadas exitosamente.");
        }
    }

    public static Cine cargarEstado() throws IOException, ClassNotFoundException {
        File archivo = obtenerArchivo();

        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado. Se crea un nuevo estado de Cine.");
            return new Cine();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Object obj = ois.readObject();
            if (obj instanceof Cine) {
                System.out.println("Estado del cine cargado correctamente.");
                return (Cine) obj;
            } else {
                throw new IOException("El obejto Cine no es valido.");
            }
        }
    }

    public static File obtenerArchivo() {
        return new File(NOMBRE_ARCHIVO);
    }
}
