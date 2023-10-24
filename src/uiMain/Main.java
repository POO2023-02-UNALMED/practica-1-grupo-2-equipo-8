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
								 System.out.println("Cantidad de ingredientes en bodega:");
								    String contabilidadIngredientes = administrador.getBodega().mostrarContabilidadIngredientes();
								    System.out.println(contabilidadIngredientes);

								    System.out.print("¿Cree necesario comprar ingredientes? (1.Sí / 2.No): ");
								    int respuestaComprarIngredientes = scan.nextInt();
								    scan.nextLine(); // Consumir el salto de línea

								    if (respuestaComprarIngredientes == 1) {
								        // Mostrar los ingredientes escasos y preguntar si están seguros de que no necesitan comprar.
								        System.out.println("Ingredientes escasos:");
								        String ingredientesEscasos = administrador.getBodega().mostrarIngredientesEscasos();
								        System.out.println(ingredientesEscasos);

								        System.out.print("Aquí puede ver los ingredientes escazos,¿Está seguro de que necesita comprar ingredientes? (1.Sí / 2.No): ");
								        int respuestaIngredientesEscasos = scan.nextInt();
								        scan.nextLine(); // Consumir el salto de línea

								        if (respuestaIngredientesEscasos == 1) {
								        	Scanner scanner = new Scanner(System.in);
								        	System.out.print("Seleccione el ingrediente que desea pedir ");
								        	System.out.println(Ingrediente.obtenerListaIngredientes());
								        	int opcion = scanner.nextInt();

								    	    if (opcion < 1 || opcion > Ingrediente.getIngredientesDisponibles().size()) {
								    	        System.out.println("Opción no válida. Seleccione un número válido.");
								    	        scanner.close();
								    	        return;
								    	    }

								    	    // Obtener el ingrediente seleccionado
								    	    Ingrediente ingredienteSeleccionado = Ingrediente.getIngredientesDisponibles().get(opcion - 1);

								    	    // Solicitar la cantidad deseada
								    	    System.out.print("¿Cuántos " + ingredienteSeleccionado.getNombre() + " desea pedir? ");
								    	    int cantidadPedida = scanner.nextInt();

								    	    // Crear la cantidad de ingredientes solicitados
								    	    for (int i = 0; i < cantidadPedida; i++) {
								    	        Ingrediente nuevoIngrediente = new Ingrediente(ingredienteSeleccionado.getNombre());
								    	        administrador.getBodega().getIngredientes().add(nuevoIngrediente);
								    	        administrador.getBodega().getContabilidadIngredientes().merge(ingredienteSeleccionado.getNombre(), 1, Integer::sum);
								    	        
								    	    }
								    	    administrador.getCaja().restarDinero(ingredienteSeleccionado.getPrecio()*cantidadPedida);
								    	    System.out.println("Su compra ha sido realizada con exito");
								        	
								        } else {
								        	System.out.println("Por ahora no se compra nada.");
								        }
								    } else if (respuestaComprarIngredientes == 2) {
								        System.out.println("Por ahora no se compra nada.");
								    } else {
								        System.out.println("Opción no válida.");
								    }
								    break;
							case 2:
								 break;
							case 3:
								 
								 break;
				        	case 4: 
				        	
				        		System.out.println("Lista de ingredientes disponibles:\n");
				        		String listaIngredientes = Ingrediente.obtenerListaIngredientes();
				        		System.out.println(listaIngredientes);

				        		HashMap<Ingrediente, Integer> ingredientesYCantidad = new HashMap<>();

				        		boolean seleccionarOtroIngrediente = true;

				        		while (seleccionarOtroIngrediente) {
				        		    // Pedir al usuario que elija un ingrediente
				        		    System.out.print("Seleccione el número correspondiente al ingrediente que necesita para su producto: ");
				        		    int opcionIngrediente = scan.nextInt();
				        		    scan.nextLine(); // Consumir el salto de línea

				        		    // Validar si la opción elegida es válida
				        		    if (opcionIngrediente >= 1 && opcionIngrediente <= Ingrediente.getIngredientesDisponibles().size()) {
				        		        Ingrediente ingredienteElegido = Ingrediente.getIngredientesDisponibles().get(opcionIngrediente - 1);

				        		        // Pedir al usuario la cantidad de ese ingrediente
				        		        System.out.print("Ingrese la cantidad de " + ingredienteElegido.getNombre() + " que necesita: ");
				        		        int cantidadIngrediente = scan.nextInt();
				        		        scan.nextLine(); // Consumir el salto de línea

				        		        ingredientesYCantidad.put(ingredienteElegido, cantidadIngrediente);

				        		        // Preguntar si desea seleccionar otro ingrediente
				        		        System.out.print("¿Desea seleccionar otro ingrediente? (1.Sí / 2.No): ");
				        		        int respuesta = scan.nextInt();
				        		        scan.nextLine(); // Consumir el salto de línea

				        		        seleccionarOtroIngrediente = (respuesta == 1);
				        		    } else {
				        		        System.out.println("Opción no válida. Seleccione un número válido.");
				        		    }
				        		}

				        		// Pregunta al usuario si desea crear un producto
				        		System.out.print("¿Desea crear un producto? (1.Sí / 2.No): ");
				        		int respuestaCrearProducto = scan.nextInt();
				        		scan.nextLine(); // Consumir el salto de línea

				        		if (respuestaCrearProducto == 1) {
				        		    System.out.println("Seleccione el tipo de producto que desea crear:");
				        		    System.out.println("1. Torta");
				        		    System.out.println("2. Dona");
				        		    System.out.println("3. Pasteles Fritos");
				        		    System.out.println("4. Galleta");

				        		    int tipoProducto = scan.nextInt();
				        		    scan.nextLine(); // Consumir el salto de línea

				        		    // Creamos un objeto de tipo Producto para guardar el producto creado
				        		    Producto productoCreado = null;

				        		    // Dependiendo del tipo de producto seleccionado, creamos la instancia correspondiente
				        		    switch (tipoProducto) {
				        		        case 1:
				        		            // Crear Torta
				        		            productoCreado = new Tortas("torta", 5, ingredientesYCantidad, 0, "abc123", 3, 6, "chocolate");
				        		            
				        		            System.out.println("Producto exitosamente creado: " + productoCreado);
				        		            break;
				        		        case 2:
				        		            // Crear Dona 	
				        		            productoCreado = new Donas("dona", 5, ingredientesYCantidad, 20, "dfg123", 3, false, "arquipe");
				        		            System.out.println("Producto exitosamente creado: " + productoCreado);
				        		            break;
				        		        case 3:
				        		            // Crear Pasteles Fritos
				        		            productoCreado = new PastelesFritos("pastelFrito", 5, ingredientesYCantidad, 20, "dfg123", 3, false, "tomate");
				        		            System.out.println("Producto exitosamente creado: " + productoCreado);
				        		            break;
				        		        case 4:
				        		            // Crear Galleta
				        		            productoCreado = new Galletas("galleta", 5, ingredientesYCantidad, 20, "dfg123", 3, false, "vainilla");
				        		            System.out.println("Producto exitosamente creado: " + productoCreado);
				        		            break;
				        		        default:
				        		            System.out.println("Opción no válida.");
				        		            System.out.println("Producto exitosamente creado: " + productoCreado);
				        		            break;
				        		    }}


				        	

				        		
				        		
				        		
					          
				        	case 5: //Funcionalidad 4: Eliminar Producto
	
					            //Metodo de clase
	
					            System.out.println("Actualmente se ofrecen los siguientes productos: ");
					            //Producto.MostrarProductos();
					            System.out.println("Por favor, escriba el nombre del producto que desea eliminar: ");
	
					            break;
					        case 6: //Funcionalidad 5: 
					        	Administrador.asignacionDeCarroDeVenta(administrador.getBodega());
					        	
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

				}while(opcionElegida != 0);
				
				
				
//				Serializador.serializarAdministrador(administrador);
//				Serializador.serializarBodegas(administrador.getBodega());
//				Serializador.serializarEnvios(Envio.getListaEnvios());
//				Serializador.serializarIngredientes(Ingrediente.getIngredientesDisponibles());
				System.out.println("Muchas gracias por usar el software de DeliHorno. Que tenga un feliz día.");
				System.exit(0);
}}
