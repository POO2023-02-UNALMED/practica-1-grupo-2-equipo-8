package gestorAplicacion.empresa;
import java.util.Scanner;
import gestorAplicacion.producto.Tortas;
import gestorAplicacion.producto.Producto;
import java.io.*;
import java.util.HashMap;
import gestorAplicacion.producto.*;

public class Fabrica implements Serializable {
    private final String NIT;
    private String direccion;
    private HashMap<String, Integer> produccionDiaria;
    private Bodega bodega;

    public Fabrica(String NIT, String direccion, Bodega bodega)  {
        this.NIT = NIT;
        this.direccion = direccion;
        this.produccionDiaria = new HashMap<String, Integer>();
        this.bodega = bodega;
    }

    public String cambiarProduccion() {
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

    public String imprimirCambiosFabrica(int cantidadVieja, int cantidadNueva, String producto) {
        return "Ha cambiado su nivel de producción de: " + cantidadVieja + " a: " + cantidadNueva + " del producto: " + producto; 
    }

    public void finalizarProduccion(HashMap<String, Integer> produccionDiaria) {
        for (String producto : produccionDiaria.keySet()) {
            for (int i = 0; i < produccionDiaria.get(producto); i++) {
                if (producto.equals("torta")) {
                    HashMap<Ingrediente, Integer> ingredientesTorta = new HashMap<>();
                    ingredientesTorta.put(new Ingrediente("Harina", 5, 1234, 10), 2);
                    ingredientesTorta.put(new Ingrediente("Azúcar", 3, 1234, 5), 1);

                    Tortas nuevoProducto = new Tortas(producto, 5, ingredientesTorta, 20, "abc123", 3, 6, "chocolate");
                    this.bodega.getProductos().add(nuevoProducto);
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);

                    for (Ingrediente ingrediente : ingredientesTorta.keySet()) {
                        if (this.bodega.getContabilidadIngredientes().containsKey(ingrediente.getNombre())) {
                            int valorARestar = ingredientesTorta.get(ingrediente);
                            int valorActual = this.bodega.getContabilidadIngredientes().get(ingrediente.getNombre());
                            this.bodega.getContabilidadIngredientes().put(ingrediente.getNombre(), valorActual - valorARestar);
                        }
                    }
                }
                else if (producto.equals("pastelFrito")) {
                    HashMap<Ingrediente, Integer> ingredientesPastelFrito = new HashMap<>();
                    ingredientesPastelFrito.put(new Ingrediente("Harina", 5, 1234, 10), 1);
                    ingredientesPastelFrito.put(new Ingrediente("Azúcar", 3, 1234, 5), 1);

                    PastelesFritos nuevoProducto = new PastelesFritos(producto, 5, ingredientesPastelFrito, 20, "dfg123", 3, false, "tomate");
                    this.bodega.getProductos().add(nuevoProducto);
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);

                    for (Ingrediente ingrediente : ingredientesPastelFrito.keySet()) {
                        if (this.bodega.getContabilidadIngredientes().containsKey(ingrediente.getNombre())) {
                            int valorARestar = ingredientesPastelFrito.get(ingrediente);
                            int valorActual = this.bodega.getContabilidadIngredientes().get(ingrediente.getNombre());
                            this.bodega.getContabilidadIngredientes().put(ingrediente.getNombre(), valorActual - valorARestar);
                        }
                
            }
        }
                else if (producto.equals("galleta")) {
                    HashMap<Ingrediente, Integer> ingredientesGalleta = new HashMap<>();
                    ingredientesGalleta.put(new Ingrediente("Harina", 5, 1234, 10), 1);
                    ingredientesGalleta.put(new Ingrediente("Azúcar", 3, 1234, 5), 1);

                    Galletas nuevoProducto = new Galletas(producto, 5, ingredientesGalleta, 20, "dfg123", 3, false, "tomate");
                    this.bodega.getProductos().add(nuevoProducto);
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);

                    for (Ingrediente ingrediente : ingredientesGalleta.keySet()) {
                        if (this.bodega.getContabilidadIngredientes().containsKey(ingrediente.getNombre())) {
                            int valorARestar = ingredientesGalleta.get(ingrediente);
                            int valorActual = this.bodega.getContabilidadIngredientes().get(ingrediente.getNombre());
                            this.bodega.getContabilidadIngredientes().put(ingrediente.getNombre(), valorActual - valorARestar);      
                
                
                
    }
}
    }
                else if (producto.equals("dona")) {
                    HashMap<Ingrediente, Integer> ingredienteDona = new HashMap<>();
                    ingredienteDona.put(new Ingrediente("Harina", 5, 1234, 10), 1);
                    ingredienteDona.put(new Ingrediente("Azúcar", 3, 1234, 5), 1);

                    Donas nuevoProducto = new Donas(producto, 5, ingredienteDona, 20, "dfg123", 3, false, "tomate");
                    this.bodega.getProductos().add(nuevoProducto);
                    this.bodega.getContabilidadProductos().merge(producto, 1, Integer::sum);

                    for (Ingrediente ingrediente : ingredienteDona.keySet()) {
                        if (this.bodega.getContabilidadIngredientes().containsKey(ingrediente.getNombre())) {
                            int valorARestar = ingredienteDona.get(ingrediente);
                            int valorActual = this.bodega.getContabilidadIngredientes().get(ingrediente.getNombre());
                            this.bodega.getContabilidadIngredientes().put(ingrediente.getNombre(), valorActual - valorARestar);      
                
                
}}}}}}}
