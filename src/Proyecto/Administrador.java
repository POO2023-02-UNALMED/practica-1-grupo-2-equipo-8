package Proyecto;

public class Administrador {

    private Carrito Carrito;
    private Bodega Bodega;
    private Productos Productos;
    private Fabrica Fabrica;
    private Rastreo Rastreo;
    private Caja Caja;

    public Administrador(Carrito Carrito, Bodega Bodega, Productos Productos, Fabrica Fabrica, Rastreo Rastreo, Caja Caja){
        this.Carrito = Carrito;
        this.Bodega = Bodega;
        this.Productos = Productos;
        this.Fabrica = Fabrica;
        this.Rastreo = Rastreo;
    }

    public Proyecto.Carrito getCarrito() {
        return Carrito;
    }

    public void setCarrito(Proyecto.Carrito carrito) {
        Carrito = carrito;
    }

    public Proyecto.Bodega getBodega() {
        return Bodega;
    }

    public void setBodega(Proyecto.Bodega bodega) {
        Bodega = bodega;
    }

    public Proyecto.Productos getProductos() {
        return Productos;
    }

    public void setProductos(Proyecto.Productos productos) {
        Productos = productos;
    }

    public Proyecto.Fabrica getFabrica() {
        return Fabrica;
    }

    public void setFabrica(Proyecto.Fabrica fabrica) {
        Fabrica = fabrica;
    }

    public Proyecto.Rastreo getRastreo() {
        return Rastreo;
    }

    public void setRastreo(Proyecto.Rastreo rastreo) {
        Rastreo = rastreo;
    }

    public Proyecto.Caja getCaja() {
        return Caja;
    }

    public void setCaja(Proyecto.Caja caja) {
        Caja = caja;
    }

    private void AgregarProducto(){
        ;
    }

    private void EliminarProducto(){
        ;
    }

    private void ComprarMateriaPrima(){
        ;
    }

    private void VentaPorEncargo(){
        ;
    }

    public void ReiniciarInteraccion(){
        ;
    }

    public void CambiarListaProduccionDiaria(){
        ;
    }

}


