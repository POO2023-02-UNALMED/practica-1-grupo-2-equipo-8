package uiMain;
import gestorAplicacion.producto.*;

import java.util.ArrayList;
import java.util.HashMap;

import baseDatos.*;
import gestorAplicacion.empresa.*;

public class Main {
	public static void main(String[] args) {
		Ingrediente leche = new Ingrediente("leche", 100, 1, 2);
		Ingrediente huevo = new Ingrediente("huevo", 1000, 2, 1);
		
		HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<Ingrediente, Integer>();
		ingredientesTorta.put(leche, 2);
		ingredientesTorta.put(huevo, 5);
		Producto torta = new Tortas("Torta de Calabaza", 3, ingredientesTorta, 0, "TOR-CA", 10, 0, 1, 12, "Crema");
		
		//System.out.println(leche.getNombre() + ": " + leche.getPrecio());
		//System.out.println(huevo.getNombre() + ": " + huevo.getPrecio());
		//System.out.println(torta.getNombre() + ": " + torta.getPrecio());
		
		//System.out.print(torta.listaCaracteristicas());
		
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(torta);
		
		System.out.println(Serializador.serializarProductos(listaProductos));
		ArrayList<Producto> listaProductosDeserializados = Deserializador.deserializarProductos();
		
		for(Producto p: listaProductosDeserializados) {
			System.out.println(p.listaCaracteristicas());
			String[] name = p.getClass().getName().split("\\.");
			System.out.println(name[2]);
		}

		
		ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
		listaIngredientes.add(leche);
		listaIngredientes.add(huevo);
		
		System.out.println(Serializador.serializarIngredientes(listaIngredientes));
		
		ArrayList<Ingrediente> listaIngredientesDeserializados = Deserializador.deserializarIngredientes();
		for(Ingrediente i: listaIngredientesDeserializados) {
			System.out.println(i.getNombre() + ": " + i.getPrecio());
		}
	}

}
