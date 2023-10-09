package Proyecto;

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

    public Proyecto.Carrito getCarrito() {
        return Carrito;
    }

    public void setCarrito(Proyecto.Carrito carrito) {
        Carrito = carrito;
    }

    public Proyecto.Caja getCaja() {
        return Caja;
    }

    public void setCaja(Proyecto.Caja caja) {
        Caja = caja;
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
        return null;
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
