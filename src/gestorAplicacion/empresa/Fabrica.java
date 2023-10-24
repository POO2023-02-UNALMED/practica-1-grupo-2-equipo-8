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
import java.util.concurrent.atomic.*;
import gestorAplicacion.producto.*;

public class Fabrica implements Serializable {
	// Atributos
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

	// Constructor
	public Fabrica(String NIT, String direccion, Bodega bodega) {
		this.NIT = NIT;
		this.direccion = direccion;
		this.produccionDiaria = new HashMap<Producto, Integer>();
		this.bodega = bodega;
	}

	public Boolean cambiarProduccion(Producto productoSeleccionado, int nuevaCantidad) {
		if (productoSeleccionado != null) {
			int cantidadVieja = produccionDiaria.get(productoSeleccionado);
			produccionDiaria.put(productoSeleccionado, nuevaCantidad);
			actualizarMateriaPrima(nuevaCantidad, productoSeleccionado);
			actualizarProduccionDiaria(productoSeleccionado, nuevaCantidad);
			return true;
		} else {
			return false;
		}
	}

	// Funcion usada para la función anterior
	public String imprimirCambiosFabrica(int cantidadVieja, int cantidadNueva, Producto productoSeleccionado) {
		return "Ha cambiado su nivel de producción de: " + cantidadVieja + " a: " + cantidadNueva + " del producto: "
				+ productoSeleccionado;
	}

	// Creación de productos y envio a bodega segun la produccionDiaria
	public void finalizarProduccion(HashMap<Producto, Integer> produccionDiaria) {
		// Sumarle 1 día en bodega a todos los productos de bodega como se acuerda en el
		// UML
		for (Producto producto : this.bodega.getProductos()) {
			producto.setDiasBodega(producto.getDiasBodega() + 1);
		}
		// Recorra toda la lista de producción diaria
		for (Producto producto : produccionDiaria.keySet()) {
			int cantidad = produccionDiaria.get(producto);
			// Dependiendo de la cantidad de productos a producir, ejecútese i veces
			for (int i = 0; i < cantidad; i++) {
				String nombreProducto = producto.getNombre(); // Obtener el nombre del producto
				// Si es una torta, se crea una torta
				if (nombreProducto.equals("torta")) {
					// Ingredientes para la torta
					HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<>();
					ingredientesTorta.put(new Ingrediente("harina", 5, 1234, 10), 1);
					ingredientesTorta.put(new Ingrediente("azucar", 3, 1234, 5), 1);

					// Crear un nuevo producto "Torta" y agregarlo a la bodega
					Tortas nuevoProducto = new Tortas(nombreProducto, 5, ingredientesTorta, 20, "abc123", 3, 6,
							"chocolate");
					this.bodega.getProductos().add(nuevoProducto);

					// Actualizar la contabilidad de productos y de ingredientes en la bodega
					// restamos los productos que utilizamos
					this.bodega.getContabilidadProductos().merge(nombreProducto, 1, Integer::sum);
					actualizarContabilidadIngredientes(ingredientesTorta);
				}
				// Similar para pastel frito
				else if (nombreProducto.equals("pastelFrito")) {
					// Ingredientes para el pastel frito
					HashMap<Ingrediente, Integer> ingredientesPastelFrito = new HashMap<>();
					ingredientesPastelFrito.put(new Ingrediente("harina", 5, 1234, 10), 1);
					ingredientesPastelFrito.put(new Ingrediente("azucar", 3, 1234, 5), 1);

					// Crear un nuevo producto "PastelesFritos" y agregarlo a la bodega
					PastelesFritos nuevoProducto = new PastelesFritos(nombreProducto, 5, ingredientesPastelFrito, 20,
							"dfg123", 3, false, "tomate");
					this.bodega.getProductos().add(nuevoProducto);

					// Actualizar la contabilidad de productos y de ingredientes en la bodega
					this.bodega.getContabilidadProductos().merge(nombreProducto, 1, Integer::sum);
					actualizarContabilidadIngredientes(ingredientesPastelFrito);
				}
				// Similar para galleta
				else if (nombreProducto.equals("galleta")) {
					// Ingredientes para la galleta
					HashMap<Ingrediente, Integer> ingredientesGalleta = new HashMap<>();
					ingredientesGalleta.put(new Ingrediente("harina", 5, 1234, 10), 1);
					ingredientesGalleta.put(new Ingrediente("azucar", 3, 1234, 5), 3);

					// Crear un nuevo producto "Galletas" y agregarlo a la bodega
					Galletas nuevoProducto = new Galletas(nombreProducto, 5, ingredientesGalleta, 20, "dfg123", 3,
							false, "vainilla");
					this.bodega.getProductos().add(nuevoProducto);

					// Actualizar la contabilidad de productos y de ingredientes en la bodega
					this.bodega.getContabilidadProductos().merge(nombreProducto, 1, Integer::sum);
					actualizarContabilidadIngredientes(ingredientesGalleta);
				}
				// Similar para Dona
				else if (nombreProducto.equals("dona")) {
					// Ingredientes para la dona
					HashMap<Ingrediente, Integer> ingredientesDona = new HashMap<>();
					ingredientesDona.put(new Ingrediente("harina", 5, 1234, 10), 3);
					ingredientesDona.put(new Ingrediente("azucar", 3, 1234, 5), 3);

					// Crear un nuevo producto "Donas" y agregarlo a la bodega
					Donas nuevoProducto = new Donas(nombreProducto, 5, ingredientesDona, 20, "dfg123", 3, false,
							"arquipe");
					this.bodega.getProductos().add(nuevoProducto);

					// Actualizar la contabilidad de productos y de ingredientes en la bodega
					this.bodega.getContabilidadProductos().merge(nombreProducto, 1, Integer::sum);
					actualizarContabilidadIngredientes(ingredientesDona);
				}
			}
		}
	}

	/*
	 * Metodo que actualiza la contabilidad de los ingredientes recibiendo como
	 * parametro un HashMap de ingredientes con sus cantidades a usar en la
	 * produccion de un producto.
	 */
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

		// realizar consultas a bases de datos o utilizar estructuras de datos
		// predefinidas para mapear los ingredientes requeridos para cada producto

		/**
		 * Ejemplo de lógica if (nombreProducto.equals("Producto1")) {
		 * ingredientesRequeridos.put(new Ingrediente("Ingrediente1"), 5);
		 * ingredientesRequeridos.put(new Ingrediente("Ingrediente2"), 3); } else if
		 * (nombreProducto.equals("Producto2")) { ingredientesRequeridos.put(new
		 * Ingrediente("Ingrediente3"), 4); ingredientesRequeridos.put(new
		 * Ingrediente("Ingrediente4"), 2); }
		 * 
		 **/
		return ingredientesRequeridos;
	}

	private void actualizarMateriaPrima(int nuevaCantidad, Producto productoSeleccionado) {
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

	// se añade un nuevo metodo para la funcionalida #2
	public String listarListaDeProduccion() {
		int index = 1;
		String cadena = "";
		for (Producto producto : produccionDiaria.keySet()) {// se puede cambiar por for (String producto, int index = 1
																// : produccionDiaria.keySet())
			int cantidad = produccionDiaria.get(producto);
			cadena += (index + ". " + producto.getNombre() + ": " + cantidad + " - $" + producto.getPrecio() * cantidad
					+ "\n");

			for (Ingrediente ingrediente : producto.getIngredientesNecesarios().keySet()) {
				cadena += ("\t" + ingrediente.getNombre() + " - "
						+ producto.getIngredientesNecesarios().get(ingrediente) * cantidad + "\n");
			}

			index++;
		}
		return cadena;
	}

	// se añade un nuevo metodo para la funcionalida #2

	public Producto productoParaCambiarEnLista(int numeroProducto) {
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

	// se añade un nuevo metodo para la funcionalida #2 para actualiizar la
	// produccion diaria
	public void actualizarProduccionDiaria(Producto productoSeleccionado, int nuevaCantidad) {
		// Obtener la lista de producción diaria actual
		HashMap<Producto, Integer> produccionDiariaActual = this.getProduccionDiaria();

		// Actualizar la lista de producción diaria con la nueva cantidad
		produccionDiariaActual.put(productoSeleccionado, nuevaCantidad);

		// Establecer la lista de producción diaria actualizada
		this.setProduccionDiaria(produccionDiariaActual);
	}

	// se añade un nuevo metodo para la funcionalida #2 fabricar primera tanda

	/*
	 * Metodo que realiza la fabricacion de la primera tanda de produccion de los
	 * productos guardados en el sistema, reajustando el inventario de los
	 * ingredientes y el espacio de la bodega. Recibe como parametros la produccion
	 * diaria de los productos y la lista de los ingredientes requeridos para la
	 * produccion. Retorna un mensaje sobre el estado de la produccion de la tanda.
	 */
	public int fabricarTanda() {
		int codigoTanda = generarCodigoTanda();
		List<Producto> productosTanda = new ArrayList<Producto>();

		if (this.getBodega().disponibilidadBodega(produccionDiaria)) {

			for (Map.Entry<Producto, Integer> entry : this.produccionDiaria.entrySet()) {
				Producto producto = entry.getKey();
				int cantidadProduccion = entry.getValue();

				if (verificarDisponibilidadIngredientes(producto.getIngredientesNecesarios(), cantidadProduccion)) {
					ajustarInventarioIngredientes(producto.getIngredientesNecesarios(), cantidadProduccion);
					espacioDisponibleBodega -= cantidadProduccion;
				} else {
					return 0;// No hay disponibilidad de ingredientes
				}

				productosTanda.add(producto);
			}

		} else {
			return 1;// No hay espacio en bodega
		}

		productosGenerados.put(codigoTanda, productosTanda);
		registroTandas.put(codigoTanda, "Tanda " + codigoTanda + " - " + produccionDiaria.toString());
		codigoTandaActual++;

		return 0;// Produccion exitosa
	}

	private int generarCodigoTanda() {
		int codigoTanda = codigoTandaActual;
		codigoTandaActual++;
		return codigoTanda;
	}

	private String ponerEnPausaProduccion() {
		this.setProduccionEnPausa(true);
		String msg = "";
		while (Fabrica.espacioDisponibleBodega < 1) {
			try {
				// Espera 1 segundo antes de verificar nuevamente el espacio disponible en la
				// bodega
				Thread.sleep(1000); // Se espera 1 segundo (1000 milisegundos)
				msg += "La producción está en pausa. Esperando espacio disponible en la bodega.\n";
				// Actualiza el valor de espacioDisponibleBodega desde la Bodega si es necesario
				Fabrica.espacioDisponibleBodega = this.getBodega().getEspacioAlmacenamiento();
			} catch (InterruptedException e) {
				// Manejo de excepciones si ocurre algún error durante la espera
				e.printStackTrace();
			}
		}
		this.setProduccionEnPausa(false);
		return msg + "Se ha reanudado la producción.";
	}

	private boolean verificarDisponibilidadIngredientes(HashMap<Ingrediente, Integer> ingredientesRequeridos,
			int cantidadProduccion) {
		List<Ingrediente> inventarioIngredientes = this.getBodega().getIngredientes();

		// Convierte la lista de ingredientes en un mapa temporal para facilitar la
		// verificación
		Map<String, Integer> inventarioMap = new HashMap<>();
		for (Ingrediente ingrediente : inventarioIngredientes) {
			inventarioMap.put(ingrediente.getNombre(), ingrediente.getCantidad());
		}

		// Verificar la disponibilidad de cada ingrediente necesario
		for (Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
			Ingrediente ingrediente = entry.getKey();
			int cantidadRequerida = entry.getValue() * cantidadProduccion; // Multiplicar la cantidad requerida por la
																			// producción diaria

			if (!inventarioMap.containsKey(ingrediente.getNombre())
					|| inventarioMap.get(ingrediente.getNombre()) < cantidadRequerida) {
				return false; // Devolver false si no hay suficiente cantidad del ingrediente en la bodega
			}
		}
		return true; // Devolver true si hay suficiente cantidad de todos los ingredientes en la
						// bodega
	}

	private void ajustarInventarioIngredientes(HashMap<Ingrediente, Integer> ingredientesRequeridos,
			int cantidadProduccion) {
		List<Ingrediente> inventarioIngredientes = this.getBodega().getIngredientes();

		// Ajustar el inventario de ingredientes después de la fabricación
		for (Map.Entry<Ingrediente, Integer> entry : ingredientesRequeridos.entrySet()) {
			Ingrediente ingrediente = entry.getKey();
			int cantidadRequerida = entry.getValue() * cantidadProduccion; // Multiplicar la cantidad requerida por la
																			// producción diaria

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

	public String establecerTiempoDemoraProduccion(int tiempoDemora) {
		this.setTiempoDemoraProduccion(tiempoDemora);
		return "El tiempo de demora de la producción se ha establecido en " + tiempoDemora + " minutos.";
	}

	public String gestionarEspacioBodega(HashMap<Producto, Integer> tanda) {
		int suma = 0;
		for (Entry<Producto, Integer> entry : tanda.entrySet()) {
			Producto producto = entry.getKey();
			int cantidadNecesaria = entry.getValue();
			suma += cantidadNecesaria;
		}
		if (this.getBodega().getEspacioAlmacenamiento() >= suma) {
			// Si hay suficiente espacio en la bodega, reservar el espacio necesario
			this.getBodega().setEspacioAlmacenamiento(this.getBodega().getEspacioAlmacenamiento() - suma);
			return "Se ha reservado el espacio necesario en la bodega para los productos.";
		} else {
			// Si no hay suficiente espacio, poner en pausa la producción en la fábrica
			return "No hay suficiente espacio en la bodega. Se ha puesto en pausa la producción en la fábrica.";
		}
	}

	public Boolean transferirProduccionOtraBodega(HashMap<Producto, Integer> tanda) {
		try {

			int suma = 0;
			for (Entry<Producto, Integer> entry : tanda.entrySet()) {
				int cantidadNecesaria = entry.getValue();
				suma += cantidadNecesaria;
			}
			for (Bodega bodega : otrasBodegas) {
				if (bodega.getEspacioAlmacenamiento() >= suma) {
					// Realizar la transferencia de producción a la otra bodega

					// Actualizar el espacio disponible en la bodega actual y en la otra bodega
					Fabrica.espacioDisponibleBodega += suma;
					bodega.setEspacioAlmacenamiento(bodega.getEspacioAlmacenamiento() - suma);
					bodega.guardarEnBodega(produccionDiaria);

				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Getters y Setters
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
