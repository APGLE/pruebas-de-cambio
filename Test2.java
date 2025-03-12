package ejercicio_3;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
		Scanner scanner = new Scanner(System.in);
		
        // Solicitar al usuario que introduzca una ruta
		System.out.print("Introduce la ruta del directorio: ");
		String ruta = scanner.nextLine();
		
		Directorio2 directorio = new Directorio2(ruta);
		
		int opcion;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Listar contenido del directorio actual");
			System.out.println("2. Cambiar de directorio");
			System.out.println("3. Salir");
			System.out.print("Elige una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcion) {
			case 1:
				System.out.println("\nContenido del directorio " + directorio.getRuta() + ":");
				directorio.listarDirectorio();
				break;
				
			case 2:
				System.out.print("introduce el nombre del subdirector: ");
				String subdir = scanner.nextLine();
				int resultado = directorio.CD(subdir);
				
				switch (resultado) {
				case 0:
					System.out.print("Cambiado el nombre del directorio: " + directorio.getRuta());
					break;
				case 1:
                    System.out.println("El subdirectorio no existe.");
                    break;
				case 2:
                    System.out.println("El nombre corresponde a un archivo, no a un directorio.");
                    break;
				
				}
				break;
			case 3:
				System.out.println("Salindo del programa");
				break;
			default:
				System.out.println("Opcion no valida. Intentalo de nuevo.");
			}


		} while (opcion != 3);
		
		
		scanner.close();
	}

}
