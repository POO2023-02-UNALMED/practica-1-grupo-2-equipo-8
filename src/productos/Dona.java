package productos;

import abastecimiento.Bodega;

public class Dona extends Producto {
    private int chocolate;
    private int chispas;

    public Dona(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega,
                 int chocolate, int chispas) {
        super(idProducto, sabor, tiempoCoccion, precioVenta, costoProduccion, bodega);
        this.chocolate = chocolate;
        this.chispas = chispas;
    }

    // Métodos getter y setter para los atributos adicionales de Donas
    public int getChocolate() {
        return chocolate;
    }

    public void setChocolate(int chocolate) {
        this.chocolate = chocolate;
    }

    public int getChispas() {
        return chispas;
    }

    public void setChispas(int chispas) {
        this.chispas = chispas;
    }
}
