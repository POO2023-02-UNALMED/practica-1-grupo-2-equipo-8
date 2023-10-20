package empresa;
import java.util.List;
import java.util.ArrayList;
public class Ingrediente {
	
    private String nombre; 
    private int costo;
    private final long identificador;
    private int espacioAlmacenamiento;//espacio que ocupara el producto en bodega
    static private List<Ingrediente> ingredientesDisponibles;//Estatico debido a que cuando se crea un ingrediente con un nombre diferente a los ya existentes a la lista se agrega uno nuevo
    
    
//Constructor
    public Ingrediente(String nombre, int costo, long identificador, int espacioAlmacenamiento ) {
        this.nombre = nombre;
        this.costo = costo;
        this.identificador = identificador;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        // Verifica si ingredientesDisponibles es null y, si lo es, inicializa la lista
        if (Ingrediente.ingredientesDisponibles == null) {
            Ingrediente.ingredientesDisponibles = new ArrayList<Ingrediente>();}
        
//      Este boolean se usará para saber si un ingrediente se crea dos veces que solo aparezca una vez en la lista  
        boolean ingredienteDuplicado = false;
        
        // Itera sobre la lista de ingredientes disponibles para buscar duplicados
        for (Ingrediente ingrediente : Ingrediente.ingredientesDisponibles) {
            if (ingrediente.getNombre().equals(this.nombre)) {
                // Ya existe un ingrediente con el mismo nombre
                ingredienteDuplicado = true;
                break;
            }
        }
        
        // Si no se encontró un ingrediente duplicado, agrega el nuevo ingrediente
        if (!ingredienteDuplicado) {
            Ingrediente.ingredientesDisponibles.add(this);
        }
    }
//Función para printear la lista de manera organizada e indexada
    public static String obtenerListaIngredientes() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Lista de ingredientes disponibles:\n\n");
        int numeracion = 1;

        for (Ingrediente ingrediente : Ingrediente.ingredientesDisponibles) {
            resultado.append(numeracion).append(". ").append(ingrediente.getNombre()).append(" - Costo: $").append(ingrediente.getCosto())
                    .append(" - Espacio de almacenamiento: ").append(ingrediente.getEspacioAlmacenamiento()).append("\n");
            numeracion++;
        }

        return resultado.toString();
    }



    //Setters y getters
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

    
}
