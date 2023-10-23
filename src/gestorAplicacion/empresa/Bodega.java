package gestorAplicacion.empresa;
import java.util.Scanner;

import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;

public class Bodega implements Serializable {
	private String identificador;
	private HashMap<Producto, Integer> contabilidadProductos = new HashMap<>();//se crearon estas dos variablea aparte para darle contabilidad a los productos en bodega dado que facilita la creacion de ingredientes y/o productos
	private int espacioAlmacenamiento;
	private HashMap<String, Integer> contabilidadIngredientes = new HashMap<>();
	//public static int cantidadProductosTotales; No esta en uso*
	private List<Producto> productos =new ArrayList<Producto>();	
	private List<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
    
	public Bodega(String identificador, HashMap<String, Integer> contabilidadProductos,int espacioAlmacenamiento,
			HashMap<String, Integer>contabilidadIngredientes,List<Producto> productos,List<Ingrediente> ingredientes) {
		this.identificador = identificador;
		this.contabilidadIngredientes=contabilidadProductos;
		this.contabilidadIngredientes=contabilidadIngredientes;
		this.espacioAlmacenamiento = espacioAlmacenamiento;
		this.productos=productos;
		this.ingredientes=ingredientes;
		
		for (Producto producto:productos) {
			this.espacioAlmacenamiento-=producto.getEspacioAlmacenamiento();
		}
		for (Ingrediente ingrediente:ingredientes) {
			this.espacioAlmacenamiento-=ingrediente.getEspacioAlmacenamiento();
		}
		
		
		
		//cantidadProductosTotales = this.productos.size();
	}
	
	public boolean disponibilidadBodega(HashMap<Producto, Integer> tanda) {
		int suma=0;
		for (Entry<Producto, Integer> entry : tanda.entrySet()) {
	        Producto producto = entry.getKey();
	        int cantidadNecesaria = entry.getValue();
	        suma+=cantidadNecesaria;
		}
		if (suma >= this.espacioAlmacenamiento / 5) {
			return false;
		}else {
			return true;
		}
	}
	
	public void guardarEnBodega(HashMap<Producto, Integer> tanda) {
        for (Map.Entry<Producto, Integer> entry : tanda.entrySet()) {
            Producto producto = entry.getKey();
            Integer cantidad = entry.getValue();

            if (contabilidadProductos.containsKey(producto)) {
                // Si el producto ya existe en la contabilidad, actualiza la cantidad
                int cantidadActual = contabilidadProductos.get(producto);
                contabilidadProductos.put(producto, cantidadActual + cantidad);
            } else {
                // Si el producto no existe en la contabilidad, agrégalo
                contabilidadProductos.put(producto, cantidad);
            }
        }
    }
	
	public boolean verificarTandaBodega(HashMap<Producto, Integer> tanda) {
		int suma=0;
		for (Entry<Producto, Integer> entry : tanda.entrySet()) {
            Producto producto = entry.getKey();
            int cantidadNecesaria = entry.getValue();
            suma+=cantidadNecesaria;
		}
		if (suma>this.espacioAlmacenamiento) {
			return false;
		}else {
			return true;
		}
	}
	
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
	
	/* Mostrar ingredientes escasos generara una lista con aquellos ingredientes 
	*  menores de 10 en la variable contabilidad ingredientes
	*/
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
   
    /*
     *   Metodo que retorna un String con los productos ordenados de manera descendente por el atributo
     *   diasBodega
     */
    public String stringProductosOrdenadosPorDiasBodega() {
    	List<Producto> productosOrdenados = this.productosOrdenadosPorDiasBodega();
    	StringBuilder result = new StringBuilder("Estancia de Productos en Bodega (Orden por Días en Bodega):\n");
    	for (Producto producto : productosOrdenados) {
            int tiempoEnBodega = producto.getDiasBodega();
            String nombreProducto = producto.getNombre();
            result.append("Producto: ").append(nombreProducto).append(", Tiempo en Bodega: ").append(tiempoEnBodega).append(" días\n");
        }
    	return result.toString();
    }
    
    /*
     * Metodo que retorna una lista de productos ordenados por dias en bodega
     */
    public List<Producto> productosOrdenadosPorDiasBodega() {
    	List<Producto> productosOrdenados = new ArrayList<Producto>(this.productos);
    	productosOrdenados.sort((Producto p1, Producto p2) -> Integer.compare(p2.getDiasBodega(), p1.getDiasBodega()));
    	
    	return productosOrdenados;
    }

    /*
     * Metodo para actualizar la produccion y los precios en base a 
     * sus ventas y dias en bodega respectivamente. Se sobrecarga el
     * metodo para cuando solo desea actualizar su precio no se necesario
     * recibir la fabrica como parametro
     */
    public String actualizarProduccionPrecio(boolean actualizarProduccion, boolean actualizarPrecio) {
    	try {
    		String msg = "";
	    	if(actualizarPrecio) {
	    		msg += this.actualizarPrecioBaseDiasBodega() + "\n";
	    	}
	    	return msg;
    	}catch(Exception e) {
    		return "Ha ocurrido un error.";
    	}
    }
    
    public String actualizarProduccionPrecio(boolean actualizarProduccion, boolean actualizarPrecio, 
    		Fabrica fabrica) {
    	try {
    		String msg = "";
	    	if(actualizarProduccion) {
	    		msg += this.actualizarProduccionBaseVentas(fabrica) + "\n";
	    	}
	    	if(actualizarPrecio) {
	    		msg += this.actualizarPrecioBaseDiasBodega() + "\n";
	    	}
	    	return msg;
    	}catch(Exception e) {
    		return "Ha ocurrido un error.";
    	}
    }
    
    /*
     * Metodo que actualiza la produccion de los productos en base a sus ventas 
     * con respecto al mas vendido. 
     */
    public String actualizarProduccionBaseVentas(Fabrica fabrica) {
    	try {
	    	List<Producto> productos = Caja.historialVentasOrganizado();
	    	HashMap<Producto, Integer> produccion = fabrica.getProduccionDiaria();
	    	Producto productoMayorVendido = productos.get(0);
	    	
	    	for(int i = 0; i < productos.size(); i++) {
	    		Producto producto = productos.get(i);
	    		
	    		if(i != 0) {
	    			if(produccion.get(productoMayorVendido) > produccion.get(producto)) {
	    				produccion.put(producto, (int) (produccion.get(producto) * 0.85));
	    			}else {
	    				produccion.put(producto, (int) (produccion.get(producto) * 0.70));
	    			}
	    		}
	    	}
	    	fabrica.setProduccionDiaria(produccion);
	    	return "Produccion actualizada en base a las ventas de los productos.";
    	}catch(Exception e) {
	    	return "Ocurrió un error al actualizar la producción.";
	    }
    }
    
    /*
     * Metodo que actualiza el precio de los productos en base a sus dias en bodega. 
     */
    public String actualizarPrecioBaseDiasBodega() {
    	try {
    		List<Producto> productos = this.productosOrdenadosPorDiasBodega();
    		for(Producto producto: productos) {
    			if(producto.getDiasBodega() >= 5) {
    				producto.setPrecio((int) (producto.getPrecio() * 0.50));
    			}
    		}
    		return "Se ha actualizado correctamente los precios con respecto a sus dias en bodega.";
    	}catch(Exception e) {
    		return "Ha ocurrido un error.";
    	}
    }
    
    // se añade un nuevo metodo para la funcionalidad #2 para descontar la materia prima
    public void descontarMateriaPrimaNecesaria(HashMap<Ingrediente, Integer> ingredientesRequeridos, int cantidadProduccion) {
        List<Ingrediente> inventarioIngredientes = this.getIngredientes();

        for (Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
            Ingrediente nombreIngrediente = entry.getKey();
            int cantidadNecesaria = entry.getValue();
            boolean ingredienteEncontrado = false;

            for (Ingrediente ingredienteEnInventario : inventarioIngredientes) {
                if (ingredienteEnInventario.getNombre().equals(nombreIngrediente)) {
                    ingredienteEncontrado = true;

                    if (ingredienteEnInventario.getCantidad() >= cantidadNecesaria) {
                        ingredienteEnInventario.setCantidad(ingredienteEnInventario.getCantidad() - cantidadNecesaria);
                    } else {
                        System.out.println("No hay suficiente cantidad de " + nombreIngrediente + " en la bodega.");
                    }
                    break;
                }
            }

            if (!ingredienteEncontrado) {
                System.out.println("El ingrediente " + nombreIngrediente + " no está disponible en la bodega.");
            }
        }

        // Actualizar la lista de ingredientes en la bodega después del descuento
        this.setIngredientes(inventarioIngredientes);
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
		//cantidadProductosTotales = this.productos.size();
	}

	public int getEspacioAlmacenamiento() {
		return espacioAlmacenamiento;
	}

	public void setEspacioAlmacenamiento(int espacioAlmacenamiento) {
		this.espacioAlmacenamiento = espacioAlmacenamiento;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> listaMateriaPrimaActual) {
		this.ingredientes = listaMateriaPrimaActual;
	}

	public HashMap<Producto, Integer> getContabilidadProductos() {
		return contabilidadProductos;
	}
	public void setContabilidadProductos(HashMap<Producto, Integer> contabilidadProductos) {
		this.contabilidadProductos = contabilidadProductos;
	}
	public HashMap<String, Integer> getContabilidadIngredientes() {
		return contabilidadIngredientes;
	}
	public void setContabilidadIngredientes(HashMap<String, Integer> contabilidadIngredientes) {
		this.contabilidadIngredientes = contabilidadIngredientes;
	}
}


