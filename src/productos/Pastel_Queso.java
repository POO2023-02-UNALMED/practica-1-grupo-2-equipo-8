package productos;

import abastecimiento.Bodega;

public class Pastel_Queso extends Pastel {
    private int queso;

    public Pastel_Queso(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega,
                       int harina, int mantequilla, int queso) {
        super(idProducto, sabor, tiempoCoccion, precioVenta, costoProduccion, bodega, harina, mantequilla);
        this.queso = queso;
    }

    // Métodos getter y setter para el atributo adicional de PastelQueso
    public int getQueso() {
        return queso;
    }

    public void setQueso(int queso) {
        this.queso = queso;
    }
}
