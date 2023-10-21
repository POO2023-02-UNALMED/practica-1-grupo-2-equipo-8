package empresa;
import java.util.List;

public class Ingrediente {
    private String nombre;
    private int costo;
    private long identificador;
    private int espacioAlmacenamiento;
    private String fechaVencimiento; // Este atributo es opcional
    private List<Ingrediente> ingredientesDisponibles;

    public Ingrediente(String nombre, int costo, long identificador, int espacioAlmacenamiento) {
        this.nombre = nombre;
        this.costo = costo;
        this.identificador = identificador;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        this.ingredientesDisponibles = null; // Inicializamos como nulo, debe ser establecido externamente
    }

    public void mostrarListaIngredientes() {
       
    }

    // Getters y Setters para los atributos
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

    public void setIngredientesDisponibles(List<Ingrediente> ingredientesDisponibles) {
        this.ingredientesDisponibles = ingredientesDisponibles;
    }
}

