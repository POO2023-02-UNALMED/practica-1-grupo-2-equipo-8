package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.*;

import gestorAplicacion.producto.Producto;

public class Administrador implements Serializable {
//Atributos
    private static Bodega bodega;
    private Caja caja;
    private List<Camion> camiones = new ArrayList<Camion>();
    private Fabrica fabrica;
    
    

    //Metodos de la clase Administrador

    //iniciarSesion(): Metodo que se ejecuta cada vez que el Administrador inicie sesiòn en cada interacciòn que tenga con el software
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
        	//Funcionalidad #2
        	
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
                System.out.println(this.getFabrica().cambiarProduccion(productoSeleccionado, nuevaCantidad));
          
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
    }

    //Metodo para verificar si un valor es de tipo String
    public static boolean esString(String input) {

        return input.matches("[a-zA-Z]+");
    }

    
  //Funcionalidad 5
    public static void asignacionDeCarroDeVenta() {
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
                        asignacionDeCarroDeVenta(); // Volver a ejecutar la función
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
  //Constructor
    public Administrador(Bodega bodega,Caja caja,List<Camion> Camiones, Fabrica Fabrica) {
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
        bodega = bodega;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        caja = caja;
    }

    public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		camiones = camiones;
	}

	public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        fabrica = fabrica;
    }


}
