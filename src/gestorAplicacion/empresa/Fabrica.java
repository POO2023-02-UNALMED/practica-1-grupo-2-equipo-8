package gestorAplicacion.empresa;
import java.util.Scanner;
import gestorAplicacion.producto.Tortas;
import gestorAplicacion.producto.Producto;
import java.io.*;
import java.util.HashMap;
import gestorAplicacion.producto.*;

public class Fabrica implements Serializable {
	//Atributos
    private final String NIT;
    private String direccion;
    private HashMap<String, Integer> produccionDiaria;
    private Bodega bodega;
    
    //Constructor
    public Fabrica(String NIT, String direccion, Bodega bodega)  {
        this.NIT = NIT;
        this.direccion = direccion;
        this.produccionDiaria = new HashMap<String, Integer>();
        this.bodega = bodega;
    }
    
    //Muestra lo que se produce actualmente de cada producto, se elige que producto cambiarle la cantidad y se muestra el cambio.
    public String cambiarProduccion() {
    	//Eleccion
        Scanner scanner = new Scanner(System.in);

        System.out.println("Producción diaria actual:");
        int index = 1;
        for (String producto : produccionDiaria.keySet()) {
            int cantidad = produccionDiaria.get(producto);
            System.out.println(index + ". " + producto + ": " + cantidad);
            index++;
        }

        System.out.println("Ingrese el número correspondiente al producto para cambiar la producción:");
        int numeroProducto = scanner.nextInt();

        int currentIndex = 1;
        String productoSeleccionado = null;

        for (String producto : produccionDiaria.keySet()) {
            if (currentIndex == numeroProducto) {
                productoSeleccionado = producto;
                break;
            }
            currentIndex++;
        }
        //Ingreso de nuevo nivel de producción para el producto seleccionado

        if (productoSeleccionado != null) {
            int cantidadVieja = produccionDiaria.get(productoSeleccionado);
            System.out.println("Ingrese la nueva cantidad de producción para " + productoSeleccionado + ":");
            int nuevaCantidad = scanner.nextInt();
            produccionDiaria.put(productoSeleccionado, nuevaCantidad);
            scanner.close();
            return imprimirCambiosFabrica(cantidadVieja, nuevaCantidad, productoSeleccionado);
        } else {
            scanner.close();
            return "Número de producto no válido.";
        }
    }
    //Funcion usada para la función anterior
    public String imprimirCambiosFabrica(int cantidadVieja, int cantidadNueva, String producto) {
        return "Ha cambiado su nivel de producción de: " + cantidadVieja + " a: " + cantidadNueva + " del producto: " + producto; 
    }
    
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
//Funcion para reutilizar en la función anterior que me actualiza los ingredientes
    private void actualizarContabilidadIngredientes(HashMap<Ingrediente, Integer> ingredientes) {
        for (Ingrediente ingrediente : ingredientes.keySet()) {
            if (this.bodega.getContabilidadIngredientes().containsKey(ingrediente.getNombre())) {
                int valorARestar = ingredientes.get(ingrediente);
                int valorActual = this.bodega.getContabilidadIngredientes().get(ingrediente.getNombre());
                this.bodega.getContabilidadIngredientes().put(ingrediente.getNombre(), valorActual - valorARestar);
            }
        }
    }
}

