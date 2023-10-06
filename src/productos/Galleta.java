package productos;

import abastecimiento.Bodega;

public class Galleta extends Producto {
    private int vainilla;
    private int mantequilla;

    public Galleta(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega,
                    int vainilla, int mantequilla) {
        super(idProducto, sabor, tiempoCoccion, precioVenta, costoProduccion, bodega);
        this.vainilla = vainilla;
        this.mantequilla = mantequilla;
    }

    // Métodos getter y setter para los atributos adicionales de Galletas
    public int getVainilla() {
        return vainilla;
    }

    public void setVainilla(int vainilla) {
        this.vainilla = vainilla;
    }

    public int getMantequilla() {
        return mantequilla;
    }

    public void setMantequilla(int mantequilla) {
        this.mantequilla = mantequilla;
    }
}

