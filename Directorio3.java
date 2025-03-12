package Ejercicio_4;

import java.io.File;
import java.util.Scanner;

public class Directorio3 {

	
	private String ruta;
	
	public Directorio3(String ruta) {
		this.ruta = ruta;
	}
	
	public void listarDirectorio() {
		File directorio = new File(this.ruta);
		
		if (!directorio.exists()) {
			System.out.println("La ruta no existe");
			return;
		}
		
		if (!directorio.isDirectory() ) {
			System.out.println("La ruta no es un directorio valido");
		}
		
		File[] archivos = directorio.listFiles();
		
		if (archivos == null || archivos.length == 0) {
			System.out.println("El directorio esta vacio");
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
	
	public int CD(String subdir) {
		String nuevaRuta = this.ruta + File.separator + subdir;
		File nuevoDirectorio = new File(nuevaRuta);
		
		if (!nuevoDirectorio.exists()) {
			return 1;
		}
		
		if (!nuevoDirectorio.isDirectory()) {
			return 2;
		}
		
		this.ruta = nuevaRuta;
		return 0;
	}
	
	public int eliminar(String archivo) {
		String rutaArchivo = this.ruta + File.separator + archivo;
		File file = new File(rutaArchivo);

		if (!file.exists()) {
			return 1;
		}
		
		if (file.isDirectory()) {
			return 2;
		}
		
		System.out.println("¿Estas seguro de que quieres eliminar el archivo?" + archivo + "(s/n): ");
		Scanner scanner = new Scanner(System.in);
		String confirmacion = scanner.nextLine().trim().toLowerCase();
		
		if (confirmacion.equals("s")) {
			if (file.delete()) {
				return 0;
			} else { 
				System.out.println("Eliminacion cancelada");
				return 1;
			}
		}
	}
	public String getRuta() {
		return this.ruta;
	}
}
