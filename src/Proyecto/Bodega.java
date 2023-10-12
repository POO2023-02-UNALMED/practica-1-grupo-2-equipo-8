package Proyecto;

import java.util.ArrayList;

public class Bodega {
    public Carrito Carrito;
    public Caja Caja;
    public Productos Productos;
    public Fabrica Fabrica;
    public ArrayList<String> ListaIngredientesAlmacenados = new ArrayList<>();
    public ArrayList<String> ListaProductosAlmacenados = new ArrayList<>();
    public ArrayList<Integer> NumeroIngredientesAlmacenados = new ArrayList<>();
    public ArrayList<Integer> EspacioAlmacenamientoTotal = new ArrayList<>();
    public int AlmacenamientoIngredientes;
    public int AlmacenamientoProductos;
    public ArrayList<String> ListaProductosAltaDemanda = new ArrayList<>();
    public ArrayList<String> ListaProductosBajaDemanda = new ArrayList<>();
    public ArrayList<Integer> EstanciaEnBodega = new ArrayList<>();


    public  Bodega(Carrito Carrito, Caja Caja, Productos Productos, Fabrica Fabrica, ArrayList<String> ListaIngredientesAlmacenados,
                   ArrayList<Integer> AlmacenamientoTotal, int AlmacenamientoIngredientes, int AlmacenamientoProductos){
        this.Carrito = Carrito;
        this.Caja = Caja;
        this.Productos = Productos;
        this.Fabrica = Fabrica;
        this.ListaIngredientesAlmacenados = ListaIngredientesAlmacenados;
        this.EspacioAlmacenamientoTotal = AlmacenamientoTotal;
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
        return EspacioAlmacenamientoTotal;
    }

    public void setAlmacenamientoTotal(ArrayList<Integer> almacenamientoTotal) {
        EspacioAlmacenamientoTotal = almacenamientoTotal;
    }
    
    

    public ArrayList<String> getListaProductosAlmacenados() {
		return ListaProductosAlmacenados;
	}

	public void setListaProductosAlmacenados(ArrayList<String> listaProductosAlmacenados) {
		ListaProductosAlmacenados = listaProductosAlmacenados;
	}

	public ArrayList<Integer> getNumeroIngredientesAlmacenados() {
		return NumeroIngredientesAlmacenados;
	}

	public void setNumeroIngredientesAlmacenados(ArrayList<Integer> numeroIngredientesAlmacenados) {
		NumeroIngredientesAlmacenados = numeroIngredientesAlmacenados;
	}

	public ArrayList<Integer> getEspacioAlmacenamientoTotal() {
		return EspacioAlmacenamientoTotal;
	}

	public void setEspacioAlmacenamientoTotal(ArrayList<Integer> espacioAlmacenamientoTotal) {
		EspacioAlmacenamientoTotal = espacioAlmacenamientoTotal;
	}

	public ArrayList<String> getListaProductosAltaDemanda() {
		return ListaProductosAltaDemanda;
	}

	public void setListaProductosAltaDemanda(ArrayList<String> listaProductosAltaDemanda) {
		ListaProductosAltaDemanda = listaProductosAltaDemanda;
	}

	public ArrayList<String> getListaProductosBajaDemanda() {
		return ListaProductosBajaDemanda;
	}

	public void setListaProductosBajaDemanda(ArrayList<String> listaProductosBajaDemanda) {
		ListaProductosBajaDemanda = listaProductosBajaDemanda;
	}

	public ArrayList<Integer> getEstanciaEnBodega() {
		return EstanciaEnBodega;
	}

	public void setEstanciaEnBodega(ArrayList<Integer> estanciaEnBodega) {
		EstanciaEnBodega = estanciaEnBodega;
	}

	private ArrayList MostrarCatalogo(){
        return null;
    }

	private void AgregarProductoBodega(String producto){
        ;
    }

	
	private void EliminarProductoBodega(String producto){
        ;
    }

    private ArrayList<?> VerIngredientesUsados(){
        return null;
    }
    
    private void VerOtrosIngredientes(){
        ;
    }
    
    private void ElegirIngredientes(){
        ;
    }

    private ArrayList<?> VerIngredientesPosibles(){
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
