
package medianota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarArchivoNotasMedias {

    public static void main(String[] args) {
      
        String archivoEntrada = "alumnosNotas.txt";
        String archivoSalida = "mediasNotas.txt";

        try {
            // Abre el archivo para leer las notas de los alumnos
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            
            // Abre el archivo para escribir las medias de las notas de los alumnos
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            // Lee el primer archivo linea a linea
            while ((linea = br.readLine()) != null) {
                // Separa la línea por partes
                String[] partes = linea.split(":");
                String nombre = partes[0];
                
                // Calcula la media de las notas para cada alumno
                double sumaNotas = 0;
                for (int i = 1; i < partes.length; i++) {
                    sumaNotas += Double.parseDouble(partes[i]);
                }
                double media = sumaNotas / (partes.length - 1);

                // Escribe la media de la nota de cada alumno en el archivo de salida
                bw.write(nombre + ": " + media);
                bw.newLine();
            }

            // Cierra los archivos
            br.close();
            bw.close();
            //mensaje de confirmacion 
            System.out.println("Medias calculadas y guardadas en " + archivoSalida);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}