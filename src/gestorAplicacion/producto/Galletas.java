package gestorAplicacion.producto;

import java.util.HashMap;

class Galletas extends Producto {
    private boolean chips;
    private String relleno;

    public Galletas(String nombre, int espacioAlmacenamiento, HashMap<String, Integer> ingredientesNecesarios, int costo,
                    String ID, int precio, int peso, int diasEnBodega, String fechaVencimiento, int tiempoProduccion,
                    boolean chips, String relleno) {
        super(nombre, espacioAlmacenamiento, ingredientesNecesarios, costo, ID, precio, peso, diasEnBodega, fechaVencimiento, tiempoProduccion);
        this.chips = chips;
        this.relleno = relleno;
    }

	public boolean isChips() {
		return chips;
	}

	public void setChips(boolean chips) {
		this.chips = chips;
	}

	public String getRelleno() {
		return relleno;
	}

	public void setRelleno(String relleno) {
		this.relleno = relleno;
	}
}
