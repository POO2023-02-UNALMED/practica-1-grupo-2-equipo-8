package uiMain;
import gestorAplicacion.producto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import baseDatos.*;
import gestorAplicacion.empresa.*;
import gestorAplicacion.producto.*;
public class Main {
	public static void main(String[] args) {
//		Ingrediente leche = new Ingrediente("leche", 100, 1, 2);
//		Ingrediente huevo = new Ingrediente("huevo", 1000, 2, 1);
//		
//		HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<Ingrediente, Integer>();
//		ingredientesTorta.put(leche, 2);
//		ingredientesTorta.put(huevo, 5);
//		Producto torta = new Tortas("Torta de Calabaza", 3, ingredientesTorta, 0, "TOR-CA", 10, 0, 1, 12, "Crema");
//		
//		//System.out.println(leche.getNombre() + ": " + leche.getPrecio());
//		//System.out.println(huevo.getNombre() + ": " + huevo.getPrecio());
//		//System.out.println(torta.getNombre() + ": " + torta.getPrecio());
//		
//		//System.out.print(torta.listaCaracteristicas());
//		
//		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
//		listaProductos.add(torta);
//		
//		System.out.println(Serializador.serializarProductos(listaProductos));
//		ArrayList<Producto> listaProductosDeserializados = Deserializador.deserializarProductos();
//		
//		for(Producto p: listaProductosDeserializados) {
//			System.out.println(p.listaCaracteristicas());
//			String[] name = p.getClass().getName().split("\\.");
//			System.out.println(name[2]);
//		}
//
//		
//		ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
//		listaIngredientes.add(leche);
//		listaIngredientes.add(huevo);
//		
//		System.out.println(Serializador.serializarIngredientes(listaIngredientes));
//		
//		ArrayList<Ingrediente> listaIngredientesDeserializados = Deserializador.deserializarIngredientes();
//		for(Ingrediente i: listaIngredientesDeserializados) {
//			System.out.println(i.getNombre() + ": " + i.getPrecio());
//		}
//	}
		
		
	//Pruebas de que todo funcione correctamente
		
		
		//CreaciónDeBodega
			//Creacion de listas iniciales
		 HashMap<String, Integer> ingredientesInicialeBodega = new HashMap<>();
		 List<Ingrediente> ingredientesIniciales= new ArrayList<Ingrediente>();
		 HashMap<String, Integer> productosInicialesBodega = new HashMap<>();
		 List<Ingrediente> productoIniciales= new ArrayList<Ingrediente>(); 
		 HashMap<String, Integer> productosInicialesBodega1 = new HashMap<>();
		 List<Producto> productosIniciales = new ArrayList<Producto>();

		 	// Crear una torta
		 HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<>();
		 Ingrediente harina = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar = new Ingrediente("azúcar", 3, 1234, 5);
		 ingredientesTorta.put(harina, 1);
		 ingredientesTorta.put(azucar, 1);
		 Tortas torta = new Tortas("torta", 5, ingredientesTorta, 20, "abc123", 3, 6, "chocolate");
		 productosIniciales.add(torta);
		 productosInicialesBodega1.put(torta.getNombre(), 1);

		 // Crear un pastel frito
		 HashMap<Ingrediente, Integer> ingredientesPastelesFritos = new HashMap<>();
		 Ingrediente harina2 = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar2 = new Ingrediente("azúcar", 3, 1234, 5);
		 ingredientesPastelesFritos.put(harina2, 2);
		 ingredientesPastelesFritos.put(azucar2, 1);
		 PastelesFritos pastelFrito = new PastelesFritos("pastelFrito",5, ingredientesPastelesFritos, 20, "dfg123", 3, false, "tomate");
		 productosIniciales.add(pastelFrito);
		 productosInicialesBodega1.put(pastelFrito.getNombre(), 1);

		 	// Crear unas galletas
		 HashMap<Ingrediente, Integer> ingredientesGalletas = new HashMap<>();
		 Ingrediente harina3 = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar3 = new Ingrediente("azúcar", 3, 1234, 5);
		 ingredientesGalletas.put(harina3, 2);
		 ingredientesGalletas.put(azucar3, 1);
		 Galletas galletas = new Galletas("galleta", 5, ingredientesGalletas, 20, "dfg123", 3, false, "vainilla");
		 productosIniciales.add(galletas);
		 productosInicialesBodega1.put(galletas.getNombre(), 1);

		 	// Crear una dona
		 HashMap<Ingrediente, Integer> ingredientesDonas = new HashMap<>();
		 Ingrediente harina4 = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar4 = new Ingrediente("azúcar", 3, 1234, 5);
		 ingredientesDonas.put(harina4, 2);
		 ingredientesDonas.put(azucar4, 1);
		 Donas dona = new Donas("dona", 5, ingredientesDonas, 20, "dfg123", 3, false, "arquipe");
		 productosIniciales.add(dona);
		 productosInicialesBodega1.put(dona.getNombre(), 1);	
		 
		 
		 for (int i = 1; i <= 10; i++) {
	            Ingrediente ingrediente1 = new Ingrediente("harina", 2, i, 1);
	            ingredientesIniciales.add(ingrediente1);
	            Ingrediente ingrediente2 = new Ingrediente("azucar", 1, i + 10, 1);
	            ingredientesIniciales.add(ingrediente2);
	            Ingrediente ingrediente3 = new Ingrediente("huevos", 3, i + 20, 2);
	            ingredientesIniciales.add(ingrediente3);
	            Ingrediente ingrediente4 = new Ingrediente("levadura", 2, i + 30, 1);
	            ingredientesIniciales.add(ingrediente4);
	            Ingrediente ingrediente5 = new Ingrediente("mantequilla", 4, i + 40, 2);
	            ingredientesIniciales.add(ingrediente5);
	        }
		 for (Ingrediente ingrediente : ingredientesIniciales) {
			 ingredientesInicialeBodega.put(ingrediente.getNombre(), 10);
			}
		 
		 
		 
		 
		
		 
		 
		 
		 //Bodega y pruebas de funciones de bodega
		 	Bodega bodega=new Bodega("ABC123",productosInicialesBodega1,1000,ingredientesInicialeBodega,productosIniciales,ingredientesIniciales);
//		 	System.out.println(bodega.calcularEstanciaProductosOrdenDiasEnBodega());
//		 	System.out.println(bodega.productosNoasignadosAEnvios());
//		 	System.out.println(bodega.mostrarIngredientesEscasos());

		 	
		 //Creación de fabrica
		 	Fabrica fabrica=new Fabrica("CBS321","CRR52#75",bodega);
		 	//Le seteamos una produccionDiariaInicial
		 	HashMap<String, Integer> produccionDiaria = new HashMap<>();
		 	produccionDiaria.put("torta", 1);
		 	produccionDiaria.put("pastelFrito", 1);
		 	produccionDiaria.put("dona", 1);
		 	produccionDiaria.put("galleta", 1);
		 	fabrica.setProduccionDiaria(produccionDiaria);
		 	fabrica.finalizarProduccion(produccionDiaria);
		 	fabrica.finalizarProduccion(produccionDiaria);
		 	
		 	System.out.println(bodega.calcularEstanciaProductosOrdenDiasEnBodega());
		 	
		 	
		 	//Creamos Caja
		 	Caja caja = new Caja(10000);
		 	
		 	
		 	//Creamos 10 camiones
		 	
		 	String[] marcas = {
		 		    "CamionetaMax", "SuperTruck", "RapidCargo", "MegaHauler", "PowerMover",
		 		    "CargoKing", "TurboTransit", "Speedster", "CargoMaster", "SwiftHaul"
		 		};

		 		String[] modelos = {
		 		    "X1", "A2", "Pro100", "MegaTruck", "UltraCargo",
		 		    "SpeedyXpress", "Transporter3000", "SuperLoad", "CargoBeast", "QuickHauler"
		 		};

		 		for (int i = 0; i < 10; i++) {
		 		    String marca = marcas[i];
		 		    String modelo = modelos[i];
		 		    int capacidad = 1500; // Capacidad ficticia

		 		    Camion camion = new Camion(marca, modelo, capacidad);
		 		    
		 		}
		 		
		 		
		 		//Creamos administrador
		 		
		 		Administrador administrador=new Administrador(bodega,caja,Camion.getCamiones(),fabrica);
		 		administrador.iniciarSesion();
		 		
		 		
		 	
		 	
		 	
		
		
		
		
		
		
		
		
		

}}
