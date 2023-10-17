package empresa;

import java.util.ArrayList;
import java.util.List;

import productos.Producto;

//OJO FALTA CAMBIAR LO DE CAJA CUANDO SE AGREGUE  UN PRODUCTO AQUÍ PERO NECESITO SABER COMO ES CAJA
public class Envio {
	private int codigoDeEnvio;
	private Camion camionAsignado=null;
	private List<Producto> productos=new ArrayList<Producto>();
	private int pesoTotal;
	private Caja caja;
	private boolean asignadoAUnCamion;
	
//	Constructor
	 public Envio(int codigoDeEnvio, Camion camionAsignado, List<Producto> productos, Caja caja) {
		 	int pesoTotal;
	        this.codigoDeEnvio = codigoDeEnvio;
	        this.camionAsignado = camionAsignado;
	        this.productos = productos;
	        this.caja = caja;
	        
	        for(Producto producto:productos) {
	        	pesoTotal+=producto.getPeso();
	        }
	        this.pesoTotal = pesoTotal;
	       
	    }
	 
//	 FuncionesDelUML
	 public void anadirProducto(Producto producto) {
		 this.productos.add(producto);
		 this.pesoTotal+=producto.peso;
	 }
	 
	 public void eliminarProducto(Producto producto) {
		 if (this.productos.contains(producto)){
			 this.productos.remove(producto);
			 this.pesoTotal-=producto.peso;
			 
		 }
	 }
	 
//	 Getters y Setters
	 
	public int getCodigoDeEnvio() {
		return codigoDeEnvio;
	}
	public Camion getCamionAsignado() {
		return camionAsignado;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public int getPesoTotal() {
		return pesoTotal;
	}
	public Caja getCaja() {
		return caja;
	}
	public void setCodigoDeEnvio(int codigoDeEnvio) {
		this.codigoDeEnvio = codigoDeEnvio;
	}
	public void setCamionAsignado(Camion camionAsignado) {
		this.camionAsignado = camionAsignado;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public void setPesoTotal(int pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public boolean isAsignadoAUnCamion() {
		return asignadoAUnCamion;
	}

	public void setAsignadoAUnCamion(boolean asignadoAUnCamion) {
		this.asignadoAUnCamion = asignadoAUnCamion;
	}
	 
	 
	 
	 
	 
}
