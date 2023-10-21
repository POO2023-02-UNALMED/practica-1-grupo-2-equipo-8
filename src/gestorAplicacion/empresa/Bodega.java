package gestorAplicacion.empresa;

import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Bodega implements Serializable {
	private String identificador;
	private HashMap<String, Integer> contabilidadProductos = new HashMap<>();//se crearon estas dos variablea aparte para darle contabilidad a los productos en bodega dado que facilita la creacion de ingredientes y/o productos
	private int espacioAlmacenamiento;
	private HashMap<String, Integer> contabilidadIngredientes = new HashMap<>();
	private static int cantidadProductosTotales;
	private List<Producto> productos =new ArrayList<Producto>();	
	private List<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
	
//	¿Para qué hacer esto?, en bodega con el historial de ventas se puede sacar esta info
//	private List<String> listaProductosAltaDemanda;
//    private List<String> listaProductosBajaDemanda;
    
 // Mostrar ingredientes escasos generara una lista con aquellos ingredientes menores de 10 en la variable contabilidad ingredientes

    public String mostrarIngredientesEscasos() {
    	StringBuilder resultado = new StringBuilder("Ingredientes escasos:\n");

        for (String ingrediente : contabilidadIngredientes.keySet()) {
            int cantidad = contabilidadIngredientes.get(ingrediente);
            if (cantidad < 10) {
                resultado.append(ingrediente).append(": ").append(cantidad).append("\n");
            }
        }

        return resultado.toString();
    }
///////////////////////////////////////////////////////////////////////////////
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

    public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getEspacioAlmacenamiento() {
		return espacioAlmacenamiento;
	}

	public void setEspacioAlmacenamiento(int espacioAlmacenamiento) {
		this.espacioAlmacenamiento = espacioAlmacenamiento;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes){
		this.ingredientes = ingredientes;
	}

	public static int getCantidadProductosTotales() {
		return cantidadProductosTotales;
	}

	public static void setCantidadProductosTotales(int cantidadProductosTotales) {
		Bodega.cantidadProductosTotales = cantidadProductosTotales;
	}
	public HashMap<String, Integer> getContabilidadProductos() {
		return contabilidadProductos;
	}
	public void setContabilidadProductos(HashMap<String, Integer> contabilidadProductos) {
		this.contabilidadProductos = contabilidadProductos;
	}
	public HashMap<String, Integer> getContabilidadIngredientes() {
		return contabilidadIngredientes;
	}
	public void setContabilidadIngredientes(HashMap<String, Integer> contabilidadIngredientes) {
		this.contabilidadIngredientes = contabilidadIngredientes;
	}



}


