package gestorAplicacion.producto;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.*;
import gestorAplicacion.empresa.Ingrediente;

public abstract class Producto implements Serializable, IProductoIngrediente {
    private String nombre;
    private int espacioAlmacenamiento;
	private HashMap<Ingrediente, Integer> ingredientesNecesarios;
    private String ID;
    private int precio;
    private int peso;
    private int diasBodega;
    private int tiempoProduccion;
    private int diasDeProduccion;
    private boolean asignadoAEnvio=false;

    public Producto(String nombre, int espacioAlmacenamiento, HashMap<Ingrediente, Integer> ingredientesNecesarios, int precioBase,
                    String ID, int peso) {
        this.nombre = nombre;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        this.ingredientesNecesarios = ingredientesNecesarios;
        this.precio = this.calcularPrecio(precioBase);
        this.ID = ID;
        this.peso = peso;
        this.setDiasBodega(0);
       
    }

	public int getEspacioAlmacenamiento() {
		return espacioAlmacenamiento;
	}

	public void setEspacioAlmacenamiento(int espacioAlmacenamiento) {
		this.espacioAlmacenamiento = espacioAlmacenamiento;
	}

	public HashMap<Ingrediente, Integer> getIngredientesNecesarios() {
		return ingredientesNecesarios;
	}

	public void setIngredientesNecesarios(HashMap<Ingrediente, Integer> ingredientesNecesarios) {
		this.ingredientesNecesarios = ingredientesNecesarios;
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
	
	public int getDiasDeProduccion() {
		return diasDeProduccion;
	}

	public void setDiasDeProduccion(int diasDeProduccion) {
		this.diasDeProduccion = diasDeProduccion;
	}

	public int getDiasBodega() {
		return diasBodega;
	}

	public void setDiasBodega(int diasBodega) {
		this.diasBodega = diasBodega;
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
    

    public boolean isAsignadoAEnvio() {
		return asignadoAEnvio;
	}

	public void setAsignadoAEnvio(boolean asignadoAEnvio) {
		this.asignadoAEnvio = asignadoAEnvio;
	}

	/*
     * 	Metodo que retorna un String con los ingredientes y su correspondiente cantidad que 
     *  necesita un Producto
     */
    public String listarIngredientesNecesarios(){
    	StringBuilder str = new StringBuilder();
    	this.ingredientesNecesarios.forEach((Ingrediente ingrediente, Integer cantidad)->{
    		str.append("Necesita la cantidad de " + cantidad.toString() + " " + ingrediente.getNombre() + ".\n");
    	});
    	return str.toString();
    };
    
    
    /*
     * 	Metodo que calcula el precio de un producto, recibiendo como parametro un precio base 
     * 	y retorna la suma de este precio con el precio de todos sus ingredientes.
     */
    @Override
    public int calcularPrecio(int precioBase) {
    	AtomicInteger precio = new AtomicInteger((precioBase >= 0)? precioBase : 0);
    	this.ingredientesNecesarios.forEach((Ingrediente ingrediente, Integer cantidad)->{
    		precio.addAndGet(ingrediente.getPrecio()*cantidad);
    	});
    	return precio.get();
    }
    
    public String toString() {
    	String saltoLinea = "\n";
    	StringBuilder str = new StringBuilder("-".repeat(50) + saltoLinea);
    	str.append("Nombre: " + this.getNombre() + saltoLinea);
    	str.append("Espacio almacenamiento: " + this.getEspacioAlmacenamiento() + saltoLinea);
    	str.append("ID: " + this.getID() + saltoLinea);
    	String[] ingredientesNecesarios = this.listarIngredientesNecesarios().split(saltoLinea);
    	str.append("Ingredientes Necesarios: \n");
    	for(String ingrediente: ingredientesNecesarios) {
    		str.append("\t" + ingrediente + "\n");
    	}
    	str.append("Precio: " + this.getPrecio() + saltoLinea);
    	str.append("Peso: " + this.getPeso() + saltoLinea);
    	str.append("Dias en bodega: " + this.getDiasBodega() + saltoLinea);
    	str.append("Tiempo de produccion: " + this.getTiempoProduccion() + saltoLinea);
    	str.append("Dias de produccion: " + this.getDiasDeProduccion() + saltoLinea);
    	
    	return str.toString();
    }
    
    /*
     * Metodo abstracto para que las clases hijas las implementen con sus respectivos
     * atributos
     */
    public abstract String listaCaracteristicas();
    
	//Metodos de Clase: Obtener/Eliminar Productos

}

