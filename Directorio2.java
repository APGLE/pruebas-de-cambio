package ejercicio_3;

import java.io.File;

public class Directorio2 {
	
	private String ruta;
	
	public Directorio2(String ruta) {
		this.ruta = ruta;
	}

    // Método para listar archivos y directorios en una ruta específica
    public static void listarDirectorio(String ruta) {
        // Crear un objeto File con la ruta proporcionada
        File directorio = new File(ruta);

        // Verificar si la ruta existe
        if (!directorio.exists()) {
            System.out.println("La ruta no existe.");
            return;
        }

        // Verificar si la ruta es un directorio
        if (!directorio.isDirectory()) {
            System.out.println("La ruta no es un directorio válido.");
            return;
        }

        // Obtener la lista de archivos y directorios en la ruta
        File[] archivos = directorio.listFiles();

        // Verificar si el directorio está vacío
        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio está vacío.");
            return;
        }

        // Recorrer y mostrar los archivos y directorios
        for (File archivo : archivos) {
            if (archivo.isFile()) {
                // Si es un archivo, mostrar su nombre y tamaño
                System.out.println("- " + archivo.getName() + " (" + archivo.length() + " bytes)");
            } else if (archivo.isDirectory()) {
                // Si es un directorio, mostrar su nombre y la etiqueta [Carpeta]
                System.out.println("+ " + archivo.getName() + " [Carpeta]");
            }
        }
    }
    
    public int CD(String subdir) {
    	String nuevaRuta = this.ruta + File.separator + subdir;
    	File nuevoDirectorio = new File(nuevaRuta);
    	
    	if(!nuevoDirectorio.exists()) {
    		return 1;
    	}
    	
    	if(!nuevoDirectorio.isDirectory()) {
    		return 2;
    	}
    	
    	this.ruta = nuevaRuta;
    	return 0;
    }
    
    public String getRuta() {
    	return this.ruta;
    }
}