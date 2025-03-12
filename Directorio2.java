package ejercicio_3;

import java.io.File;

public class Directorio2 {

    // Atributo para almacenar la ruta actual
    private String ruta;

    // Constructor para inicializar la ruta
    public Directorio2(String ruta) {
        this.ruta = ruta;
    }

    // Método para listar archivos y directorios en la ruta actual
    public void listarDirectorio() {
        File directorio = new File(this.ruta);

        if (!directorio.exists()) {
            System.out.println("La ruta no existe.");
            return;
        }

        if (!directorio.isDirectory()) {
            System.out.println("La ruta no es un directorio válido.");
            return;
        }

        File[] archivos = directorio.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio está vacío.");
            return;
        }

        for (File archivo : archivos) {
            if (archivo.isFile()) {
                System.out.println("- " + archivo.getName() + " (" + archivo.length() + " bytes)");
            } else if (archivo.isDirectory()) {
                System.out.println("+ " + archivo.getName() + " [Carpeta]");
            }
        }
    }

    // Método para cambiar de directorio (CD)
    public int CD(String subdir) {
        // Construir la nueva ruta
        String nuevaRuta = this.ruta + File.separator + subdir;
        File nuevoDirectorio = new File(nuevaRuta);

        // Verificar si la nueva ruta existe
        if (!nuevoDirectorio.exists()) {
            return 1; // El subdirectorio no existe
        }

        // Verificar si la nueva ruta es un directorio
        if (!nuevoDirectorio.isDirectory()) {
            return 2; // Es un archivo, no un directorio
        }

        // Cambiar la ruta actual
        this.ruta = nuevaRuta;
        return 0; // Cambio exitoso
    }

    // Método para obtener la ruta actual
    public String getRuta() {
        return this.ruta;
    }
}