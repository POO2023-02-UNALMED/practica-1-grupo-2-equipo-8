package gestorAplicacion.empresa;
import java.util.Scanner;
import java.util.Map.Entry;

import gestorAplicacion.producto.Tortas;
import gestorAplicacion.producto.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestorAplicacion.producto.*;

public class Fabrica implements Serializable {
	//Atributos
    private final String NIT;
    private String direccion;
    private HashMap<Producto, Integer> produccionDiaria;
    private Bodega bodega;
    private static int espacioDisponibleBodega = 0;
    private int tiempoDemoraProduccion;
	private boolean produccionEnPausa;
	private static int codigoTandaActual = 1;
	private HashMap<Integer, String> registroTandas;
	private HashMap<Integer, List<Producto>> productosGenerados;
	private List<Bodega> otrasBodegas; // Otras bodegas de la empresa
    
    //Constructor
    public Fabrica(String NIT, String direccion, Bodega bodega)  {
        this.NIT = NIT;
        this.direccion = direccion;
        this.produccionDiaria = new HashMap<Producto, Integer>();
        this.bodega = bodega;
    }
    
    //Muestra lo que se produce actualmente de cada producto, se elige que producto cambiarle la cantidad y se muestra el cambio.
 
    public String ListarListaDeProduccion() {
        int index = 1;
        String cadena ="";
        for (Producto producto : produccionDiaria.keySet()) {//se puede cambiar por for (String producto, int index = 1 : produccionDiaria.keySet())
            int cantidad = produccionDiaria.get(producto);
            cadena+=(index + ". " + producto.getNombre() + ": " + cantidad + "$"+ producto.getPrecio()*cantidad +"\n");
            
        	for(Ingrediente ingrediente: producto.getIngredientesNecesarios().keySet()) {
        		cadena+=("\t" + ingrediente.getNombre() + " - " + ingrediente.getCantidad() +"\n");
        	}
        	
            index++;
        }
        return cadena;
    }
    
    
    

    public Producto ProductoParaCambiarEnLista(int numeroProducto) {

        int index = 1;
        Producto productoSeleccionado = null;

        for (Producto producto : produccionDiaria.keySet()) {
            if (index == numeroProducto) {
                productoSeleccionado = producto;
                break;
            }
            index++;
        }
        return productoSeleccionado;
    }
    
    public String cambiarProduccion(Producto productoSeleccionado, int nuevaCantidad) {

        //Ingreso de nuevo nivel de producción para el producto seleccionado    	
    	Scanner sc = new Scanner(System.in);
        if (productoSeleccionado != null) {
            int cantidadVieja = produccionDiaria.get(productoSeleccionado);
            produccionDiaria.put(productoSeleccionado, nuevaCantidad);
            sc.close();
            actualizarMateriaPrima(nuevaCantidad,productoSeleccionado);
            actualizarProduccionDiaria(productoSeleccionado, nuevaCantidad);
            
            return "Ha cambiado su nivel de producción de: " + cantidadVieja + " a: " + nuevaCantidad + " del producto: " + productoSeleccionado; 
        } else {
        	sc.close();
            return "Número de producto no válido.";
        }
    }
    //Funcion usada para la función anterior

    
    //Creación de productos y envio a bodega segun la produccionDiaria
    public void finalizarProduccion(HashMap<String, Integer> produccionDiaria) {
    	//Sumarle 1 día en bodega a todos los productos de bodega como se acuerda en el UML
    	for(Producto producto: this.bodega.getProductos()) {
    		producto.setDiasBodega(producto.getDiasBodega()+1);
    	}
    	//Recorra toda la lista de producción díaria
        for (String producto : produccionDiaria.keySet()) {
            int cantidad = produccionDiaria.get(producto);
            //Dependiendo de la cantidad de productos a producir ejecutese i veces
            for (int i = 0; i < cantidad; i++) {
            	//si es una torta de lo que hablamos hagame una torta
                if (producto.equals("torta")) {
                    // Ingredientes para la torta
                    HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<>();
                    ingredientesTorta.put(new Ingrediente("Harina", 5, 1234, 10), 2);
                    ingredientesTorta.put(new Ingrediente("Azúcar", 3, 1234, 5), 1);

                    // Crear un nuevo producto "Torta" y agregarlo a la bodega
                    Tortas nuevoProducto = new Tortas(producto, 5, ingredientesTorta, 20, "abc123", 3, 6, "chocolate");
                    this.bodega.getProductos().add(nuevoProducto);

                    // Actualizar la contabilidad de productos y de ingredientes en la bodega restamos los productos que utilizamos
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);
                    actualizarContabilidadIngredientes(ingredientesTorta);
                }
                
                //Similar en pastel frito
                else if (producto.equals("pastelFrito")) {
                    // Ingredientes para el pastelFrito
                    HashMap<Ingrediente, Integer> ingredientesPastelFrito = new HashMap<>();
                    ingredientesPastelFrito.put(new Ingrediente("Harina", 5, 1234, 10), 1);
                    ingredientesPastelFrito.put(new Ingrediente("Azúcar", 3, 1234, 5), 1);

                    // Crear un nuevo producto "PastelesFritos" y agregarlo a la bodega
                    PastelesFritos nuevoProducto = new PastelesFritos(producto, 5, ingredientesPastelFrito, 20, "dfg123", 3, false, "tomate");
                    this.bodega.getProductos().add(nuevoProducto);

                    // Actualizar la contabilidad de productos y de ingredientes en la bodega
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);
                    actualizarContabilidadIngredientes(ingredientesPastelFrito);
                }
                //Similar en galleta
                else if (producto.equals("galleta")) {
                    // Ingredientes para la galleta
                    HashMap<Ingrediente, Integer> ingredientesGalleta = new HashMap<>();
                    ingredientesGalleta.put(new Ingrediente("Harina", 5, 1234, 10), 1);
                    ingredientesGalleta.put(new Ingrediente("Azúcar", 3, 1234, 5), 3);

                    // Crear un nuevo producto "Galletas" y agregarlo a la bodega
                    Galletas nuevoProducto = new Galletas(producto, 5, ingredientesGalleta, 20, "dfg123", 3, false, "tomate");
                    this.bodega.getProductos().add(nuevoProducto);

                    // Actualizar la contabilidad de productos y de ingredientes en la bodega
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);
                    actualizarContabilidadIngredientes(ingredientesGalleta);
                }
                //similar en Dona
                else if (producto.equals("dona")) {
                    // Ingredientes para la dona
                    HashMap<Ingrediente, Integer> ingredientesDona = new HashMap<>();
                    ingredientesDona.put(new Ingrediente("Harina", 5, 1234, 10), 3);
                    ingredientesDona.put(new Ingrediente("Azúcar", 3, 1234, 5), 3);

                    // Crear un nuevo producto "Donas" y agregarlo a la bodega
                    Donas nuevoProducto = new Donas(producto, 5, ingredientesDona, 20, "dfg123", 3, false, "tomate");
                    this.bodega.getProductos().add(nuevoProducto);

                    // Actualizar la contabilidad de productos y de ingredientes en la bodega
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);
                    actualizarContabilidadIngredientes(ingredientesDona);
                }
            }
        }
    }
    
    
    
//Funcion para utilizar en la función anterior que me actualiza los ingredientes
    private void actualizarContabilidadIngredientes(HashMap<Ingrediente, Integer> ingredientes) {
        for (Ingrediente ingrediente : ingredientes.keySet()) {
            if (this.bodega.getContabilidadIngredientes().containsKey(ingrediente.getNombre())) {
                int valorARestar = ingredientes.get(ingrediente);
                int valorActual = this.bodega.getContabilidadIngredientes().get(ingrediente.getNombre());
                this.bodega.getContabilidadIngredientes().put(ingrediente.getNombre(), valorActual - valorARestar);
            }
        }
    }
    
    private HashMap<Ingrediente, Integer> obtenerIngredientesRequeridos() {
        HashMap<Ingrediente, Integer> ingredientesRequeridos = new HashMap<>();

        return ingredientesRequeridos;
    }
    
    public void actualizarMateriaPrima(int nuevaCantidad, Producto productoSeleccionado) {
        List<Ingrediente> listaMateriaPrimaActual = this.getBodega().getIngredientes();
        HashMap<Ingrediente, Integer> ingredientesRequeridos = obtenerIngredientesRequeridos();

        for (Map.Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            int cantidadRequerida = entry.getValue();
            int cantidadTotalNecesaria = cantidadRequerida * nuevaCantidad;

            for (Ingrediente ingredienteActual : listaMateriaPrimaActual) {
                if (ingredienteActual.equals(ingrediente)) {
                    int cantidadExistente = ingredienteActual.getCantidad();
                    ingredienteActual.setCantidad(cantidadExistente - cantidadTotalNecesaria);
                }
            }
        }

        this.getBodega().setIngredientes(listaMateriaPrimaActual);
    }

  //se añade un nuevo metodo para la funcionalida #2 para actualiizar la produccion diaria
    

    public void actualizarProduccionDiaria(Producto productoSeleccionado, int nuevaCantidad) {
        // Obtener la lista de producción diaria actual
        HashMap<Producto, Integer> produccionDiariaActual = this.getProduccionDiaria();

        // Actualizar la lista de producción diaria con la nueva cantidad
        produccionDiariaActual.put(productoSeleccionado, nuevaCantidad);

        // Establecer la lista de producción diaria actualizada
        this.setProduccionDiaria(produccionDiariaActual);
    }
    
    //se añade un nuevo metodo para la funcionalida #2 fabricar primera tanda
    

    public void fabricarTanda() {
    	int codigoTanda = generarCodigoTanda();
    	List<Producto> productosTanda = new ArrayList<>();
        for (Map.Entry<Producto, Integer> entry : this.produccionDiaria.entrySet()) {
        	Producto producto = entry.getKey();
            int cantidadProduccion = entry.getValue();

            int espacioDisponibleBodega = 0;
			// Verificar si hay espacio disponible en la bodega
            if (espacioDisponibleBodega >= cantidadProduccion) {
                // Verificar si hay suficientes ingredientes
                if (verificarDisponibilidadIngredientes(producto.getIngredientesNecesarios(), cantidadProduccion)) {
                    // Realizar la fabricación de la primera tanda
                    System.out.println("Se ha fabricado la primera tanda de " + cantidadProduccion + " unidades de " + producto);
                    // Ajustar la cantidad de ingredientes en la bodega después de la fabricación
                    ajustarInventarioIngredientes(producto.getIngredientesNecesarios(), cantidadProduccion);
                    // Reservar espacio en la bodega
                    espacioDisponibleBodega -= cantidadProduccion;
                } else {
                    System.out.println("No hay suficientes ingredientes para fabricar la primera tanda de " + producto);
                }
            } else {
                System.out.println("No hay suficiente espacio en la bodega para fabricar la primera tanda de " + producto);
                // Poner en pausa la producción hasta que haya suficiente espacio
                ponerEnPausaProduccion();
                return; // Salir del bucle y detener la fabricación
            }
            productosTanda.add(producto);
        }
     // Guardar los productos generados con su código de tanda
        productosGenerados.put(codigoTanda, productosTanda);
        
        
     // Registrar la tanda fabricada
        registroTandas.put(codigoTanda, "Tanda " + codigoTanda + " - " + produccionDiaria.toString());
        codigoTandaActual++;
    }
    
    private int generarCodigoTanda() {
        int codigoTanda = codigoTandaActual;
        codigoTandaActual++;
        return codigoTanda;
    }
    
    private void ponerEnPausaProduccion() {
        this.setProduccionEnPausa(true);
        while (Fabrica.espacioDisponibleBodega < 1) {
            try {
                // Espera 1 segundo antes de verificar nuevamente el espacio disponible en la bodega
                Thread.sleep(1000); // Se espera 1 segundo (1000 milisegundos)
                System.out.println("La producción está en pausa. Esperando espacio disponible en la bodega.");
                // Actualiza el valor de espacioDisponibleBodega desde la Bodega si es necesario
                Fabrica.espacioDisponibleBodega = this.getBodega().getEspacioAlmacenamiento();
            } catch (InterruptedException e) {
                // Manejo de excepciones si ocurre algún error durante la espera
                e.printStackTrace();
            }
        }
        this.setProduccionEnPausa(false);
        System.out.println("Se ha reanudado la producción.");
    }
    
    private boolean verificarDisponibilidadIngredientes(HashMap<Ingrediente, Integer> ingredientesRequeridos, int cantidadProduccion) {
        List<Ingrediente> inventarioIngredientes = this.getBodega().getIngredientes();

        // Convierte la lista de ingredientes en un mapa temporal para facilitar la verificación
        Map<String, Integer> inventarioMap = new HashMap<>();
        for (Ingrediente ingrediente : inventarioIngredientes) {
            inventarioMap.put(ingrediente.getNombre(), ingrediente.getCantidad());
        }

        // Verificar la disponibilidad de cada ingrediente necesario
        for (Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            int cantidadRequerida = entry.getValue() * cantidadProduccion; // Multiplicar la cantidad requerida por la producción diaria

            if (!inventarioMap.containsKey(ingrediente.getNombre()) || inventarioMap.get(ingrediente.getNombre()) < cantidadRequerida) {
                return false; // Devolver false si no hay suficiente cantidad del ingrediente en la bodega
            }
        }
        return true; // Devolver true si hay suficiente cantidad de todos los ingredientes en la bodega
    }

    private void ajustarInventarioIngredientes(HashMap<Ingrediente, Integer> ingredientesRequeridos, int cantidadProduccion) {
        List<Ingrediente> inventarioIngredientes = this.getBodega().getIngredientes();

        // Ajustar el inventario de ingredientes después de la fabricación
        for (Map.Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            int cantidadRequerida = entry.getValue() * cantidadProduccion; // Multiplicar la cantidad requerida por la producción diaria

            for (Ingrediente ingredienteActual : inventarioIngredientes) {
                if (ingredienteActual.equals(ingrediente)) {
                    int cantidadActual = ingredienteActual.getCantidad();
                    int cantidadRestante = cantidadActual - cantidadRequerida;
                    ingredienteActual.setCantidad(cantidadRestante);
                }
            }
        }

        // Actualizar el inventario de ingredientes en la bodega
        this.getBodega().setIngredientes(inventarioIngredientes);
    }
    
    public void establecerTiempoDemoraProduccion(int tiempoDemora) {
        this.setTiempoDemoraProduccion(tiempoDemora);
        System.out.println("El tiempo de demora de la producción se ha establecido en " + tiempoDemora + " minutos.");
    }
    
    public void gestionarEspacioBodega(HashMap<Producto, Integer> tanda) {
    	int suma=0;
		for (Entry<Producto, Integer> entry : tanda.entrySet()) {
            Producto producto = entry.getKey();
            int cantidadNecesaria = entry.getValue();
            suma+=cantidadNecesaria;
		}
        if (this.getBodega().getEspacioAlmacenamiento() >= suma) {
            // Si hay suficiente espacio en la bodega, reservar el espacio necesario
            this.getBodega().setEspacioAlmacenamiento(this.getBodega().getEspacioAlmacenamiento() - suma);
            System.out.println("Se ha reservado el espacio necesario en la bodega para los productos.");
        } else {
            // Si no hay suficiente espacio, poner en pausa la producción en la fábrica
            System.out.println("No hay suficiente espacio en la bodega. Se ha puesto en pausa la producción en la fábrica.");
        }
    }
    


    
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public HashMap<Producto, Integer> getProduccionDiaria() {
		return produccionDiaria;
	}

	public void setProduccionDiaria(HashMap<Producto, Integer> produccionDiaria) {
		this.produccionDiaria = produccionDiaria;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public static int getEspacioDisponibleBodega() {
		return espacioDisponibleBodega;
	}

	public static void setEspacioDisponibleBodega(int espacioDisponibleBodega) {
		Fabrica.espacioDisponibleBodega = espacioDisponibleBodega;
	}

	public int getTiempoDemoraProduccion() {
		return tiempoDemoraProduccion;
	}

	public void setTiempoDemoraProduccion(int tiempoDemoraProduccion) {
		this.tiempoDemoraProduccion = tiempoDemoraProduccion;
	}

	public boolean isProduccionEnPausa() {
		return produccionEnPausa;
	}

	public void setProduccionEnPausa(boolean produccionEnPausa) {
		this.produccionEnPausa = produccionEnPausa;
	}

	public static int getCodigoTandaActual() {
		return codigoTandaActual;
	}

	public static void setCodigoTandaActual(int codigoTandaActual) {
		Fabrica.codigoTandaActual = codigoTandaActual;
	}

	public HashMap<Integer, String> getRegistroTandas() {
		return registroTandas;
	}

	public void setRegistroTandas(HashMap<Integer, String> registroTandas) {
		this.registroTandas = registroTandas;
	}

	public HashMap<Integer, List<Producto>> getProductosGenerados() {
		return productosGenerados;
	}

	public void setProductosGenerados(HashMap<Integer, List<Producto>> productosGenerados) {
		this.productosGenerados = productosGenerados;
	}

	public List<Bodega> getOtrasBodegas() {
		return otrasBodegas;
	}

	public void setOtrasBodegas(List<Bodega> otrasBodegas) {
		this.otrasBodegas = otrasBodegas;
	}

	public String getNIT() {
		return NIT;
	}
    
    
}

