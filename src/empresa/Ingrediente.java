package empresa;
import java.util.List;
import compras.Producto;

public class Ingrediente implements Producto {
    private String nombre;
    private int costo;
    private final long identificador;
    private int espacioAlmacenamiento;
    private String fechaVencimiento;
    private List<Ingrediente> ingredientesDisponibles;

    public Ingrediente(String nombre, int costo, long identificador, int espacioAlmacenamiento, String fechaVencimiento) {
        this.nombre = nombre;
        this.costo = costo;
        this.identificador = identificador;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void mostrarListaIngredientes() {
        // Implementación para mostrar la lista de ingredientes disponibles
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public int getCosto() {
        return costo;
    }

    
    public long getIdentificador() {
        return identificador;
    }

    
    public int getEspacioAlmacenamiento() {
        return espacioAlmacenamiento;
    }

    
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
}
