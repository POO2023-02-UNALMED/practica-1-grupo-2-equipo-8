package compras;

import java.util.ArrayList;

public class Bodega {
    public Carrito Carrito;
    public Caja Caja;
    public Productos Productos;
    public Fabrica Fabrica;
    public ArrayList<String> ListaIngredientesAlmacenados = new ArrayList<>();
    public ArrayList<Integer> AlmacenamientoTotal = new ArrayList<>();
    public int AlmacenamientoIngredientes;
    public int AlmacenamientoProductos;

    public  Bodega(Carrito Carrito, Caja Caja, Productos Productos, Fabrica Fabrica, ArrayList<String> ListaIngredientesAlmacenados,
                   ArrayList<Integer> AlmacenamientoTotal, int AlmacenamientoIngredientes, int AlmacenamientoProductos){
        this.Carrito = Carrito;
        this.Caja = Caja;
        this.Productos = Productos;
        this.Fabrica = Fabrica;
        this.ListaIngredientesAlmacenados = ListaIngredientesAlmacenados;
        this.AlmacenamientoTotal = AlmacenamientoTotal;
        this.AlmacenamientoIngredientes = AlmacenamientoIngredientes;
        this.AlmacenamientoProductos = AlmacenamientoProductos;
    }

    public compras.Carrito getCarrito() {
        return Carrito;
    }

    public void setCarrito(compras.Carrito carrito) {
        Carrito = carrito;
    }

    public compras.Caja getCaja() {
        return Caja;
    }

    public void setCaja(compras.Caja caja) {
        Caja = caja;
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

    public ArrayList<String> getListaIngredientesAlmacenados() {
        return ListaIngredientesAlmacenados;
    }

    public void setListaIngredientesAlmacenados(ArrayList<String> listaIngredientesAlmacenados) {
        ListaIngredientesAlmacenados = listaIngredientesAlmacenados;
    }

    public int getAlmacenamientoIngredientes() {
        return AlmacenamientoIngredientes;
    }

    public void setAlmacenamientoIngredientes(int almacenamientoIngredientes) {
        AlmacenamientoIngredientes = almacenamientoIngredientes;
    }

    public int getAlmacenamientoProductos() {
        return AlmacenamientoProductos;
    }

    public void setAlmacenamientoProductos(int almacenamientoProductos) {
        AlmacenamientoProductos = almacenamientoProductos;
    }

    public ArrayList<Integer> getAlmacenamientoTotal() {
        return AlmacenamientoTotal;
    }

    public void setAlmacenamientoTotal(ArrayList<Integer> almacenamientoTotal) {
        AlmacenamientoTotal = almacenamientoTotal;
    }

    private ArrayList MostrarCatalogo(){
        return null;
    }

    private void EliminarProductoBodega(){
        ;
    }

    private ArrayList VerIngredientesUsados(){
        return null;
    }

    private void ElegirIngredientes(){
        ;
    }

    private ArrayList VerIngredientesPosibles(){
        return null;
    }

    private String VerEscasezIngredientes(){
        ;
    }

    private void ConfirmarDisponibilidadProductos(){
        ;
    }

    private void ConfirmarDisponibilidadIngredientes(){
        ;
    }

    private void LiberarAlmacenamiento(){
        ;
    }

    private void OcuparAlmacenamiento(){
        ;
    }

    public void CalcularAlmacenamiento(){
        ;
    }

    public void ConfirmarEspacioDisponible(){
        ;
    }

}
