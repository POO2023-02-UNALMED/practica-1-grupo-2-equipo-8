package uiMain;
import gestorAplicacion.producto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import baseDatos.*;
import gestorAplicacion.empresa.*;
import gestorAplicacion.producto.*;
public class Main {
	public static Scanner scan = new Scanner(System.in);
	private static Administrador administrador = Administrador.inicializar();
	
	public static void imprimirListaProductos(){
		List<Producto> productos = administrador.getBodega().getProductos();
		for(Producto producto: productos) {
			System.out.println(producto.toString());
		}
	}
	
	public static void imprimirSeparador() {
		System.out.println("-".repeat(50));
	}
	
	public static boolean iniciarSesion() {
		boolean estaLoggeado = false;
		int cont = 1;
		do {
			System.out.print((cont != 1) ? "Contraseña incorrecta. Te quedan "+ (6-cont) +" intentos.\n" : "");
			System.out.println((cont == 1) ? "Ingrese la contraseña del administrador:": "Ingresela nuevamente:");
			estaLoggeado = Administrador.iniciarSesion(administrador, scan.nextLine().split("\n")[0]);
			cont += 1;
		}while(!estaLoggeado && cont <= 5);
		
		return estaLoggeado;
	}
	
	public static void main(String[] args) {
				imprimirListaProductos();
				System.out.println("Bienvenido a Alimentos Delihorno.");
				
				int opcionElegida = -1;
				
				do {
					 System.out.println("¿Que desearìa hacer?:" + "\n" +
				                "\t1. Comprar Materia Prima" + "\n" + 
				                "\t2. Venta Por Encargo" + "\n" + 
				                "\t3. Cambiar Lista de Produccion Diaria" + "\n" + 
				                "\t4. Agregar Producto" + "\n" + 
				                "\t5. Eliminar Producto"+ "\n" + 
				                "\t6. Asignar Envio Y camion" + "\n" +
				                "\t7. Cambiar Produccion y/o ventas de un producto" + "\n" +
				                "\t0. Para salir");

				        //Se lee la respuesta del usuario al mensaje anterior
				        opcionElegida = scan.nextInt(); 
				        scan.nextLine();
				        //De acuerdo al valor Integer de opcionElegida, se elige ejecutar uno de los metodos a continuacion
				        switch(opcionElegida) {
							//De acuerdo al valor Integer de opcionElegida, se elige ejecutar uno de los metodos a continuacion
							case 1:
								break;
							case 2:
								 break;
							case 3:
								 
								 break;
				        	case 4: //Funcionalidad 4: Agregar Producto

<<<<<<< Updated upstream
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
		 	
		 	System.out.println(bodega.stringProductosOrdenadosPorDiasBodega());
		 	
		 	
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

		 		String[] placas = {
		 			    "ABC-123",
		 			    "DEF-456",
		 			    "GHI-789",
		 			    "JKL-012",
		 			    "MNO-345",
		 			    "PQR-678",
		 			    "STU-901",
		 			    "VWX-234",
		 			    "YZA-567",
		 			    "BCD-890"
		 			};

		 			for (int i = 0; i < 10; i++) {
		 			    String marca = marcas[i];
		 			    String modelo = modelos[i];
		 			    int capacidad = 1500; // Capacidad ficticia
		 			    String placa = placas[i];

		 			    Camion camion = new Camion(marca, modelo, capacidad, placa);
		 			}
		 		//Creamos Envios
		 	    for (int i = 1; i <= 5; i++) {
		 	        List<Producto> productosEnvio = new ArrayList<Producto>();
		 	        productosEnvio.add(bodega.getProductos().get(0)); // Agregamos el primer producto de la bodega al envío
		 	        Envio envio = new Envio(i, productosEnvio, caja, bodega);
		 	    }
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		//Creamos administrador
		 		
		 		Administrador administrador=new Administrador(bodega,caja,Camion.getCamiones(),fabrica);
		 		administrador.iniciarSesion();
		 		System.out.println(bodega.getProductos());
		 		System.out.println(caja.getHistorialVentas());
		 		
		 	
		 	
		 	
		
		
		
		
		
		
		
		
		
=======
					            //Metodo de clase
	
					            System.out.println("Actualmente se ofrecen los siguientes productos: ");
					            //Producto.MostrarProductos();
	
					            //Se crea un scanner para leer el nombre del nuevo producto que escribe el usuario
					            Scanner nombreProductoEscrito = new Scanner(System.in);
					            String nombreProductoNuevo;
					            boolean esString = false; // Variable para repetir el ciclo do while si es false, se usa el metodo "esString"
	
					            //Ciclo donde se confirma si el valor tipeado por el usuario es de tipo String
					            do{
					                System.out.println("Por favor, escriba el nombre del producto que desea agregar: ");
					                nombreProductoNuevo = nombreProductoEscrito.next(); //Se guarda el valor escrito en "nombreProductoNuevo"
	
					                //Se verifica si el valor escrito es de tipo String
					                if (Administrador.esString(nombreProductoNuevo)){
					                    esString = true;
					                } else { //Si el valor escrito no es String
					                    System.out.println("Este nombre no es valido");
					                }
					            } while (!esString); //Se repite el ciclo hasta que esString = true
	
					            System.out.println("El nombre del nuevo producto es " + nombreProductoNuevo);
	
					            System.out.println("Actualmente usamos los siguientes ingredientes para fabricar nuestro catalogo de productos: ");
	
					            //MostrarListaIngredientes() Funcion de SerializadorIngredientes
	
					            System.out.println("¿Cuales de los ingredientes de la lsta piensa usar para fabricar el nuevo producto?");
	
					            //Crear caso de excepcion en el que si se eligen menos de dos ingredientes se repita el loop hasta que se elijan dos o màs ingredientes (similar al do while del primer Scanner
	
					            System.out.println("¿El nuevo producto necesita uno o varios ingredientes nuevos?: ");
	
					            //
					            /*if (hayIngredienteNuevo){
	
					                System.out.println("Escriba el/los nuevos ingredientes (separados por coma) a continuacion: ");
	
					                if(noEscribeBien){
					                    System.out.println("Por favor, escriba cifras validas");
					                }
					            }*/
	
					            System.out.println("Por favor, inserte la cifra necesaria de cada ingrediente para la fabricacion del nuevo producto (separados por comas): ");
					            //Se muestra la lista de los ingredientes elegidos antes de que el usuario escriba los valores, para usarlos como guia de orden
					            //Si inserta valores invalidos, se repite la interaccion hasta que los valores sean validos
	
					            System.out.println("De acuerdo a los costes de los ingredientes, el valor del nuevo producto a producir serìa de CalcularCostoProductoNuevo() por unidad");
	
					            //Se añade el producto nuevo al Serializador de Productos junto con su respectiva informacion
	
					            System.out.println("Se ha añadido el producto UltimoProductoAñadido.getnombre() al catalogo de forma exitosa");
	
					            //Se imprime el nombre del producto, seguido por la cantidad y tipo de ingredientes que necesita para fabricarse, y el costo de cada unidad
	
					            //Se aplica la informacion nueva del Serializador de Productos a todas las clases que la necesiten
	
					            
					            break;
				        	case 5: //Funcionalidad 4: Eliminar Producto
	
					            //Metodo de clase
	
					            System.out.println("Actualmente se ofrecen los siguientes productos: ");
					            //Producto.MostrarProductos();
					            System.out.println("Por favor, escriba el nombre del producto que desea eliminar: ");
	
					            break;
					        case 6: //Funcionalidad 5: 
					        	break;
					        case 7:
					        	System.out.println("Descripcion: Cambia automaticamente el nivel de produccion en base a las ventas de un producto y/o el precio de un producto en base a los dias que lleva en bodega");
					        	System.out.println("¿Esta de acuerdo?:");
					        	if(scan.nextLine().toLowerCase().equals("si")) {
					        		System.out.println("Desea cambiar la produccion de los productos?:");
					        		boolean cambioProduccion = scan.nextLine().toLowerCase().equals("si");
					        		
					        		System.out.println("Desea cambiar el precio de los productos?:");
					        		boolean cambioPrecio = scan.nextLine().toLowerCase().equals("si");
					        		
					        		System.out.println(administrador.getBodega().actualizarProduccionPrecio(cambioProduccion, cambioPrecio, administrador.getFabrica()));
					        	
					        		imprimirSeparador();
					        		System.out.println("Tabla de productos con precios actualizados");
					        		imprimirListaProductos();
					        		imprimirSeparador();
					        	}else{
					        		System.out.println("No se ha realizado ningun cambio.");
					        	}
					        	break;
					        case 0:
					        	break;
					        default:
					        	System.out.println("No has seleccionado una opcion valida.");
				        }
>>>>>>> Stashed changes

				}while(opcionElegida != 0);
				
				
				
				Serializador.serializarAdministrador(administrador);
				Serializador.serializarBodegas(administrador.getBodega());
				Serializador.serializarEnvios(Envio.getListaEnvios());
				Serializador.serializarIngredientes(Ingrediente.getIngredientesDisponibles());
				System.out.println("Muchas gracias por usar el software de DeliHorno. Que tenga un feliz día.");
				System.exit(0);
}}
