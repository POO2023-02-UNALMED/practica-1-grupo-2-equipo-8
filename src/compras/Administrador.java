package compras;

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

    public compras.Carrito getCarrito() {
        return Carrito;
    }

    public void setCarrito(compras.Carrito carrito) {
        Carrito = carrito;
    }

    public compras.Bodega getBodega() {
        return Bodega;
    }

    public void setBodega(compras.Bodega bodega) {
        Bodega = bodega;
    }

    public compras.Productos getProductos() {
        return Productos;
    }

    public void setProductos(compras.Productos productos) {
        Productos = productos;
    }

    public compras.Fabrica getFabrica() {
        return Fabrica;
    }

    public void setFabrica(compras.Fabrica fabrica) {
        Fabrica = fabrica;
    }

    public compras.Rastreo getRastreo() {
        return Rastreo;
    }

    public void setRastreo(compras.Rastreo rastreo) {
        Rastreo = rastreo;
    }

    public compras.Caja getCaja() {
        return Caja;
    }

    public void setCaja(compras.Caja caja) {
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


