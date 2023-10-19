package empresa;
import producto.Producto;
import java.util.HashMap;

public class Caja {
	private int dinero;
	private HashMap<Producto, Integer> historialVentas = new HashMap<Producto, Integer>();

    // Declaración del método para mostrar el historial de compras
    public void verHistorialCompras() {
        this.historialVentas.forEach((Producto producto, Integer venta) -> {
            System.out.println("El producto " + producto.nombre + " ha sido comprado " + venta + (venta == 1 ? " vez." : " veces."));
        });
    }

    // Declaración del método para ingresar dinero en la caja
    public void ingresarDinero(int cantidad) {
    	this.dinero += cantidad;
    }
    // Declaración del método para restar dinero de la caja
    public void restarDinero(int cantidad) {
    	this.dinero -= cantidad;
    }
    
    // Metodo para agregar una venta
    public void agregarVenta(Producto producto, Integer cantidadVenta){
        if(this.historialVentas.containsKey(producto)){
            this.historialVentas.put(producto, this.historialVentas.get(producto) + cantidadVenta);
        }else{
            this.historialVentas.put(producto, cantidadVenta);
        }
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
		this.historialVentas = historialVentas;
	}

}
