package gestorAplicacion.producto;

import java.util.HashMap;

class PastelesFritos extends Producto {
    private boolean dulce;
    private String salsa;

    public boolean isDulce() {
		return dulce;
	}

	public void setDulce(boolean dulce) {
		this.dulce = dulce;
	}

	public String getSalsa() {
		return salsa;
	}

	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}

	public PastelesFritos(String nombre, int espacioAlmacenamiento, HashMap<String, Integer> ingredientesNecesarios, int costo,
                          String ID, int precio, int peso, int diasEnBodega, String fechaVencimiento, int tiempoProduccion,
                          boolean dulce, String salsa) {
        super(nombre, espacioAlmacenamiento, ingredientesNecesarios, costo, ID, precio, peso, diasEnBodega, fechaVencimiento, tiempoProduccion);
        this.dulce = dulce;
        this.salsa = salsa;
    }
}
