package empresa;

import java.util.HashMap;
import compras.Bodega;
import producto.Producto;

public class Fabrica {
    private final String NIT; // NIT es constante y se inicializa en el constructor
    private String direccion;
    private HashMap<Producto, Integer> produccionDiaria;
    private Bodega bodega;

    public Fabrica(String NIT, String direccion) {
        this.NIT = NIT;
        this.direccion = direccion;
        this.produccionDiaria = new HashMap<>();
        this.bodega = new Bodega();
    }

    public void cambiarProduccion() {
        // Implementación para cambiar la producción diaria
    }

    public String imprimirCambiosFabrica() {
        // Implementación para imprimir los cambios en la fábrica
        return ""; 
    }

    public void finalizarProduccion(HashMap<Producto, Integer> produccionPorPedido) {
        
    }
}
