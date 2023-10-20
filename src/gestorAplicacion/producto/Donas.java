package gestorAplicacion.producto;

import java.util.HashMap;

class Donas extends Producto {
    private boolean chips;
    private String cobertura;

    public Donas(String nombre, int espacioAlmacenamiento, HashMap<String, Integer> ingredientesNecesarios, int costo,
                String ID, int precio, int peso, int diasEnBodega, String fechaVencimiento, int tiempoProduccion,
                boolean chips, String cobertura) {
        super(nombre, espacioAlmacenamiento, ingredientesNecesarios, costo, ID, precio, peso, diasEnBodega, fechaVencimiento, tiempoProduccion);
        this.chips = chips;
        this.cobertura = cobertura;
    }

	public boolean isChips() {
		return chips;
	}

	public void setChips(boolean chips) {
		this.chips = chips;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
}