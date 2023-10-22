package gestorAplicacion.empresa;
import java.util.Scanner;

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
	private List<Producto> productos =new ArrayList<Producto>();	
	private List<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
	
	
//	¿Para qué hacer esto?, en bodega con el historial de ventas se puede sacar esta info
//	private List<String> listaProductosAltaDemanda;
//    private List<String> listaProductosBajaDemanda;
    
	//Retorna los productos no asignados a un envio IMPORTANTE PARA FUNCIONALIDAD 5
	public String productosNoasignadosAEnvios() {
	    StringBuilder resultado = new StringBuilder();

	    for (Producto producto : productos) {
	        if (!producto.isAsignadoAEnvio()) {
	            resultado.append(producto.toString()).append("\n");
	        }
	    }

	    return resultado.toString();
	}
	
	public void pedirCantidadIngredientes() {
	    Scanner scanner = new Scanner(System.in);

	    // Solicitar al usuario que elija un ingrediente
	    System.out.print("Seleccione el número correspondiente al ingrediente que desea pedir: ");
	    int opcion = scanner.nextInt();

	    if (opcion < 1 || opcion > Ingrediente.getIngredientesDisponibles().size()) {
	        System.out.println("Opción no válida. Seleccione un número válido.");
	        scanner.close();
	        return;
	    }

	    // Obtener el ingrediente seleccionado
	    Ingrediente ingredienteSeleccionado = Ingrediente.getIngredientesDisponibles().get(opcion - 1);

	    // Solicitar la cantidad deseada
	    System.out.print("¿Cuántos " + ingredienteSeleccionado.getNombre() + " desea pedir? ");
	    int cantidadPedida = scanner.nextInt();

	    // Crear la cantidad de ingredientes solicitados
	    for (int i = 0; i < cantidadPedida; i++) {
	        Ingrediente nuevoIngrediente = new Ingrediente(ingredienteSeleccionado.getNombre());
	        ingredientes.add(nuevoIngrediente);
	        contabilidadIngredientes.merge(ingredienteSeleccionado.getNombre(), 1, Integer::sum);
	    }
}
	
	
	
	
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
    	
    // Confirmar disponibilidad de ingredientes
    //public void confirmarDisponibilidadIngredientes(List<String> listaIngredientes) {
        // Implementa la lógica para confirmar la disponibilidad de ingredientes en base a la lista
        // Puedes utilizar el HashMap y las listas para verificar la disponibilidad
    

    // Calcular productos veces no disponibles
    //public int calcularProductosVecesNoDisponibles() {
        // Implementa la lógica para calcular la cantidad de veces que los productos no estuvieron disponibles
        // Puedes utilizar el HashMap y las listas para realizar este cálculo
        //return 0; // Reemplaza con el cálculo real
//}

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


