package Proyecto;

import java.util.List;

public class Carrito {
	private static  List<Productos>listaCatalogoOfrecido;
	private List<Productos> productosIngresados;
	
	
	public void eliminarProductoCarrito() {}
	
	public void agregarProductoCarrito() {}
	
	public void comprarProductos(List<Productos> listaproductos) {
		
	}
//	Getters y Setters

	public static List<Productos> getListaCatalogoOfrecido() {
		return listaCatalogoOfrecido;
	}

	public static void setListaCatalogoOfrecido(List<Productos> listaCatalogoOfrecido) {
		Carrito.listaCatalogoOfrecido = listaCatalogoOfrecido;
	}

	public List<Productos> getProductosIngresados() {
		return productosIngresados;
	}

	public void setProductosIngresados(List<Productos> productosIngresados) {
		this.productosIngresados = productosIngresados;
	}

	private void EliminarProductoCarrito(){
		;
	}

	private void AgregarProductoCarrito(){
		;
	}

	private void ComprarProductos(){
		;
	}
}


