
package medianota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarArchivoNotasMedias {

    public static void main(String[] args) {
        // Nombre del archivo de entrada y salida
        String archivoEntrada = "alumnosNotas.txt";
        String archivoSalida = "mediasNotas.txt";

        try {
            // Abre el archivo de entrada para lectura
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            
            // Abre el archivo de salida para escritura
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            // Lee cada línea del archivo de entrada
            while ((linea = br.readLine()) != null) {
                // Separa la línea en partes usando el carácter ","
                String[] partes = linea.split(":");
                String nombre = partes[0];
                
                // Calcula la media de las notas para cada alumno
                double sumaNotas = 0;
                for (int i = 1; i < partes.length; i++) {
                    sumaNotas += Double.parseDouble(partes[i]);
                }
                double media = sumaNotas / (partes.length - 1);

                // Escribe el nombre del alumno y su media en el archivo de salida
                bw.write(nombre + ": " + media);
                bw.newLine();
            }

            // Cierra los archivos
            br.close();
            bw.close();

            System.out.println("Medias calculadas y guardadas en " + archivoSalida);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}