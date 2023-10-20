package gestorAplicacion.empresa;
import gestorAplicacion.producto.Producto;
import java.util.HashMap;

public class Caja {
	static private int dinero;
	static private HashMap<Producto, Integer> historialVentas = new HashMap<>();
	


    // Declaración del método para mostrar el historial de compras
    public void verHistorialCompras() {
        Caja.historialVentas.forEach((Producto producto, Integer venta) -> {
            System.out.println("El producto " + producto.getNombre() + " ha sido comprado " + venta + (venta == 1 ? " vez." : " veces."));
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
    public void agregarVenta(Producto producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) + cantidadVenta);
        }else{
            Caja.historialVentas.put(producto, cantidadVenta);
        }
    }

    public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		Caja.dinero = dinero;
	}

	public HashMap<Producto, Integer> getHistorialVentas() {
		return historialVentas;
	}

	public void setHistorialVentas(HashMap<Producto, Integer> historialVentas) {
		Caja.historialVentas = historialVentas;
	}

}
