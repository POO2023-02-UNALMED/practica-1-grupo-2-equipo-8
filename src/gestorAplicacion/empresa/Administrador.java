package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.*;

public class Administrador implements Serializable {

    private Bodega Bodega;
    private Caja Caja;
    private HashMap<String, Integer> Productos ;
    private List<Camion> Camiones = new ArrayList<Camion>();
    private Fabrica Fabrica;

    
    //Funcionalidad 5
    public void asignacionDeCarroDeVenta() {
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
                System.out.println(this.getBodega().productosNoasignadosAEnvios());

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

 
    public Administrador() {
        Bodega = new Bodega();
        Caja = new Caja();
        //Productos = Producto.  Implementar metodo de clase ObtenerProductos
        //Fabrica = new Fabrica(); Implementar dependiendo de Decision de Fabrica

    }

    //Getters y Setters
    public Bodega getBodega() {
        return Bodega;
    }

    public void setBodega(Bodega bodega) {
        Bodega = bodega;
    }

    public Caja getCaja() {
        return Caja;
    }

    public void setCaja(Caja caja) {
        Caja = caja;
    }

    public HashMap<String, Integer> getProductos() {
        return Productos;
    }

    public void setProductos(HashMap<String, Integer> productos) {
        Productos = productos;
    }

 
    public List<Camion> getCamiones() {
		return Camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		Camiones = camiones;
	}

	public Fabrica getFabrica() {
        return Fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        Fabrica = fabrica;
    }


    //Metodos de la clase Administrador

    //iniciarSesion(): Metodo que se ejecuta cada vez que el Administrador inicie sesiòn en cada interacciòn que tenga con el software
    public static String iniciarSesion(){

        //public static void iniciarSesion(String[] args){}

        //while

        //Se crea un objeto Scanner para leer la respuesta del usuario al mensaje a continuacion
        Scanner numero = new Scanner(System.in);

        //Mensaje inicial del Software, dando la bienvenida al Administrador y dandole las opciones disponibles a elegir mediante numeros (del 1 al 5)
        System.out.println("Bienvenido a Alimentos Delihorno. ¿Que desearìa hacer el dìa de hoy?:" + "\n" +
                "1. Comprar Materia Prima" + "\n" + "2. Venta Por Encargo" + "\n" + "3. Cambiar Lista de Produccion Diaria"
                + "\n" + "4. Agregar Producto" + "\n" + "5. Eliminar Producto");

        //Se lee la respuesta del usuario al mensaje anterior
        int opcionElegida = numero.nextInt(); 

        //De acuerdo al valor Integer de opcionElegida, se elige ejecutar uno de los metodos a continuacion
        if (opcionElegida == 1){

        } else if(opcionElegida == 2){

        } else if(opcionElegida == 3){


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
            } while (!esString);

            System.out.println("El nombre del nuevo producto es " + nombreProductoNuevo);


        } else if (opcionElegida == 5){ //Funcionalidad 4: Eliminar Producto

            //Metodo de clase

            System.out.println("Actualmente se ofrecen los siguientes productos: ");
            //Producto.MostrarProductos();
            System.out.println("Por favor, escriba el nombre del producto que desea eliminar: ");
        };

        //Retorno a eliminarse cuando se corrija el codigo
        return null;
    }
    
    public void configurar() {
        // Se obtiene la instancia de la fábrica
        Fabrica fabrica = this.getFabrica();

        // Se llama al método cambiarProduccion en la fábrica
        String mensajeCambio = fabrica.cambiarProduccion();

        // Se imprime el mensaje que indica el cambio en la producción diaria
        System.out.println(mensajeCambio);
    }

    //acabarSesion(): Metodo que se ejecuta cada vez que termine la interaccion del Administrador con el software
    @SuppressWarnings("unused")
	private void finalizarSesion() {
        System.out.println("Muchas gracias por usar el software de DeliHorno. Que tenga un feliz día.");
        System.exit(0);
    }

    //Metodo para verificar si un valor es de tipo String
    public static boolean esString(String input) {

        return input.matches("[a-zA-Z]+");
    }

}
