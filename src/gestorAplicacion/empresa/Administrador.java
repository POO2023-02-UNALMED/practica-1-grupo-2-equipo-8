package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.*;

import baseDatos.Deserializador;
import gestorAplicacion.producto.Donas;
import gestorAplicacion.producto.Galletas;
import gestorAplicacion.producto.PastelesFritos;
import gestorAplicacion.producto.Producto;
import gestorAplicacion.producto.Tortas;

public class Administrador implements Serializable {
//Atributos
    private Bodega bodega;
    private Caja caja;
//    private HashMap<String, Integer> Productos ; PARA QUÉ ESTO EL ADMINISTRADOR TIENE PRODUCTOS?!
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
		 Ingrediente azucar2 = new Ingrediente("azucar", 3, 1234, 5);
		 ingredientesPastelesFritos.put(harina2, 2);
		 ingredientesPastelesFritos.put(azucar2, 1);
		 PastelesFritos pastelFrito = new PastelesFritos("pastelFrito",5, ingredientesPastelesFritos, 20, "abc213", 3, false, "tomate");
		 productosIniciales.add(pastelFrito);
		 productosInicialesBodega1.put(pastelFrito.getNombre(), 1);
		
		// Crear unas galletas
		 HashMap<Ingrediente, Integer> ingredientesGalletas = new HashMap<Ingrediente, Integer>();
		 Ingrediente harina3 = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar3 = new Ingrediente("azucar", 3, 1234, 5);
		 ingredientesGalletas.put(harina3, 2);
		 ingredientesGalletas.put(azucar3, 1);
		 Galletas galletas = new Galletas("galleta", 5, ingredientesGalletas, 20, "rtx213", 3, false, "vainilla");
		 productosIniciales.add(galletas);
		 productosInicialesBodega1.put(galletas.getNombre(), 1);
		
		// Crear una dona
		 HashMap<Ingrediente, Integer> ingredientesDonas = new HashMap<>();
		 Ingrediente harina4 = new Ingrediente("harina", 5, 1234, 10);
		 Ingrediente azucar4 = new Ingrediente("azucar", 3, 1234, 5);
		 ingredientesDonas.put(harina4, 2);
		 ingredientesDonas.put(azucar4, 1);
		 Donas dona = new Donas("dona", 5, ingredientesDonas, 20, "ald245", 3, false, "arquipe");
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
	 	HashMap<Producto, Integer> produccionDiaria = new HashMap<>();
	 	produccionDiaria.put(torta, 1);
	 	produccionDiaria.put(pastelFrito, 1);
	 	produccionDiaria.put(dona, 1);
	 	produccionDiaria.put(galletas, 1);
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
    }

    //Metodo para verificar si un valor es de tipo String
    public static boolean esString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    
  //Funcionalidad 5
    public static void asignacionDeCarroDeVenta(Bodega bodega) {
        try {
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
                envioAsignar.setAsignadoAUnCamion(true);
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
                   
                    Envio.getListaEnvios().remove(envioAsignar);
                    
                    Envio.getListaEnviosAsignados().add(envioAsignar);
                    
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
                        Camion.getCamionesAsignados().add(camionAsignado);
                        Camion.getCamiones().remove(camionAsignado);
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

            
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Ingrese un número entero válido.");
        }
    }
  //Funcionalidad #2
	public void cambiarListaProduccionDiaria() {
		Scanner sc = new Scanner(System.in);
    	
    	//Se muestra la produccion diaria
        System.out.println("Producción diaria actual:");
        System.out.println(this.fabrica.ListarListaDeProduccion());
        
        //Se le pide al usuario que ingrese el numero del producto el cual quiere cambiar
        System.out.println("Ingrese el número correspondiente al producto para cambiar la producción:");
        Producto productoSeleccionado = this.getFabrica().ProductoParaCambiarEnLista(sc.nextInt());
        
        //Se le pide al usuario que ingrese la nueva cantidad de productos a realizar 
        System.out.println("Ingrese la nueva cantidad de producción para el producto seleccionado:");
        int nuevaCantidad = sc.nextInt();
        
        if (this.getBodega().disponibilidadBodega(this.getFabrica().getProduccionDiaria())){
        	
        	//Se cambia la lista de producción diaria
            System.out.println(this.getFabrica().cambiarProduccionn(productoSeleccionado, nuevaCantidad));
      
            //Se ajustan los costos de produccion
            this.getCaja().actualizarCostosProduccion(productoSeleccionado,nuevaCantidad);
            
            //Se muestra la nueva lista de producción diaria incluidos costes
            System.out.println("Listado de producción diaria actualizada:");
            System.out.println(this.fabrica.ListarListaDeProduccion());
            
            
            //Se fabrica la tanda
            System.out.println("Fabricando tanda...");
            this.fabrica.fabricarTanda();
            
          //Descontar materia prima para poder fabricar tanda
            
            this.getBodega().descontarMateriaPrimaNecesaria(productoSeleccionado.getIngredientesNecesarios(), nuevaCantidad);
            
          //Se descuenta el valor de la lista de la caja
            
            this.getCaja().descontarValorLista(this.getFabrica().getProduccionDiaria());
            
          //se establece tiempo de demora de producción
            
            this.fabrica.establecerTiempoDemoraProduccion(nuevaCantidad);
            
          //validar si hay espacio disponible en la bodega (IF)
            
            if (this.getBodega().verificarTandaBodega(this.getFabrica().getProduccionDiaria())) {
            	// --iftrue reservar esapcio en bodega
                
                this.getFabrica().gestionarEspacioBodega(this.getFabrica().getProduccionDiaria());
                
              // se genera codigo de tanda
                
                int numeroTanda=this.getFabrica().getCodigoTandaActual();
                System.out.println("El codigo de la tanda es "+numeroTanda);
                
              // se guardan los productos generados
                
                this.getBodega().guardarEnBodega(this.getFabrica().getProduccionDiaria());
            	
            }else {
            	// se manda la tanda a otra bodega
            	this.getFabrica().transferirProduccionOtraBodega(this.getFabrica().getProduccionDiaria());
            	System.out.println("Se ha transferido la producción de la tanda a otra bodega");
           
            }
        }else {
            	System.out.println("La nueva lista de Producción Diaria es demasiado grande para la capacidad de la Bodega. Por favor, elija valores menores y tenga en cuenta el espacio que ocupa cada tipo de producto.");
            }

      //Fin de la funcionalidad
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
