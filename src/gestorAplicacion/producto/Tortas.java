package gestorAplicacion.producto;

import java.util.HashMap;
import gestorAplicacion.empresa.Ingrediente;

public class Tortas extends Producto {
    private int porciones;
    private String cobertura;

    public Tortas(String nombre, int espacioAlmacenamiento, HashMap<Ingrediente, Integer> hashMap, int precioBase,
                  String ID, int peso, int diasEnBodega, int tiempoProduccion, int porciones, String cobertura) {
        super(nombre, espacioAlmacenamiento, hashMap, precioBase, ID, peso, diasEnBodega);
        this.porciones = porciones;
        this.cobertura = cobertura;
    }
    
    @Override
    public String listaCaracteristicas() {
    	String str = this.toString();
    	str = str + "Porciones: " +  this.getPorciones() + "\n";
    	str = str + "Cobertura: " + this.getCobertura() + "\n";
    	str = str + "-".repeat(50) + "\n";
    	return str;
    }
    
	public int getPorciones() {
		return porciones;
	}

	public void setPorciones(int porciones) {
		this.porciones = porciones;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
}
