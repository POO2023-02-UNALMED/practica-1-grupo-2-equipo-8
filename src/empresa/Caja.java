package empresa;
import producto.Producto;
import java.util.HashMap;

public class Caja {
	static private int dinero;
	static private HashMap<Producto, Integer> historialVentas = new HashMap<>();

    // Declaración del método para mostrar el historial de compras
    public void verHistorialCompras() {
    	
    }

    // Declaración del método para ingresar dinero en la caja
    public void ingresarDinero(int cantidad) {
    	Caja.dinero+=cantidad;
    	
    }
    // Declaración del método para restar dinero de la caja
    public void restarDinero(int cantidad) {
    	Caja.dinero+=cantidad;
    	
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
		this.historialVentas = historialVentas;
	}

}
