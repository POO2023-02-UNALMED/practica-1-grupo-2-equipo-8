package gestorAplicacion.producto;

import java.util.HashMap;

class Tortas extends Producto {
    private int porciones;
    private String cobertura;

    public Tortas(String nombre, int espacioAlmacenamiento, HashMap<String, Integer> ingredientesNecesarios, int costo,
                  String ID, int precio, int peso, int diasEnBodega, String fechaVencimiento, int tiempoProduccion,
                  int porciones, String cobertura) {
        super(nombre, espacioAlmacenamiento, ingredientesNecesarios, costo, ID, precio, peso, diasEnBodega, fechaVencimiento, tiempoProduccion);
        this.porciones = porciones;
        this.cobertura = cobertura;
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
