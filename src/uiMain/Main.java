package uiMain;
import gestorAplicacion.producto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
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
	
	/*
	 * Interfaz de Usuario para la funcionalidad 1: Compra de materia prima
	 */
	public static void compraMateriaPrimaUI() {
		System.out.println("Cantidad de ingredientes en bodega:");
	    String contabilidadIngredientes = administrador.getBodega().mostrarContabilidadIngredientes();
	    System.out.println(contabilidadIngredientes);

	    System.out.println("¿Cree necesario comprar ingredientes? (1.Si / 2.No): ");
	    int respuestaComprarIngredientes = scan.nextInt();
	    scan.nextLine(); // Consumir el salto de línea

	    if (respuestaComprarIngredientes == 1) {
	        // Mostrar los ingredientes escasos y preguntar si están seguros de que no necesitan comprar.
	        String ingredientesEscasos = administrador.getBodega().mostrarIngredientesEscasos();
	        System.out.println(ingredientesEscasos);

	        System.out.println("Aquí puede ver los ingredientes escazos,¿Está seguro de que necesita comprar ingredientes? (1.Si / 2.No): ");
	        int respuestaIngredientesEscasos = scan.nextInt();
	        scan.nextLine(); // Consumir el salto de línea

	        if (respuestaIngredientesEscasos == 1) {
	        	System.out.println("Seleccione el ingrediente que desea pedir:");
	        	System.out.println(Ingrediente.obtenerListaIngredientes());
	        	int opcion = scan.nextInt();
	        	scan.nextLine();
	        	
	    	    if (opcion < 1 || opcion > Ingrediente.getIngredientesDisponibles().size()) {
	    	        System.out.println("Opción no válida. Seleccione un número válido.");
	    	        return;
	    	    }

	    	    // Solicitar la cantidad deseada
	    	    System.out.println("¿Cuántos " +  Ingrediente.getIngredientesDisponibles().get(opcion - 1).getNombre() + " desea pedir? ");
	    	    int cantidadPedida = scan.nextInt();
	    	    scan.nextLine();
	    	    
	    	    
	    	    
	    	    System.out.println(administrador.getBodega().pedirCantidadIngrediente(opcion, cantidadPedida, administrador));

	        } else {
	        	System.out.println("Por ahora no se compra nada.");
	        }
	    } else if (respuestaComprarIngredientes == 2) {
	        System.out.println("Por ahora no se compra nada.");
	    } else {
	        System.out.println("Opción no válida.");
	    }
	}
	
	/*
	 * Interfaz de Usuario para la funcionalidad 2: Venta por encargo
	 */
	public static void ventaPorEncargoUI() {
		// Pedir al usuario que ingrese un código de envío
		System.out.println("Ingrese un código de envío (número entero): ");
		int codigoEnvio = scan.nextInt();
		scan.nextLine();

		// Crear una lista para almacenar los productos seleccionados
		List<Producto> productosSeleccionados = new ArrayList<>();

		// Variable para controlar si el cliente quiere seleccionar más productos
		boolean seleccionarOtroProducto = true;

		while (seleccionarOtroProducto) {
		    // Mostrar la lista de productos disponibles
		    System.out.println(administrador.getBodega().mostrarProductos());

		    // Pedir al cliente que elija un producto
		    System.out.println("Elija un producto ingresando el número correspondiente: ");
		    int opcionProducto = scan.nextInt();
		    scan.nextLine();

		    // Validar si la opción elegida es válida
		    if (opcionProducto >= 1 && opcionProducto <= administrador.getBodega().getProductos().size()) {
		        Producto productoElegido = administrador.getBodega().getProductos().get(opcionProducto - 1);

		        // Verificar si el producto ya fue seleccionado previamente
		        if (productosSeleccionados.contains(productoElegido)) {
		            System.out.println("Ya ha seleccionado ese producto. Por favor, elija otro.");
		        } else {
		            // Agregar el producto a la lista de productos seleccionados
		            productosSeleccionados.add(productoElegido);
		            System.out.println("Has elegido el producto: " + productoElegido.getNombre());
		        }

		        // Preguntar si desea seleccionar otro producto
		        System.out.println("¿Desea elegir otro producto? (1.Sí / 2.No): ");
		        int respuesta = scan.nextInt();
		        scan.nextLine();

		        seleccionarOtroProducto = (respuesta == 1);
		    } else {
		        System.out.println("Opción no válida. Seleccione un número válido.");
		    }
		}

		// Crear un envío con el código ingresado, la lista de productos seleccionados, la caja y la bodega
		Envio nuevoEnvio = new Envio(codigoEnvio, productosSeleccionados, administrador.getCaja(), administrador.getBodega());

		

		// Mensaje de confirmación
		System.out.println("Se ha creado un nuevo envío con código " + nuevoEnvio.getCodigoDeEnvio() + " y los productos seleccionados.");
	}
	
	/*
	 * Interfaz de Usuario para la funcionalidad 3: Cambiar la lista de produccion diaria
	 */
	public static void cambiarListaProduccionDiariaUI() {
		//Funcionalidad #2

    	//Se muestra la produccion diaria
        System.out.println("Producción diaria actual:");
        System.out.println(administrador.getFabrica().listarListaDeProduccion());

        //Se le pide al usuario que ingrese el numero del producto el cual quiere cambiar
        System.out.println("Ingrese el número correspondiente al producto para cambiar la producción:");
        Producto productoSeleccionado = administrador.getFabrica().productoParaCambiarEnLista(scan.nextInt());
        scan.nextLine();

        //Se le pide al usuario que ingrese la nueva cantidad de productos a realizar 
        System.out.println("Ingrese la nueva cantidad de producción para el producto seleccionado:");
        int nuevaCantidad = scan.nextInt();
        scan.nextLine();

        if (administrador.getBodega().disponibilidadBodega(administrador.getFabrica().getProduccionDiaria())){

        	//Se cambia la lista de producción diaria
            System.out.println(administrador.getFabrica().cambiarProduccion(productoSeleccionado, nuevaCantidad));
            
            //Se ajustan los costos de produccion
            administrador.getCaja().actualizarCostosProduccion(productoSeleccionado,nuevaCantidad);

            //Se muestra la nueva lista de producción diaria incluidos costes
            System.out.println("Listado de producción diaria actualizada:");
            System.out.println(administrador.getFabrica().listarListaDeProduccion());


            //Se fabrica la tanda
            System.out.println("Fabricando tanda...");
            System.out.println(administrador.getFabrica().fabricarTanda());

          //Descontar materia prima para poder fabricar tanda

            administrador.getBodega().descontarMateriaPrimaNecesaria(productoSeleccionado.getIngredientesNecesarios(), nuevaCantidad);

          //Se descuenta el valor de la lista de la caja

            administrador.getCaja().descontarValorLista(administrador.getFabrica().getProduccionDiaria());

          //se establece tiempo de demora de producción

            System.out.println(administrador.getFabrica().establecerTiempoDemoraProduccion(nuevaCantidad));

          //validar si hay espacio disponible en la bodega (IF)

            if (administrador.getBodega().verificarTandaBodega(administrador.getFabrica().getProduccionDiaria())) {
            	// --iftrue reservar esapcio en bodega

                System.out.println(administrador.getFabrica().gestionarEspacioBodega(administrador.getFabrica().getProduccionDiaria()));

              // se genera codigo de tanda

                administrador.getFabrica();
				int numeroTanda= Fabrica.getCodigoTandaActual();
                System.out.println("El codigo de la tanda es " + numeroTanda);

              // se guardan los productos generados

                administrador.getBodega().guardarEnBodega(administrador.getFabrica().getProduccionDiaria());

            }else {
            	// se manda la tanda a otra bodega
            	administrador.getFabrica().transferirProduccionOtraBodega(administrador.getFabrica().getProduccionDiaria());
            	System.out.println("Se ha transferido la producción de la tanda a otra bodega");

            }
    	}else {
        	System.out.println("La nueva lista de Producción Diaria es demasiado grande para la capacidad de la Bodega. Por favor, elija valores menores y tenga en cuenta el espacio que ocupa cada tipo de producto.");
        }

      //Fin de la funcionalidad
	};
	
	/*
	 * Interfaz de Usuario para la funcionalidad 4: Agregar un producto ---------- No implementado correctamente
	 */
	public static void agregarProductoUI() {
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

				if (respuesta != 1) {
					if (2 > ingredientesYCantidad.size()) {
						imprimirSeparador();
						System.out.println("Se requieren minimo dos ingredientes para la creaccion de un producto");
						imprimirSeparador();
					} else {
						seleccionarOtroIngrediente = false;
					}
				}
			} else {
				System.out.println("Opción no válida. Seleccione un número válido.");
			}
		}

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
		}
	}
	
	/*
	 * Interfaz de Usuario para la funcionalidad 5: Eliminar un producto ---------- No implementado correctamente
	 */
	public static void eliminarProductoUI() {
        System.out.println("Actualmente se ofrecen los siguientes productos: ");
        //Producto.MostrarProductos();
        System.out.println("Por favor, escriba el nombre del producto que desea eliminar: ");
	}
	
	/*
	 * Interfaz de Usuario para la funcionalidad 6: Asignar envio y camion
	 */
	public static void asignarEnvioCamionUI() {
		try {
			// Mostrar los envíos sin camión asignado
	        System.out.println("Envíos pendientes de asignación de camión:");
	        System.out.println(Envio.enviosPorAsignar());
	
	        // Preguntar al usuario cuál envío desea asignar
	        System.out.println("Seleccione el número del envío que desea asignar a un camión: ");
	        int eleccion = scan.nextInt();
	        scan.nextLine();
	        
	        if (eleccion >= 1 && eleccion <= Envio.getListaEnvios().size()) {
	            // El usuario ha seleccionado un envío válido
	            Envio envioAsignar = Envio.getListaEnvios().get(eleccion - 1);
	            envioAsignar.setAsignadoAUnCamion(true);
	            System.out.println(Camion.camionesYCapacidad(envioAsignar.getPesoTotal()));
	
	            // Preguntar al usuario cuál camión desea usar
	            System.out.println("Seleccione el número del camión que desea asignar: ");
	            int eleccionCamion = scan.nextInt();
	            scan.nextLine();
	            
	            if (eleccionCamion >= 1 && eleccionCamion <= Camion.getCamiones().size()) {
	                // El usuario ha seleccionado un camión válido
	                Camion camionAsignado = Camion.getCamiones().get(eleccionCamion - 1);
	
	                // Asignar el camión al envío
	                camionAsignado.agregarEnvio(envioAsignar);
	                envioAsignar.setCamionAsignado(camionAsignado);
	                envioAsignar.setAsignadoAUnCamion(true);
	                camionAsignado.setCapacidad(camionAsignado.getCapacidad() - envioAsignar.getPesoTotal());
	               
	                Envio.getListaEnvios().remove(envioAsignar);
	                
	                Envio.getListaEnviosAsignados().add(envioAsignar);
	                
	                System.out.println("Envío asignado exitosamente al camión " + camionAsignado.getMarca() + " " + camionAsignado.getModelo() + " con placa " + camionAsignado.getPlaca());
	
	                // Mostrar productos en bodega no asignados
	                System.out.println("Productos en bodega no asignados a envíos:");
	                System.out.println(administrador.getBodega().productosNoAsignadosAEnvios());
	
	                // Preguntar al usuario si quiere enviar el camión
	                System.out.println("¿Desea enviar el camión? (1. Sí / 2. No): ");
	                int opcionEnvio = scan.nextInt();
	                scan.nextLine();
	                
	                if (opcionEnvio == 1) {
	                    // Cambiar estado de disponibilidad del camión
	                    camionAsignado.setDisponibilidad(false);
	                    Camion.getCamiones().add(camionAsignado);
	                    Camion.getCamiones().remove(camionAsignado);
	                    camionAsignado.setDisponibilidad(false);
	                    System.out.println("El camión ha sido enviado.");
	                } else {
	                    // Preguntar si quiere realizar otro envío
	                    System.out.println("¿Desea realizar otro envío? (1. Sí / 2. No): ");
	                    int opcionOtroEnvio = scan.nextInt();
	                    scan.nextInt();
	                    
	                    if (opcionOtroEnvio == 1) {
	                    	asignarEnvioCamionUI(); // Volver a ejecutar la función
	                    } else {
	                        System.out.println("Hasta luego.");
	                    }
	                }
	            } else {
	                System.out.println("Selección no válida. Por favor, elija un número de camión válido.");
	            }
	        } else {
	            System.out.println("Selección no válida. Por favor, elija un número de envío válido.");
	        }
	
	        
	    } catch (InputMismatchException e) {
	        System.out.println("Entrada no válida. Ingrese un número entero válido.");
	    }
	}
	
	/*
	 * Interfaz de Usuario para la funcionalidad 7: cambiar la produccion y/o ventas 
	 * en base a las ventas y dias en bodega respectivamente
	 */
	public static void cambiarProduccionVentasUI() {
		System.out.println("Descripcion: Cambia automaticamente el nivel de produccion en base a las ventas de un producto y/o el precio de un producto en base a los dias que lleva en bodega");
    	System.out.println("¿Esta de acuerdo? 1. Si / 2. No");
    	switch(scan.nextInt()) {
    		case 1:
    			scan.nextLine();
	    		System.out.println("Desea cambiar la produccion de los productos?:");
	    		boolean cambioProduccion = scan.nextLine().toLowerCase().equals("si");
	    		
	    		System.out.println("Desea cambiar el precio de los productos?:");
	    		boolean cambioPrecio = scan.nextLine().toLowerCase().equals("si");
	    		
	    		System.out.println(administrador.getBodega().actualizarProduccionPrecio(cambioProduccion, cambioPrecio, administrador.getFabrica()));
	    	
	    		imprimirSeparador();
	    		System.out.println("Tabla de productos con precios actualizados");
	    		imprimirListaProductos();
	    		imprimirSeparador();
	    		break;
    		case 2:
    			scan.nextLine();
    			System.out.println("No se ha realizado ningun cambio.");
    			break;
    		default:
    			scan.nextLine();
    			System.out.println("No seleccesionaste ninguna opcion.");
    			break;
    	}
	}
	
	public static void main(String[] args) {
				System.out.println(" ,gggggggggggg,                                                                                           \r\n"
						+ "dP\"\"\"88\"\"\"\"\"\"Y8b,           ,dPYb,           ,dPYb,                                                       \r\n"
						+ "Yb,  88       `8b,          IP'`Yb           IP'`Yb                                                       \r\n"
						+ " `\"  88        `8b          I8  8I  gg       I8  8I                                                       \r\n"
						+ "     88         Y8          I8  8'  \"\"       I8  8'                                                       \r\n"
						+ "     88         d8  ,ggg,   I8 dP   gg       I8 dPgg,     ,ggggg,     ,gggggg,   ,ggg,,ggg,     ,ggggg,   \r\n"
						+ "     88        ,8P i8\" \"8i  I8dP    88       I8dP\" \"8I   dP\"  \"Y8ggg  dP\"\"\"\"8I  ,8\" \"8P\" \"8,   dP\"  \"Y8ggg\r\n"
						+ "     88       ,8P' I8, ,8I  I8P     88       I8P    I8  i8'    ,8I   ,8'    8I  I8   8I   8I  i8'    ,8I  \r\n"
						+ "     88______,dP'  `YbadP' ,d8b,_ _,88,_    ,d8     I8,,d8,   ,d8'  ,dP     Y8,,dP   8I   Yb,,d8,   ,d8'  \r\n"
						+ "    888888888P\"   888P\"Y8888P'\"Y888P\"\"Y8    88P     `Y8P\"Y8888P\"    8P      `Y88P'   8I   `Y8P\"Y8888P\"    \r\n"
						+ "                                                                                                          ");
				
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
								ventaPorEncargoUI();
								 break;
							case 3:
						    	cambiarListaProduccionDiariaUI();
								 break;
				        	case 4: 
				        		agregarProductoUI();
					            break;
				        	case 5: 
				        		eliminarProductoUI();
					            break;
					        case 6: 
					        	asignarEnvioCamionUI();
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
				System.out.println("           ___\r\n"
						+ "       .-'`   `'-.\r\n"
						+ "   _,.'.===   ===.'.,_\r\n"
						+ "  / /  .___. .___.  \\ \\\r\n"
						+ " / /   ( o ) ( o )   \\ \\                                            _\r\n"
						+ ": /|    '-'___'-'    |\\ ;                                          (_)\r\n"
						+ "| |`\\_,.-'`   `\"-.,_/'| |                                          /|\r\n"
						+ "| |  \\             /  | |                                         /\\;\r\n"
						+ "| |   \\           /   | | _                              ___     /\\/\r\n"
						+ "| |    \\   __    /\\   | |' `\\-.-.-.-.-.-.-.-.-.-.-.-.-./`   `\"-,/\\/ \r\n"
						+ "| |     \\ (__)  /\\ `-'| |    `\\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\`\\       \\/\r\n"
						+ "| |      \\-...-/  `-,_| |      \\`\\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\ \\       \\\r\n"
						+ "| |       '---'    /  | |       | | | | | | | | | | | | | |       |\r\n"
						+ "| |               |   | |       | | | | | | | | | | | | | |       |\r\n"
						+ "\\_/               |   \\_/       | | | | | | | | | | | | | | .--.  ;Deli Horno\r\n"
						+ "                  |       .--.  | | | | | | | | | | | | | | |  | /\r\n"
						+ "                   \\      |  | / / / / / / / / / / / / / /  |  |/\r\n"
						+ "              WOOF! |`-.___|  |/-'-'-'-'-'-'-'-'-'-'-'-'-'`--|  |\r\n"
						+ "            ,.-----'~~;   |  |                  (_(_(______)|  |\r\n"
						+ "           (_(_(_______)  |  |                        ,-----`~~~\\\r\n"
						+ "                    ,-----`~~~\\                      (_(_(_______)\r\n"
						+ "                   (_(_(_______)");
				scan.close();
				System.exit(0);
}}
