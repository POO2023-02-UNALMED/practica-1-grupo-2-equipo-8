package gestorAplicacion.empresa;
import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Caja implements Serializable {
	static private int dinero;
	static private HashMap<String, Integer> historialVentas = new HashMap<>();
	private HashMap<String, Integer> costosProduccion = new HashMap<>(); // Variable costosProduccion agregada ¿deberia ser estatico?


    // Declaración del método para mostrar el historial de compras
    public void verHistorialCompras() {
        Caja.historialVentas.forEach((String producto, Integer venta) -> {
            System.out.println("El producto " + producto + " ha sido comprado " + venta + (venta == 1 ? " vez." : " veces."));
        });
    }

    // Declaración del método para ingresar dinero en la caja
    public void ingresarDinero(int cantidad) {

    	Caja.dinero+=cantidad;
    	
    }

    public void restarDinero(int cantidad) {
    	Caja.dinero -= cantidad;
    }
    
    // Metodo para agregar una venta
    public void agregarVenta(String producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) + cantidadVenta);
        }else{
            Caja.historialVentas.put(producto, cantidadVenta);
        }
    }
    
    // Metodo para agregar una venta
    public void eliminarVenta(String producto, Integer cantidadVenta){
        if(Caja.historialVentas.containsKey(producto)){
            Caja.historialVentas.put(producto, Caja.historialVentas.get(producto) - cantidadVenta);
        }else{
            
        }
    }
    
  //se añade un nuevo metodo para la funcionalida #2 para actualizarCostosProduccion
    
    public void actualizarCostosProduccion(HashMap<String, Integer> produccionDiaria, HashMap<String, Integer> costosUnitarios, HashMap<String, Integer> materiaPrimaNecesaria) {
        // Obtener la lista de costos de producción actual
        HashMap<String, Integer> costosProduccionActual = new HashMap<>();

        // Calcular los costos de producción en función de la lista de producción diaria y los costos unitarios de producción
        for (Map.Entry<String, Integer> entry : produccionDiaria.entrySet()) {
            String producto = entry.getKey();
            int cantidadProduccion = entry.getValue();

            // Verificar si el producto tiene un costo unitario asociado
            if (costosUnitarios.containsKey(producto)) {
                int costoUnitario = costosUnitarios.get(producto);
                int costoProduccion = cantidadProduccion * costoUnitario;
                // Agregar el costo de producción calculado a la lista de costos de producción actualizada
                costosProduccionActual.put(producto, costoProduccion);
            }
        }

        // Mostrar la lista de costos de producción actualizada
        System.out.println("Lista de costos de producción actualizada:");
        for (Map.Entry<String, Integer> entry : costosProduccionActual.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + ", Costo de producción: " + entry.getValue());
        }

        // Establecer la lista de costos de producción actualizada en la caja
        this.setCostosProduccion(costosProduccionActual);
    }

	private void setCostosProduccion(HashMap<String, Integer> costosProduccionActual) {
		this.costosProduccion = costosProduccionActual;
	    System.out.println("Lista de costos de producción actualizada correctamente.");
		
	}
//se añade un nuevo metodo para la funcionalida #2 para descontar el valor


    public void descontarValorLista(HashMap<String, Integer> costosProduccion) {
        // Obtener el dinero actual en la caja
        int dineroActual = this.getDinero();

        // Descontar el valor de la lista de costos de producción de la caja
        for (Map.Entry<String, Integer> entry : costosProduccion.entrySet()) {
            String producto = entry.getKey();
            int costoProduccion = entry.getValue();

            if (dineroActual >= costoProduccion) {
                // Descontar el costo de producción de la caja
                dineroActual -= costoProduccion;
            } else {
                System.out.println("No hay suficiente dinero en la caja para descontar el costo de producción de " + producto);
            }
        }

        // Actualizar el valor de dinero en la caja después del descuento
        this.setDinero(dineroActual);
    }



    public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		Caja.dinero = dinero;
	}

	public HashMap<String, Integer> getHistorialVentas() {
		return historialVentas;
	}

	public void setHistorialVentas(HashMap<String, Integer> historialVentas) {
		Caja.historialVentas = historialVentas;
	}

}
