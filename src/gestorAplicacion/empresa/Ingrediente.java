package gestorAplicacion.empresa;
import java.util.List;
import java.util.ArrayList;

public class Ingrediente {
    private String nombre;
    private int costo;
    private final long identificador;
    private int espacioAlmacenamiento;
    private String fechaVencimiento;
    static private List<Ingrediente> ingredientesDisponibles;

    public Ingrediente(String nombre, int costo, long identificador, int espacioAlmacenamiento, String fechaVencimiento) {
        this.nombre = nombre;
        this.costo = costo;
        this.identificador = identificador;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        this.fechaVencimiento = fechaVencimiento;

        // Verifica si ingredientesDisponibles es null y, si lo es, inicializa la lista
        if (Ingrediente.ingredientesDisponibles == null) {
            Ingrediente.ingredientesDisponibles = new ArrayList<Ingrediente>();
        }

        Ingrediente.ingredientesDisponibles.add(this);
    }


    public static String obtenerListaIngredientes() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Lista de ingredientes disponibles:\n\n");
        int numeracion = 1;

        for (Ingrediente ingrediente : Ingrediente.ingredientesDisponibles) {
            resultado.append(numeracion).append(". ").append(ingrediente.getNombre()).append(" - Costo: $").append(ingrediente.getCosto())
                    .append(" - Espacio de almacenamiento: ").append(ingrediente.getEspacioAlmacenamiento()).append(" - Fecha de vencimiento: ")
                    .append(ingrediente.getFechaVencimiento()).append("\n");
            numeracion++;
        }

        return resultado.toString();
    }



    
    public static List<Ingrediente> getIngredientesDisponibles() {
		return ingredientesDisponibles;
	}

	public static void setIngredientesDisponibles(List<Ingrediente> ingredientesDisponibles) {
		Ingrediente.ingredientesDisponibles = ingredientesDisponibles;
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
