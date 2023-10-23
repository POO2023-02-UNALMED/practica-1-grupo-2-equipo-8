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
	
	public static void compraMateriaPrimaUI() {
		int ingredienteSeleccionado = 0;
		ArrayList<Ingrediente> ingredientes = Ingrediente.getIngredientesDisponibles();
		boolean esPrimeraVez = true;
		do {
			imprimirSeparador();
			System.out.print(!esPrimeraVez ? "Ingrese una opcion valida.\n" : "");
			esPrimeraVez = false;
			System.out.println("Seleccione el número correspondiente al ingrediente que desea pedir: ");
		    for(Ingrediente ingrediente: ingredientes){
		    	System.out.println("\t" + (ingredientes.indexOf(ingrediente)+1) + " " + ingrediente.getNombre());
		    }
		    ingredienteSeleccionado = scan.nextInt();
		    scan.nextLine();
		}while(ingredienteSeleccionado < 1 || ingredienteSeleccionado > ingredientes.size());
		
		String nombreIngrediente = ingredientes.get(ingredienteSeleccionado - 1).getNombre();
		imprimirSeparador();
		
		System.out.println("¿Cuántos " + nombreIngrediente + " desea pedir? ");
		int cantidad = scan.nextInt();
		scan.nextLine();
		System.out.println(administrador.getBodega().pedirCantidadIngrediente(ingredienteSeleccionado,cantidad));
	}
	
	public static void cambiarProduccionVentasUI() {
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
	}
	
	public static void agregarProductoUI() {
        System.out.println("Actualmente se ofrecen los siguientes productos: ");
        //Producto.MostrarProductos();

        String nombreProductoNuevo = "";

        do{
            System.out.println("Por favor, escriba el nombre del producto que desea agregar: ");
            nombreProductoNuevo = scan.nextLine(); //Se guarda el valor escrito en "nombreProductoNuevo"

            if(!Administrador.esString(nombreProductoNuevo)) {
            	System.out.println("Este nombre no es valido");
            }
        } while (!Administrador.esString(nombreProductoNuevo)); //Se repite el ciclo hasta que esString = true

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

        
	}
	
	public static void eliminarProductoUI() {
        System.out.println("Actualmente se ofrecen los siguientes productos: ");
        //Producto.MostrarProductos();
        System.out.println("Por favor, escriba el nombre del producto que desea eliminar: ");

	}
	
	public static void main(String[] args) {
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

				        opcionElegida = scan.nextInt(); 
				        scan.nextLine();
				        
				        switch(opcionElegida) {
							case 1:
								compraMateriaPrimaUI();
								break;
							case 2:
								 break;
							case 3:
								 break;
				        	case 4: 
				        		agregarProductoUI();
					            break;
				        	case 5: 
				        		eliminarProductoUI();
					            break;
					        case 6: 
					        	break;
					        case 7:
					        	cambiarProduccionVentasUI();
					        	break;
					        case 0:
					        	break;
					        default:
					        	System.out.println("No has seleccionado una opcion valida.");
				        }

				}while(opcionElegida != 0);
				
				Administrador.finalizarSesion(administrador);
				System.out.println("Muchas gracias por usar el software de DeliHorno. Que tenga un feliz día.");
				scan.close();
				System.exit(0);
}}
