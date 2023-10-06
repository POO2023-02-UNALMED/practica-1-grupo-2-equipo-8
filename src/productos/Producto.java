package productos;

import abastecimiento.Bodega;

public abstract class Producto {
    private String idProducto;
    private String sabor;
    private int tiempoCoccion;
    private double precioVenta;
    private double costoProduccion;
    private Bodega bodega;

    public Producto(String idProducto, String sabor, int tiempoCoccion, double precioVenta, double costoProduccion, Bodega bodega) {
        this.idProducto = idProducto;
        this.sabor = sabor;
        this.tiempoCoccion = tiempoCoccion;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
        this.bodega = bodega;
    }

    // Métodos getter y setter
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(double costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
}
