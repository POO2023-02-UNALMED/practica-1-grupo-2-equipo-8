package gestorAplicacion.producto;

import java.util.HashMap;
import gestorAplicacion.empresa.Ingrediente;

public class Galletas extends Producto {
    private boolean chips;
    private String relleno;

    public Galletas(String nombre, int espacioAlmacenamiento, HashMap<Ingrediente, Integer> ingredientesNecesarios, int precioBase,
                    String ID,  int peso,  boolean chips, String relleno) {
        super(nombre, ingredientesNecesarios, precioBase, ID, peso);
        this.chips = chips;
        this.relleno = relleno;
    }

    @Override
    public String listaCaracteristicas() {
    	String str = this.toString();
    	str = str + "Chips: " +  (this.isChips() ? "Si" : "No") + "\n";
    	str = str + "Relleno: " + this.getRelleno() + "\n";
    	str = str + "-".repeat(50) + "\n";
    	return str;
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
