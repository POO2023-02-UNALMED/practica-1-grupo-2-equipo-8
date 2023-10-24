package gestorAplicacion.empresa;
import java.util.List;

import gestorAplicacion.producto.IProductoIngrediente;

import java.io.Serializable;
import java.util.ArrayList;
public class Ingrediente implements IProductoIngrediente, Serializable{
	
    private int cantidad = 0;
	private String nombre; 
    private int precio;
    private final long identificador;
    private int espacioAlmacenamiento;//espacio que ocupara el producto en bodega
    static private ArrayList<Ingrediente> ingredientesDisponibles = new ArrayList<Ingrediente>();//Estatico debido a que cuando se crea un ingrediente con un nombre diferente a los ya existentes a la lista se agrega uno nuevo
    
    
    //Constructor
    public Ingrediente(String nombre, int precioBase, long identificador, int espacioAlmacenamiento ) {
        this.nombre = nombre;
        this.precio = calcularPrecio(precioBase);
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
//    Sobrecarga necesaria para hacer el pedido de insumos en bodega
    
    public Ingrediente(String nombre) {
        this.nombre = nombre;
        
        // Establecer valores predeterminados según el nombre del ingrediente
        switch (nombre.toLowerCase()) {
            case "harina":
                this.precio = calcularPrecio(2);  // Precio base para harina
                this.identificador = 1;  // Identificador para harina
                this.espacioAlmacenamiento = 10;  // Espacio de almacenamiento para harina
                break;
            case "huevos":
                this.precio = calcularPrecio(1);  // Precio base para huevos
                this.identificador = 2;  // Identificador para huevos
                this.espacioAlmacenamiento = 5;  // Espacio de almacenamiento para huevos
                break;
            case "azucar":
                this.precio = calcularPrecio(3);  // Precio base para azúcar
                this.identificador = 3;  // Identificador para azúcar
                this.espacioAlmacenamiento = 8;  // Espacio de almacenamiento para azúcar
                break;
            case "leche":
                this.precio = calcularPrecio(4);  // Precio base para leche
                this.identificador = 4;  // Identificador para leche
                this.espacioAlmacenamiento = 7;  // Espacio de almacenamiento para leche
                break;
            default:
                // Establecer valores predeterminados genéricos
                this.precio = calcularPrecio(1);
                this.identificador = 5;
                this.espacioAlmacenamiento = 5;
                break;
        }

        // Verificar si ingredientesDisponibles es null y, si lo es, inicializar la lista
        if (Ingrediente.ingredientesDisponibles == null) {
            Ingrediente.ingredientesDisponibles = new ArrayList<Ingrediente>();
        }
        
        // Usar un boolean para verificar duplicados
        boolean ingredienteDuplicado = false;
        
        // Iterar sobre la lista de ingredientes disponibles para buscar duplicados
        for (Ingrediente ingrediente : Ingrediente.ingredientesDisponibles) {
            if (ingrediente.getNombre().equals(this.nombre)) {
                // Ya existe un ingrediente con el mismo nombre
                ingredienteDuplicado = true;
                break;
            }
        }
        
        // Si no se encontró un ingrediente duplicado, agregar el nuevo ingrediente
        if (!ingredienteDuplicado) {
            Ingrediente.ingredientesDisponibles.add(this);
        }
    }

    
    
    
    
    
    
    /*
     * Metodo que retorna un String con la lista de ingredientes disponibles
     */
    
    //Muestra la lista de ingredientes disponibles importante para funcionalidad 1
    public static String obtenerListaIngredientes() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Lista de ingredientes disponibles:\n\n");
        int numeracion = 1;

        for (Ingrediente ingrediente : Ingrediente.ingredientesDisponibles) {
            resultado.append(numeracion).append(". ").append(ingrediente.getNombre()).append(" - precio: $").append(ingrediente.getPrecio())
                    .append(" - Espacio de almacenamiento: ").append(ingrediente.getEspacioAlmacenamiento()).append("\n");
            numeracion++;
        }

        return resultado.toString();
    }

    /*
     *  Metodo que retorna un int con el precio total de un ingrediente con IVA incluido, 
     *  recibiendo como parametro un coste base
     */
    @Override
    public int calcularPrecio(int precioBase) {
    	Double p = precioBase * 1.19;
    	return (int) Math.round(p);
    }
    

    //Setters y getters
    public static ArrayList<Ingrediente> getIngredientesDisponibles() {
		return ingredientesDisponibles;
	}

	public static void setIngredientesDisponibles(ArrayList<Ingrediente> ingredientesDisponibles) {
		Ingrediente.ingredientesDisponibles = ingredientesDisponibles;
	}

	public String getNombre() {
        return nombre;
    }

    
    public int getPrecio() {
        return precio;
    }
    
    
    public long getIdentificador() {
        return identificador;
    }

    
    public int getEspacioAlmacenamiento() {
        return espacioAlmacenamiento;
    }

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		
	}
   
}