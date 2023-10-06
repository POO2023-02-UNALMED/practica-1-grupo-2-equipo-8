package productos;

import abastecimiento.Bodega;

public class Torta extends Producto {
    private int harina;
    private int huevos;
    private int mantequilla;

    public Torta(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega,
                 int harina, int huevos, int mantequilla) {
        super(idProducto, sabor, tiempoCoccion, precioVenta, costoProduccion, bodega);
        this.harina = harina;
        this.huevos = huevos;
        this.mantequilla = mantequilla;
    }

    // Métodos getter y setter para los atributos adicionales de Torta
    public int getHarina() {
        return harina;
    }

    public void setHarina(int harina) {
        this.harina = harina;
    }

    public int getHuevos() {
        return huevos;
    }

    public void setHuevos(int huevos) {
        this.huevos = huevos;
    }

    public int getMantequilla() {
        return mantequilla;
    }

    public void setMantequilla(int mantequilla) {
        this.mantequilla = mantequilla;
    }
}
