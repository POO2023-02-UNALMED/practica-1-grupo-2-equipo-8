<<<<<<< Updated upstream
package uiMain;

import gestorAplicacion.empresa.Ingrediente;
import gestorAplicacion.producto.Producto;
import gestorAplicacion.producto.Tortas;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Ingrediente leche = new Ingrediente("leche", 100, 1, 2);
		Ingrediente huevo = new Ingrediente("huevo", 1000, 2, 1);
		
		HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<Ingrediente, Integer>();
		ingredientesTorta.put(leche, 2);
		ingredientesTorta.put(huevo, 5);
		Producto torta = new Tortas("Torta de Calabaza", 3, ingredientesTorta, 0, "TOR-CA", 10, 0,  "Crema");
		
		System.out.println(leche.getNombre() + ": " + leche.getPrecio());
		System.out.println(huevo.getNombre() + ": " + huevo.getPrecio());
		System.out.println(torta.getNombre() + ": " + torta.getPrecio());
		
		System.out.print(torta.listaCaracteristicas());
=======
package baseDeDatos;

import gestorAplicacion.empresa.Ingrediente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SerializadorIngredientes {

	private static final String RUTA_ARCHIVO = "src/baseDeDatos/Archivos/ingredientes.txt";

	public static List<Ingrediente>  leerIngredientes(){
		List<Ingrediente> ingredientes = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
			String linea;
			while ((linea = br.readLine())!= null){
				String[] partes = linea.split(",");
				if (partes.length == 4){
					String nombre = partes[0];
					int precioBase = Integer.parseInt(partes[1]);
					long identificador = Long.parseLong(partes[2]);
					int espacioAlmacenamiento = Integer.parseInt(partes[3]);

					Ingrediente ingrediente = new Ingrediente(nombre, precioBase, identificador, espacioAlmacenamiento);
					ingredientes.add(ingrediente);
				}
			}
		}catch (IOException e){
			System.err.println("Error al leer ingrediente"+ e.getMessage());
		}

		return ingredientes;
	}

	public static void agregarIngrediente(Ingrediente ingrediente) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
			String ingredienteString = ingrediente.toString();
			bw.write(ingredienteString);
			bw.newLine(); // Agrega una nueva línea para separar los ingredientes en el archivo
		} catch (IOException e) {
			System.err.println("Error al agregar ingrediente: " + e.getMessage());
		}
>>>>>>> Stashed changes
	}

	public static boolean existeIngrediente(Ingrediente ingrediente) {
		try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				if (partes.length == 4) {
					if (Objects.equals(partes[0], ingrediente.getNombre())) {
						return true;
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error al leer ingrediente" + e.getMessage());
		}
		return false; // Solo después de revisar todas las líneas del archivo
	}

}