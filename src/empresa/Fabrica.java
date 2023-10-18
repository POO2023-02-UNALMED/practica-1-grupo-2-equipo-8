package empresa;

import java.util.HashMap;
import java.util.Map;
import compras.Bodega;


public class Fabrica {
    private final String NIT; // NIT es constante y se inicializa en el constructor
    private String direccion;
    private Map<Producto, Integer> produccionDiaria;
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
        return ""; // Devuelve una cadena vacía como marcador de posición
    }

    public void finalizarProduccion(Map<Producto, Integer> produccionPorPedido) {
        // Implementación para finalizar la producción por pedido
        // Se asume que produccionPorPedido es un mapeo de Producto a cantidad
    }
}
