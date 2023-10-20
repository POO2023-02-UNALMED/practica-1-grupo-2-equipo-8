package gestorAplicacion.empresa;

import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//OJO FALTA CAMBIAR LO DE CAJA CUANDO SE AGREGUE  UN PRODUCTO AQUÍ PERO NECESITO SABER COMO ES CAJA
public class Envio implements Serializable {
	
	private int codigoDeEnvio;
	private Camion camionAsignado;
	private List<Producto> productos=new ArrayList<Producto>();
	private int pesoTotal;
	private Caja caja;
	private boolean asignadoAUnCamion;
	private static List<Envio> listaEnvios = new ArrayList<Envio>();
//	Constructor
	
	 public Envio(int codigoDeEnvio, Camion camionAsignado, List<Producto> productos, Caja caja) {
		 	int pesoTotal = 0;
	        this.codigoDeEnvio = codigoDeEnvio;
	        this.camionAsignado = camionAsignado;
	        this.productos = productos;
	        this.caja = caja;
	        for(Producto producto:productos) {
	        	pesoTotal+=producto.getPeso();
	        }
	        this.pesoTotal = pesoTotal;
	        Envio.listaEnvios.add(this);
	       
	    }
	 
	 public static String enviosPorAsignar() {
		    StringBuilder result = new StringBuilder();
		    int numeracion = 1;

		    for (Envio envio : listaEnvios) {
		        if (!envio.isAsignadoAUnCamion()) {
		            result.append(numeracion).append(". Envío con código ").append(envio.getCodigoDeEnvio())
		                  .append(", con un peso de ").append(envio.getPesoTotal()).append("\n");
		            numeracion++;
		        }
		    }

		    return result.toString();
		}

	 
//	 FuncionesDelUML
	 public void anadirProducto(Producto producto) {
		 this.productos.add(producto);
		 this.pesoTotal+=producto.getPeso();
		 this.getCaja().ingresarDinero(producto.getPrecio());
	 }
	 
	 public void eliminarProducto(Producto producto) {
		 if (this.productos.contains(producto)){
			 this.productos.remove(producto);
			 this.pesoTotal-=producto.getPeso();
			 this.getCaja().restarDinero(producto.getPrecio());
			 
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
