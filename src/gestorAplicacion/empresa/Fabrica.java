package gestorAplicacion.empresa;
import java.util.Scanner;
import gestorAplicacion.producto.Producto;

import java.io.*;
import java.util.HashMap;

public class Fabrica implements Serializable {
    private final String NIT; // NIT es constante y se inicializa en el constructor
    private String direccion;
    private HashMap<String, Integer> produccionDiaria;
    private Bodega bodega;

    public Fabrica(String NIT, String direccion,Bodega bodega)  {
        this.NIT = NIT;
        this.direccion = direccion;
        this.produccionDiaria = new HashMap<>();
        this.bodega = bodega;
    }
   
    
    
    //Crear Constructor Vacìo para Sobrecargar y sacar los atributos de la base de datos
    //Crear Metodos de Clase para afectar ProduccionDiaria
    //La clase Administrador tiene constantes (finales) NIT y Direccion y los entrega al constructor de la Fabrica

    
	public String cambiarProduccion() {
//		Se crea un scaner para seleccionar el producto
	    Scanner scanner = new Scanner(System.in);
//////////////////////////////////////////////////////////////////
	    
	    //Se muestra como está siendo la producción diaria actual en la fabrica, indexando cada producto
	    System.out.println("Producción diaria actual:");
	    int index = 1;
	    for (String producto : produccionDiaria.keySet()) {
	        int cantidad = produccionDiaria.get(producto);
	        System.out.println(index + ". " + producto + ": " + cantidad);
	        index++;
	    }
	    /////////////////////////////////////////////////////////////

	    //Se ingresa el número correspondiente al producto al que se le desea cambiar el niver de producción y se selecciona dichoo
//	    producto
	    
	    System.out.println("Ingrese el número correspondiente al producto para cambiar la producción:");
	    int numeroProducto = scanner.nextInt();

	    int currentIndex = 1;
	    String productoSeleccionado = null;

	    for (String producto : produccionDiaria.keySet()) {
	        if (currentIndex == numeroProducto) {
	            productoSeleccionado = producto;
	            break;
	        }
	        currentIndex++;
	    }
	    
//	Hace la verificación y se asigna el nuevo nivel de producción para cada producto
	    
	    
	    if (productoSeleccionado != null) {
	    	int cantidadVieja=produccionDiaria.get(productoSeleccionado);
	        System.out.println("Ingrese la nueva cantidad de producción para " + productoSeleccionado + ":");
	        int nuevaCantidad = scanner.nextInt();
	        produccionDiaria.put(productoSeleccionado, nuevaCantidad);
	        scanner.close();
	        return imprimirCambiosFabrica(cantidadVieja,nuevaCantidad,productoSeleccionado);
	        
	    } else {
	    	scanner.close();
	        return "Número de producto no válido.";
	    }
	    
	    
	}


    public String imprimirCambiosFabrica(int cantidadVieja, int cantidadNueva, String producto) {
        return "Ha cambiado su nivel de produccion de: "+ cantidadVieja +"a: "+cantidadNueva+" del producto: "+ producto; 
    }

    public void finalizarProduccion(HashMap<Producto, Integer> produccionPorPedido) {
        
    }
}
