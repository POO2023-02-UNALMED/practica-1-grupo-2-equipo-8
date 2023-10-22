package gestorAplicacion.empresa;
import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.HashMap;

public class Caja implements Serializable {
	static private int dinero;
	static private HashMap<String, Integer> historialVentas = new HashMap<>();
	


    // Declaración del método para mostrar el historial de compras
    public void verHistorialCompras() {
        Caja.historialVentas.forEach((String producto, Integer venta) -> {
            System.out.println("El producto " + producto + " ha sido comprado " + venta + (venta == 1 ? " vez." : " veces."));
        });
    }

    // Declaración del método para ingresar dinero en la caja
    public void ingresarDinero(int cantidad) {

    	Caja.dinero+=cantidad;
    	
    }

    public void restarDinero(int cantidad) {
    	Caja.dinero -= cantidad;
    }
    
    // Metodo para agregar una venta
    public void agregarVenta(String producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) + cantidadVenta);
        }else{
            Caja.historialVentas.put(producto, cantidadVenta);
        }
    }
    
    // Metodo para agregar una venta
    public void eliminarVenta(String producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) - cantidadVenta);
        }else{
            
        }
    }


    public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		Caja.dinero = dinero;
	}

	public HashMap<String, Integer> getHistorialVentas() {
		return historialVentas;
	}

	public void setHistorialVentas(HashMap<String, Integer> historialVentas) {
		Caja.historialVentas = historialVentas;
	}

}
