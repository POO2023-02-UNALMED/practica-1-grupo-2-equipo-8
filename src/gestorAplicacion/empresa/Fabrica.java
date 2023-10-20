package gestorAplicacion.empresa;

import gestorAplicacion.producto.Producto;

import java.util.HashMap;

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
    //Crear Constructor Vacìo para Sobrecargar y sacar los atributos de la base de datos
    //Crear Metodos de Clase para afectar ProduccionDiaria
    //La clase Administrador tiene constantes (finales) NIT y Direccion y los entrega al constructor de la Fabrica

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
