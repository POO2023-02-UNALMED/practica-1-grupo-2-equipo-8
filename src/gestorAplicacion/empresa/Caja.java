package gestorAplicacion.empresa;
import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caja implements Serializable {
	private int dinero;
	static private HashMap<String, Integer> historialVentas = new HashMap<String, Integer>();
	private HashMap<String, Integer> costosProduccion = new HashMap<>(); // Variable costosProduccion agregada ¿deberia ser estatico?
	
	public Caja(int dinero) {
		this.dinero=dinero;
	}
    /* Metodo que me retorna un string con el 
	* historial de compras para mostrar en pantalla
    */
	public static String verHistorialCompras() {
    	StringBuilder str = new StringBuilder();
        Caja.historialVentas.forEach((String producto, Integer venta) -> {
            str.append("El producto " + producto + " ha sido comprado " + venta + (venta == 1 ? " vez." : " veces."));
        });
        return str.toString();
    }

    public static List<String> historialVentasOrganizado() {
    	List<String> productosOrdenados = new ArrayList<String>(historialVentas.keySet());
    	productosOrdenados.sort((String p1, String p2) -> Integer.compare(historialVentas.get(p2), historialVentas.get(p1)));
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
    public static void agregarVenta(String producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) + cantidadVenta);
        }else{
            Caja.historialVentas.put(producto, cantidadVenta);
        }
    }
    
    // Metodo para agregar una venta
    public static void eliminarVenta(String producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) - cantidadVenta);
        }
    }
    
  //se añade un nuevo metodo para la funcionalida #2 para actualizarCostosProduccion
    
    public void actualizarCostosProduccion(Producto producto,int nuevaCantidad) {
    	
    	int nuevoCosto = producto.getPrecio() * nuevaCantidad;
    	
    	
        // Obtener la lista de costos de producción actual
        HashMap<String, Integer> costosProduccionActual = new HashMap<>();

        // Calcular los costos de producción en función de la lista de producción diaria y los costos unitarios de producción
        for (Map.Entry<String, Integer> entry : produccionDiaria.entrySet()) {
            String producto = entry.getKey();
            int cantidadProduccion = entry.getValue();

            // Verificar si el producto tiene un costo unitario asociado
            if (costosUnitarios.containsKey(producto)) {
                int costoUnitario = costosUnitarios.get(producto);
                int costoProduccion = cantidadProduccion * costoUnitario;
                // Agregar el costo de producción calculado a la lista de costos de producción actualizada
                costosProduccionActual.put(producto, costoProduccion);
            }
        }
        
        // Establecer la lista de costos de producción actualizada en la caja
        this.setCostosProduccion(costosProduccionActual);
    
        // Mostrar la lista de costos de producción actualizada
        StringBuilder str = new StringBuilder("Lista de costos de producción actualizada:");
        for (Map.Entry<String, Integer> entry : costosProduccionActual.entrySet()) {
            str.append("\tProducto: " + entry.getKey() + ", Costo de producción: " + entry.getValue() + ".\n");
        }
        
        return str.toString();
    }

	private void setCostosProduccion(HashMap<String, Integer> costosProduccionActual) {
		this.costosProduccion = costosProduccionActual;
	}
	//se añade un nuevo metodo para la funcionalida #2 para descontar el valor


    public String descontarValorLista(HashMap<String, Integer> costosProduccion) {
        // Obtener el dinero actual en la caja
        int dineroActual = this.getDinero();
        StringBuilder str = new StringBuilder();
        
        // Descontar el valor de la lista de costos de producción de la caja
        for (Map.Entry<String, Integer> entry : costosProduccion.entrySet()) {
            String producto = entry.getKey();
            int costoProduccion = entry.getValue();

            if (dineroActual >= costoProduccion) {
                // Descontar el costo de producción de la caja
                dineroActual -= costoProduccion;
                str.append("Se ha descontado " + costoProduccion + " para el producto "+ producto +".\n");
            } else {
                str.append("No hay suficiente dinero en la caja para descontar el costo de producción de " + producto + ".\n");
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

	public HashMap<String, Integer> getHistorialVentas() {
		return historialVentas;
	}

	public void setHistorialVentas(HashMap<String, Integer> historialVentas) {
		Caja.historialVentas = historialVentas;
	}

}
