package uiMain;
import gestorAplicacion.producto.*;

import java.util.HashMap;

import gestorAplicacion.empresa.*;

public class Main {
	public static void main(String[] args) {
		Ingrediente leche = new Ingrediente("leche", 100, 1, 2);
		Ingrediente huevo = new Ingrediente("huevo", 1000, 2, 1);
		
		HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<Ingrediente, Integer>();
		ingredientesTorta.put(leche, 2);
		ingredientesTorta.put(huevo, 5);
		Producto torta = new Tortas("Torta de Calabaza", 3, ingredientesTorta, 0, "TOR-CA", 10, 0, 1, 12, "Crema");
		
		System.out.println(leche.getNombre() + ": " + leche.getPrecio());
		System.out.println(huevo.getNombre() + ": " + huevo.getPrecio());
		System.out.println(torta.getNombre() + ": " + torta.getPrecio());
		
		System.out.print(torta.listaCaracteristicas());
	}

}
