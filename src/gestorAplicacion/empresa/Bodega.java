package gestorAplicacion.empresa;

import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Bodega implements Serializable {
	private String identificador;
	private HashMap<String, Integer> contabilidadProductos = new HashMap<>();//se crearon estas dos variablea aparte para darle contabilidad a los productos en bodega dado que facilita la creacion de ingredientes y/o productos
	private int espacioAlmacenamiento;
	private HashMap<String, Integer> contabilidadIngredientes = new HashMap<>();
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
	}
	
	//Muestra las claves y los valores del hashmap lo cual es necesario en la funcionalidad 1
	public String mostrarContabilidadIngredientes() {
	    StringBuilder resultado = new StringBuilder();
	    resultado.append("Contabilidad de Ingredientes:\n");
	    
	    int numeracion = 1;
	    for (String ingrediente : contabilidadIngredientes.keySet()) {
	        int cantidad = contabilidadIngredientes.get(ingrediente);
	        resultado.append(numeracion).append(". ").append(ingrediente).append(" : ").append(cantidad).append("\n");
	        numeracion++;
	    }
	    
	    return resultado.toString();
	}
	
	//Importante para hacer funcionalidad 1.2
	public String mostrarProductos() {
	    StringBuilder sb = new StringBuilder();
	    int indice = 1;
	    for (Producto producto : productos) {
	        sb.append(indice).append(". ").append(producto.getNombre()).append(" - Precio: $").append(producto.getPrecio()).append("\n");
	        indice++;
	    }
	    return sb.toString();
	}
	
	//Retorna los productos no asignados a un envio IMPORTANTE PARA FUNCIONALIDAD 5
	public String productosNoAsignadosAEnvios() {
		StringBuilder resultado = new StringBuilder();

	    for (Producto producto : productos) {
	        if (!producto.isAsignadoAEnvio()) {
	            resultado.append(producto.toString()).append("\n");
	        }
	    }

	    return resultado.toString();
	}
	
	
	/*
	 * Realiza la compra de un ingrediente y automaticamente la agrega a la contabilidad de los ingredientes. 
	 * Retorna un String con un mensaje de confirmacion o en caso de error un mensaje de que ha fallado.
	 */
	public String pedirCantidadIngrediente(int opcion, int cantidadPedida, Administrador administrador) {
	    try{
	    	// Obtener el ingrediente seleccionado
	    	Ingrediente ingredienteSeleccionado = Ingrediente.getIngredientesDisponibles().get(opcion - 1);
	    	String nombreIngrediente = ingredienteSeleccionado.getNombre();

	    	if(!contabilidadIngredientes.containsKey(nombreIngrediente)) {
	    		contabilidadIngredientes.put(nombreIngrediente, 0);
	    	}else if(contabilidadIngredientes.get(nombreIngrediente) == null) {
	    		contabilidadIngredientes.put(nombreIngrediente, 1);
	    	}
	    	
	    	for (int i = 0; i < cantidadPedida; i++) {
	    		Ingrediente nuevoIngrediente = new Ingrediente(nombreIngrediente);
	    		ingredientes.add(nuevoIngrediente);
	    		contabilidadIngredientes.put(nombreIngrediente, contabilidadIngredientes.get(nombreIngrediente) + 1);
	    	}
	    
	    	administrador.getCaja().restarDinero(ingredienteSeleccionado.getPrecio()*cantidadPedida);
	    	String msg = "Se ha realizado el pedido con exito.\n";
	    	msg += "Nueva cantidad de "+ nombreIngrediente + ": " + this.getContabilidadIngredientes().get(nombreIngrediente);
	    	return msg;
	    	
	    	
	    }catch(Exception e) {
	    	return "Ha ocurrido un error, intentelo de nuevo mas tarde";
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
    public String actualizarProduccionPrecio(boolean actualizarPrecio) {
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
	    		if(i != 0 && produccion.get(producto) != null) {
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
    			if(producto.getDiasBodega() >= 5 && producto.getPrecio() > 1) {
    				producto.setPrecio((int) (Math.round(producto.getPrecio() * 0.50)));
    			}
    		}
    		return "Se ha actualizado correctamente los precios con respecto a sus dias en bodega.";
    	}catch(Exception e) {
    		return "Ha ocurrido un error.";
    	}
    }
    
    // se añade un nuevo metodo para la funcionalidad #2
    
    public void guardarEnBodega(HashMap<Producto, Integer> tanda) {
        tanda.forEach((Producto p, Integer cantidad) -> {
        	String nombreProducto = p.getNombre();
    	 if (contabilidadProductos.containsKey(nombreProducto)) {
             // Si el producto ya existe en la contabilidad, actualiza la cantidad
             int cantidadActual = contabilidadProductos.get(nombreProducto);
             contabilidadProductos.put(nombreProducto, cantidadActual + cantidad);
         } else {
             // Si el producto no existe en la contabilidad, agrégalo
             contabilidadProductos.put(nombreProducto, cantidad);
         }
        });
    }
    
    // se añade un nuevo metodo para la funcionalidad #2
    
    public boolean verificarTandaBodega(HashMap<Producto, Integer> tanda) {
		int suma=0;
		
		for (Map.Entry<Producto, Integer> entry : tanda.entrySet()) {
            int cantidadNecesaria = entry.getValue();
            suma+=cantidadNecesaria;
		}
		
		return !(suma > this.espacioAlmacenamiento);
	}
    
    // se añade un nuevo metodo para la funcionalidad #2
    
    public boolean disponibilidadBodega(HashMap<Producto, Integer> tanda) {
		int suma=0;
		
		for (Map.Entry<Producto, Integer> entry : tanda.entrySet()) {
	        int cantidadNecesaria = entry.getValue();
	        suma+=cantidadNecesaria;
		}
		
		return !(suma >= this.espacioAlmacenamiento / 5);
	}
    
    // se añade un nuevo metodo para la funcionalidad #2 para descontar la materia prima
    public String descontarMateriaPrimaNecesaria(HashMap<Ingrediente, Integer> ingredientesRequeridos, int cantidadProduccion) {
        String msg = "";
    	try{
    		List<Ingrediente> inventarioIngredientes = this.getIngredientes();
        
        
	        for (Map.Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
	            Ingrediente ingrediente = entry.getKey();
	            int cantidadNecesaria = entry.getValue();
	            boolean ingredienteEncontrado = false;
	
	            for (Ingrediente ingredienteEnInventario : inventarioIngredientes) {
	                if (ingredienteEnInventario.getNombre().equals(ingrediente.getNombre())) {
	                    ingredienteEncontrado = true;
	
	                    if (ingredienteEnInventario.getCantidad() >= cantidadNecesaria) {
	                        ingredienteEnInventario.setCantidad(ingredienteEnInventario.getCantidad() - cantidadNecesaria);
	                    } else {
	                        msg += "No hay suficiente cantidad de " + ingrediente.getNombre() + " en la bodega.";
	                    }
	                    break;
	                }
	            }
	
	            if (!ingredienteEncontrado) {
	                msg += "El ingrediente " + ingrediente.getNombre() + " no está disponible en la bodega.";
	            }
	        }
	
	        // Actualizar la lista de ingredientes en la bodega después del descuento
	        this.setIngredientes(inventarioIngredientes);
	        msg += "Se ha actualizado el inventario.";
    	}catch(Exception e) {
    		msg += "Ups! Algo salio mal";
    	}
    	return msg;
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
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> listaMateriaPrimaActual) {
		this.ingredientes = listaMateriaPrimaActual;
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


