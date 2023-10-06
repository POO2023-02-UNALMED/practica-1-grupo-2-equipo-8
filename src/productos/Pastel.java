package productos;

import abastecimiento.Bodega;

public class Pastel extends Producto {
    private int harina;
    private int mantequilla;

    public Pastel(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega,
                    int harina, int mantequilla) {
        super(idProducto, sabor, tiempoCoccion, precioVenta, costoProduccion, bodega);
        this.harina = harina;
        this.mantequilla = mantequilla;
    }

    // Métodos getter y setter para los atributos adicionales de Pasteles
    public int getHarina() {
        return harina;
    }

    public void setHarina(int harina) {
        this.harina = harina;
    }

    public int getMantequilla() {
        return mantequilla;
    }

    public void setMantequilla(int mantequilla) {
        this.mantequilla = mantequilla;
    }
}
