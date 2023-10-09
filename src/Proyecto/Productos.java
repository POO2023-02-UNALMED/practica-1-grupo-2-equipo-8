package Proyecto;

public class Productos {
    public String nombre;
    public String tipo;
    public int NIT;
    public int cantidadEnStock;

    public Productos(String nombre, String tipo, int NIT, int cantidadEnStock){
        this.nombre = nombre;
        this.tipo = tipo;
        this.NIT = NIT;
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    private void AgregarProductosProducto(){
        ;
    }

    private void EliminarProductoProductos(){
        ;
    }
}
