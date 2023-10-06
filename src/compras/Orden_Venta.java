package compras;

import java.util.Date;

import productos.Producto;

public class Orden_Venta {
    private String idOrdenVenta;
    private Date fechaVenta;
    private int lineaCompra;
    private Producto producto;
    private int cantidadProducto;
    private double presupuestoCliente;
    private Caja caja;

    public Orden_Venta(String idOrdenVenta, Date fechaVenta, int lineaCompra, Producto producto, int cantidadProducto, double presupuestoCliente, Caja caja) {
        this.idOrdenVenta = idOrdenVenta;
        this.fechaVenta = fechaVenta;
        this.lineaCompra = lineaCompra;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.presupuestoCliente = presupuestoCliente;
        this.caja = caja;
    }

    // Métodos getter y setter
    public String getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(String idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getLineaCompra() {
        return lineaCompra;
    }

    public void setLineaCompra(int lineaCompra) {
        this.lineaCompra = lineaCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPresupuestoCliente() {
        return presupuestoCliente;
    }

    public void setPresupuestoCliente(double presupuestoCliente) {
        this.presupuestoCliente = presupuestoCliente;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
}
