package productos;

import abastecimiento.Bodega;

public class Pastel_Pollo extends Pastel {
    private int pollo;

    public Pastel_Pollo(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega,
                       int harina, int mantequilla, int pollo) {
        super(idProducto, sabor, tiempoCoccion, precioVenta, costoProduccion, bodega, harina, mantequilla);
        this.pollo = pollo;
    }

    // Metodos getter y setter para el atributo adicional de PastelPollo
    public int getPollo() {
        return pollo;
    }

    public void setPollo(int pollo) {
        this.pollo = pollo;
    }
}
