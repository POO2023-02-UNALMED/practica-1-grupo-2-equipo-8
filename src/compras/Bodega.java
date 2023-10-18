package compras;
import java.util.HashMap;
import java.util.List;
import Producto;
import Ingrediente;

public class Bodega {
	private String identificador;
	private HashMap<Producto, Integer> productos = new HashMap<>();
	private int espacioAlmacenamiento;
	private HashMap<ingredientes, Integer> Ingredientes = new HashMap<>();
	private static int cantidadProductosTotales;
	private List<String> listaProductosAltaDemanda;
    private List<String> listaProductosBajaDemanda;
    
 // Mostrar ingredientes escasos
    public String mostrarIngredientesEscasos() {
        // Implementa la lógica para mostrar ingredientes escasos y devuelve una cadena
        // Puedes utilizar las listas y el HashMap para determinar ingredientes escasos
        return "Lista de ingredientes escasos: ...";
    }

    // Pedir cantidad de ingredientes
    public void pedirCantidadIngredientes() {
        // Implementa la lógica para pedir cantidad de ingredientes
        // Puedes utilizar las listas y el HashMap para llevar un seguimiento de los ingredientes
    }

    // Confirmar disponibilidad de ingredientes
    public void confirmarDisponibilidadIngredientes(List<String> listaIngredientes) {
        // Implementa la lógica para confirmar la disponibilidad de ingredientes en base a la lista
        // Puedes utilizar el HashMap y las listas para verificar la disponibilidad
    }

    // Calcular productos veces no disponibles
    public int calcularProductosVecesNoDisponibles() {
        // Implementa la lógica para calcular la cantidad de veces que los productos no estuvieron disponibles
        // Puedes utilizar el HashMap y las listas para realizar este cálculo
        return 0; // Reemplaza con el cálculo real
    }
}


