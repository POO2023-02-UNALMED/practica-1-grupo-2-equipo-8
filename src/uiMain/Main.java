package uiMain;

import baseDeDatos.SerializadorIngredientes;
import gestorAplicacion.empresa.Administrador;
import gestorAplicacion.empresa.Ingrediente;
import gestorAplicacion.empresa.Administrador;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		Instanciamos ingredientes
		
		Ingrediente ingrediente1 = new Ingrediente("Harina", 5, 1, 500, "01/01/2024");
		Ingrediente ingrediente2 = new Ingrediente("Azúcar", 3, 2, 300, "01/01/2023");
		Ingrediente ingrediente3 = new Ingrediente("Levadura", 2, 3, 100, "01/01/2023");
		Ingrediente ingrediente4 = new Ingrediente("Sal", 1, 4, 200, "01/01/2025");
		Ingrediente ingrediente5 = new Ingrediente("Mantequilla", 4, 5, 250, "01/01/2023");
		Ingrediente ingrediente6 = new Ingrediente("Huevos", 2, 6, 100, "01/01/2023");
		Ingrediente ingrediente7 = new Ingrediente("Chocolate", 6, 7, 150, "01/01/2023");
		Ingrediente ingrediente8 = new Ingrediente("Canela", 3, 8, 50, "01/01/2024");
		Ingrediente ingrediente9 = new Ingrediente("Vainilla", 5, 9, 50, "01/01/2023");
		Ingrediente ingrediente10 = new Ingrediente("Nuez", 4, 10, 200, "01/01/2024");

		//Se ejecuta la funcion Administrador
		Administrador.iniciarSesion();

		//Se imprime cada ingrediente con su respectiva informacion
		//System.out.println(Ingrediente.obtenerListaIngredientes());

		new SerializadorIngredientes();

	}

}
