package gestorAplicacion.producto;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.*;
import gestorAplicacion.empresa.Ingrediente;



public abstract class Producto implements Serializable, IProductoIngrediente {
	
	//Atributos
    private String nombre;
    private int espacioAlmacenamiento;
	private HashMap<Ingrediente, Integer> ingredientesNecesarios;
    private String ID;
    private int precio;
    private int peso;
    private int diasBodega;
    private boolean asignadoAEnvio=false;

    
    //Constructor
    protected Producto(String nombre, HashMap<Ingrediente, Integer> ingredientesNecesarios, int precioBase,
                    String ID, int peso) {
    	
    	//Se calcula el espacio acumulado según se especifico en el UML
    	int espacioCalculado=0;
    	for (HashMap.Entry<Ingrediente, Integer> entry : ingredientesNecesarios.entrySet()) {
    		Ingrediente ingrediente = entry.getKey();
    		int cantidad=entry.getValue();
    		int pesoIngrediente=ingrediente.getEspacioAlmacenamiento();
    		espacioCalculado= cantidad* pesoIngrediente;
    		
    	}
    	double espacioCalculadoConAumento = espacioCalculado * 1.1;
    	int espacioAproximado = (int) Math.round(espacioCalculadoConAumento);
    	
    	
    	
    	
        this.nombre = nombre;
        this.espacioAlmacenamiento = espacioAproximado;
        this.ingredientesNecesarios = ingredientesNecesarios;
        this.precio = this.calcularPrecio(precioBase);
        this.ID = ID;
        this.peso = peso;
        this.setDiasBodega(0);
       
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
    
    //TOSTRING
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

    	
    	return str.toString();
    }
    
    /*
     * Metodo abstracto para que las clases hijas las implementen con sus respectivos
     * atributos
     */
    public abstract String listaCaracteristicas();
    
	//Metodos de Clase: Obtener/Eliminar Productos


    
    
    
    
    //Getters y setters
    
    
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


	public int getDiasBodega() {
		return diasBodega;
	}

	public void setDiasBodega(int diasBodega) {
		this.diasBodega = diasBodega;
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
}

    



