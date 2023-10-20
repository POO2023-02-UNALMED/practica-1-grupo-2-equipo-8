package gestorAplicacion.producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Producto {
    private String nombre;
    private int espacioAlmacenamiento;
    

	private HashMap<String, Integer> ingredientesNecesarios;
    private int costo;
    private String ID;
    private int precio;
    private int peso;
    private int diasVencimiento;
    private int tiempoProduccion;

    public Producto(String nombre, int espacioAlmacenamiento, HashMap<String, Integer> ingredientesNecesarios, int costo,
                    String ID, int precio, int peso, int diasVencimiento, int tiempoProduccion) {
        this.nombre = nombre;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        this.ingredientesNecesarios = ingredientesNecesarios;
        this.costo = costo;
        this.ID = ID;
        this.precio = precio;
        this.peso = peso;
        this.diasVencimiento(diasVencimiento);
        this.tiempoProduccion = tiempoProduccion;
    }

    public Producto(String nombre2, int espacioAlmacenamiento2, HashMap<String, Integer> ingredientesNecesarios2,
			int costo2, String iD2, int precio2, int peso2, int diasEnBodega, String fechaVencimiento,
			int tiempoProduccion2) {
	}

	public int getEspacioAlmacenamiento() {
		return espacioAlmacenamiento;
	}

	public void setEspacioAlmacenamiento(int espacioAlmacenamiento) {
		this.espacioAlmacenamiento = espacioAlmacenamiento;
	}

	public HashMap<String, Integer> getIngredientesNecesarios() {
		return ingredientesNecesarios;
	}

	public void setIngredientesNecesarios(HashMap<String, Integer> ingredientesNecesarios) {
		this.ingredientesNecesarios = ingredientesNecesarios;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}


	public int getTiempoProduccion() {
		return tiempoProduccion;
	}

	public void setTiempoProduccion(int tiempoProduccion) {
		this.tiempoProduccion = tiempoProduccion;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static List<String> MostrarProductos(List<Producto> productos) {
        List<String> listaProductos = new ArrayList<>();
        for (Producto producto : productos) {
            listaProductos.add("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
        return listaProductos;
    }
    
    public int diasVencimiento(int diasTranscurridos) {
        return (diasTranscurridos > this.diasVencimiento) ? 0 : this.diasVencimiento - diasTranscurridos;
    }

	//Metodos de Clase: Obtener/Eliminar Productos

}

