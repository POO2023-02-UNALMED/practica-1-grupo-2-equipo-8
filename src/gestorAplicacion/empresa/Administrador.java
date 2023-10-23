package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.*;

<<<<<<< Updated upstream
import gestorAplicacion.producto.Producto;
=======
import baseDatos.Deserializador;
import gestorAplicacion.producto.Donas;
import gestorAplicacion.producto.Galletas;
import gestorAplicacion.producto.PastelesFritos;
import gestorAplicacion.producto.Producto;
import gestorAplicacion.producto.Tortas;
>>>>>>> Stashed changes

public class Administrador implements Serializable {
//Atributos
    private Bodega bodega;
    private Caja caja;
    private List<Camion> camiones = new ArrayList<Camion>();
    private Fabrica fabrica;
    
    public static boolean iniciarSesion(Administrador usuario, String contrasena) {
    	if("root".equals(contrasena)) {
    		return true;
    	}else {
    		return false;
    	}
    }

    //Metodos de la clase Administrador

    //iniciarSesion(): Metodo que se ejecuta cada vez que el Administrador inicie sesiòn en cada interacciòn que tenga con el software
<<<<<<< Updated upstream
    public  String iniciarSesion(){

        //public static void iniciarSesion(String[] args){}

        //while

        //Se crea un objeto Scanner para leer la respuesta del usuario al mensaje a continuacion
        Scanner numero = new Scanner(System.in);

        //Mensaje inicial del Software, dando la bienvenida al Administrador y dandole las opciones disponibles a elegir mediante numeros (del 1 al 5)
        System.out.println("Bienvenido a Alimentos Delihorno. ¿Que desearìa hacer el dìa de hoy?:" + "\n" +
                "1. Comprar Materia Prima" + "\n" + "2. Venta Por Encargo" + "\n" + "3. Cambiar Lista de Produccion Diaria"
                + "\n" + "4. Agregar Producto" + "\n" + "5. Eliminar Producto"+ "\n" + "6. Asignar Envio Y camion");

        //Se lee la respuesta del usuario al mensaje anterior
        int opcionElegida = numero.nextInt(); 

        //De acuerdo al valor Integer de opcionElegida, se elige ejecutar uno de los metodos a continuacion
        if (opcionElegida == 1){

        } else if(opcionElegida == 2){

        } else if(opcionElegida == 3){
        	Scanner sc = new Scanner(System.in);
        	//Funcionalidad bella y hermosa de MQ
        	
            System.out.println("Producción diaria actual:");
            System.out.println(this.fabrica.ListarListaDeProduccion());
            
            
            System.out.println("Ingrese el número correspondiente al producto para cambiar la producción:");
            int numeroProducto = sc.nextInt();
            
            Producto productoSeleccionado = this.getFabrica().ProductoParaCambiarEnLista(numeroProducto);
            
            System.out.println("Ingrese la nueva cantidad de producción para el producto seleccionado:");
            int nuevaCantidad = sc.nextInt();
            
            //validación 1/5 de bodega
            
            System.out.println(this.getFabrica().cambiarProduccion(productoSeleccionado, nuevaCantidad));
            
            this.getCaja().actualizarCostosProduccion(productoSeleccionado,nuevaCantidad);
            
            System.out.println("Listado de producción diaria actualizada:");
            System.out.println(this.fabrica.ListarListaDeProduccion());
            
            System.out.println("Fabricando tanda...");
            this.fabrica.fabricarTanda();
            
            
            
            
        	
        	
        	
        	


        } else if (opcionElegida == 4){ //Funcionalidad 4: Agregar Producto

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
                if (esString(nombreProductoNuevo)){

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

            System.exit(0);

        } else if (opcionElegida == 5){ //Funcionalidad 4: Eliminar Producto

            //Metodo de clase

            System.out.println("Actualmente se ofrecen los siguientes productos: ");
            //Producto.MostrarProductos();
            System.out.println("Por favor, escriba el nombre del producto que desea eliminar: ");

            System.exit(0);
        }else if (opcionElegida == 6){ //Funcionalidad 5: 

        	asignacionDeCarroDeVenta();

            
        }

        //Retorno a eliminarse cuando se corrija el codigo
        return null;
    }

    //acabarSesion(): Metodo que se ejecuta cada vez que termine la interaccion del Administrador con el software

	private void finalizarSesion() {
        System.out.println("Muchas gracias por usar el software de DeliHorno. Que tenga un feliz día.");
        System.exit(0);
=======
    
    public static Administrador inicializar() {
    	Administrador administrador = Deserializador.deserializarAdministrador();
    	if(administrador == null) {
    		administrador = Administrador.crearTodo();
    	}else {
    		Envio.setListaEnvios(Deserializador.deserializarEnvios());
    		Ingrediente.setIngredientesDisponibles(Deserializador.deserializarIngredientes());
    	}
    	return administrador;
    }
    
    private static Administrador crearTodo() {
		//CreaciónDeBodega
		//Creacion de listas iniciales
		 HashMap<String, Integer> ingredientesInicialeBodega = new HashMap<String, Integer>();
		 List<Ingrediente> ingredientesIniciales= new ArrayList<Ingrediente>();
		 HashMap<String, Integer> productosInicialesBodega = new HashMap<String, Integer>();
		 List<Ingrediente> productoIniciales= new ArrayList<Ingrediente>(); 
		 HashMap<String, Integer> productosInicialesBodega1 = new HashMap<String, Integer>();
		 List<Producto> productosIniciales = new ArrayList<Producto>();
		
		// Crear una torta
		 HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<Ingrediente, Integer>();
		 Ingrediente harina = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar = new Ingrediente("azúcar", 3, 1234, 5);
		 ingredientesTorta.put(harina, 1);
		 ingredientesTorta.put(azucar, 1);
		 Tortas torta = new Tortas("torta", 5, ingredientesTorta, 0, "abc123", 3, 6, "chocolate");
		 productosIniciales.add(torta);
		 productosInicialesBodega1.put(torta.getNombre(), 1);
		
		 // Crear un pastel frito
		 HashMap<Ingrediente, Integer> ingredientesPastelesFritos = new HashMap<Ingrediente, Integer>();
		 Ingrediente harina2 = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar2 = new Ingrediente("azúcar", 3, 1234, 5);
		 ingredientesPastelesFritos.put(harina2, 2);
		 ingredientesPastelesFritos.put(azucar2, 1);
		 PastelesFritos pastelFrito = new PastelesFritos("pastelFrito",5, ingredientesPastelesFritos, 20, "dfg123", 3, false, "tomate");
		 productosIniciales.add(pastelFrito);
		 productosInicialesBodega1.put(pastelFrito.getNombre(), 1);
		
		// Crear unas galletas
		 HashMap<Ingrediente, Integer> ingredientesGalletas = new HashMap<Ingrediente, Integer>();
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
	 	
	 	
	 	//System.out.println(bodega.stringProductosOrdenadosPorDiasBodega());
	 	
	 	
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
	 	    
	 	    Administrador administrador=new Administrador(bodega,caja,Camion.getCamiones(),fabrica);
	 	    return administrador;
    }
    
    public String configurarProduccion() {
        // Se obtiene la instancia de la fábrica
        Fabrica fabrica = this.getFabrica();

        // Se llama al método cambiarProduccion en la fábrica
        String mensajeCambio = fabrica.cambiarProduccion();

        // Se imprime el mensaje que indica el cambio en la producción diaria
        return mensajeCambio;
>>>>>>> Stashed changes
    }

    //Metodo para verificar si un valor es de tipo String
    public static boolean esString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    
  //Funcionalidad 5
    public static void asignacionDeCarroDeVenta(Bodega bodega) {
        // Mostrar los envíos sin camión asignado
        System.out.println("Envíos pendientes de asignación de camión:");
        System.out.println(Envio.enviosPorAsignar());

        // Preguntar al usuario cuál envío desea asignar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el número del envío que desea asignar a un camión: ");
        int eleccion = scanner.nextInt();

        if (eleccion >= 1 && eleccion <= Envio.getListaEnvios().size()) {
            // El usuario ha seleccionado un envío válido
            Envio envioAsignar = Envio.getListaEnvios().get(eleccion - 1);
            System.out.println(Camion.camionesYCapacidad(envioAsignar.getPesoTotal()));

            // Preguntar al usuario cuál camión desea usar
            System.out.print("Seleccione el número del camión que desea asignar: ");
            int eleccionCamion = scanner.nextInt();

            if (eleccionCamion >= 1 && eleccionCamion <= Camion.getCamiones().size()) {
                // El usuario ha seleccionado un camión válido
                Camion camionAsignado = Camion.getCamiones().get(eleccionCamion - 1);

                // Asignar el camión al envío
                camionAsignado.agregarEnvio(envioAsignar);
                envioAsignar.setCamionAsignado(camionAsignado);
                envioAsignar.setAsignadoAUnCamion(true);
                camionAsignado.setCapacidad(camionAsignado.getCapacidad() - envioAsignar.getPesoTotal());

                System.out.println("Envío asignado exitosamente al camión " + camionAsignado.getMarca() + " " + camionAsignado.getModelo() + " con placa " + camionAsignado.getPlaca());

                // Mostrar productos en bodega no asignados
                System.out.println("Productos en bodega no asignados a envíos:");
                System.out.println(bodega.productosNoasignadosAEnvios());

                // Preguntar al usuario si quiere enviar el camión
                System.out.print("¿Desea enviar el camión? (1. Sí / 2. No): ");
                int opcionEnvio = scanner.nextInt();

                if (opcionEnvio == 1) {
                    // Cambiar estado de disponibilidad del camión
                    camionAsignado.setDisponibilidad(false);
                    System.out.println("El camión ha sido enviado.");
                } else {
                    // Preguntar si quiere realizar otro envío
                    System.out.print("¿Desea realizar otro envío? (1. Sí / 2. No): ");
                    int opcionOtroEnvio = scanner.nextInt();

                    if (opcionOtroEnvio == 1) {
                        asignacionDeCarroDeVenta(bodega); // Volver a ejecutar la función
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

        scanner.close();
    }
  //Constructores, si no desea establecer una contraseña por defecto se le asigna la contraseña "root"
    public Administrador(Bodega bodega,Caja caja,List<Camion> camiones, Fabrica fabrica) {
    	this.bodega=bodega;
    	this.caja=caja;
    	this.camiones=camiones;
    	this.fabrica=fabrica;
    }
    


    //Getters y Setters
    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
<<<<<<< Updated upstream

=======
 
>>>>>>> Stashed changes
    public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}

	public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
}
