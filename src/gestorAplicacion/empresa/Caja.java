package gestorAplicacion.empresa;
import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caja implements Serializable {
	private int dinero;
	static private HashMap<Producto, Integer> historialVentas = new HashMap<Producto, Integer>();
	private HashMap<Producto, Integer> costosProduccion = new HashMap<>(); // Variable costosProduccion agregada ¿deberia ser estatico?
	
	public Caja(int dinero) {
		this.dinero=dinero;
	}
    /* Metodo que me retorna un string con el 
	* historial de compras para mostrar en pantalla
    */
	public static String verHistorialCompras() {
    	StringBuilder str = new StringBuilder();
        Caja.historialVentas.forEach((Producto  producto, Integer venta) -> {
            str.append("El producto " + producto.getNombre() + " ha sido comprado " + venta + (venta == 1 ? " vez." : " veces."));
        });
        return str.toString();
    }

	public static List<Producto> historialVentasOrganizado() {
    	List<Producto> productosOrdenados = new ArrayList<Producto>(historialVentas.keySet());
    	productosOrdenados.sort((Producto p1, Producto p2) -> Integer.compare(historialVentas.get(p2), historialVentas.get(p1)));
    	return productosOrdenados;
    }
    
	// Declaración del método para ingresar dinero en la caja
    public void ingresarDinero(int cantidad) {
    	this.dinero+=cantidad;
    }

    public void restarDinero(int cantidad) {
    	this.dinero -= cantidad;
    }
    
    // Metodo para agregar una venta
    public static void agregarVenta(Producto producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) + cantidadVenta);
        }else{
            Caja.historialVentas.put(producto, cantidadVenta);
        }
    }
    
    // Metodo para agregar una venta
    public static void eliminarVenta(Producto producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) - cantidadVenta);
        }
    }
    
  //se añade un nuevo metodo para la funcionalida #2 para actualizarCostosProduccion
    
  	public void actualizarCostosProduccion(Producto producto,int nuevaCantidad) {
  	    	int nuevoCosto = producto.getPrecio() * nuevaCantidad;
  	    	
  	    	for(Producto productoHashMap : costosProduccion.keySet()) {
  	    		costosProduccion.put(productoHashMap,  nuevoCosto);
  	    	}
    }

  	private void setCostosProduccion(HashMap<Producto, Integer> costosProduccionActual) {
		this.costosProduccion = costosProduccionActual;
	}
	//se añade un nuevo metodo para la funcionalida #2 para descontar el valor


  	public String descontarValorLista(HashMap<Producto, Integer> costosProduccion) {
	    // Obtener el dinero actual en la caja
	    int dineroActual = this.getDinero();
	    StringBuilder str = new StringBuilder();

	    // Descontar el valor de la lista de costos de producción de la caja
	    for (Map.Entry<Producto, Integer> entry : costosProduccion.entrySet()) {
	        Producto producto = entry.getKey();
	        int costoProduccion = entry.getValue();

	        if (dineroActual >= producto.getPrecio()*costoProduccion) {
	            // Descontar el costo de producción de la caja
	            dineroActual -= producto.getPrecio()*costoProduccion;
	            str.append("Se ha descontado " + producto.getPrecio() * costoProduccion + " para el producto " + producto.getNombre() + ".\n");
	        } else {
	            str.append("No hay suficiente dinero en la caja para descontar el costo de producción de " + producto.getNombre() + ".\n");
	        }
	    }

	    // Actualizar el valor de dinero en la caja después del descuento
	    this.setDinero(dineroActual);
	    str.append("Actualmente cuenta con " + this.getDinero() + " en la caja.\n");
	    return str.toString();
	}



    public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public HashMap<Producto, Integer> getHistorialVentas() {
		return historialVentas;
	}

	public void setHistorialVentas(HashMap<Producto, Integer> historialVentas) {
		Caja.historialVentas = historialVentas;
	}

}
