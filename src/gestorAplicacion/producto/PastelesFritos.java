package gestorAplicacion.producto;

import java.util.HashMap;
import gestorAplicacion.empresa.Ingrediente;

public class PastelesFritos extends Producto {
    private boolean dulce;
    private String salsa;


	public PastelesFritos(String nombreProducto, int espacioAlmacenamiento, HashMap<Ingrediente, Integer> ingredientesNecesarios, int precioBase,
            String ID, int peso , boolean dulce, String salsa) {
			super(nombreProducto, ingredientesNecesarios, precioBase, ID, peso);
			this.dulce = dulce;
			this.salsa = salsa;
	}

    @Override
    public String listaCaracteristicas() {
    	String str = this.toString();
    	str = str + "Dulce: " +  (this.isDulce() ? "Si" : "No") + "\n";
    	str = str + "Salsa: " + this.getSalsa() + "\n";
    	str = str + "-".repeat(50) + "\n";
    	return str;
    }
    
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


}
