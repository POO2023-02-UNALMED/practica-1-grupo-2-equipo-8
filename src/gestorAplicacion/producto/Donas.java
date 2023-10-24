package gestorAplicacion.producto;

import java.util.HashMap;
import gestorAplicacion.empresa.Ingrediente;

public class Donas extends Producto {
    private boolean chips;
    private String cobertura;

    public Donas(String nombreProducto, int espacioAlmacenamiento, HashMap<Ingrediente, Integer> ingredientesNecesarios, int precioBase,
                String ID, int peso, boolean chips, String cobertura) {
        super(nombreProducto, ingredientesNecesarios, precioBase, ID, peso);
        this.chips = chips;
        this.cobertura = cobertura;
    }
    
    @Override
    public String listaCaracteristicas() {
    	String str = this.toString();
    	str = str + "Chips: " +  (this.isChips() ? "Si" : "No") + "\n";
    	str = str + "Cobertura: " + this.getCobertura() + "\n";
    	str = str + "-".repeat(50) + "\n";
    	return str;
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